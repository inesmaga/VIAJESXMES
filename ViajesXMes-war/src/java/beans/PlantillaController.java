
package beans;

import entities.Menu;
import entities.Meses;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import services.MenuFacadeLocal;

/**
 *
 * @author inesm
 */
@Named
@SessionScoped
public class PlantillaController implements Serializable{
Meses mea;
    @EJB
    private MenuFacadeLocal menuFacade;
   private List<String> imagenes;
     private List<String> images;
    private int am;
       private List<Menu> lista;
       private MenuModel model;
private String namemenu;

    public String getNamemenu() {
        return namemenu;
    }

    public void setNamemenu(String namemenu) {
        this.namemenu = namemenu;
    }
    
    
  public void verificarMes(){
am=0;
 
      try {
         
         FacesContext context= FacesContext.getCurrentInstance();
   mea =   (Meses) context.getExternalContext().getSessionMap().get("mes");
        if (mea==null)  {
       context.getExternalContext().redirect("principal.xhtml");
        }else{
      am=mea.getIdmes();
        imagenes = new ArrayList<>();
           for (int i= am;i<= am;i++){
              imagenes.add("TIT" + i + ".png");
             }
             images = new ArrayList<>();
             
        for (int i = 1; i <= 6; i++) {
            images.add( am +"/MFOTOM" + i + ".jpeg");
        }
        }
        this.listarMenus(am);
  model = new DefaultMenuModel();
   this.obteniendoMenusMes();
      } catch (IOException e) {
          //log para errores
      }
  
  } 
   public int getAm() {
        return am;
    }
   
public void listarMenus(int imes) {
        try {
             
            lista = menuFacade.findByIdmes(imes);
            
        } catch (Exception e) {
            //mensaje de jsf
        }

    }
   

    public void obteniendoMenusMes() {

        for (Menu m : lista) {
            if ( m.getTipo().equals("S")) {

                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
                for (Menu i : lista) {
                    Menu submenu = i.getCodigoSubmenu();
                    if (submenu != null) {
                        if (submenu.getCodigo().equals(m.getCodigo())) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                     
                            item.setUrl(i.getUrl());
                       namemenu=i.getNombre();
                           firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            } else {

                if (m.getCodigoSubmenu() == null ) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    
                   
                            model.addElement(item);
                }
            }
        }
    } 

   

   
    
   public List<String> getImagenes() {
  return imagenes;
    
   }
   public List<String> getImages() {
        return images;
    }
   public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

  
}
