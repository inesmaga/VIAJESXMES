
package beans;

import entities.Agenda;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import services.AgendaFacadeLocal;

/**
 *
 * @author inesm
 */
@Named(value = "tviaje")
@SessionScoped
public class Tviaje implements Serializable {

    @EJB
    private AgendaFacadeLocal agendaFacade;

  
    
    @Inject
    private Registro registro;
    
    @Inject
private PlantillaController plantillaController;
  
     @Inject
private SitioController sitioController;
     
  @PostConstruct
    public void init() {
       
    }
    
 private boolean value2;
 private List<Agenda>Ltviaje;
 private int codm;
    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }
      
    public void addMessage() {
        String summary = value2 ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
  public int getCodm() {
        return codm;
    }

    public void setCodm(int codm) {
        this.codm = codm;
    }
    
    
    
    
    public List<Agenda>obtenerLViajesG(int idmes ){
        int idpers=registro.getPers();
         codm=plantillaController.getAm();
     try {
   Ltviaje = agendaFacade.findViajGuard(codm, idpers, "G");
        } catch (Exception e) {
            //mensaje de jsf
        }
return Ltviaje;
    }

    public List<Agenda> getLtviaje() {
        return Ltviaje;
    }

    public void setLtviaje(List<Agenda> Ltviaje) {
        this.Ltviaje = Ltviaje;
    }

   
    
    public void GuardarViaje(){
    Agenda ag =new Agenda();
     try {
                     
   int eip=registro.getPers();
    
      int cv=sitioController.getCodviaj();
   
     
     
    } catch (Exception e) {
            throw e;
        }
    }
    
}
