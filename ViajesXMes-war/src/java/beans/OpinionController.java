
package beans;

import entities.Opinion;
import static entities.Opinion_.fechaop;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import javax.inject.Named;
import services.OpinionFacadeLocal;

/**
 *
 * @author inesm
 */
@Named
@SessionScoped
public class OpinionController implements Serializable{

    @EJB
    private OpinionFacadeLocal opinionFacade;
   
    @Inject
    private Registro registro;
    
   @Inject 
   private SitioController sitioController;
   
  
   
   @PostConstruct
   public void init(){
    
   Opinion op = new Opinion();
  
   }
   
   private List<Opinion> lista;
   
   private String topinion;

    public String getTopinion() {
        return topinion;
    }

    public void setTopinion(String topinion) {
        this.topinion = topinion;
    }
   
    
public void listarOpiniones(int ivia) {
        try {
              int cv=sitioController.getCodviaj();
            lista = opinionFacade.findByIdviaje(cv);
            
        } catch (Exception e) {
            //mensaje de jsf
        }

    }

    public void setLista(List<Opinion> lista) {
        this.lista = lista;
    }

    public List<Opinion> getLista() {
        return lista;
    }
    
   
    public void regisOpinion(){
        
         Opinion op= new Opinion();
       java.util.Date fecha = new Date();
        try {
                     
   int eip=registro.getPers();
     op.setIdpersona(eip);
      int cv=sitioController.getCodviaj();
     op.setIdviaje(cv);
      op.setOpinion(topinion);
     op.setFechaop(fecha);
       opinionFacade.create(op);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gracias" , "Su Opinion ha sido Registrada"));
       
       
        } catch (Exception e) {
            throw e;
        }

      
    }
    
    
}
