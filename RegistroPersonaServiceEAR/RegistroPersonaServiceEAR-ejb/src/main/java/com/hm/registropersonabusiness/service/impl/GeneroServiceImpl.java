/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.service.impl;

import com.hm.registropersonabusiness.dao.GeneroDAO;
import com.hm.registropersonabusiness.service.GeneroService;
import com.hm.registropersonaentities.entities.Genero;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author HugoM
 */
@Stateless(mappedName = "GeneroService")
public class GeneroServiceImpl implements GeneroService {

    @EJB
    private GeneroDAO generoDAO;
    
    @Override
    public List<Genero> getAllGeners() {
        return generoDAO.getAllGeners();
    }

    @Override
    public Genero getrByGener(String idGenero) {
        return generoDAO.getrByGener(idGenero);
    }
    
}
