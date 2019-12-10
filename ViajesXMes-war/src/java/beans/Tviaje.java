/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Agenda;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.AgendaFacadeLocal;

/**
 *
 * @author inesm
 */

@Named(value = "tviaje")
@SessionScoped
public class Tviaje implements Serializable{
    @EJB
    private AgendaFacadeLocal agendaFacade;
   
    @Inject
    private Registro registro;
    private List<Agenda>LtviajeF;  

    public List<Agenda> getLtviajeF() {
        return LtviajeF;
    }

    public void setLtviajeR(List<Agenda> LtviajeF) {
        this.LtviajeF = LtviajeF;
    }
    
     public List<Agenda>obtenerLViajesF( ){
        int idpers=registro.getPers();
        
     try {
LtviajeF = agendaFacade.findViajFav(idpers);
        } catch (Exception e) {
            //mensaje de jsf
        }
return LtviajeF;
    } 
    
    
}
