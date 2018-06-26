package email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

import html.CorpoHtml;
import regras.ReadFiles;

//http://www.devmedia.com.br/utilizando-a-api-commons-email-para-enviar-e-mails/3306
///https://www.lifewire.com/what-are-the-gmail-smtp-settings-1170854
//https://support.google.com/a/answer/176600?hl=pt-BR

public class EnviarEmail {

	private String smtp_365 = "smtp.office365.com";
	private String office_365 = "helio@inovax.com.br";
	private String senha365 = "Killer01734";

	private String apelido = "Monitor de Rede-CEF";

	private String destino = "helio@inovax.com.br";
	private String apelidoDestino = "Suporte";
	ReadFiles readFiles = new ReadFiles();

	// Usado no ProgressBarView
	private static boolean enviado = false;
	private static boolean concluido = false;

	public void emailHtml(String resultado, String titulo) {

		try {

			destino = readFiles.email();

			resultado = "<html>The apache logo - </html>";

			// Create the email message
			HtmlEmail email = new HtmlEmail();

			email.setDebug(true);
			email.setHostName(smtp_365);
			email.setAuthenticator(new DefaultAuthenticator(office_365, senha365));
			email.addTo(destino, apelidoDestino);
			email.setFrom(office_365, apelido);
			email.setSubject(titulo);
			email.setStartTLSEnabled(true);

			String textoHtml = CorpoHtml.bodyHTML(resultado);

			// set the html message
			email.setHtmlMsg(textoHtml);

			// set the alternative message
			email.setTextMsg("Seu E-mail não suporta mensagem no formato HTML.");

			// send the email
			email.send();
			enviado = true;
			concluido = true;

		} catch (Exception e) {
			System.out.println("Email office-365 não foi enviado----------------------------");
			enviado = false;
			concluido = false;
			emailHtmlGmail(resultado, titulo);

		}

	}

	public void emailHtmlGmail(String resultado, String titulo) {

		try {

			destino = readFiles.email();
			resultado = "<html>The apache logo - </html>";
			// Create the email message
			HtmlEmail email = new HtmlEmail();

			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setSslSmtpPort("465");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("heliordf@gmail.com", "killer01734"));
			email.addTo(destino, "Helio Franca");
			email.setFrom("heliordf@gmail.com", apelido);
			email.setSubject(titulo);
			email.setStartTLSEnabled(true);

			String textoHtml = CorpoHtml.bodyHTML(resultado);

			// set the html message
			email.setHtmlMsg(textoHtml);

			// set the alternative message
			email.setTextMsg("Seu E-mail não suporta mensagem no formato HTML.");

			// send the email
			email.send();
			enviado = true;
			concluido = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			enviado = false;
			concluido = true;
			System.out.println("Email Gmail não foi enviado----------------------------");
		}

		// Cria o e-mail

	}

	public static boolean isEnviado() {
		return enviado;
	}

	public static void setEnviado(boolean enviado) {
		EnviarEmail.enviado = enviado;
	}

	public static boolean isConcluido() {
		return concluido;
	}

	public static void setConcluido(boolean concluido) {
		EnviarEmail.concluido = concluido;
	}

}
