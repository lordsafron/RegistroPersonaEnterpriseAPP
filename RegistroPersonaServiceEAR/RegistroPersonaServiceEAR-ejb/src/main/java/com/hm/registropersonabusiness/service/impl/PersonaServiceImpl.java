/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.service.impl;

import com.hm.registropersonabusiness.dao.PersonaDAO;
import com.hm.registropersonabusiness.service.PersonaService;
import com.hm.registropersonaentities.entities.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HugoM
 */
@Stateless(mappedName = "PersonaService")
public class PersonaServiceImpl implements  PersonaService {
    
    @EJB
    private PersonaDAO personaDAO;

    @Override
    public List<Persona> getAllPersons() {
        return personaDAO.getAllPersons();
    }

    @Override
    public Persona getByPersonId(long idPersona) {
        return personaDAO.getByPersonId(idPersona);
    }

    @Override
    public boolean insertPerson(Persona persona) {
        return personaDAO.insertPerson(persona);
    }

    @Override
    public boolean updatePerson(Persona persona) {
        return personaDAO.updatePerson(persona);
    }

    @Override
    public boolean DeletePerson(long idPersona) {
        return personaDAO.DeletePerson(idPersona);
    }
    
}
