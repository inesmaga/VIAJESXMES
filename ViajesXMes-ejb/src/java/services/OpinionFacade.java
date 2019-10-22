
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
    query.setParameter("idmes",idv);
    return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    @Override
    public List <Opinion> findValorByIdviaje(int idv, int idper){
       String consulta;
        try {
         consulta ="SELECT o.valorac FROM Opinion o WHERE  o.idviaje=?1 and o.idpersona=?2 ";
           Query query = em.createQuery(consulta);
            query.setParameter(1, idv);
            query.setParameter(2, idper);
           List<Opinion> lista= query.getResultList();    
            return lista; 
    
        } catch (Exception e) {
            throw e;
        }
   
    }
}
