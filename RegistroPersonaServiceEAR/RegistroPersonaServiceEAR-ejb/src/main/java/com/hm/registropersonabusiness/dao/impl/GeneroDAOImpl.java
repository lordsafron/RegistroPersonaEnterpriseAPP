/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.dao.impl;

import com.hm.registropersonabusiness.dao.GeneroDAO;
import com.hm.registropersonaentities.entities.Genero;
import java.util.ArrayList;
import java.util.List;
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
public class GeneroDAOImpl implements GeneroDAO {

    private static final Logger log = Logger.getLogger(GeneroDAOImpl.class);

    @PersistenceContext(name = "registroPersonaUnit")
    private EntityManager em;

    @Override
    public List<Genero> getAllGeners() {
        log.info("Inicio del metodo getAllGeners de GeneroDAO");
        List<Genero> lGenero = new ArrayList<>();
        try {
            Query consulta = em.createQuery("SELECT g FROM Genero g");
            lGenero = consulta.getResultList();
            log.info("Fin del metodo getAllGeners de GeneroDAO");
            return lGenero;
        } catch (Exception ex) {
            log.error("Error en el metodo getAllGeners de GeneroDAO: " + ex);
            return lGenero;
        }
    }

    @Override
    public Genero getrByGener(String idGenero) {
        log.info("Inicio del metodo getrByGener de GeneroDAO");
        Genero genero = new Genero();
        try {
            Query consulta = em.createQuery("SELECT g FROM Genero g WHERE g.idGenero =?1");
            consulta.setParameter(1, idGenero);
            List<Genero> lGenero = consulta.getResultList();
            if (!lGenero.isEmpty()) {
                genero = lGenero.get(0);
                log.info("Fin del metodo getrByGener de GeneroDAO");
                return genero;
            } else {
                log.info("Fin del metodo getrByGener de GeneroDAO sin registro");
                return genero;
            }
        } catch (Exception ex) {
            log.info("Error en el metodo getrByGener de GeneroDAO: " + ex);
            return genero;
        }
    }

}
