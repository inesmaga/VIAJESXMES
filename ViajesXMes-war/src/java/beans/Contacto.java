package beans;

import entities.Contactos;
import entities.Persona;
import static entities.Persona_.clave;
import static entities.Persona_.username;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import services.ContactosFacadeLocal;
import services.PersonaFacadeLocal;

/**
 *
 * @author inesm
 */
@Named(value = "contacto")
@SessionScoped
public class Contacto implements Serializable {

    @EJB
    private PersonaFacadeLocal personaFacade;

    

    @EJB
    private ContactosFacadeLocal contactosFacade;

      @Inject
    private Registro registro;
    
    @PostConstruct
   public void init(){
    
   Contacto contact = new Contacto();
  
   }
  
    private String tocontacto;
    private String totema;
    public String getTocontacto() {
        return tocontacto;
    }

    public void setTocontacto(String tocontacto) {
        this.tocontacto = tocontacto;
    }

    public String getTotema() {
        return totema;
    }

    public void setTotema(String totema) {
        this.totema = totema;
    }

   
    
    
    
     public void regisContacto(){
      
          Contactos contact = new Contactos();
       java.util.Date fecha = new Date();
        int eip=registro.getPers();
    
   contact.setIdpersona(eip);
   contact.setFechacont(fecha);
   contact.setDescripcion(tocontacto);
   contact.setTema(totema);
   contactosFacade.create(contact);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gracias" , "Su Contacto ha sido Guardado"));
       
        
     }   

}
