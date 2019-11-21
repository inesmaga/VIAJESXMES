
package beans;






import entities.Opinion;

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
   
   @Inject 
   private Rating  rating;
   
   @PostConstruct
   public void init(){
    
   Opinion op = new Opinion();
  

  
   }
   
   private List<Opinion> lista;
   private List<Opinion> listaOT;
   private String topinion;

    public String getTopinion() {
        return topinion;
    }

    public void setTopinion(String topinion) {
        this.topinion = topinion;
    }

 
   
    public List<Opinion> listarOpinionesOU() {
        
            int eip=registro.getPers();
              int cv=sitioController.getCodviaj();
            listaOT =opinionFacade.findOByIdviajeOP(cv, eip);
            
return listaOT;
    }

    public List<Opinion> getLista() {
        return lista;
    }

    public void setLista(List<Opinion> lista) {
        this.lista = lista;
    }

    public List<Opinion> getListaOT() {
        return listaOT;
    }

    public void setListaOT(List<Opinion> listaOT) {
        this.listaOT = listaOT;
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
