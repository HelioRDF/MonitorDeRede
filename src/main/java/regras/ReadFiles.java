package regras;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
	
	private static File file = new File("C:/Program Files/Apache Software Foundation/Tomcat 9.0/logs/monitor/control.txt");
	private static File email = new File("C:/Program Files/Apache Software Foundation/Tomcat 9.0/logs/monitor/email.txt");
	
	
	public  String read() throws IOException{
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
//		while((data = reader.readLine()) != null){
//			System.out.println(data);
//		}
		
		data = reader.readLine();
		fileReader.close();
		reader.close();
		return data;
	}
	
	
	
	public  String email() throws IOException{
		
		FileReader fileReader = new FileReader(email);
		BufferedReader reader = new BufferedReader(fileReader);
		String data = null;
		
		data = reader.readLine();
		fileReader.close();
		reader.close();
		return data;
	}
//	public static void main(String[] args) {
//		try{
//			ReadFiles.read(file);
//		}catch(IOException e){
//			e.printStackTrace();
//		}
//		
//	}
}