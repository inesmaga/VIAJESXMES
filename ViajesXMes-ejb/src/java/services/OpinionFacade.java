/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Opinion;
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
public class OpinionFacade extends AbstractFacade<Opinion> implements OpinionFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpinionFacade() {
        super(Opinion.class);
    }
    
      @Override
    public List <Opinion> findByIdviaje(int idv){
        try {
            Query query =em.createNamedQuery("Opinion.findByIdviaje");
    query.setParameter("idviaje",idv);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
}
    
    }
    

    
    @Override
    public  Opinion opi(int cod){
 Opinion opi;
    
       try {
            Query query =em.createNamedQuery("Opinion.findByCodigo");
    query.setParameter("codigo",cod);
   List<Opinion> lista= query.getResultList();
              if(!lista.isEmpty()){
           opi= lista.get(0);
           return opi;
           }
      } catch (Exception e) {
            throw e;
           
       
        }
        return null;
      
     
    }       
    
    @Override
    public int codOp (int idv, int idper){
       int  cop=0;
     try {
            Query query =em.createNamedQuery("Opinion.findCByIdviajeP");
    query.setParameter("idviaje",idv);
    query.setParameter("idpersona",idper);
   List<Opinion> lista= query.getResultList();
           if(!lista.isEmpty()){
         
        cop = lista.get(0).getCodigo();
         
                  }
      } catch (Exception e) {
            throw e;
           
        }
     return cop;
    }
           
   
    
}
