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
@Table(name = "estado_notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoNotas.findAll", query = "SELECT e FROM EstadoNotas e")
    , @NamedQuery(name = "EstadoNotas.findByIdEstadoNota", query = "SELECT e FROM EstadoNotas e WHERE e.idEstadoNota = :idEstadoNota")
    , @NamedQuery(name = "EstadoNotas.findByEstadoNotas", query = "SELECT e FROM EstadoNotas e WHERE e.estadoNotas = :estadoNotas")})
public class EstadoNotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_nota")
    private Integer idEstadoNota;
    @Basic(optional = false)
    @Column(name = "estado_notas")
    private String estadoNotas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoNota")
    private Collection<Notas> notasCollection;

    public EstadoNotas() {
    }

    public EstadoNotas(Integer idEstadoNota) {
        this.idEstadoNota = idEstadoNota;
    }

    public EstadoNotas(Integer idEstadoNota, String estadoNotas) {
        this.idEstadoNota = idEstadoNota;
        this.estadoNotas = estadoNotas;
    }

    public Integer getIdEstadoNota() {
        return idEstadoNota;
    }

    public void setIdEstadoNota(Integer idEstadoNota) {
        this.idEstadoNota = idEstadoNota;
    }

    public String getEstadoNotas() {
        return estadoNotas;
    }

    public void setEstadoNotas(String estadoNotas) {
        this.estadoNotas = estadoNotas;
    }

    @XmlTransient
    public Collection<Notas> getNotasCollection() {
        return notasCollection;
    }

    public void setNotasCollection(Collection<Notas> notasCollection) {
        this.notasCollection = notasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoNota != null ? idEstadoNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoNotas)) {
            return false;
        }
        EstadoNotas other = (EstadoNotas) object;
        if ((this.idEstadoNota == null && other.idEstadoNota != null) || (this.idEstadoNota != null && !this.idEstadoNota.equals(other.idEstadoNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.EstadoNotas[ idEstadoNota=" + idEstadoNota + " ]";
    }
    
}
