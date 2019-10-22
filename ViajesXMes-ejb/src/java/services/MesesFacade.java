/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Meses;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inesm
 */
@Stateless
public class MesesFacade extends AbstractFacade<Meses> implements MesesFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MesesFacade() {
        super(Meses.class);
    }
    
}
