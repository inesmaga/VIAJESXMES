/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Meses;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author inesm
 */
@Local
public interface MesesFacadeLocal {

    void create(Meses meses);

    void edit(Meses meses);

    void remove(Meses meses);

    Meses find(Object id);

    List<Meses> findAll();

    List<Meses> findRange(int[] range);

    int count();
    
}
