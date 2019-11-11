/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Valoracion;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import services.ValoracionFacadeLocal;

/**
 *
 * @author inesm
 */
@Named
@SessionScoped
public class ValoracionController implements Serializable{

    @EJB
    private ValoracionFacadeLocal valoracionFacade;

   
    
    @Inject
    private Registro registro;
    
   @Inject 
   private SitioController sitioController;
   
   @Inject 
   private Rating  rating;
    private List<Valoracion> lista;
   private int tovalorac ;

    public int getTovalorac() {
        return tovalorac;
    }

    public void setTovalorac(int tovalorac) {
        this.tovalorac = tovalorac;
    }
    
    
    
    
    
   public void regisValorac(){
       Valoracion va= new Valoracion();
       java.util.Date fecha = new Date();  
       
    try {
                     
   int eip=registro.getPers();
     int cv=sitioController.getCodviaj();
     tovalorac= rating.getRating1();
         va.setIdpersona(eip);
     
     va.setIdviaje(cv);
     
     va.setFechaval(fecha);
   va.setValorac(tovalorac);
      valoracionFacade.create(va); 

 
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gracias" , "Su Valoración ha sido Registrada"));
             
    } catch (Exception e) {
            throw e;
        }
    }
    
    
    
  public void listarValoraciones(int ivia ) {
      
        try {
              int cv=sitioController.getCodviaj();
              int eip=registro.getPers();
            lista = valoracionFacade.findValoByIdviaje(cv);
            
        } catch (Exception e) {
            //mensaje de jsf
        }

    }   

      
    
    
    
}
