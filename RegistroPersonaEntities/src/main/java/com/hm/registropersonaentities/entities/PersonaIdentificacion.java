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
@Table(name = "persona_identificacion")
@XmlRootElement
public class PersonaIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @SerializedName("idPersonaIdentificacion")
    @Column(name = "id_persona_identificacion")
    private Integer idPersonaIdentificacion;
    @SerializedName("Persona")
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersona;
    @SerializedName("tipoIdentificacion")
    @JoinColumn(name = "id_tipo_identificacion", referencedColumnName = "id_tipo_identificacion")
    @ManyToOne
    private TipoIdentificacion idTipoIdentificacion;

    public PersonaIdentificacion() {
    }

    public PersonaIdentificacion(Integer idPersonaIdentificacion) {
        this.idPersonaIdentificacion = idPersonaIdentificacion;
    }

    public Integer getIdPersonaIdentificacion() {
        return idPersonaIdentificacion;
    }

    public void setIdPersonaIdentificacion(Integer idPersonaIdentificacion) {
        this.idPersonaIdentificacion = idPersonaIdentificacion;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoIdentificacion getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(TipoIdentificacion idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonaIdentificacion != null ? idPersonaIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaIdentificacion)) {
            return false;
        }
        PersonaIdentificacion other = (PersonaIdentificacion) object;
        if ((this.idPersonaIdentificacion == null && other.idPersonaIdentificacion != null) || (this.idPersonaIdentificacion != null && !this.idPersonaIdentificacion.equals(other.idPersonaIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hm.registropersonawarapiapp.entities.PersonaIdentificacion[ idPersonaIdentificacion=" + idPersonaIdentificacion + " ]";
    }
    
}
