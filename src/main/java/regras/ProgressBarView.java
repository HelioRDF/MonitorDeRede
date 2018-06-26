package regras;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import email.EnviarEmail;
 
@ManagedBean
@ViewScoped
public class ProgressBarView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer progress;
 
    public Integer getProgress() {
    	
        if(progress == null || progress == 100) {
            progress = 0;
        }
        else {
        	 
            progress = progress + (int)(Math.random() * 4); // Onde 4 define a velocidade do ProgressBar
            if(EnviarEmail.isConcluido()){
            	progress =100;
            }
             
            if(progress > 100)
                progress = 100;
            
        }
         
        return progress;
    }
 
    public void setProgress(Integer progress) {
        this.progress = progress;
    }
     
    public void onComplete() {
    	progress =null;
    while(!EnviarEmail.isConcluido()){	

     System.out.println("Aguardando envio de e-mail...");
     try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}if(EnviarEmail.isConcluido()){
		break;
	}
    }
    
	if(EnviarEmail.isEnviado()){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enviado com Sucesso", "hhehehe"));
	}else{
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível enviar o e-mail", null));
	}
    }
     
    public void cancel() {
        progress = null;
    }
}