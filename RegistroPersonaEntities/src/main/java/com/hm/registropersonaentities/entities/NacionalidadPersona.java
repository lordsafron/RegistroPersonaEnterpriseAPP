/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonaentities.entities;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HugoM
 */
@Entity
@Table(name = "nacionalidad_persona")
@XmlRootElement
public class NacionalidadPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @SerializedName("idNacionalidadPersona")
    @Column(name = "id_nacionalidad_persona")
    private Integer idNacionalidadPersona;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")
    @ManyToOne
    @SerializedName("Pais")
    private Pais idPais;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;

    public NacionalidadPersona() {
    }

    public NacionalidadPersona(Integer idNacionalidadPersona) {
        this.idNacionalidadPersona = idNacionalidadPersona;
    }

    public Integer getIdNacionalidadPersona() {
        return idNacionalidadPersona;
    }

    public void setIdNacionalidadPersona(Integer idNacionalidadPersona) {
        this.idNacionalidadPersona = idNacionalidadPersona;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNacionalidadPersona != null ? idNacionalidadPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NacionalidadPersona)) {
            return false;
        }
        NacionalidadPersona other = (NacionalidadPersona) object;
        if ((this.idNacionalidadPersona == null && other.idNacionalidadPersona != null) || (this.idNacionalidadPersona != null && !this.idNacionalidadPersona.equals(other.idNacionalidadPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hm.registropersonawarapiapp.entities.NacionalidadPersona[ idNacionalidadPersona=" + idNacionalidadPersona + " ]";
    }
    
}
