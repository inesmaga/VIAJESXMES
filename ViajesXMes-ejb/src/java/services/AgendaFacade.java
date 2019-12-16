/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Agenda;
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
public class AgendaFacade extends AbstractFacade<Agenda> implements AgendaFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgendaFacade() {
        super(Agenda.class);
    }
    
      @Override
   public List <Agenda>  findViajGuard(int idmes, int idpers,  String est){
 String consulta;
        try {
         consulta ="SELECT a.nameviaje FROM Agenda a WHERE  a.idmes=?1 and a.idpersona=?2 and a.estado=?3";
           Query query = em.createQuery(consulta);
            query.setParameter(1, idmes);
            query.setParameter(2, idpers);
             query.setParameter(3, "G");
           List<Agenda> lista= query.getResultList();    
            return lista; 
    
        } catch (Exception e) {
            throw e;
}
    }
   
    @Override
   public void CEstnameVij(int idpers,int idmes,String nv){
       List <Agenda> namev = null ;
       String consulta;
       try {
              consulta ="UPDATE  Agenda a  SET a.estado='R' WHERE  a.idmes=?1 and a.idpersona=?2 and a.nameviaje=?3";
             Query query = em.createQuery(consulta);
            query.setParameter(1, idmes);
            query.setParameter(2, idpers);
             query.setParameter(3, nv);  
            query.executeUpdate();
   
           
        } catch (Exception e) {
            throw e;
        }
       
   }
    @Override
     public List <Agenda> findByViajesG( int idp ){
   
   String consulta;
        try {
         consulta ="SELECT a.nameviaje FROM Agenda a WHERE   a.idpersona=?1 and a.estado=?2";
           Query query = em.createQuery(consulta);
           
            query.setParameter(1, idp);
             query.setParameter(2, "G");
           List<Agenda> lista= query.getResultList();    
            return lista; 
    
        } catch (Exception e) {
            throw e;
}
   
     }
 
 @Override
     public List <Agenda> findByViajesR( int idp ){
   
   String consulta;
        try {
         consulta ="SELECT a.nameviaje FROM Agenda a WHERE   a.idpersona=?1 and a.estado=?2";
           Query query = em.createQuery(consulta);
           
            query.setParameter(1, idp);
             query.setParameter(2, "R");
           List<Agenda> lista= query.getResultList();    
            return lista; 
    
        } catch (Exception e) {
            throw e;
}
   
     }    
     
     
    @Override
   public void CFavoritoVij(int idpers,int idmes,String nv){
     
       String consulta;
       try {
              consulta ="UPDATE  Agenda a  SET a.favorito='true' WHERE  a.idmes=?1 and a.idpersona=?2 and a.nameviaje=?3";
             Query query = em.createQuery(consulta);
            query.setParameter(1, idmes);
            query.setParameter(2, idpers);
             query.setParameter(3, nv);  
            query.executeUpdate();
   
           
        } catch (Exception e) {
            throw e;
        }
   }  
   

   @Override
      public List <Agenda> findByFavorito( int idp ){
        try {
            Query query =em.createNamedQuery("Agenda.findByFavorito");
    
    query.setParameter("idpersona",idp);
   query.setParameter("favorito",true);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
}
      }
      
   @Override
      public List <Agenda> findByValorado( int idp ){
        try {
            Query query =em.createNamedQuery("Agenda.findByValorado");
    
    query.setParameter("idpersona",idp);
   query.setParameter("valorado",true);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
}
      }   
      
     @Override
      public List <Agenda> findByOpinado( int idp ){
        try {
            Query query =em.createNamedQuery("Agenda.findByOpinado");
    
    query.setParameter("idpersona",idp);
   query.setParameter("opinado",true);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
}
      } 
      
      
      
}