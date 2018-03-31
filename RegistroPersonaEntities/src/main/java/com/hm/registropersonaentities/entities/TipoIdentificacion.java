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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HugoM
 */
@Entity
@Table(name = "tipo_identificacion")
@XmlRootElement
public class TipoIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @SerializedName("idTipoIdentificacion")
    @Column(name = "id_tipo_identificacion")
    private String idTipoIdentificacion;
    @Size(max = 50)
    @SerializedName("descripcionIdentificacion")
    @Column(name = "descripcion_identificacion")
    private String descripcionIdentificacion;
    @SerializedName("personaIdentificacion")
    @OneToMany(mappedBy = "idTipoIdentificacion")
    private List<PersonaIdentificacion> personaIdentificacionList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(String idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(String idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getDescripcionIdentificacion() {
        return descripcionIdentificacion;
    }

    public void setDescripcionIdentificacion(String descripcionIdentificacion) {
        this.descripcionIdentificacion = descripcionIdentificacion;
    }

    @XmlTransient
    public List<PersonaIdentificacion> getPersonaIdentificacionList() {
        return personaIdentificacionList;
    }

    public void setPersonaIdentificacionList(List<PersonaIdentificacion> personaIdentificacionList) {
        this.personaIdentificacionList = personaIdentificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoIdentificacion != null ? idTipoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.idTipoIdentificacion == null && other.idTipoIdentificacion != null) || (this.idTipoIdentificacion != null && !this.idTipoIdentificacion.equals(other.idTipoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hm.registropersonawarapiapp.entities.TipoIdentificacion[ idTipoIdentificacion=" + idTipoIdentificacion + " ]";
    }
    
}
