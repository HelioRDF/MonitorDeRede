
package ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {

	public static String executarComando(String comando, String equipamento) {
		Process processo;
		Boolean status = true;
		String lost = "";
		String resultado = "";


		
		StringBuffer estiloH2 =  new StringBuffer();
		estiloH2.append("padding:auto;");
		estiloH2.append("margin-left:15px;");
		estiloH2.append("color:green;");
		estiloH2.append("font:14px;");
		estiloH2.append("padding-left:20px;");
		
		StringBuffer estiloH3 =  new StringBuffer();
		estiloH3.append("padding:auto;");
		estiloH3.append("margin-left:15px;");
		estiloH3.append("color:red;");
		estiloH3.append("font:14px;");
		estiloH3.append("padding-left:20px;");
		
		
		

		try {
			processo = Runtime.getRuntime().exec(comando);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String saida = null, linha = null;

			while ((linha = entrada.readLine()) != null) {
				saida = saida == null ? linha + "\n" : saida + linha + "\n";

				System.out.println(linha);
				if (linha.contains("(100% loss)") || linha.contains("Request timed out.")
						|| linha.contains("Ping request could not find")) {
					status = false;
					lost = linha.trim();			
					break;

				}

				if (linha.contains("(0% loss)")) {
					status = true;
					lost = linha.trim();
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Caso esteja Ok
		if (status) {
			resultado = "<br> <span style=\" "+estiloH2+" \">  &ensp; &ensp; <img  src='https://uploaddeimagens.com.br/images/001/037/749/thumb/ok.png?1502471213'  width='25' height='25' align='BASELINE'  /> &ensp; &ensp; &ensp;" + equipamento + " &ensp; &ensp; --- &ensp; &ensp;" + lost + "</span><hr>";

		// Caso de erro
		} else {
			resultado = "<br> <span style=\" "+estiloH3+" \">  &ensp; &ensp; <img  src='https://uploaddeimagens.com.br/images/001/037/751/full/erro.png?1502471274' width='25' height='25' align='BASELINE'  />&ensp; &ensp; &ensp;" + equipamento  + " &ensp; &ensp; --- &ensp; &ensp;" + lost + "</span><hr>";
		}

		return resultado;
	}

}
