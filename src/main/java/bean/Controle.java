package bean;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import domain.LDC;
import domain.SJQ;
import domain.SLG;
import email.EnviarEmail;
import regras.ReadFiles;
import regras.WriteFiles;
import sites.SiteLDC;
import sites.SiteSJQ;
import sites.SiteSLG;

@ManagedBean
@ApplicationScoped
public class Controle {

	// Define se o teste em loop deve continuar
	private static Boolean testando;
	// Tempo em hora entre um teste e outro.
	private static int intervalo = 1;
	// Enviar e-mail programado?
	private static String titulo;
	private static Boolean enviarEmail = true;
	private static Boolean erroPing = false;
	private static Boolean alerta = false;
	private static Calendar alertaCalendar = Calendar.getInstance();
	private static int alertaDia = 0;

	Calendar calendar = Calendar.getInstance();

	private static Date horaDeEnvio;

	// Hora do Sistema
	private static Date hora;

	// Site SLG
	private static String horaSlg; // Hora que o site foi testado
	private static SiteSLG slg = new SiteSLG();
	static ArrayList<SLG> allSLG = new ArrayList<>();

	// Site SJQ
	private static String horaSjq; // Hora que o site foi testado
	private static SiteSJQ sjq = new SiteSJQ();
	static ArrayList<SJQ> allSJQ = new ArrayList<>();

	// Site LDC
	private static String horaLdc; // Hora que o site foi testado
	private static SiteLDC ldc = new SiteLDC();
	static ArrayList<LDC> allLDC = new ArrayList<>();

	// Runnable
	// ------------------------------------------------------------------
	// Envia E-mail programado ...
	private static Runnable emailAgendado = new Runnable() {
		public void run() {

			// Condição para e-mail programado -----------
			while (testando) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\nEmail --------------------------------------------\t" + new Date());
				System.out.println("E-Mail:" + enviarEmail);

				Calendar calendar = new GregorianCalendar();
				hora = new Date();
				calendar.setTime(hora);
				int horaSistema = calendar.get(Calendar.HOUR_OF_DAY);
				int minutoSistema = calendar.get(Calendar.MINUTE);
				System.out.println("Hora Sitema:" + horaSistema + "\t Minuto Sitema: " + minutoSistema);

				Calendar calendar2 = new GregorianCalendar();
				calendar2.setTime(horaDeEnvio);
				int horaAgenda = calendar2.get(Calendar.HOUR_OF_DAY);
				int minutoAgenda = calendar2.get(Calendar.MINUTE);
				System.out.println("Hora Agenda:" + horaAgenda + "\t Minuto Agenda: " + minutoAgenda);

				hora = new Date();
				alertaCalendar.setTime(hora);
				int ifAlertaDia = alertaCalendar.get(Calendar.DAY_OF_YEAR);
				System.out.println("\n---------------------------------");
				System.out.println("Dia do Ano If:" + ifAlertaDia);
				System.out.println("---------------------------------");

				if (ifAlertaDia != alertaDia) {
					alerta = false;
				}

				if ((erroPing == true && alerta == false)
						|| (horaSistema == horaAgenda && minutoSistema == minutoAgenda)) {
					
					String status="Ok";
					if(erroPing==true){
						titulo="Problemas de Comunicação - (Verificação Automática)  ";
						status="Erro";
						
					}if (horaSistema == horaAgenda && minutoSistema == minutoAgenda) {
						
						titulo="Verificação Automática - Status = "+status;
					}
					System.out.println("Thead Mail ...");
//					String siteSlgR = slg.validarSite();
//					String siteSjqR = sjq.validarSite();
//					String siteLdcR = ldc.validarSite();

					StringBuilder result = new StringBuilder();

//					result.append(siteSlgR);
//					result.append(siteSjqR);
//					result.append(siteLdcR);

					EnviarEmail mail = new EnviarEmail();
					mail.emailHtml(result.toString(),titulo);
					alerta = true;

					hora = new Date();
					alertaCalendar.setTime(hora);
					alertaDia = alertaCalendar.get(Calendar.DAY_OF_YEAR);
					System.out.println("\n---------------------------------");
					System.out.println("Dia do Ano:" + alertaDia);
					System.out.println("---------------------------------");

					try {
						Thread.sleep(55000);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Fim Email ---------------" + enviarEmail + "----------------------------\t"
						+ new Date() + "\n\n");
				if (!enviarEmail) {
					break;
				}
			}
			// Fim da Condição para e-mail programado -------------
		}
	};

	// Enviar Email
	private static Runnable enviar = new Runnable() {
		public void run() {
			
			
			titulo="Verificação solicitada";
			System.out.println("Thead Mail ...");
//			String siteSlgR = slg.validarSite();
//			String siteSjqR = sjq.validarSite();
//			String siteLdcR = ldc.validarSite();

			StringBuilder result = new StringBuilder();

//			result.append(siteSlgR);
//			result.append(siteSjqR);
//			result.append(siteLdcR);
			
			EnviarEmail mail = new EnviarEmail();
			mail.emailHtml(result.toString(), titulo);

		}

	};

