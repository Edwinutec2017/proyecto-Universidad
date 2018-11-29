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
@Table(name = "carreras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreras.findAll", query = "SELECT c FROM Carreras c")
    , @NamedQuery(name = "Carreras.findByIdCarrera", query = "SELECT c FROM Carreras c WHERE c.idCarrera = :idCarrera")
    , @NamedQuery(name = "Carreras.findByNombreCarrera", query = "SELECT c FROM Carreras c WHERE c.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carreras.findByFechaCreacionCarrera", query = "SELECT c FROM Carreras c WHERE c.fechaCreacionCarrera = :fechaCreacionCarrera")
    , @NamedQuery(name = "Carreras.findByCiclos", query = "SELECT c FROM Carreras c WHERE c.ciclos = :ciclos")})
public class Carreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_carrera")
    private String idCarrera;
    @Basic(optional = false)
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @Column(name = "fecha_creacion_carrera")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionCarrera;
    @Basic(optional = false)
    @Column(name = "ciclos")
    private int ciclos;
    @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad")
    @ManyToOne(optional = false)
    private Facultades idFacultad;
    @JoinColumn(name = "id_modalidad", referencedColumnName = "id_modalidad")
    @ManyToOne(optional = false)
    private Modalidad idModalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrera")
    private Collection<Materia> materiaCollection;

    public Carreras() {
    }

    public Carreras(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Carreras(String idCarrera, String nombreCarrera, Date fechaCreacionCarrera, int ciclos) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.fechaCreacionCarrera = fechaCreacionCarrera;
        this.ciclos = ciclos;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Date getFechaCreacionCarrera() {
        return fechaCreacionCarrera;
    }

    public void setFechaCreacionCarrera(Date fechaCreacionCarrera) {
        this.fechaCreacionCarrera = fechaCreacionCarrera;
    }

    public int getCiclos() {
        return ciclos;
    }

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }

    public Facultades getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultades idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carreras)) {
            return false;
        }
        Carreras other = (Carreras) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Carreras[ idCarrera=" + idCarrera + " ]";
    }
    
}
