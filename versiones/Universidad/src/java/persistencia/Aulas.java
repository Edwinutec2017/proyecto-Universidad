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
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a")
    , @NamedQuery(name = "Aulas.findByIdAula", query = "SELECT a FROM Aulas a WHERE a.idAula = :idAula")
    , @NamedQuery(name = "Aulas.findByNumeroAula", query = "SELECT a FROM Aulas a WHERE a.numeroAula = :numeroAula")
    , @NamedQuery(name = "Aulas.findByNivelAula", query = "SELECT a FROM Aulas a WHERE a.nivelAula = :nivelAula")
    , @NamedQuery(name = "Aulas.findByCapacidadEstudiantes", query = "SELECT a FROM Aulas a WHERE a.capacidadEstudiantes = :capacidadEstudiantes")})
public class Aulas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aula")
    private Integer idAula;
    @Basic(optional = false)
    @Column(name = "numero_aula")
    private int numeroAula;
    @Basic(optional = false)
    @Column(name = "nivel_aula")
    private int nivelAula;
    @Basic(optional = false)
    @Column(name = "capacidad_estudiantes")
    private int capacidadEstudiantes;
    @JoinColumn(name = "id_edificio", referencedColumnName = "id_edificio")
    @ManyToOne(optional = false)
    private Edificios idEdificio;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAula")
    private Collection<Horarios> horariosCollection;

    public Aulas() {
    }

    public Aulas(Integer idAula) {
        this.idAula = idAula;
    }

    public Aulas(Integer idAula, int numeroAula, int nivelAula, int capacidadEstudiantes) {
        this.idAula = idAula;
        this.numeroAula = numeroAula;
        this.nivelAula = nivelAula;
        this.capacidadEstudiantes = capacidadEstudiantes;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public int getNivelAula() {
        return nivelAula;
    }

    public void setNivelAula(int nivelAula) {
        this.nivelAula = nivelAula;
    }

    public int getCapacidadEstudiantes() {
        return capacidadEstudiantes;
    }

    public void setCapacidadEstudiantes(int capacidadEstudiantes) {
        this.capacidadEstudiantes = capacidadEstudiantes;
    }

    public Edificios getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Edificios idEdificio) {
        this.idEdificio = idEdificio;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAula != null ? idAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.idAula == null && other.idAula != null) || (this.idAula != null && !this.idAula.equals(other.idAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Aulas[ idAula=" + idAula + " ]";
    }
    
}
