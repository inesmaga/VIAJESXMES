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
        String consulta;
        try {
            consulta ="SELECT v FROM Viajes v WHERE v.idmenu = ?1";
           Query query =   em.createQuery(consulta);
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
}
