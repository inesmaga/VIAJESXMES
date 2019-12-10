/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Agenda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author inesm
 */
@Local
public interface AgendaFacadeLocal {

    void create(Agenda agenda);

    void edit(Agenda agenda);

    void remove(Agenda agenda);

    Agenda find(Object id);

    List<Agenda> findAll();

    List<Agenda> findRange(int[] range);

    int count();
    
    List <Agenda>  findViajGuard(int idmes, int idpers,  String est);
    
 void CEstnameVij(int idpers,int idmes,String nv);
 
 void CFavoritoVij(int idpers,int idmes,String nv);
 
 List <Agenda>  findViajFav( int idpers);
    
}
