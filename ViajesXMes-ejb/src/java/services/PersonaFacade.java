/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "ViajesXMes-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
     @Override
    public Persona iniciarSesion(String pe1, String pe2){
    Persona person= null;
    String consulta;
        try {
            consulta ="SELECT p FROM Persona p WHERE  p.username=?1 and p.clave=?2 ";
           Query query = em.createQuery(consulta);
            query.setParameter(1, pe1);
            query.setParameter(2, pe2);
           List<Persona> lista= query.getResultList();
           if(!lista.isEmpty()){
               person= lista.get(0);
           }
           
           
        } catch (Exception e) {
            throw e;
        }
        return person;
    } 
    
    @Override
    public int codPers(String user){
       int cperson= 0; 
       try {
            Query query =em.createNamedQuery("Persona.findCodByUsername");
    query.setParameter("username",user);
   List<Persona> lista= query.getResultList();
           if(!lista.isEmpty()){
               cperson= lista.get(0).getCodigo();
           }
           
           
        } catch (Exception e) {
            throw e;
        }
        return cperson;
    }
    
    
   
    
    
    
}
