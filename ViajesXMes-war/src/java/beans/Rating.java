/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Opinion;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RateEvent;
import services.OpinionFacadeLocal;
import services.ValoracionFacadeLocal;

/**
 *
 * @author inesm
 */
@Named(value="rating")
@SessionScoped
public class Rating  implements Serializable{

    @EJB
    private ValoracionFacadeLocal valoracionFacade;

   private Integer rating1;   
    private Integer rating2; 
   private  Integer ViaAVG;
   @Inject 
   private SitioController sitioController;

   

    public Integer getRating1() {
        return rating1;
    }

    public void setRating1(Integer rating1) {
        this.rating1 = rating1;
    }

    public Integer getRating2() {
        return rating2;
    }

    public void setRating2(Integer rating2) {
        this.rating2 = rating2;
    }

    public Integer getViaAVG() {
        return ViaAVG;
    }

    public void setViaAVG(Integer ViaAVG) {
        this.ViaAVG = ViaAVG;
    }
    
    
    
   public void ObtenerAvg() {
 
   int cv=sitioController.getCodviaj();
   
   ViaAVG= valoracionFacade.ratingAverage(cv);
  this.setRating2(ViaAVG);

 
   }



    
    
   
    

}
