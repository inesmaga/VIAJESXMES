/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Valoracion;
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
public class ValoracionFacade extends AbstractFacade<Valoracion> implements ValoracionFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ValoracionFacade() {
        super(Valoracion.class);
    }
   @Override
     public List <Valoracion> findValoByIdviaje(int idv){
          try {
            Query query =em.createNamedQuery("Valoracion.findByIdviaje");
    query.setParameter("idviaje",idv);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
        }     
    
    
    
}
   
    
      @Override
    public  Valoracion vali(int cod){
 Valoracion valy;
    
       try {
            Query query =em.createNamedQuery("Valoracion.findByCodigo");
    query.setParameter("codigo",cod);
   List<Valoracion> lista= query.getResultList();
              if(!lista.isEmpty()){
          valy= lista.get(0);
           return valy;
           }
      } catch (Exception e) {
            throw e;
           
       
        }
        return null;
      
     
    }       
    
    @Override
    public int codVal (int idv, int idper){
        int  cva=0;
     try {
            Query query =em.createNamedQuery("Valoracion.findCByIdviajeP");
    query.setParameter("idviaje",idv);
    query.setParameter("idpersona",idper);
   List<Valoracion> lista= query.getResultList();
           if(!lista.isEmpty()){
         
                cva = lista.get(0).getCodigo().intValue();
         
           return cva;
           }
      } catch (Exception e) {
            throw e;
           
        }
     return cva;
    }  
    
    @Override
    public int ratingAverage(int idv){
          int ratingAvg;
       String consulta;
        try {
            consulta ="SELECT AVG(v.valorac) FROM Valoracion v WHERE  v.idviaje=?1 ";
           Query query = em.createQuery(consulta);
            query.setParameter(1, idv); 
              List<Valoracion> lista= query.getResultList();
           ratingAvg = lista.get(0).getValorac();
           return ratingAvg;
             } catch (Exception e) {
            throw e;
        }
       
    }
    
    
}
