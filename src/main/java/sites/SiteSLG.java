package sites;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Controle;
import domain.SLG;
import ping.Ping;
import ping.PingLoop;

public class SiteSLG {

	// Equipamentos
	HashMap<String, String> audioCodes = new HashMap<String, String>();
	HashMap<String, String> sbc = new HashMap<String, String>();
	HashMap<String, String> servidores = new HashMap<String, String>();
	HashMap<String, String> storage = new HashMap<String, String>();
	HashMap<String, String> tunel = new HashMap<String, String>();

	String comando = "ping ";

	// audioCodes;
	SLG audioCodes1000_251 = new SLG();
	SLG audioCodes1000_252 = new SLG();
	SLG audioCodes2000_253 = new SLG();
	SLG audioCodes2000_254 = new SLG();

	// SBC
	SLG acmePacketPort1 = new SLG();
	SLG acmePacketPort2 = new SLG();
	SLG acmePacketPort3 = new SLG();
	SLG acmePacketPort4 = new SLG();

	// Servidores
	SLG servidorNpcs = new SLG();
	SLG servidorNpds = new SLG();
	SLG servidorNprs = new SLG();
	SLG servidorNprs2 = new SLG();

	// Storage
	SLG storageISCSI1a = new SLG();
	SLG storageISCSI1b = new SLG();
	SLG storageISCSI1c = new SLG();
	SLG storageISCSI1d = new SLG();

	// tunel
	SLG tunelLDC = new SLG();
	SLG tunelSJQ = new SLG();

