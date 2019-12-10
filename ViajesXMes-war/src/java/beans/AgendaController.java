/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Agenda;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import services.AgendaFacadeLocal;
import services.OpinionFacadeLocal;
import services.ValoracionFacadeLocal;
import services.ViajesFacadeLocal;

/**
 *
 * @author inesm
 */
@Named(value = "agendaController")
@SessionScoped
public class AgendaController implements Serializable{
  @EJB
    private ValoracionFacadeLocal valoracionFacade;

   
    @EJB
    private OpinionFacadeLocal opinionFacade;

   

    @EJB
    private AgendaFacadeLocal agendaFacade;

    

    @EJB
    private ViajesFacadeLocal viajesFacade;
    
    @Inject
private PlantillaController plantillaController;

@Inject
private Registro registro;
    
 @Inject 
   private SitioController sitioController;
 
    
    public void  registrar() {
        Agenda a = new Agenda();
        int cm= plantillaController.getAm();
        int eip=registro.getPers();
        
      int  codvi= sitioController.getCodviaj();
      String DESC= plantillaController.getNamemenu();
      String ET= "G";
     int iop;
      iop = opinionFacade.findByIdviaje(codvi).get(0).getCodigo();
     
       int ival=valoracionFacade.findValoByIdviaje(codvi).get(0).getCodigo();
         try { 
      a.setIdmes(cm);
      a.setIdpersona(eip);
      a.setIdviaje(codvi);
      a.setNameviaje(DESC);
      a.setEstado(ET);
      if (ival>0){
          a.setValorado(Boolean.TRUE);
          a.setIdvalorac(ival);
      }else{
      a.setValorado(Boolean.FALSE);
      a.setIdvalorac(0);
      }
       if (iop>0){
      a.setOpinado(Boolean.TRUE);
      a.setIdopinion(iop);
      }else{
      a.setOpinado(Boolean.FALSE);
       a.setIdopinion(0);
      }
     
      agendaFacade.create(a);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gracias,Su Viaje ha sido Guardado","gracias"));
      } catch (Exception e) {
             throw e;
         }       
     }      
    
     public void cambioFavori( ){
      int eip=registro.getPers();
       int idm= plantillaController.getAm();
       String namviaj=plantillaController.getNamemenu();
   agendaFacade.CFavoritoVij(eip,idm,namviaj);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gracias,su Viaje ha sido Guardado como Favorito","gracias"));
  
    }
    
    
    public AgendaController() {
    }
    
}
