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
@Table(name = "inscripcion_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscripcionMateria.findAll", query = "SELECT i FROM InscripcionMateria i")
    , @NamedQuery(name = "InscripcionMateria.findByIdInscripcion", query = "SELECT i FROM InscripcionMateria i WHERE i.idInscripcion = :idInscripcion")
    , @NamedQuery(name = "InscripcionMateria.findByFechaInscripcion", query = "SELECT i FROM InscripcionMateria i WHERE i.fechaInscripcion = :fechaInscripcion")})
public class InscripcionMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;
    @Basic(optional = false)
    @Column(name = "fecha_inscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechaInscripcion;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    @ManyToOne(optional = false)
    private Horarios idHorario;
    @JoinColumn(name = "id_cuota", referencedColumnName = "id_cuota")
    @ManyToOne(optional = false)
    private Cuota idCuota;
    @JoinColumn(name = "id_reg_usuario", referencedColumnName = "id_reg_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario idRegUsuario;

    public InscripcionMateria() {
    }

    public InscripcionMateria(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public InscripcionMateria(Integer idInscripcion, Date fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
    }

    public Cuota getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Cuota idCuota) {
        this.idCuota = idCuota;
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
        hash += (idInscripcion != null ? idInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionMateria)) {
            return false;
        }
        InscripcionMateria other = (InscripcionMateria) object;
        if ((this.idInscripcion == null && other.idInscripcion != null) || (this.idInscripcion != null && !this.idInscripcion.equals(other.idInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.InscripcionMateria[ idInscripcion=" + idInscripcion + " ]";
    }
    
}
