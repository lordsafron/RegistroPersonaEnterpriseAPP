/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.service.impl;

import com.hm.registropersonabusiness.dao.TipoIdentificacionDAO;
import com.hm.registropersonabusiness.service.TipoIdentificacionService;
import com.hm.registropersonaentities.entities.TipoIdentificacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HugoM
 */
@Stateless(mappedName = "TipoIdentificacionService")
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {
    
    @EJB
    private TipoIdentificacionDAO tipoIdentificacionDAO;

    @Override
    public List<TipoIdentificacion> getAllIdentificationType() {
        return tipoIdentificacionDAO.getAllIdentificationType();
    }

    @Override
    public TipoIdentificacion getByIdIdentificationType(String idTipoIdentificacion) {
        return tipoIdentificacionDAO.getByIdIdentificationType(idTipoIdentificacion);
    }
    
}
