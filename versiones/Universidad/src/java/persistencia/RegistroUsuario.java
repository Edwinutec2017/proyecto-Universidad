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
@Table(name = "registro_usuario")
@XmlRootElement
@NamedQueries({    
    @NamedQuery(name = "RegistroUsuario.findAll", query = "SELECT r FROM RegistroUsuario r")
    , @NamedQuery(name = "RegistroUsuario.findByIdRegUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.idRegUsuario = :idRegUsuario")
    , @NamedQuery(name = "RegistroUsuario.findByCodUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.codUsuario = :codUsuario")
    , @NamedQuery(name = "RegistroUsuario.findByNombreUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "RegistroUsuario.findByTelefonoUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.telefonoUsuario = :telefonoUsuario")
    , @NamedQuery(name = "RegistroUsuario.findByCorreo", query = "SELECT r FROM RegistroUsuario r WHERE r.correo = :correo")
    , @NamedQuery(name = "RegistroUsuario.findByDireccionUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.direccionUsuario = :direccionUsuario")
    , @NamedQuery(name = "RegistroUsuario.findByFechaCreacionUsuario", query = "SELECT r FROM RegistroUsuario r WHERE r.fechaCreacionUsuario = :fechaCreacionUsuario")
    , @NamedQuery(name = "RegistroUsuario.findByGenero", query = "SELECT r FROM RegistroUsuario r WHERE r.genero = :genero")
    , @NamedQuery(name = "RegistroUsuario.findByFechaNacimiento", query = "SELECT r FROM RegistroUsuario r WHERE r.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "RegistroUsuario.findByDui", query = "SELECT r FROM RegistroUsuario r WHERE r.dui = :dui")
    , @NamedQuery(name = "RegistroUsuario.findByNit", query = "SELECT r FROM RegistroUsuario r WHERE r.nit = :nit")
    , @NamedQuery(name = "RegistroUsuario.findByCarnet", query = "SELECT r FROM RegistroUsuario r WHERE r.carnet = :carnet")})
public class RegistroUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reg_usuario")
    private Integer idRegUsuario;
    @Basic(optional = false)
    @Column(name = "cod_usuario")
    private String codUsuario;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "telefono_usuario")
    private String telefonoUsuario;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "direccion_usuario")
    private String direccionUsuario;
    @Basic(optional = false)
    @Column(name = "fecha_creacion_usuario")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionUsuario;
    @Basic(optional = false)
    @Column(name = "genero")
    private Character genero;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Column(name = "dui")
    private String dui;
    @Basic(optional = false)
    @Column(name = "nit")
    private String nit;
    @Column(name = "carnet")
    private String carnet;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne(optional = false)
    private TipoUsuario idTipoUsuario;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;

    public RegistroUsuario() {
    }

    public RegistroUsuario(Integer idRegUsuario) {
        this.idRegUsuario = idRegUsuario;
    }

    public RegistroUsuario(Integer idRegUsuario, String codUsuario, String nombreUsuario, String telefonoUsuario, String correo, String direccionUsuario, Date fechaCreacionUsuario, Character genero, String fechaNacimiento, String nit) {
        this.idRegUsuario = idRegUsuario;
        this.codUsuario = codUsuario;
        this.nombreUsuario = nombreUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.correo = correo;
        this.direccionUsuario = direccionUsuario;
        this.fechaCreacionUsuario = fechaCreacionUsuario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.nit = nit;
    }

    public Integer getIdRegUsuario() {
        return idRegUsuario;
    }

    public void setIdRegUsuario(Integer idRegUsuario) {
        this.idRegUsuario = idRegUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Date getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegUsuario != null ? idRegUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroUsuario)) {
            return false;
        }
        RegistroUsuario other = (RegistroUsuario) object;
        if ((this.idRegUsuario == null && other.idRegUsuario != null) || (this.idRegUsuario != null && !this.idRegUsuario.equals(other.idRegUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idRegUsuario.toString();
    }
  
}