	// Executar loop ...
	private static Runnable executarLoop = new Runnable() {
		public void run() {
			try {
				while (testando) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\nLoop -----------------------------------------\t" + new Date());
					System.out.println("\nRecursividade..." + testando);

					System.out.println("Testar:" + testando);
					erroPing = false;

					new Thread(siteslg).start();
					
					new Thread(sitesjq).start();
					
					new Thread(siteldc).start();
					
					

					try {
						System.out.println("\nThread...");
						int horaConverte = 3600000; // 3600 * 1000ms =1h
						int tempo = horaConverte * intervalo;
						Thread.sleep(tempo);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Thread.sleep(5000);
					System.out.println("Fim Loop --------------------------------------------\t" + new Date() + "\n\n");
					if (!testando) {
						break;
					}
					
					
				}
			} catch (Exception e) {
				e.getMessage();
			}
			
			

		}
		
	};

	private static Runnable stop = new Runnable() {
		public void run() {
			alerta = false;
			testando = false;
			System.out.println("------------------------------------");
			System.out.println("\n\nParar teste:" + testando);
			System.out.println("------------------------------------");

		}
	};

	private static Runnable siteslg = new Runnable() {
		public void run() {
			long begin = System.currentTimeMillis();
			allSLG = slg.setarValoresGui();
			horaSlg = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()).toString();
			long end = System.currentTimeMillis();
			System.out.println("\nTempo de teste SLG:\t" + (end - begin));

		}
	};

	private static Runnable sitesjq = new Runnable() {
		public void run() {
			long begin = System.currentTimeMillis();
			allSJQ = sjq.setarValoresGui();
			horaSjq = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()).toString();
			long end = System.currentTimeMillis();
			System.out.println("\nTempo de teste SJQ:\t" + (end - begin));

		}
	};

	private static Runnable siteldc = new Runnable() {
		public void run() {
			long begin = System.currentTimeMillis();
			allLDC = ldc.setarValoresGui();
			horaLdc = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()).toString();
			long end = System.currentTimeMillis();
			System.out.println("\nTempo de teste LDC:\t" + (end - begin));

		}
	};

	// Métodos
	// ------------------------------------------------------------------
	@PostConstruct
	@SuppressWarnings("deprecation")
	public void atualizar() {
		horaDeEnvio = new Date();
		horaDeEnvio.setHours(7);
		horaDeEnvio.setMinutes(0);
	}

	public void iniciar() {

		WriteFiles w = new WriteFiles();
		try {
			w.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!licenca()) {
			System.out.println("Licença Expirou");

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Licença Expirada", null));

		} else {
			testando = true;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Validação iniciada", null));
			new Thread(executarLoop).start();

			if (enviarEmail) {
				new Thread(emailAgendado).start();
			}
		}

	}

	public void parar() {
		WriteFiles w = new WriteFiles();
		try {
			w.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(stop).start();

	}

	public void metodoEmail() {
		WriteFiles w = new WriteFiles();
		try {
			w.mail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new Thread(enviar).start();

	}
	


	public boolean licenca() {

		boolean ok = false;
		String ok2;
		Date data = new Date();
		Calendar calendar2 = new GregorianCalendar();
		calendar2.setTime(data);
		int ano = calendar2.get(Calendar.YEAR);

		System.out.println("Ano Atual:" + ano);

		if (ano <= 2018) {
			ok = true;

			// Validação por Arquivo
			ReadFiles r = new ReadFiles();
			try {
				ok2 = r.read();

				if (!ok2.trim().equalsIgnoreCase("17")) {

					System.out.println("Xxx ---\t" + ok2);
					ok = false;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Validação por ano
			if (ano == 2018) {
				int mes = calendar2.get(Calendar.MONTH);
				int dia = calendar2.get(Calendar.DAY_OF_MONTH);
				if (mes == 12 && dia == 28) {
					WriteFiles w = new WriteFiles();
					try {
						w.control();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		} else {
			ok = false;
		}

		return ok;

	}

	// Get e Set
	// ------------------------------------------------------------------
	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		Controle.intervalo = intervalo;
	}

	public ArrayList<SLG> getAllSLG() {
		return allSLG;
	}

	public void setAllSLG(ArrayList<SLG> allSLG) {
		Controle.allSLG = allSLG;
	}

	public Boolean getTestando() {
		return testando;
	}

	public void setTestando(Boolean testando) {
		Controle.testando = testando;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		Controle.hora = hora;
	}

	public Boolean getEnviarEmail() {
		return enviarEmail;
	}

	public void setEnviarEmail(Boolean enviarEmail) {
		Controle.enviarEmail = enviarEmail;
	}

	public String getHoraSlg() {
		return horaSlg;
	}

	public void setHoraSlg(String horaSlg) {
		Controle.horaSlg = horaSlg;
	}

	public Date getHoraDeEnvio() {
		return horaDeEnvio;
	}

	public void setHoraDeEnvio(Date horaDeEnvio) {
		Controle.horaDeEnvio = horaDeEnvio;
	}

	public String getHoraSjq() {
		return horaSjq;
	}

	public void setHoraSjq(String horaSjq) {
		Controle.horaSjq = horaSjq;
	}

	public ArrayList<SJQ> getAllSJQ() {
		return allSJQ;
	}

	public void setAllSJQ(ArrayList<SJQ> allSJQ) {
		Controle.allSJQ = allSJQ;
	}

	public String getHoraLdc() {
		return horaLdc;
	}

	public void setHoraLdc(String horaLdc) {
		Controle.horaLdc = horaLdc;
	}

	public ArrayList<LDC> getAllLDC() {
		return allLDC;
	}

	public void setAllLDC(ArrayList<LDC> allLDC) {
		Controle.allLDC = allLDC;
	}

	public Boolean getErroPing() {
		return erroPing;
	}

	public void setErroPing(Boolean erroPing) {
		Controle.erroPing = erroPing;
	}

	// ------------------------------------------------------------------

}
