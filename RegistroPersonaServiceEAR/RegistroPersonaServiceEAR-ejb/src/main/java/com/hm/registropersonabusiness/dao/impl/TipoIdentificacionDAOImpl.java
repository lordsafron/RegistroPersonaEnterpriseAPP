/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.dao.impl;

import com.hm.registropersonabusiness.dao.TipoIdentificacionDAO;
import com.hm.registropersonaentities.entities.TipoIdentificacion;
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
public class TipoIdentificacionDAOImpl implements TipoIdentificacionDAO {

    private static final Logger log = Logger.getLogger(TipoIdentificacionDAOImpl.class);

    @PersistenceContext(name = "registroPersonaUnit")
    private EntityManager em;

    @Override
    public List<TipoIdentificacion> getAllIdentificationType() {
        log.info("Inicio del metodo getAllIdentificationType de TipoIdentificacionDAO");
        List<TipoIdentificacion> lTipoIdentificacion = new ArrayList<>();
        try {
            Query consulta = em.createQuery("SELECT ti FROM TipoIdentificacion ti");
            lTipoIdentificacion = consulta.getResultList();
            log.info("Fin del metodo getAllIdentificationType de TipoIdentificacionDAO");
            return lTipoIdentificacion;
        } catch (Exception ex) {
            log.error("Error en el metodo getAllIdentificationType de TipoIdentificacionDAO: " + ex);
            return lTipoIdentificacion;
        }
    }

    @Override
    public TipoIdentificacion getByIdIdentificationType(String idTipoIdentificacion) {
        log.info("Inicio del metodo getByIdIdentificationType de TipoIdentificacionDAO");
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
        try {
            Query consulta = em.createQuery("SELECT ti FROM TipoIdentificacion ti WHERE ti.idTipoIdentificacion = ?1");
            consulta.setParameter(1, idTipoIdentificacion);
            List<TipoIdentificacion> lTipoIdentificacion = consulta.getResultList();
            if (!lTipoIdentificacion.isEmpty()) {
                tipoIdentificacion = lTipoIdentificacion.get(0);
                log.info("Fin del metodo getByIdIdentificationType de TipoIdentificacionDAO");
                return tipoIdentificacion;
            } else {
                log.info("Fin del metodo getByIdIdentificationType de TipoIdentificacionDAO sin registro");
                return tipoIdentificacion;
            }
        } catch (Exception ex) {
            log.error("Error en el metodo getByIdIdentificationType de TipoIdentificacionDAO: " + ex);
            return tipoIdentificacion;
        }
    }

}
