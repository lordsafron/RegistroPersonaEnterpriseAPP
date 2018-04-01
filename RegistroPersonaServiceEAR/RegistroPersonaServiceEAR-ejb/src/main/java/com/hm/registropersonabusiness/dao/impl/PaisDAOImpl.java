/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.dao.impl;

import com.hm.registropersonabusiness.dao.PaisDAO;
import com.hm.registropersonaentities.entities.Pais;
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
public class PaisDAOImpl implements PaisDAO {

    private static final Logger log = Logger.getLogger(PaisDAO.class);

    @PersistenceContext(name = "registroPersonaUnit")
    private EntityManager em;

    @Override
    public List<Pais> getAllCountries() {
        log.info("Inicio del metodo getAllCountries en paisDAO");
        List<Pais> lPais = new ArrayList<>();
        try {
            Query consulta = em.createQuery("SELECT p FROM Pais p");
            lPais = consulta.getResultList();

            log.info("Fin del metodo getAllCountries en paisDAO");
            return lPais;
        } catch (Exception ex) {
            log.error("Error del metodo getAllCountries en paisDAO: " + ex);
            return lPais;
        }
    }

    @Override
    public Pais getCountry(int idPais) {
        log.info("Inicio del metodo getCountry en paisDAO");
        Pais pais = new Pais();
        try {
            Query consulta = em.createQuery("SELECT p FROM Pais p WHERE p.idPais =?1");
            consulta.setParameter(1, idPais);
            List<Pais> lPais = consulta.getResultList();

            if (!lPais.isEmpty()) {
                pais = lPais.get(0);
                log.info("Fin del metodo getCountry en paisDAO");
                return pais;
            } else {
                log.info("Fin del metodo getCountry en paisDAO sin registro");
                return pais;
            }
        } catch (Exception ex) {
            log.error("Error del metodo getCountry en paisDAO: " + ex);
            return pais;
        }
    }

}
