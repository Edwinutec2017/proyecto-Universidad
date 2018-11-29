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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "edificios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificios.findAll", query = "SELECT e FROM Edificios e")
    , @NamedQuery(name = "Edificios.findByIdEdificio", query = "SELECT e FROM Edificios e WHERE e.idEdificio = :idEdificio")
    , @NamedQuery(name = "Edificios.findByNombreEdificio", query = "SELECT e FROM Edificios e WHERE e.nombreEdificio = :nombreEdificio")
    , @NamedQuery(name = "Edificios.findByNiveles", query = "SELECT e FROM Edificios e WHERE e.niveles = :niveles")})
public class Edificios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_edificio")
    private String idEdificio;
    @Basic(optional = false)
    @Column(name = "nombre_edificio")
    private String nombreEdificio;
    @Basic(optional = false)
    @Column(name = "niveles")
    private int niveles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEdificio")
    private Collection<Aulas> aulasCollection;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad")
    @ManyToOne(optional = false)
    private Facultades idFacultad;

    public Edificios() {
    }

    public Edificios(String idEdificio) {
        this.idEdificio = idEdificio;
    }

    public Edificios(String idEdificio, String nombreEdificio, int niveles) {
        this.idEdificio = idEdificio;
        this.nombreEdificio = nombreEdificio;
        this.niveles = niveles;
    }

    public String getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(String idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    @XmlTransient
    public Collection<Aulas> getAulasCollection() {
        return aulasCollection;
    }

    public void setAulasCollection(Collection<Aulas> aulasCollection) {
        this.aulasCollection = aulasCollection;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Facultades getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultades idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdificio != null ? idEdificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificios)) {
            return false;
        }
        Edificios other = (Edificios) object;
        if ((this.idEdificio == null && other.idEdificio != null) || (this.idEdificio != null && !this.idEdificio.equals(other.idEdificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Edificios[ idEdificio=" + idEdificio + " ]";
    }
    
}
