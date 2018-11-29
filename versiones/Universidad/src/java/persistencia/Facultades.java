/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwin.nolascoUSAM
 */
@Entity
@Table(name = "facultades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultades.findAll", query = "SELECT f FROM Facultades f")
    , @NamedQuery(name = "Facultades.findByIdFacultad", query = "SELECT f FROM Facultades f WHERE f.idFacultad = :idFacultad")
    , @NamedQuery(name = "Facultades.findByNombreFaculta", query = "SELECT f FROM Facultades f WHERE f.nombreFaculta = :nombreFaculta")
    , @NamedQuery(name = "Facultades.findByFechaCreacionFacultad", query = "SELECT f FROM Facultades f WHERE f.fechaCreacionFacultad = :fechaCreacionFacultad")})
public class Facultades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_facultad")
    private String idFacultad;
    @Basic(optional = false)
    @Column(name = "nombre_faculta")
    private String nombreFaculta;
    @Column(name = "fecha_creacion_facultad")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionFacultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacultad")
    private Collection<Carreras> carrerasCollection;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacultad")
    private Collection<Edificios> edificiosCollection;

    public Facultades() {
    }

    public Facultades(String idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Facultades(String idFacultad, String nombreFaculta) {
        this.idFacultad = idFacultad;
        this.nombreFaculta = nombreFaculta;
    }

    public String getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(String idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFaculta() {
        return nombreFaculta;
    }

    public void setNombreFaculta(String nombreFaculta) {
        this.nombreFaculta = nombreFaculta;
    }

    public Date getFechaCreacionFacultad() {
        return fechaCreacionFacultad;
    }

    public void setFechaCreacionFacultad(Date fechaCreacionFacultad) {
        this.fechaCreacionFacultad = fechaCreacionFacultad;
    }

    @XmlTransient
    public Collection<Carreras> getCarrerasCollection() {
        return carrerasCollection;
    }

    public void setCarrerasCollection(Collection<Carreras> carrerasCollection) {
        this.carrerasCollection = carrerasCollection;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public Collection<Edificios> getEdificiosCollection() {
        return edificiosCollection;
    }

    public void setEdificiosCollection(Collection<Edificios> edificiosCollection) {
        this.edificiosCollection = edificiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacultad != null ? idFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultades)) {
            return false;
        }
        Facultades other = (Facultades) object;
        if ((this.idFacultad == null && other.idFacultad != null) || (this.idFacultad != null && !this.idFacultad.equals(other.idFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Facultades[ idFacultad=" + idFacultad + " ]";
    }
    
}
