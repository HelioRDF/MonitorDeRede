
package ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingLoop {

	public static boolean executarComando(String comando, String equipamento) {
		Process processo;
		boolean status = false;

		try {
			processo = Runtime.getRuntime().exec(comando);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String saida = null, linha = null;

			while ((linha = entrada.readLine()) != null) {
				saida = saida == null ? linha + "\n" : saida + linha + "\n";

				// Falha na Comunicação
				if (linha.contains("(100% loss)") || linha.contains("Request timed out.")
						|| linha.contains("Ping request could not find")) {
					status = false;
					break;

				}

				// Comunicação Bem-Sucedida
				if (linha.contains("(0% loss)")) {
					status = true;
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return status;
	}

}
