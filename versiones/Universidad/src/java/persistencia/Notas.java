/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edwin.nolascoUSAM
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n")
    , @NamedQuery(name = "Notas.findByIdNotas", query = "SELECT n FROM Notas n WHERE n.idNotas = :idNotas")
    , @NamedQuery(name = "Notas.findByNota1", query = "SELECT n FROM Notas n WHERE n.nota1 = :nota1")
    , @NamedQuery(name = "Notas.findByNota2", query = "SELECT n FROM Notas n WHERE n.nota2 = :nota2")
    , @NamedQuery(name = "Notas.findByNota3", query = "SELECT n FROM Notas n WHERE n.nota3 = :nota3")
    , @NamedQuery(name = "Notas.findByNota4", query = "SELECT n FROM Notas n WHERE n.nota4 = :nota4")
    , @NamedQuery(name = "Notas.findByNota5", query = "SELECT n FROM Notas n WHERE n.nota5 = :nota5")
    , @NamedQuery(name = "Notas.findByNotaFinal", query = "SELECT n FROM Notas n WHERE n.notaFinal = :notaFinal")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notas")
    private Integer idNotas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "nota1")
    private BigDecimal nota1;
    @Basic(optional = false)
    @Column(name = "nota2")
    private BigDecimal nota2;
    @Basic(optional = false)
    @Column(name = "nota3")
    private BigDecimal nota3;
    @Basic(optional = false)
    @Column(name = "nota4")
    private BigDecimal nota4;
    @Basic(optional = false)
    @Column(name = "nota5")
    private BigDecimal nota5;
    @Basic(optional = false)
    @Column(name = "nota_final")
    private BigDecimal notaFinal;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne(optional = false)
    private Materia idMateria;
    @JoinColumn(name = "id_reg_usuario", referencedColumnName = "id_reg_usuario")
    @ManyToOne(optional = false)
    private RegistroUsuario idRegUsuario;
    @JoinColumn(name = "id_estado_nota", referencedColumnName = "id_estado_nota")
    @ManyToOne(optional = false)
    private EstadoNotas idEstadoNota;
    @JoinColumn(name = "id_cuota", referencedColumnName = "id_cuota")
    @ManyToOne(optional = false)
    private Cuota idCuota;

    public Notas() {
    }

    public Notas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Notas(Integer idNotas, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, BigDecimal nota4, BigDecimal nota5, BigDecimal notaFinal) {
        this.idNotas = idNotas;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.nota5 = nota5;
        this.notaFinal = notaFinal;
    }

    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public BigDecimal getNota4() {
        return nota4;
    }

    public void setNota4(BigDecimal nota4) {
        this.nota4 = nota4;
    }

    public BigDecimal getNota5() {
        return nota5;
    }

    public void setNota5(BigDecimal nota5) {
        this.nota5 = nota5;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
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

    public EstadoNotas getIdEstadoNota() {
        return idEstadoNota;
    }

    public void setIdEstadoNota(EstadoNotas idEstadoNota) {
        this.idEstadoNota = idEstadoNota;
    }

    public Cuota getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Cuota idCuota) {
        this.idCuota = idCuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Notas[ idNotas=" + idNotas + " ]";
    }
    
}
