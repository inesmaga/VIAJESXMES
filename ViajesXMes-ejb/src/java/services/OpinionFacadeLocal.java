/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Opinion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author inesm
 */
@Local
public interface OpinionFacadeLocal {

    void create(Opinion opinion);

    void edit(Opinion opinion);

    void remove(Opinion opinion);

    Opinion find(Object id);

    List<Opinion> findAll();

    List<Opinion> findRange(int[] range);

    int count();
    
    List <Opinion> findByIdviaje(int idv);
    
    Opinion opi(int cod);
    
    
    
   int codOp (int idv, int idper);
    
}
