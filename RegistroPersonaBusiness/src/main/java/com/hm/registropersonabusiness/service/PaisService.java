/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.service;

import com.hm.registropersonaentities.entities.Pais;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HugoM
 */
@Remote
public interface PaisService {
    
    public List<Pais> getAllCountries();
    
    public Pais getCountry(int idPais);
    
}
