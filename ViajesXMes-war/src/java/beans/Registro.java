
package beans;

import entities.Persona;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import services.PersonaFacadeLocal;

/**
 *
 * @author inesm
 */

@Named(value = "registro")
@SessionScoped
public class Registro implements Serializable{

    @EJB
    private PersonaFacadeLocal personaFacade;

    
     private String nombres;
    private String apellidos;
    private String sexo;
    private Date fechaNacimiento;
    private String email;
    private String clave;
    private String username;
    private String tipo;
 private int pers;
    private String redireccion;
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public int getIntento() {
        return intento;
    }
   
    public void setIntento(int intento) {
        this.intento = intento;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
     public String registrar() {
         Persona p = new Persona();
      
    
         try {
           p.setNombres(nombres);
        p.setApellidos(apellidos);
        p.setSexo(sexo);
        p.setFechaNacimiento(fechaNacimiento);
        p.setEmail(email);
        p.setUsername(username);
        p.setClave(clave);
        p.setTipo(tipo);    
      personaFacade.create(p);
      
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenida/o" , "YA ERES DE LOS NUESTROS!"));
      
    
  return this.iniciarSesion();
         } catch (Exception e) {
             throw e;
         }
             
     }
     
    public String actualiza(){ 
  
        try {
     personaFacade.actualizarPassw(username,clave);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenida/o" , "TU PASSWORD HA SIDO CAMBIADA"));
    
return this.iniciarSesion();

}catch(Exception e){
    throw e;
}
    }    
     
     
  private   int intento=0;
 
  public String iniciarSesion(){
    String redireccion=null;
   Persona per;
    
        try {
       
         per= personaFacade.iniciarSesion(username,clave);
           if(per == null) {
              if( intento<=3 ){
               
              
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso" , "Credenciales Incorrectas, intento:"+intento+" de 3"));
                  intento=intento+1;
                   redireccion="index"; 
               }else{
         
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso" , "Has  superado los intentos con Credenciales Incorrectas, Cambiala!"));
              }
               
           }else{
                
             pers= per.getCodigo();
           Persona p= (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("per", per);
             redireccion="principal";
                 
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
    
    public int exportIntentoValor(int intento){
    
    if (intento>3){
    return intento;
} else{
    return 0;
    }
    }  
}
