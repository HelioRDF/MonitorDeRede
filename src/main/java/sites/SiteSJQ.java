package sites;

import java.util.ArrayList;
import java.util.HashMap;

import bean.Controle;
import domain.SJQ;
import ping.Ping;
import ping.PingLoop;

public class SiteSJQ {

    // Equipamentos
    HashMap <String, String> audioCodes = new HashMap<String, String>();
    HashMap <String, String> sbc = new HashMap<String, String>();
    HashMap <String, String> servidores = new HashMap<String, String>();
    HashMap <String, String> storage = new HashMap<String, String>();
    HashMap <String, String> tunel = new HashMap<String, String>();
    
    String comando="ping ";
    
	//audioCodes;
	SJQ audioCodes2000_254 = new SJQ();
	
	// SBC
	SJQ acmePacketPort1 = new SJQ();
	SJQ acmePacketPort2 = new SJQ();
	
	
    // Servidores
	SJQ servidorNpcs = new SJQ();
	SJQ servidorNpds = new SJQ();
	SJQ servidorNprs = new SJQ();
	SJQ servidorNprs2 = new SJQ();
	
	 // Storage
	SJQ storageISCSI1a = new SJQ();
	SJQ storageISCSI1b = new SJQ();
	SJQ storageISCSI1c = new SJQ();
	SJQ storageISCSI1d = new SJQ();
	
	// tunel
	SJQ tunelSLG = new SJQ();
	SJQ tunelLDC = new SJQ();
	
	

	

    
	
	public ArrayList<SJQ> setarValoresGui(){
		
		
		ArrayList<SJQ> allSJQ = new ArrayList<>();
		
		//AudioCodes -----------------------------------------------------------------------------------------------------------------------------
		audioCodes2000_254.setEquipamento("audioCodes2000_254");
		audioCodes2000_254.setIp("10.10.254.1");		
		audioCodes2000_254.setStatus(PingLoop.executarComando(comando+" "+audioCodes2000_254.getIp(), audioCodes2000_254.getEquipamento() ));
		allSJQ.add(audioCodes2000_254);
	
		
		
	    // SBC -----------------------------------------------------------------------------------------------------------------------------	
		acmePacketPort1.setEquipamento("acmePacketPort1");
		acmePacketPort1.setIp("10.18.1.1");		
		acmePacketPort1.setStatus(PingLoop.executarComando(comando+" "+acmePacketPort1.getIp(), acmePacketPort1.getEquipamento() ));
		allSJQ.add(acmePacketPort1);

		
		acmePacketPort2.setEquipamento("acmePacketPort2");
		acmePacketPort2.setIp("10.18.2.1");		
		acmePacketPort2.setStatus(PingLoop.executarComando(comando+" "+acmePacketPort2.getIp(), acmePacketPort2.getEquipamento() ));
		allSJQ.add(acmePacketPort2);
	
		
		
		
		
		
		
		// Servidores  -----------------------------------------------------------------------------------------------------------------------------	
		servidorNpcs.setEquipamento("servidorNpcs");
		servidorNpcs.setIp("10.18.5.1");		
		servidorNpcs.setStatus(PingLoop.executarComando(comando+" "+servidorNpcs.getIp(), servidorNpcs.getEquipamento() ));
		allSJQ.add(servidorNpcs);

		
		servidorNpds.setEquipamento("servidorNpds");
		servidorNpds.setIp("10.18.9.1");		
		servidorNpds.setStatus(PingLoop.executarComando(comando+" "+servidorNpds.getIp(), servidorNpds.getEquipamento() ));
		allSJQ.add(servidorNpds);

		
		servidorNprs.setEquipamento("servidorNprs");
		servidorNprs.setIp("10.18.6.1");		
		servidorNprs.setStatus(PingLoop.executarComando(comando+" "+servidorNprs.getIp(), servidorNprs.getEquipamento() ));
		allSJQ.add(servidorNprs);

		
		servidorNprs2.setEquipamento("servidorNprs2");
		servidorNprs2.setIp("10.18.7.1");		
		servidorNprs2.setStatus(PingLoop.executarComando(comando+" "+servidorNprs2.getIp(), servidorNprs2.getEquipamento() ));
		allSJQ.add(servidorNprs2);

		

	    
	    // Storage  -----------------------------------------------------------------------------------------------------------------------------	
		storageISCSI1a.setEquipamento("storageISCSI1a");
		storageISCSI1a.setIp("10.18.11.1");		
		storageISCSI1a.setStatus(PingLoop.executarComando(comando+" "+storageISCSI1a.getIp(), storageISCSI1a.getEquipamento() ));
		allSJQ.add(storageISCSI1a);
	
		
		storageISCSI1b.setEquipamento("storageISCSI1b");
		storageISCSI1b.setIp("10.10.0.11");		
		storageISCSI1b.setStatus(PingLoop.executarComando(comando+" "+storageISCSI1b.getIp(), storageISCSI1b.getEquipamento() ));
		allSJQ.add(storageISCSI1b);

		
		storageISCSI1c.setEquipamento("storageISCSI1c");
		storageISCSI1c.setIp("10.18.12.1");		
		storageISCSI1c.setStatus(PingLoop.executarComando(comando+" "+storageISCSI1c.getIp(), storageISCSI1c.getEquipamento() ));
		allSJQ.add(storageISCSI1c);
	
		
		storageISCSI1d.setEquipamento("storageISCSI1d");
		storageISCSI1d.setIp("10.10.0.12");		
		storageISCSI1d.setStatus(PingLoop.executarComando(comando+" "+storageISCSI1d.getIp(), storageISCSI1d.getEquipamento() ));
		allSJQ.add(storageISCSI1d);
	
	

	    // tunel   -----------------------------------------------------------------------------------------------------------------------------	
		tunelSLG.setEquipamento("tunelSLG");
		tunelSLG.setIp("45.1.1.1");		
		tunelSLG.setStatus(PingLoop.executarComando(comando+" "+tunelSLG.getIp(), tunelSLG.getEquipamento() ));
		allSJQ.add(tunelSLG);
	
		
		tunelLDC.setEquipamento("tunelLDC");
		tunelLDC.setIp("40.1.1.1");		
		tunelLDC.setStatus(PingLoop.executarComando(comando+" "+tunelLDC.getIp(), tunelLDC.getEquipamento() ));
		allSJQ.add(tunelLDC);

		
		System.out.println("\n------------- Equipamentos SJQ -----------------\n");
		for (SJQ sjq : allSJQ) {
			
			if(!sjq.getStatus()){
				Controle c = new Controle();				
				c.setErroPing(true);
				System.out.println("Falha no equipamento: \t "+sjq.getEquipamento());
				
			}else{
				
				System.out.println("Comunicação normal: \t"+sjq.getEquipamento());
				
			}
			
		}
		System.out.println("\n------------------------------------------------\n");

		
		return allSJQ;

	}
    

