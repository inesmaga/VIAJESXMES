/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Contactos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author inesm
 */
@Local
public interface ContactosFacadeLocal {

    void create(Contactos contactos);

    void edit(Contactos contactos);

    void remove(Contactos contactos);

    Contactos find(Object id);

    List<Contactos> findAll();

    List<Contactos> findRange(int[] range);

    int count();
    
}