	public ArrayList<SLG> setarValoresGui() {

		ArrayList<SLG> allSLG = new ArrayList<>();

		// AudioCodes
		// -----------------------------------------------------------------------------------------------------------------------------
		audioCodes1000_251.setEquipamento("audioCodes1000_251");
		audioCodes1000_251.setIp("10.0.251.1");
		audioCodes1000_251.setStatus(PingLoop.executarComando(comando + " " + audioCodes1000_251.getIp(),
				audioCodes1000_251.getEquipamento()));
		allSLG.add(audioCodes1000_251);

		audioCodes1000_252.setEquipamento("audioCodes1000_252");
		audioCodes1000_252.setIp("10.0.252.1");
		audioCodes1000_252.setStatus(PingLoop.executarComando(comando + " " + audioCodes1000_252.getIp(),
				audioCodes1000_252.getEquipamento()));
		allSLG.add(audioCodes1000_252);

		audioCodes2000_253.setEquipamento("audioCodes2000_253");
		audioCodes2000_253.setIp("10.0.253.1");
		audioCodes2000_253.setStatus(PingLoop.executarComando(comando + " " + audioCodes2000_253.getIp(),
				audioCodes2000_253.getEquipamento()));
		allSLG.add(audioCodes2000_253);

		audioCodes2000_254.setEquipamento("audioCodes2000_254");
		audioCodes2000_254.setIp("10.0.254.1");
		audioCodes2000_254.setStatus(PingLoop.executarComando(comando + " " + audioCodes2000_254.getIp(),
				audioCodes2000_254.getEquipamento()));
		allSLG.add(audioCodes2000_254);

		// Acme
		// -----------------------------------------------------------------------------------------------------------------------------
		acmePacketPort1.setEquipamento("acmePacketPort1");
		acmePacketPort1.setIp("10.9.1.1");
		acmePacketPort1.setStatus(
				PingLoop.executarComando(comando + " " + acmePacketPort1.getIp(), acmePacketPort1.getEquipamento()));
		allSLG.add(acmePacketPort1);

		acmePacketPort2.setEquipamento("acmePacketPort2");
		acmePacketPort2.setIp("10.9.2.1");
		acmePacketPort2.setStatus(
				PingLoop.executarComando(comando + " " + acmePacketPort2.getIp(), acmePacketPort2.getEquipamento()));
		allSLG.add(acmePacketPort2);

		acmePacketPort3.setEquipamento("acmePacketPort3");
		acmePacketPort3.setIp("10.8.1.1");
		acmePacketPort3.setStatus(
				PingLoop.executarComando(comando + " " + acmePacketPort3.getIp(), acmePacketPort3.getEquipamento()));
		allSLG.add(acmePacketPort3);

		acmePacketPort4.setEquipamento("acmePacketPort4");
		acmePacketPort4.setIp("10.8.2.1");
		acmePacketPort4.setStatus(
				PingLoop.executarComando(comando + " " + acmePacketPort4.getIp(), acmePacketPort4.getEquipamento()));
		allSLG.add(acmePacketPort4);

		// Servidores
		// -----------------------------------------------------------------------------------------------------------------------------
		servidorNpcs.setEquipamento("servidorNpcs");
		servidorNpcs.setIp("10.8.5.1");
		servidorNpcs.setStatus(
				PingLoop.executarComando(comando + " " + servidorNpcs.getIp(), servidorNpcs.getEquipamento()));
		allSLG.add(servidorNpcs);

		servidorNpds.setEquipamento("servidorNpds");
		servidorNpds.setIp("10.8.9.1");
		servidorNpds.setStatus(
				PingLoop.executarComando(comando + " " + servidorNpds.getIp(), servidorNpds.getEquipamento()));
		allSLG.add(servidorNpds);

		servidorNprs.setEquipamento("servidorNprs");
		servidorNprs.setIp("10.8.6.1");
		servidorNprs.setStatus(
				PingLoop.executarComando(comando + " " + servidorNprs.getIp(), servidorNprs.getEquipamento()));
		allSLG.add(servidorNprs);

		servidorNprs2.setEquipamento("servidorNprs2");
		servidorNprs2.setIp("10.8.7.1");
		servidorNprs2.setStatus(
				PingLoop.executarComando(comando + " " + servidorNprs2.getIp(), servidorNprs2.getEquipamento()));
		allSLG.add(servidorNprs2);

		// Storage
		// -----------------------------------------------------------------------------------------------------------------------------

		storageISCSI1a.setEquipamento("storageISCSI1a");
		storageISCSI1a.setIp("10.8.11.1");
		storageISCSI1a.setStatus(
				PingLoop.executarComando(comando + " " + storageISCSI1a.getIp(), storageISCSI1a.getEquipamento()));
		allSLG.add(storageISCSI1a);

		storageISCSI1b.setEquipamento("storageISCSI1b");
		storageISCSI1b.setIp("10.0.0.11");
		storageISCSI1b.setStatus(
				PingLoop.executarComando(comando + " " + storageISCSI1b.getIp(), storageISCSI1b.getEquipamento()));
		allSLG.add(storageISCSI1b);

		storageISCSI1c.setEquipamento("storageISCSI1c");
		storageISCSI1c.setIp("10.8.12.1");
		storageISCSI1c.setStatus(
				PingLoop.executarComando(comando + " " + storageISCSI1c.getIp(), storageISCSI1c.getEquipamento()));
		allSLG.add(storageISCSI1c);

		storageISCSI1d.setEquipamento("storageISCSI1d");
		storageISCSI1d.setIp("10.0.0.12");
		storageISCSI1d.setStatus(
				PingLoop.executarComando(comando + " " + storageISCSI1d.getIp(), storageISCSI1d.getEquipamento()));
		allSLG.add(storageISCSI1d);

		// tunel
		// -----------------------------------------------------------------------------------------------------------------------------

		tunelLDC.setEquipamento("tunelLDC");
		tunelLDC.setIp("41.1.1.1");
		tunelLDC.setStatus(PingLoop.executarComando(comando + " " + tunelLDC.getIp(), tunelLDC.getEquipamento()));
		allSLG.add(tunelLDC);

		tunelSJQ.setEquipamento("tunelSJQ");
		tunelSJQ.setIp("45.1.1.2");
		tunelSJQ.setStatus(PingLoop.executarComando(comando + " " + tunelSJQ.getIp(), tunelSJQ.getEquipamento()));
		allSLG.add(tunelSJQ);

		System.out.println("\n------------- Equipamentos SLG -----------------\n");
		for (SLG slg : allSLG) {

			if (!slg.getStatus()) {
				Controle c = new Controle();
				c.setErroPing(true);
				System.out.println("Falha no equipamento: \t" + slg.getEquipamento());

			} else {

				System.out.println("Comunicação normal: \t" + slg.getEquipamento());

			}

		}

		System.out.println("\n------------------------------------------------\n");

		return allSLG;

	}

