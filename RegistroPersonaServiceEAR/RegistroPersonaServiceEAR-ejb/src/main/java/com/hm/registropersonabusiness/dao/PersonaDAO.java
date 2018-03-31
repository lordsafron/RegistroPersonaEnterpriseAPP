/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.dao;

import com.hm.registropersonaentities.entities.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HugoM
 */
@Local
public interface PersonaDAO {
    
    public List<Persona> getAllPersons();
    
    public Persona getByPersonId(long idPersona);
    
    public boolean insertPerson(Persona persona);
    
    public boolean updatePerson(Persona persona);
    
    public boolean DeletePerson(long idPersona);    
    
}
