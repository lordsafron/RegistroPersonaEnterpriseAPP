/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonaentities.entities;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HugoM
 */
@Entity
@Table(name = "pais")
@XmlRootElement
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @SerializedName("idPais")
    @Column(name = "id_pais")
    private Integer idPais;
    @Size(max = 10)
    @SerializedName("nomenclaturaPais")
    @Column(name = "nomenclatura_pais")
    private String nomenclaturaPais;
    @Size(max = 50)
    @SerializedName("nombrePais")
    @Column(name = "nombre_pais")
    private String nombrePais;
    @SerializedName("nacionalidadPersona")
    @OneToMany(mappedBy = "idPais")
    private List<NacionalidadPersona> nacionalidadPersonaList;

    public Pais() {
    }

    public Pais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNomenclaturaPais() {
        return nomenclaturaPais;
    }

    public void setNomenclaturaPais(String nomenclaturaPais) {
        this.nomenclaturaPais = nomenclaturaPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @XmlTransient
    public List<NacionalidadPersona> getNacionalidadPersonaList() {
        return nacionalidadPersonaList;
    }

    public void setNacionalidadPersonaList(List<NacionalidadPersona> nacionalidadPersonaList) {
        this.nacionalidadPersonaList = nacionalidadPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hm.registropersonawarapiapp.entities.Pais[ idPais=" + idPais + " ]";
    }
    
}
