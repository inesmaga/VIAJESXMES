
package beans;





import static com.sun.org.apache.xerces.internal.impl.xpath.regex.CaseInsensitiveMap.get;
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
   
   private String topinion;
private int tovalorac ;
    public String getTopinion() {
        return topinion;
    }

    public void setTopinion(String topinion) {
        this.topinion = topinion;
    }

    public int getTovalorac() {
        return tovalorac;
    }

    public void setTovalorac(int tovalorac) {
        this.tovalorac = tovalorac;
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
    public void regisValorac(){
    try {
                     
   int eip=registro.getPers();
     int cv=sitioController.getCodviaj();
     tovalorac= rating.getRating1();
    List< Opinion> op =opinionFacade.cop(cv,eip);
       if(op.get(0)!=null){ 
 

   op.get(0).setValorac(tovalorac);
       }
    } catch (Exception e) {
            throw e;
        }
    }
    
    
    
  public void listarValoraciones(int ivia ) {
        try {
              int cv=sitioController.getCodviaj();
              int eip=registro.getPers();
            lista = opinionFacade.findValoByIdviaje(cv);
            
        } catch (Exception e) {
            //mensaje de jsf
        }

    }
    
   
 
}
