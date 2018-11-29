/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edwin.nolascoUSAM
 */
@Entity
@Table(name = "tipo_transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t")
    , @NamedQuery(name = "TipoTransaccion.findByIdTipoTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.idTipoTransaccion = :idTipoTransaccion")
    , @NamedQuery(name = "TipoTransaccion.findByNombreTransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.nombreTransaccion = :nombreTransaccion")})
public class TipoTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_transaccion")
    private Integer idTipoTransaccion;
    @Basic(optional = false)
    @Column(name = "nombre_transaccion")
    private String nombreTransaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransaccion")
    private Collection<Cuota> cuotaCollection;

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public TipoTransaccion(Integer idTipoTransaccion, String nombreTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
        this.nombreTransaccion = nombreTransaccion;
    }

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getNombreTransaccion() {
        return nombreTransaccion;
    }

    public void setNombreTransaccion(String nombreTransaccion) {
        this.nombreTransaccion = nombreTransaccion;
    }

    @XmlTransient
    public Collection<Cuota> getCuotaCollection() {
        return cuotaCollection;
    }

    public void setCuotaCollection(Collection<Cuota> cuotaCollection) {
        this.cuotaCollection = cuotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransaccion != null ? idTipoTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.idTipoTransaccion == null && other.idTipoTransaccion != null) || (this.idTipoTransaccion != null && !this.idTipoTransaccion.equals(other.idTipoTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TipoTransaccion[ idTipoTransaccion=" + idTipoTransaccion + " ]";
    }
    
}
