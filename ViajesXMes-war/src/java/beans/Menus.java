package beans;

import entities.Menu;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
@Named(value="menus")
@SessionScoped
public class Menus implements Serializable {

    @EJB
    private MenuFacadeLocal menuFacade;
   private List<Menu> lista;
    private MenuModel model;
    private String namemenu;
 @Inject
    private PlantillaController plantillaController;
 
    @PostConstruct
    public void init() {
        this.listarMenus(plantillaController.getAm());
        model = new DefaultMenuModel();
        this.obteniendoMenusMes();
    }

    public String getNamemenu() {
        return namemenu;
    }

    public void setNamemenu(String namemenu) {
        this.namemenu = namemenu;
    }

    public void listarMenus(int imes) {
        try {
            lista = menuFacade.findByIdmes(imes);
        } catch (Exception e) {
            //mensaje de jsf
        }

    }

  

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
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
                    item.setUrl(m.getUrl());
                                 
                   
                            model.addElement(item);
                }
            }
        }
    }
 public String exportDAtmenus(String name){
  
namemenu=name;
 
return namemenu;


}

     
     
     
     
     

   
   
}