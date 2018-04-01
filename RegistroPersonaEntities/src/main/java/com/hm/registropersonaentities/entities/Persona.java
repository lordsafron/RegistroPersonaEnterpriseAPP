/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonaentities.entities;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HugoM
 */
@Entity
@Table(name = "persona")
@XmlRootElement
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @SerializedName("idTipoIdentificacion")
    @Column(name = "id_tipo_identificacion")
    private String idTipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @SerializedName("nroIdentificacion")
    @Column(name = "nro_identificacion")
    private int nroIdentificacion;
    @Size(max = 60)
    @SerializedName("nombre")
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 60)
    @SerializedName("primerApellido")
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 60)
    @SerializedName("segundoApellido")
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @SerializedName("fechaNacimiento")
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 5)
    @SerializedName("idGenero")
    @Column(name = "id_genero")
    private String idGenero;
    @Size(max = 255)
    @SerializedName("direccion")
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @SerializedName("correo")
    @Column(name = "correo")
    private String correo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @SerializedName("idPersona")
    @Column(name = "id_persona")
    private long idPersona;
    @SerializedName("fechaRegistro")
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIME)
    private Date fechaRegistro;
    @SerializedName("personaIdentificacion")
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.EAGER)
    private List<PersonaIdentificacion> personaIdentificacionList;
    @Column(name = "id_pais")
    private int idPais;

    public Persona() {
    }

    public Persona(long idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(long idPersona, String idTipoIdentificacion, int nroIdentificacion) {
        this.idPersona = idPersona;
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(String idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public int getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(int nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(String idGenero) {
        this.idGenero = idGenero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public List<PersonaIdentificacion> getPersonaIdentificacionList() {
        return personaIdentificacionList;
    }

    public void setPersonaIdentificacionList(List<PersonaIdentificacion> personaIdentificacionList) {
        this.personaIdentificacionList = personaIdentificacionList;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.idPersona ^ (this.idPersona >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "com.hm.registropersonawarapiapp.entities.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
