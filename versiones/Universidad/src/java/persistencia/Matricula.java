/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin.nolascoUSAM
 */
@Entity
@Table(name = "matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findByIdMadtricula", query = "SELECT m FROM Matricula m WHERE m.idMadtricula = :idMadtricula")
    , @NamedQuery(name = "Matricula.findByNumMatricula", query = "SELECT m FROM Matricula m WHERE m.numMatricula = :numMatricula")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_madtricula")
    private Integer idMadtricula;
    @Basic(optional = false)
    @Column(name = "num_matricula")
    private int numMatricula;

    public Matricula() {
    }

    public Matricula(Integer idMadtricula) {
        this.idMadtricula = idMadtricula;
    }

    public Matricula(Integer idMadtricula, int numMatricula) {
        this.idMadtricula = idMadtricula;
        this.numMatricula = numMatricula;
    }

    public Integer getIdMadtricula() {
        return idMadtricula;
    }

    public void setIdMadtricula(Integer idMadtricula) {
        this.idMadtricula = idMadtricula;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMadtricula != null ? idMadtricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMadtricula == null && other.idMadtricula != null) || (this.idMadtricula != null && !this.idMadtricula.equals(other.idMadtricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Matricula[ idMadtricula=" + idMadtricula + " ]";
    }
    
}
