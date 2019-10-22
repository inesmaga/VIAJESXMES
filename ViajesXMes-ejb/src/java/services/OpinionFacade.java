
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
}
