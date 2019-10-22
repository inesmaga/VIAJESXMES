/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Meses;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import services.MesesFacadeLocal;

/**
 *
 * @author inesm
 */

@Named(value = "mBean")
@SessionScoped
public class MBean implements Serializable {

    @EJB
    private MesesFacadeLocal mesesFacade;

   
    
 private MenuModel model;
    private int Mes;
    private String ADI;
    private String CT;
    
    @PostConstruct
    public void init() {

        Meses me = new Meses();

    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public List<Meses> getMeses() {
        return mesesFacade.findAll();
        
        
        
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public String getADI() {
        return ADI;
    }

    public void setADI(String ADI) {
        this.ADI = ADI;
    }

    public String getCT() {
        return CT;
    }

    public void setCT(String CT) {
        this.CT = CT;
    }

    public String iniciarmes() {
        String paginame = null;
        String direccion = null;
       ADI= null;
         CT=null;
   model = new DefaultMenuModel();
        try {
            Meses me = null;
           
            me = mesesFacade.find(Mes);
            if (me != null) {
                Meses m=null;
               m = (Meses) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mes", me);
           ADI= me.getAdonde();
           CT= me.getCondtiemp();
         
                paginame = me.getNommes();
                if (paginame.equals("Enero")) {
                    direccion = "/WEB-INF/protegido/enero.xhtml";
                } else {
                    if (paginame.equals("Febrero")) {
                        direccion = "/WEB-INF/protegido/febrero.xhtml";
                    } else {
                        if (paginame.equals("Marzo")) {
                            direccion = "/WEB-INF/protegido/marzo.xhtml";
                        } else {
                            if (paginame.equals("Abril")) {
                                direccion = "/WEB-INF/protegido/abril.xhtml";
                            } else {
                                if (paginame.equals("Mayo")) {
                                    direccion = "/WEB-INF/protegido/mayo.xhtml";
                                } else {
                                    if (paginame.equals("Junio")) {
                                        direccion = "/WEB-INF/protegido/junio.xhtml";
                                    } else {
                                        if (paginame.equals("Julio")) {
                                            direccion = "/WEB-INF/protegido/julio.xhtml";
                                        } else {
                                            if (paginame.equals("Agosto")) {
                                                direccion = "/WEB-INF/protegido/agosto.xhtml";
                                            } else {
                                                if (paginame.equals("Septiembre")) {
                                                    direccion = "/WEB-INF/protegido/septiembre.xhtml";
                                                } else {
                                                    if (paginame.equals("Octubre")) {
                                                        direccion = "/WEB-INF/protegido/octubre.xhtml";
                                                    } else {
                                                        if (paginame.equals("Noviembre")) {
                                                            direccion = "/WEB-INF/protegido/noviembre.xhtml";
                                                        } else {
                                                            if (paginame.equals("Diciembre")) {
                                                                direccion = "/WEB-INF/protegido/diciembre.xhtml";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso" , "Credenciales Incorrectas"));
          }
            }catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
          
        }

            return direccion;

        }

 
    public MBean() {
    }

}
