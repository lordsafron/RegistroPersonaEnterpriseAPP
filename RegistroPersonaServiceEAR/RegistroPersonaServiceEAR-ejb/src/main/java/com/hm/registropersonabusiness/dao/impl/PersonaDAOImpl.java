/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.dao.impl;

import com.hm.registropersonabusiness.dao.GeneroDAO;
import com.hm.registropersonabusiness.dao.PaisDAO;
import com.hm.registropersonabusiness.dao.PersonaDAO;
import com.hm.registropersonabusiness.dao.TipoIdentificacionDAO;
import com.hm.registropersonaentities.entities.Genero;
import com.hm.registropersonaentities.entities.Pais;
import com.hm.registropersonaentities.entities.Persona;
import com.hm.registropersonaentities.entities.TipoIdentificacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author HugoM
 */
@Stateless
public class PersonaDAOImpl implements PersonaDAO {
    
    private static final Logger log = Logger.getLogger(PersonaDAOImpl.class);
    
    @EJB
    private TipoIdentificacionDAO tipoIdentificacionDAO;
    @EJB
    private GeneroDAO generoDAO;
    @EJB
    private PaisDAO paisDAO;
    
    @PersistenceContext(name = "registroPersonaUnit")
    private EntityManager em;

    @Override
    public List<Persona> getAllPersons() {
        log.info("Inicio del metodo getAllPersons de PersonaDAO");
        List<Persona> lPersona = new ArrayList<>();
        try {
            Query consulta = em.createQuery("SELECT p FROM Persona p");
            lPersona = consulta.getResultList();
            
            log.info("Fin del metodo getAllPersons de PersonaDAO");
            return lPersona;
        } catch (Exception ex) {
            log.error("Error en el metodo getAllPersons de PersonaDAO: " + ex);
            return lPersona;
        }
    }

    @Override
    public Persona getByPersonId(long idPersona) {
        log.info("Inicio del metodo getByPersonId de PersonaDAO");
        Persona persona = new Persona();
        try {
            //persona = em.find(Persona.class, idPersona); other method
            Query consulta = em.createQuery("SELECT p FROM Persona p WHERE p.idPersona = ?1");
            consulta.setParameter(1, idPersona);
            List<Persona> lPersona = consulta.getResultList();
            if (!lPersona.isEmpty()) {
                persona = lPersona.get(0);
                log.info("Fin del metodo getByPersonId de PersonaDAO");
                return persona;
            } else {
                log.info("Fin del metodo getByPersonId de PersonaDAO sin registro");
                return persona;
            }
        } catch (Exception ex) {
            log.error("Error en el metodo getByPersonId de PersonaDAO: " + ex);
            return persona;
        }
    }

    @Override
    public boolean insertPerson(Persona persona) {
        log.info("Inicio del metodo insertPerson de PersonaDAO");
        
        boolean respuesta;

        Genero genero = generoDAO.getrByGener(persona.getIdGenero());
        if (genero.getIdGenero().isEmpty()) {
            respuesta = false;
            log.info("Fin del metodo insertPerson de PersonaDAO, por genero");
            return respuesta;
        }
        TipoIdentificacion tipoIdentificacion = tipoIdentificacionDAO.getByIdIdentificationType(persona.getIdTipoIdentificacion());
        if (tipoIdentificacion.getIdTipoIdentificacion().isEmpty()) {
            respuesta = false;
            log.info("Fin del metodo insertPerson de PersonaDAO, por tipoIdentificacion");
            return respuesta;
        }
        Pais pais = paisDAO.getCountry(persona.getIdPais());
        if (pais.getNomenclaturaPais().isEmpty()) {
            respuesta = false;
            log.info("Fin del metodo insertPerson de PersonaDAO, por pais");
            return respuesta;
        }
        

        try {
            em.persist(persona);
            try {
            } catch (Exception ex) {
                log.error("Aun no existe el id de la persona");
            }
            
            
            respuesta = true;
            log.info("Fin del metodo insertPerson de PersonaDAO");
            return respuesta;
        } catch (Exception ex) {
            log.error("Error en el metodo insertPerson de PersonaDAO: " + ex);
            respuesta = false;
            return respuesta;
        }
    }

    @Override
    public boolean updatePerson(Persona persona) {
        log.info("Inicio del metodo updatePerson de PersonaDAO");
        boolean respuesta;
        try {
            Persona personaValidate = getByPersonId(persona.getIdPersona());

            if (personaValidate.getPrimerApellido().isEmpty()) {
                log.info("Fin del metodo updatePerson de PersonaDAO sin cambios");
                respuesta = false;
                return respuesta;
            } else {
                persona.setIdPersona(personaValidate.getIdPersona());
                em.merge(persona);
                log.info("Fin del metodo updatePerson de PersonaDAO");
                respuesta = true;
                return respuesta;
            }
        } catch (Exception ex) {
            log.error("Error en el metodo updatePerson de PersonaDAO: " + ex);
            respuesta = false;
            return respuesta;
        }
    }

    @Override
    public boolean DeletePerson(long idPersona) {
        log.info("Inicio del metodo DeletePerson de PersonaDAO");
        boolean respuesta;
        try {
            Persona persona = getByPersonId(idPersona);
            if (!persona.getPrimerApellido().isEmpty()) {
                em.remove(persona);
                respuesta = true;
                log.info("Fin del metodo DeletePerson de PersonaDAO");
                return respuesta;
            } else {
                respuesta = false;
                log.info("Fin del metodo DeletePerson de PersonaDAO sin eliminacion");
                return respuesta;
            }

        } catch (Exception ex) {
            respuesta = false;
            log.error("Error en el metodo DeletePerson de PersonaDAO: " + ex);
            return respuesta;
        }
    }
    
}
