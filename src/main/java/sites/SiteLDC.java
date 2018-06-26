package sites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import bean.Controle;
import domain.LDC;
import ping.Ping;
import ping.PingLoop;

public class SiteLDC {

	// Equipamentos
    HashMap <String, String> servidores = new HashMap<String, String>();
    HashMap <String, String> storage = new HashMap<String, String>();
    HashMap <String, String> tunel = new HashMap<String, String>();
    
    String comando="ping ";
    
    // Servidores
	LDC servidorNpcs = new LDC();
	LDC servidorNpds = new LDC();
	LDC servidorNprs = new LDC();
	LDC servidorNprs2 = new LDC();
	
	// Storage
	LDC storageISCSI1a = new LDC();
	LDC storageISCSI1b = new LDC();
	
	// Storage
	LDC tunelSLG = new LDC();
	LDC tunelSJQ = new LDC();
	
	
	

    
    
	public ArrayList<LDC> setarValoresGui(){
		
		
		ArrayList<LDC> allLDC = new ArrayList<>();
		
		
		// Servidores -----------------------------------------------------------------------------------------------------------------------------
		servidorNpcs.setEquipamento("servidorNpcs");
		servidorNpcs.setIp("10.28.8.1");		
		servidorNpcs.setStatus(PingLoop.executarComando(comando+" "+servidorNpcs.getIp(), servidorNpcs.getEquipamento() ));
		allLDC.add(servidorNpcs);
		
		
		servidorNpds.setEquipamento("servidorNpds");
		servidorNpds.setIp("10.28.9.1");		
		servidorNpds.setStatus(PingLoop.executarComando(comando+" "+servidorNpds.getIp(), servidorNpds.getEquipamento() ));
		allLDC.add(servidorNpds);
		
		
		servidorNprs.setEquipamento("servidorNprs");
		servidorNprs.setIp("10.20.0.1");		
		servidorNprs.setStatus(PingLoop.executarComando(comando+" "+servidorNprs.getIp(), servidorNprs.getEquipamento() ));
		allLDC.add(servidorNprs);

		
		
		servidorNprs2.setEquipamento("servidorNprs2");
		servidorNprs2.setIp("10.20.0.2");		
		servidorNprs2.setStatus(PingLoop.executarComando(comando+" "+servidorNprs2.getIp(), servidorNprs2.getEquipamento() ));
		allLDC.add(servidorNprs2);
	

	    
	    // Storage -----------------------------------------------------------------------------------------------------------------------------
		
		storageISCSI1a.setEquipamento("storageISCSI1a");
		storageISCSI1a.setIp("10.20.0.11");		
		storageISCSI1a.setStatus(PingLoop.executarComando(comando+" "+storageISCSI1a.getIp(), storageISCSI1a.getEquipamento() ));
		allLDC.add(storageISCSI1a);
	
		
		storageISCSI1b.setEquipamento("storageISCSI1b");
		storageISCSI1b.setIp("10.20.0.12");		
		storageISCSI1b.setStatus(PingLoop.executarComando(comando+" "+storageISCSI1b.getIp(), storageISCSI1b.getEquipamento() ));
		allLDC.add(storageISCSI1b);
	

	    // tunel -----------------------------------------------------------------------------------------------------------------------------
		tunelSLG.setEquipamento("tunelSLG");
		tunelSLG.setIp("45.1.1.1");		
		tunelSLG.setStatus(PingLoop.executarComando(comando+" "+tunelSLG.getIp(), tunelSLG.getEquipamento() ));
		allLDC.add(tunelSLG);

		
		tunelSJQ.setEquipamento("tunelSJQ");
		tunelSJQ.setIp("40.1.1.2");		
		tunelSJQ.setStatus(PingLoop.executarComando(comando+" "+tunelSJQ.getIp(), tunelSJQ.getEquipamento() ));
		allLDC.add(tunelSJQ);

		System.out.println("\n------------- Equipamentos LDC -----------------\n");
for (LDC ldc : allLDC) {
			
			if(!ldc.getStatus()){
				Controle c = new Controle();				
				c.setErroPing(true);
				System.out.println("Falha no equipamento: \t"+ldc.getEquipamento());
				
			}else{
				
				System.out.println("Comunicação normal: \t"+ldc.getEquipamento());
				
			}
			
		}

System.out.println("\n------------------------------------------------\n");

		
		return allLDC;

	}

	public String validarSite() {
		StringBuffer resultado = new StringBuffer();
		StringBuffer estiloFundo = new StringBuffer();
		StringBuffer rodape = new StringBuffer();
		
		
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String data = formatter.format( new Date() );

		estiloFundo.append("background:#fff;");
		estiloFundo.append("border-radius:10px;");
		estiloFundo.append("width:95%;");
		estiloFundo.append("margin:30px;");
		estiloFundo.append("border: 2px solid;");
		estiloFundo.append("border-color: #499c73;");//verde
		estiloFundo.append("position:relative;");

		StringBuffer estiloH1 = new StringBuffer();
		estiloH1.append("margin-top:10px;");
		estiloH1.append("font:26px;");
		estiloH1.append("color:#45455a;");// Azul escuro
		estiloH1.append("padding-left:30px;");
		
		rodape.append("background:#aedead;");
		rodape.append("width:100%;");
		rodape.append("height:100px;");
		rodape.append("font-size:12px;");

		resultado.append("<br><br>  <div style=\" " + estiloFundo + " \"><br><h1 style=\" " + estiloH1
				+ " \"  > &ensp;&ensp; -  Largo da Concordia - CEF</h1><hr>");

		   // Servidores
        servidores.put( "servidorNpcs","ping 10.28.8.1");
        servidores.put( "servidorNpds","ping 10.28.9.1");
        servidores.put( "servidorNprs","ping 10.20.0.1");
        servidores.put( "servidorNprs2","ping 10.20.0.2");
        resultado.append(Ping.executarComando(servidores.get("servidorNpcs"), "Servidor Npxs 01 - IP: 10.28.8.1"));
        resultado.append(Ping.executarComando(servidores.get("servidorNpds"), "Servidor Npxs 02 - IP: 10.28.9.1"));
        resultado.append(Ping.executarComando(servidores.get("servidorNprs"), "Servidor Npms 01 - IP: 10.20.0.1"));
        resultado.append(Ping.executarComando(servidores.get("servidorNprs2"),"Servidor Npms 02 - IP: 10.20.0.2"));
        
        
        // Storage
        storage.put( "storageISCSI1a","ping 10.20.0.11");
        storage.put( "storageISCSI1b","ping 10.20.0.12");
    
        
        resultado.append(Ping.executarComando(storage.get("storageISCSI1a"), "Storage ISCSI1 1.a - IP: 10.20.0.11"));
        resultado.append(Ping.executarComando(storage.get("storageISCSI1b"), "Storage ISCSI1 1.b - IP: 10.20.0.12"));

        


        // tunel
        tunel.put("tunelSLG", "ping 45.1.1.1");
        tunel.put("tunelSJQ", "ping 40.1.1.2");
        resultado.append(Ping.executarComando(tunel.get("tunelSLG"), "Tunel SLG - IP: 45.1.1.1"));
        resultado.append(Ping.executarComando(tunel.get("tunelSJQ"), "Tunel SJQ - IP: 40.1.1.2"));

		resultado.append("<div style=\" " + rodape +  " \"> <br> <span> Data: "+ data +"<br></span></div></div>");
		return resultado.toString();

	}

}
