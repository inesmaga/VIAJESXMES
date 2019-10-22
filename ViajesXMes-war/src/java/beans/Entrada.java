
package beans;

import entities.Persona;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import services.PersonaFacadeLocal;

/**
 *
 * @author inesm
 */
@Named
@SessionScoped
public class Entrada implements Serializable{

    @EJB
    private PersonaFacadeLocal personaFacade;
    
    
    private Persona persona;
    private String username;
    private String clave;
    private int pers;
    
    
    @PostConstruct
    public void init(){
    Persona pe = new Persona();
   pe.setUsername(username);
    pe.setClave(clave);
     }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String iniciarSesion(){
    String redireccion=null;
    Persona per;
        try {
          per= personaFacade.iniciarSesion(username,clave);
          if(per!= null){
             pers= per.getCodigo();
           Persona p= (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("per", per);
             redireccion="principal";
             
          }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso" , "Credenciales Incorrectas"));
          }
        } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
          
        }
        return redireccion;
    }

    public int getPers() {
        return pers;
    }

    public void setPers(int pers) {
        this.pers = pers;
    }

  
  
}
