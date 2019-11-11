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
         consulta ="SELECT a.nameviaje FROM Agenda a WHERE  a.idmes=?1 and a.idpersona=?2 a.estado=?3";
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
}