	public String validarSite() {
		StringBuffer resultado = new StringBuffer();
		StringBuffer estiloFundo = new StringBuffer();

		estiloFundo.append("background:#fff;");
		estiloFundo.append("width:95%;");
		estiloFundo.append("border-radius:10px;");
		estiloFundo.append("margin:30px;");
		estiloFundo.append("border: 2px solid;");
		estiloFundo.append("border-color: #c1c12a;");// amarelo
		estiloFundo.append("position:relative;");

		StringBuffer estiloH1 = new StringBuffer();
		estiloH1.append("margin-top:10px;");
		estiloH1.append("font:26px;");
		estiloH1.append("color:#45455a;");// Azul escuro
		estiloH1.append("padding-left:30px;");

		resultado.append("<br><br>  <div style=\" " + estiloFundo + " \"><br><h1 style=\" " + estiloH1
				+ " \"  > &ensp;&ensp; -  São Luís Gonzaga - CEF </h1><hr>");

		// Define os valores dos atributos.
		// AudioCodes ...
		audioCodes.put("audioCodes1000_251", "ping 10.0.251.1");
		audioCodes.put("audioCodes1000_252", "ping 10.0.252.1");
		audioCodes.put("audioCodes2000_253", "ping 10.0.253.1");
		audioCodes.put("audioCodes2000_254", "ping 10.0.254.1");

		// SBC
		sbc.put("acmePacketPort1", "ping 10.9.1.1");
		sbc.put("acmePacketPort2", "ping 10.9.2.1");
		sbc.put("acmePacketPort3", "ping 10.8.1.1");
		sbc.put("acmePacketPort4", "ping 10.8.2.1");

		// Servidores
		servidores.put("servidorNpcs", "ping 10.8.5.1");
		servidores.put("servidorNpds", "ping 10.8.9.1");
		servidores.put("servidorNprs", "ping 10.8.6.1");
		servidores.put("servidorNprs2", "ping 10.8.7.1");

		// Storage
		storage.put("storageISCSI1a", "ping 10.8.11.1");
		storage.put("storageISCSI1b", "ping 10.0.0.11");
		storage.put("storageISCSI1c", "ping 10.8.12.1");
		storage.put("storageISCSI1d", "ping 10.0.0.12");

		// tunel
		tunel.put("tunelLDC", "ping 41.1.1.1");
		tunel.put("tunelSJQ", "ping 45.1.1.2");

		// AudioCodes ...
		resultado
				.append(Ping.executarComando(audioCodes.get("audioCodes1000_251"), "AudioCodes 1000 - IP: 10.0.251.1"));
		resultado
				.append(Ping.executarComando(audioCodes.get("audioCodes1000_252"), "AudioCodes 1000 - IP: 10.0.252.1"));
		resultado
				.append(Ping.executarComando(audioCodes.get("audioCodes2000_253"), "AudioCodes 2000 - IP: 10.0.253.1"));
		resultado
				.append(Ping.executarComando(audioCodes.get("audioCodes2000_254"), "AudioCodes 2000 - IP: 10.0.254.1"));

		// SBC
		resultado.append(Ping.executarComando(sbc.get("acmePacketPort1"), "AcmePacket Port 1 - IP: 10.9.1.1"));
		resultado.append(Ping.executarComando(sbc.get("acmePacketPort2"), "AcmePacket Port 2 -; IP: 10.9.2.1"));
		resultado.append(Ping.executarComando(sbc.get("acmePacketPort3"), "AcmePacket Port 3 - IP: 10.8.1.1"));
		resultado.append(Ping.executarComando(sbc.get("acmePacketPort4"), "AcmePacket Port 4 - IP: 10.8.2.1"));

		// Servidores
		resultado.append(Ping.executarComando(servidores.get("servidorNpcs"), "Servidor Npcs - IP: 10.8.5.1"));
		resultado.append(Ping.executarComando(servidores.get("servidorNpds"), "Servidor Npds - IP: 10.8.9.1"));
		resultado.append(Ping.executarComando(servidores.get("servidorNprs"), "Servidor Nprs -; IP: 10.8.6.1"));
		resultado.append(Ping.executarComando(servidores.get("servidorNprs2"), "Servidor Nprs2 - IP: 10.8.7.1"));

		// Storage
		resultado.append(Ping.executarComando(storage.get("storageISCSI1a"), "Storage ISCSI1 1.a - IP: 10.8.11.1"));
		resultado.append(Ping.executarComando(storage.get("storageISCSI1b"), "Storage ISCSI1 1.b - IP: 10.0.0.11"));
		resultado.append(Ping.executarComando(storage.get("storageISCSI1c"), "Storage ISCSI1 2.a - IP: 10.8.12.1"));
		resultado.append(Ping.executarComando(storage.get("storageISCSI1d"), "Storage ISCSI1 2.b - IP: 10.0.0.12"));

		// tunel
		resultado.append(Ping.executarComando(tunel.get("tunelLDC"), "Tunel LDC - IP: 41.1.1.1"));
		resultado.append(Ping.executarComando(tunel.get("tunelSJQ"), "Tunel SJQ - IP: 45.1.1.2"));

		resultado.append("</div>");
		return resultado.toString();

	}

}
