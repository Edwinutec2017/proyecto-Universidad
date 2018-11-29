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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findByIdHorario", query = "SELECT h FROM Horarios h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "Horarios.findByDiaClases", query = "SELECT h FROM Horarios h WHERE h.diaClases = :diaClases")
    , @NamedQuery(name = "Horarios.findByCicloCurso", query = "SELECT h FROM Horarios h WHERE h.cicloCurso = :cicloCurso")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario")
    private Integer idHorario;
    @Basic(optional = false)
    @Column(name = "dia_clases")
    private String diaClases;
    @Basic(optional = false)
    @Column(name = "ciclo_curso")
    private String cicloCurso;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materia idMateria;
    @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
    @ManyToOne(optional = false)
    private Aulas idAula;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHorario")
    private Collection<InscripcionMateria> inscripcionMateriaCollection;

    public Horarios() {
    }

    public Horarios(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Horarios(Integer idHorario, String diaClases, String cicloCurso) {
        this.idHorario = idHorario;
        this.diaClases = diaClases;
        this.cicloCurso = cicloCurso;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getDiaClases() {
        return diaClases;
    }

    public void setDiaClases(String diaClases) {
        this.diaClases = diaClases;
    }

    public String getCicloCurso() {
        return cicloCurso;
    }

    public void setCicloCurso(String cicloCurso) {
        this.cicloCurso = cicloCurso;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Aulas getIdAula() {
        return idAula;
    }

    public void setIdAula(Aulas idAula) {
        this.idAula = idAula;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
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
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Horarios[ idHorario=" + idHorario + " ]";
    }
    
}
