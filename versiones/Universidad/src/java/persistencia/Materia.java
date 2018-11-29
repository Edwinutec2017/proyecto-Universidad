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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria")
    , @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria")
    , @NamedQuery(name = "Materia.findByHoraClases", query = "SELECT m FROM Materia m WHERE m.horaClases = :horaClases")
    , @NamedQuery(name = "Materia.findByModulos", query = "SELECT m FROM Materia m WHERE m.modulos = :modulos")
    , @NamedQuery(name = "Materia.findByFechaRegistroMateria", query = "SELECT m FROM Materia m WHERE m.fechaRegistroMateria = :fechaRegistroMateria")
    , @NamedQuery(name = "Materia.findByNumeroMateria", query = "SELECT m FROM Materia m WHERE m.numeroMateria = :numeroMateria")
    , @NamedQuery(name = "Materia.findByPrerrequisitos", query = "SELECT m FROM Materia m WHERE m.prerrequisitos = :prerrequisitos")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_materia")
    private String idMateria;
    @Basic(optional = false)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @Basic(optional = false)
    @Column(name = "hora_clases")
    private int horaClases;
    @Basic(optional = false)
    @Column(name = "modulos")
    private int modulos;
    @Basic(optional = false)
    @Column(name = "fecha_registro_materia")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroMateria;
    @Basic(optional = false)
    @Column(name = "numero_materia")
    private int numeroMateria;
    @Basic(optional = false)
    @Column(name = "prerrequisitos")
    private int prerrequisitos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private Collection<Notas> notasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private Collection<AsignacionCarreraAlumno> asignacionCarreraAlumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private Collection<AsignacionMtriaDocentes> asignacionMtriaDocentesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private Collection<Horarios> horariosCollection;
    @JoinColumn(name = "id_carrera", referencedColumnName = "id_carrera")
    @ManyToOne(optional = false)
    private Carreras idCarrera;
    @JoinColumn(name = "id_ciclo", referencedColumnName = "id_ciclo")
    @ManyToOne(optional = false)
    private Ciclo idCiclo;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;

    public Materia() {
    }

    public Materia(String idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(String idMateria, String nombreMateria, int horaClases, int modulos, Date fechaRegistroMateria, int numeroMateria, int prerrequisitos) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.horaClases = horaClases;
        this.modulos = modulos;
        this.fechaRegistroMateria = fechaRegistroMateria;
        this.numeroMateria = numeroMateria;
        this.prerrequisitos = prerrequisitos;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getHoraClases() {
        return horaClases;
    }

    public void setHoraClases(int horaClases) {
        this.horaClases = horaClases;
    }

    public int getModulos() {
        return modulos;
    }

    public void setModulos(int modulos) {
        this.modulos = modulos;
    }

    public Date getFechaRegistroMateria() {
        return fechaRegistroMateria;
    }

    public void setFechaRegistroMateria(Date fechaRegistroMateria) {
        this.fechaRegistroMateria = fechaRegistroMateria;
    }

    public int getNumeroMateria() {
        return numeroMateria;
    }

    public void setNumeroMateria(int numeroMateria) {
        this.numeroMateria = numeroMateria;
    }

    public int getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(int prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    @XmlTransient
    public Collection<AsignacionCarreraAlumno> getAsignacionCarreraAlumnoCollection() {
        return asignacionCarreraAlumnoCollection;
    }

    public void setAsignacionCarreraAlumnoCollection(Collection<AsignacionCarreraAlumno> asignacionCarreraAlumnoCollection) {
        this.asignacionCarreraAlumnoCollection = asignacionCarreraAlumnoCollection;
    }

    @XmlTransient
    public Collection<AsignacionMtriaDocentes> getAsignacionMtriaDocentesCollection() {
        return asignacionMtriaDocentesCollection;
    }

    public void setAsignacionMtriaDocentesCollection(Collection<AsignacionMtriaDocentes> asignacionMtriaDocentesCollection) {
        this.asignacionMtriaDocentesCollection = asignacionMtriaDocentesCollection;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    public Carreras getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carreras idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Ciclo getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Ciclo idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Materia[ idMateria=" + idMateria + " ]";
    }
    
}
