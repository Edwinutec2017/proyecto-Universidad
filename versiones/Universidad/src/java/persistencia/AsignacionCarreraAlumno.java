/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin.nolascoUSAM
 */
@Entity
@Table(name = "asignacion_carrera_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionCarreraAlumno.findAll", query = "SELECT a FROM AsignacionCarreraAlumno a")
    , @NamedQuery(name = "AsignacionCarreraAlumno.findByIdAsignacion", query = "SELECT a FROM AsignacionCarreraAlumno a WHERE a.idAsignacion = :idAsignacion")
    , @NamedQuery(name = "AsignacionCarreraAlumno.findByFechaAsignacionAlumno", query = "SELECT a FROM AsignacionCarreraAlumno a WHERE a.fechaAsignacionAlumno = :fechaAsignacionAlumno")})
public class AsignacionCarreraAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @Column(name = "fecha_asignacion_alumno")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionAlumno;
    @JoinColumn(name = "id_reg_usuario", referencedColumnName = "id_reg_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario idRegUsuario;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materia idMateria;

    public AsignacionCarreraAlumno() {
    }

    public AsignacionCarreraAlumno(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaAsignacionAlumno() {
        return fechaAsignacionAlumno;
    }

    public void setFechaAsignacionAlumno(Date fechaAsignacionAlumno) {
        this.fechaAsignacionAlumno = fechaAsignacionAlumno;
    }

    public RegistroUsuario getIdRegUsuario() {
        return idRegUsuario;
    }

    public void setIdRegUsuario(RegistroUsuario idRegUsuario) {
        this.idRegUsuario = idRegUsuario;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionCarreraAlumno)) {
            return false;
        }
        AsignacionCarreraAlumno other = (AsignacionCarreraAlumno) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.AsignacionCarreraAlumno[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
