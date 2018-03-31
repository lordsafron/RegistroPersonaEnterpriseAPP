/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonabusiness.dao;

import com.hm.registropersonaentities.entities.Pais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HugoM
 */
@Local
public interface PaisDAO {
    
    public List<Pais> getAllCountries();
    
    public Pais getCountry(int idPais);
    
}
