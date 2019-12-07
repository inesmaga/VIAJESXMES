/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author inesm
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
    
    @Override
    public List <Menu> findByIdmes(int idm){
        try {
            Query query =em.createNamedQuery("Menu.findByIdmes");
    query.setParameter("idmes",idm);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
}
    
    }
    
   @Override
     public List <Menu> findByUrl(String url){
        try {
            Query query =em.createNamedQuery("Menu.findByUrl");
    query.setParameter("url",url);
    return query.getResultList();
    
        } catch (Exception e) {
            throw e;
        }
    
    }  
    
     
     
}
