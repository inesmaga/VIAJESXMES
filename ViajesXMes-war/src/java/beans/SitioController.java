package beans;

import entities.Agenda;
import entities.Menu;
import entities.Meses;
import entities.Viajes;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import services.AgendaFacadeLocal;
import services.MesesFacadeLocal;
import services.OpinionFacadeLocal;
import services.PersonaFacadeLocal;
import services.ValoracionFacadeLocal;
import services.ViajesFacadeLocal;

/**
 *
 * @author inesm
 */
@Named(value="sitioController")

@SessionScoped
public class SitioController implements Serializable {

    @EJB
    private ValoracionFacadeLocal valoracionFacade;

   
    @EJB
    private OpinionFacadeLocal opinionFacade;

   

    @EJB
    private AgendaFacadeLocal agendaFacade;

    

    @EJB
    private ViajesFacadeLocal viajesFacade;
    
    

    private List<String> Simagenes;
    private List<String> Simages;
   private int codviaj;
    private String CLL;
    private String CD;
    private String ET;
    private String DD;
    private String DCO;
    private String WEB;
private String DESC;
 
@Inject
private PlantillaController plantillaController;

@Inject
private Registro registro;



    @PostConstruct
    public void init() {
        Viajes ve = new Viajes();
     this.obtenerImgMes();
    this.verificarSitio();
    }
    
public void obtenerImgMes(){
      
Simagenes = new ArrayList<>(plantillaController.getImagenes());
     
}

  

    public List<String> getSimagenes() {
        return Simagenes;
    }

    public void setSimagenes(List<String> Simagenes) {
        this.Simagenes = Simagenes;
    }

    public List<String> getSimages() {
        return Simages;
    }

    public void setSimages(List<String> Simages) {
        this.Simages = Simages;
    }



       public void verificarSitio() {
 Viajes ve;
      int codig;
        CLL = null;
        CD = null;
        ET = null;
        DD = null;
        DCO = null;
        WEB = null;
        DESC= null;
        try {
           //debo obtener el nombre del item seleccionado y debo obtener el numero del menu 
            Simages = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                Simages.add("bangkok/" + i + ".jpeg");
            }
         //debo buscar el viaje que se corresponde con idmenu
            ve = viajesFacade.buscaviajemenu(7);
            if (ve != null) {
                CLL = ve.getCll();
                CD = ve.getCd();
                ET = ve.getEt();
                DD = ve.getDd();
                DCO = ve.getDco();
                WEB = ve.getWeb();
                DESC= ve.getDescripcion();
              codviaj=ve.getIdviajes();
            } 
          // }
        } catch (Exception e) {
            //log para errores
        }
    }

    public String getDESC() {
        return DESC;
    }

    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

   
    public String getCLL() {
        return CLL;
    }

    public void setCLL(String CLL) {
        this.CLL = CLL;
    }

    public String getCD() {
        return CD;
    }

    public void setCD(String CD) {
        this.CD = CD;
    }

    public String getET() {
        return ET;
    }

    public void setET(String ET) {
        this.ET = ET;
    }

    public String getDD() {
        return DD;
    }

    public void setDD(String DD) {
        this.DD = DD;
    }

    public String getDCO() {
        return DCO;
    }

    public void setDCO(String DCO) {
        this.DCO = DCO;
    }

    public String getWEB() {
        return WEB;
    }

    public void setWEB(String WEB) {
        this.WEB = WEB;
    }

    public int getCodviaj() {
        return codviaj;
    }

    public void setCodviaj(int codviaj) {
        this.codviaj = codviaj;
    }
   
 
             
             
             
             
}
