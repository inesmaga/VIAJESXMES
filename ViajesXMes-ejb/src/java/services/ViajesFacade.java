/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Viajes;
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
public class ViajesFacade extends AbstractFacade<Viajes> implements ViajesFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ViajesFacade() {
        super(Viajes.class);
    }
    
     @Override
    public Viajes buscaviajemenu(int idm) {
        Viajes viaje = null;
      
        try {
             Query query =em.createNamedQuery("Viajes.findByIdmenu");
           
            query.setParameter(1, idm);
            List<Viajes> lista= query.getResultList();
           if(!lista.isEmpty()){
               viaje= lista.get(0);
           }
            
        } catch (Exception e) {
            throw e;
        }
     return viaje;
    
    }   
    @Override 
      public Integer  obtenerNSel(int idv){
          int nsel=0;
        try {
            Query query =em.createNamedQuery("Viajes.findByIdviajes");
    query.setParameter("idviajes",idv);
      List<Viajes> lista=query.getResultList();
      if(!lista.isEmpty()){
            nsel= lista.get(0).getNSelect().intValue();
           
          }
        } catch (Exception e) {
            throw e;
}
    return nsel;
    }
    @Override
     public void actualizarNSelect(int idvia, int nsel){
   
    String consulta;
        try {
            consulta ="UPDATE  Viajes v SET v.NSelect=?2 WHERE  v.idviajes=?1 ";
           Query query = em.createQuery(consulta);
            query.setParameter(1, idvia);
             query.setParameter(2, nsel);
            query.executeUpdate();
           
           
        } catch (Exception e) {
            throw e;
        }
      
    }  
    
}
