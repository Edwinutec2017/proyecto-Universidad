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
@Table(name = "asignacion_mtria_docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionMtriaDocentes.findAll", query = "SELECT a FROM AsignacionMtriaDocentes a")
    , @NamedQuery(name = "AsignacionMtriaDocentes.findByIdAsignacion", query = "SELECT a FROM AsignacionMtriaDocentes a WHERE a.idAsignacion = :idAsignacion")
    , @NamedQuery(name = "AsignacionMtriaDocentes.findByFechaAsignacionDocente", query = "SELECT a FROM AsignacionMtriaDocentes a WHERE a.fechaAsignacionDocente = :fechaAsignacionDocente")})
public class AsignacionMtriaDocentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @Column(name = "fecha_asignacion_docente")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionDocente;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materia idMateria;
    @JoinColumn(name = "id_reg_usuario", referencedColumnName = "id_reg_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario idRegUsuario;

    public AsignacionMtriaDocentes() {
    }

    public AsignacionMtriaDocentes(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaAsignacionDocente() {
        return fechaAsignacionDocente;
    }

    public void setFechaAsignacionDocente(Date fechaAsignacionDocente) {
        this.fechaAsignacionDocente = fechaAsignacionDocente;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public RegistroUsuario getIdRegUsuario() {
        return idRegUsuario;
    }

    public void setIdRegUsuario(RegistroUsuario idRegUsuario) {
        this.idRegUsuario = idRegUsuario;
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
        if (!(object instanceof AsignacionMtriaDocentes)) {
            return false;
        }
        AsignacionMtriaDocentes other = (AsignacionMtriaDocentes) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.AsignacionMtriaDocentes[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
