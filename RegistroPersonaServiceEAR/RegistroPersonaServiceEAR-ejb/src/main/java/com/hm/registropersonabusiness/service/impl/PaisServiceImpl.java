/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.service.impl;

import com.hm.registropersonabusiness.dao.PaisDAO;
import com.hm.registropersonabusiness.service.PaisService;
import com.hm.registropersonaentities.entities.Pais;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HugoM
 */
@Stateless(mappedName = "PaisService")
public class PaisServiceImpl implements PaisService {

    @EJB
    private PaisDAO paisDAO;
    
    @Override
    public List<Pais> getAllCountries() {
        return paisDAO.getAllCountries();
    }

    @Override
    public Pais getCountry(int idPais) {
        return paisDAO.getCountry(idPais);
    }
    
}
