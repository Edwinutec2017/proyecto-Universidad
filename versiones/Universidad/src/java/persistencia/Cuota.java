/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c")
    , @NamedQuery(name = "Cuota.findByIdCuota", query = "SELECT c FROM Cuota c WHERE c.idCuota = :idCuota")
    , @NamedQuery(name = "Cuota.findByCuota", query = "SELECT c FROM Cuota c WHERE c.cuota = :cuota")
    , @NamedQuery(name = "Cuota.findByFechaCuota", query = "SELECT c FROM Cuota c WHERE c.fechaCuota = :fechaCuota")})
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuota")
    private Integer idCuota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cuota")
    private BigDecimal cuota;
    @Basic(optional = false)
    @Column(name = "fecha_cuota")
    @Temporal(TemporalType.DATE)
    private Date fechaCuota;
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")
    @ManyToOne(optional = false)
    private TipoPago idTipoPago;
    @JoinColumn(name = "id_tipo_transaccion", referencedColumnName = "id_tipo_transaccion")
    @ManyToOne(optional = false)
    private TipoTransaccion idTipoTransaccion;
    @JoinColumn(name = "id_reg_usuario", referencedColumnName = "id_reg_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario idRegUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuota")
    private Collection<Notas> notasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuota")
    private Collection<InscripcionMateria> inscripcionMateriaCollection;

    public Cuota() {
    }

    public Cuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public Cuota(Integer idCuota, BigDecimal cuota, Date fechaCuota) {
        this.idCuota = idCuota;
        this.cuota = cuota;
        this.fechaCuota = fechaCuota;
    }

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public Date getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(Date fechaCuota) {
        this.fechaCuota = fechaCuota;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public TipoTransaccion getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(TipoTransaccion idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public RegistroUsuario getIdRegUsuario() {
        return idRegUsuario;
    }

    public void setIdRegUsuario(RegistroUsuario idRegUsuario) {
        this.idRegUsuario = idRegUsuario;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    @XmlTransient
    public Collection<InscripcionMateria> getInscripcionMateriaCollection() {
        return inscripcionMateriaCollection;
    }

    public void setInscripcionMateriaCollection(Collection<InscripcionMateria> inscripcionMateriaCollection) {
        this.inscripcionMateriaCollection = inscripcionMateriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuota != null ? idCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.idCuota == null && other.idCuota != null) || (this.idCuota != null && !this.idCuota.equals(other.idCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Cuota[ idCuota=" + idCuota + " ]";
    }
    
}
