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
@Table(name = "historias_navegacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriasNavegacion.findAll", query = "SELECT h FROM HistoriasNavegacion h")
    , @NamedQuery(name = "HistoriasNavegacion.findByIdHistoriasNavegacion", query = "SELECT h FROM HistoriasNavegacion h WHERE h.idHistoriasNavegacion = :idHistoriasNavegacion")
    , @NamedQuery(name = "HistoriasNavegacion.findByActividades", query = "SELECT h FROM HistoriasNavegacion h WHERE h.actividades = :actividades")
    , @NamedQuery(name = "HistoriasNavegacion.findByFechaNavegacion", query = "SELECT h FROM HistoriasNavegacion h WHERE h.fechaNavegacion = :fechaNavegacion")
    , @NamedQuery(name = "HistoriasNavegacion.findByHoraNavegacion", query = "SELECT h FROM HistoriasNavegacion h WHERE h.horaNavegacion = :horaNavegacion")})
public class HistoriasNavegacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_historias_navegacion")
    private Integer idHistoriasNavegacion;
    @Basic(optional = false)
    @Column(name = "actividades")
    private String actividades;
    @Basic(optional = false)
    @Column(name = "fecha_navegacion")
    @Temporal(TemporalType.DATE)
    private Date fechaNavegacion;
    @Basic(optional = false)
    @Column(name = "hora_navegacion")
    @Temporal(TemporalType.TIME)
    private Date horaNavegacion;
    @JoinColumn(name = "id_reg_usuario", referencedColumnName = "id_reg_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario idRegUsuario;

    public HistoriasNavegacion() {
    }

    public HistoriasNavegacion(Integer idHistoriasNavegacion) {
        this.idHistoriasNavegacion = idHistoriasNavegacion;
    }

    public HistoriasNavegacion(Integer idHistoriasNavegacion, String actividades, Date fechaNavegacion, Date horaNavegacion) {
        this.idHistoriasNavegacion = idHistoriasNavegacion;
        this.actividades = actividades;
        this.fechaNavegacion = fechaNavegacion;
        this.horaNavegacion = horaNavegacion;
    }

    public Integer getIdHistoriasNavegacion() {
        return idHistoriasNavegacion;
    }

    public void setIdHistoriasNavegacion(Integer idHistoriasNavegacion) {
        this.idHistoriasNavegacion = idHistoriasNavegacion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public Date getFechaNavegacion() {
        return fechaNavegacion;
    }

    public void setFechaNavegacion(Date fechaNavegacion) {
        this.fechaNavegacion = fechaNavegacion;
    }

    public Date getHoraNavegacion() {
        return horaNavegacion;
    }

    public void setHoraNavegacion(Date horaNavegacion) {
        this.horaNavegacion = horaNavegacion;
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
        hash += (idHistoriasNavegacion != null ? idHistoriasNavegacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriasNavegacion)) {
            return false;
        }
        HistoriasNavegacion other = (HistoriasNavegacion) object;
        if ((this.idHistoriasNavegacion == null && other.idHistoriasNavegacion != null) || (this.idHistoriasNavegacion != null && !this.idHistoriasNavegacion.equals(other.idHistoriasNavegacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.HistoriasNavegacion[ idHistoriasNavegacion=" + idHistoriasNavegacion + " ]";
    }
    
}
