/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.service;

import com.hm.registropersonaentities.entities.Genero;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HugoM
 */
@Remote
public interface GeneroService {
    
    public List<Genero> getAllGeners();
    
    public Genero getrByGener(String idGenero);
    
}
