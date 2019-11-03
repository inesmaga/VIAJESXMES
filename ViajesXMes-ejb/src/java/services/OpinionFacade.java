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
     public List <Opinion> findValoByIdviaje(int idv){
          try {
            Query query =em.createNamedQuery("Opinion.findValoByIdviaje");
    query.setParameter(1,idv);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
        }     
            
             
             
     }         
             
    @Override
    public int findValorByIdviajeP(int idv, int idper){
       String consulta;
      int cvalorac =0;
        try {
         consulta ="SELECT o.valorac FROM Opinion o WHERE  o.idviaje=?1 and o.idpersona=?2";
           Query query = em.createQuery(consulta);
            query.setParameter(1, idv);
            query.setParameter(2, idper);
           List<Opinion> lista= query.getResultList(); 
           if(!lista.isEmpty()){
               cvalorac= lista.get(0).getValorac();
           }
        
           
    
        } catch (Exception e) {
            throw e;
        }
    return cvalorac; 
    }
    
      @Override
    public List<Opinion> cop(int idv, int idper){
 
      
       try {
            Query query =em.createNamedQuery("Opinion.findCByIdviajeP");
    query.setParameter("idviaje",idv);
    query.setParameter("idpersona",idper);
   List<Opinion> lista= query.getResultList();
           if(!lista.isEmpty()){
         List<Opinion> op= (List<Opinion>) lista.get(0);
           return op;
           }
      } catch (Exception e) {
            throw e;
           
       
        }
        return null;
       
     
    }       
    
    @Override
    public int codOp (int idv, int idper){
     try {
            Query query =em.createNamedQuery("Opinion.findCByIdviajeP");
    query.setParameter("idviaje",idv);
    query.setParameter("idpersona",idper);
   List<Opinion> lista= query.getResultList();
           if(!lista.isEmpty()){
      int  cop= lista.get(0).getCodigo();
         
           return cop;
           }
      } catch (Exception e) {
            throw e;
           
        }
     return 0;
    }
           
   
    
}
