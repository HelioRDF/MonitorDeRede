package regras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteFiles {

	private static final String pathControl = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/logs/monitor/control.txt";
	private static final String pathMail = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/logs/monitor/sendmail.txt";
	private static final String pathStart = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/logs/monitor/start-stop.txt";
	static String dias;

	public static void main(String[] args) {
		WriteFiles w = new WriteFiles();
		try {

			w.mail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void control() throws IOException {
		File file = new File(pathControl);

		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		writer.write("fim"); // senha 17
		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println("Arquivo gravado em: " + pathControl);
	}

	public void mail() throws IOException {
		File file = new File(pathMail);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		writer.newLine();
		writer.write("E-mail enviado:\t " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		writer.newLine();
		writer.write("-------------------------------------------------------------------");

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();
		System.out.println("Arquivo gravado em: " + pathMail);
	}

	public void start() throws IOException {
		File file = new File(pathStart);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.newLine();
		writer.write("Start: " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		writer.newLine();
		writer.write("------------------------------------------------------------");
		writer.newLine();

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();

	}

	public void stop() throws IOException {
		
		File file = new File(pathStart);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.newLine();
		writer.write("Stop: " + new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		writer.newLine();
		writer.write("------------------------------------------------------------");
		writer.newLine();

		// Criando o conteúdo do arquivo
		writer.flush();
		// Fechando conexão e escrita do arquivo.
		writer.close();

	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		WriteFiles.dias = dias;
	}

}