	public String validarSite() {
		StringBuffer resultado = new StringBuffer();
		StringBuffer estiloFundo = new StringBuffer();

		estiloFundo.append("background:#fff;");
		estiloFundo.append("border-radius:10px;");
		estiloFundo.append("width:95%;");
		estiloFundo.append("margin:30px;");

		estiloFundo.append("border: 2px solid;");
		estiloFundo.append("border-color:#4d6296;"); // Azul
		estiloFundo.append("position:relative;");
		
		StringBuffer estiloH1 = new StringBuffer();
		estiloH1.append("margin-top:10px;");
		estiloH1.append("font:26px;");
		estiloH1.append("color:#45455a;");// Azul escuro
		estiloH1.append("padding-left:30px;");
		
		resultado.append("<br><br>  <div style=\" " + estiloFundo + " \"><br><h1 style=\" " + estiloH1
		+ " \"  > &ensp;&ensp; -  São Joaquim - CEF</h1><hr>");

		 // AudioCodes ...
        audioCodes.put( "audioCodes2000_254", "ping 10.10.254.1");
        resultado.append(Ping.executarComando(audioCodes.get("audioCodes2000_254"),"AudioCodes 2000 - IP: 10.10.254.1"));
        
        // SBC
        sbc.put( "acmePacketPort1","ping 10.18.1.1");
        sbc.put( "acmePacketPort2","ping 10.18.2.1");

        resultado.append(Ping.executarComando(sbc.get("acmePacketPort1"),"acmePacket Port 1 - IP: 10.18.1.1"));
        resultado.append(Ping.executarComando(sbc.get("acmePacketPort2"),"acmePacket Port 2 - IP: 10.18.2.1"));
        
        // Servidores
        servidores.put( "servidorNpcs","ping 10.18.5.1");
        servidores.put( "servidorNpds","ping 10.18.9.1");
        servidores.put( "servidorNprs","ping 10.18.6.1");
        servidores.put( "servidorNprs2","ping 10.18.7.1");
        resultado.append(Ping.executarComando(servidores.get("servidorNpcs"),"Servidor Npcs - IP: 10.18.5.1"));
        resultado.append(Ping.executarComando(servidores.get("servidorNpds"),"Servidor Npds - IP: 10.18.9.1"));
        resultado.append(Ping.executarComando(servidores.get("servidorNprs"),"Servidor Nprs - IP: 10.18.6.1"));
        resultado.append(Ping.executarComando(servidores.get("servidorNprs2"),"Servidor Nprs2 - IP: 10.18.7.1"));
                
        // Storage
        storage.put( "storageISCSI1a","ping 10.18.11.1");
        storage.put( "storageISCSI1b","ping 10.10.0.11");
        storage.put( "storageISCSI1c","ping 10.18.12.1");
        storage.put( "storageISCSI1d","ping 10.10.0.12");
        
        resultado.append(Ping.executarComando(storage.get("storageISCSI1a"), "Storage ISCSI1 1.a - IP: 10.18.11.1"));
        resultado.append(Ping.executarComando(storage.get("storageISCSI1b"), "Storage ISCSI1 1.b - IP: 10.10.0.11"));
        resultado.append(Ping.executarComando(storage.get("storageISCSI1c"), "Storage ISCSI1 2.a - IP: 10.18.12.1"));
        resultado.append(Ping.executarComando(storage.get("storageISCSI1d"), "Storage ISCSI1 2.b - IP: 10.10.0.12"));
        
        // tunel
        tunel.put("tunelSLG", "ping 40.1.1.1");
        tunel.put("tunelLDC", "ping 45.1.1.1");
        resultado.append(Ping.executarComando(tunel.get("tunelSLG"), "Tunel SLG - IP: 45.1.1.1"));
        resultado.append(Ping.executarComando(tunel.get("tunelLDC"), "Tunel LDC - IP: 40.1.1.1"));

		resultado.append("</div>");
		return resultado.toString();

	}

}
