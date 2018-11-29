/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mantenimiento.MantenimientoREgUser;
import persistencia.Estado;
import persistencia.RegistroUsuario;
import persistencia.TipoUsuario;
import persistencia.Usuarios;
import static persistencia.Usuarios_.usuario;

/**
 *
 * @author edwin.nolascoUSAM
 */
@ManagedBean
@RequestScoped
public class BeanRegUser {

    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
    private int id_reg_usuario, id_tipo_usuario, id_estado;
    private String Cod_usuario, nombre_usuario, telefono, correo, direccio_usuario, DUI, NIT, Tipouser, Estados, Generos;
    private Date Fecha_creacion_usuario;
    private String fecha_nacimiento;
    private char genero;
    public List<TipoUsuario> listausuario;
    public List<RegistroUsuario> regUser;

    public List<RegistroUsuario> getRegUser() {
        return regUser;
    }

    public String getEstados() {
        return Estados;
    }

    public void setEstados(String Estados) {
        this.Estados = Estados;
    }

    public String getGeneros() {
        return Generos;
    }

    public void setGeneros(String Generos) {
        this.Generos = Generos;
    }

    public void setRegUser(List<RegistroUsuario> regUser) {
        this.regUser = regUser;
    }

    public SimpleDateFormat getFecha() {
        return fecha;
    }

    public void setFecha(SimpleDateFormat fecha) {
        this.fecha = fecha;
    }

    public List<TipoUsuario> getListausuario() {
        this.listausuario = new ArrayList<>();
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        listausuario = matuser.ConsultarTipoUsuario();
        return listausuario;
    }

    public void setListausuario(List<TipoUsuario> listausuario) {
        this.listausuario = listausuario;
    }

    public String getTipouser() {
        return Tipouser;
    }

    public void setTipouser(String Tipouser) {
        this.Tipouser = Tipouser;
    }

    public int getId_reg_usuario() {
        return id_reg_usuario;
    }

    public void setId_reg_usuario(int id_reg_usuario) {
        this.id_reg_usuario = id_reg_usuario;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getCod_usuario() {
        return Cod_usuario;
    }

    public void setCod_usuario(String Cod_usuario) {
        this.Cod_usuario = Cod_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccio_usuario() {
        return direccio_usuario;
    }

    public void setDireccio_usuario(String direccio_usuario) {
        this.direccio_usuario = direccio_usuario;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public Date getFecha_creacion_usuario() {
        return Fecha_creacion_usuario;
    }

    public void setFecha_creacion_usuario(Date Fecha_creacion_usuario) {
        this.Fecha_creacion_usuario = Fecha_creacion_usuario;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    /**
     * Creates a new instance of BeanRegUser
     */
    public BeanRegUser() {
    }

    public void guardarUsuario() {
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        RegistroUsuario usuario = new RegistroUsuario();
        Estado estado = new Estado();
        TipoUsuario tipousuario = new TipoUsuario();
        usuario.setIdRegUsuario(0);
        usuario.setNombreUsuario(nombre_usuario);
        usuario.setTelefonoUsuario(telefono);
        usuario.setCorreo(correo);
        usuario.setDireccionUsuario(direccio_usuario);
        usuario.setFechaCreacionUsuario(new Date());
        usuario.setGenero(genero);
        usuario.setFechaNacimiento(fecha_nacimiento);
        usuario.setDui(DUI);
        usuario.setNit(NIT);
        usuario.setCarnet("proceso");
        estado.setIdEstado(1);
        usuario.setIdEstado(estado);
        String msg = "";
        switch (Tipouser) {
            case "1":
                usuario.setCodUsuario("Admin");
                tipousuario.setIdTipoUsuario(1);
                usuario.setIdTipoUsuario(tipousuario);
                if (matuser.guardarDatos(usuario) == 1) {

                    msg = "Ingresado";

                } else {
                    msg = "No Ingresado";
                }
                break;
            case "2":
                usuario.setCodUsuario("Doce");
                tipousuario.setIdTipoUsuario(2);
                usuario.setIdTipoUsuario(tipousuario);

                if (matuser.guardarDatos(usuario) == 1) {

                    msg = "Ingresado";

                } else {
                    msg = "No Ingresado";
                }
                break;
            case "3":
                usuario.setCodUsuario("Alum");
                tipousuario.setIdTipoUsuario(3);
                usuario.setIdTipoUsuario(tipousuario);
                if (matuser.guardarDatos(usuario) == 1) {

                    msg = "Ingresado";

                } else {
                    msg = "No Ingresado";
                }
                break;
        }
        FacesMessage ms = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, ms);

    }

    public List<RegistroUsuario> getLIstUser() {
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        regUser = matuser.consultar();
        return regUser;
    }

    /*metodo eliminar*/
    public void eliminar(int id) {
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        String a = null;
        if (matuser.Eliminar(id) == 1) {
            a = "Eliminado";

        } else {
            a = "No eiliminado";
        }
        FacesMessage delete = new FacesMessage(a);
        FacesContext.getCurrentInstance().addMessage(null, delete);

    }

    /*metodo de limpiar datos*/
    public void limpiarDatos() {
        this.nombre_usuario = "";
        this.telefono = "";
        this.direccio_usuario = "";
        this.NIT = "";
        this.correo = "";
        this.DUI = "";
        this.fecha_nacimiento = "";
        String msg = "Limpiando Datos";
        FacesMessage user = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, user);
    }

    /*metodo de llenado de datos por id*/
    public void Consulta(int id) {
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        RegistroUsuario datos = null;
        datos = matuser.ConsultarId(id);
        if (datos != null) {
            this.id_reg_usuario = datos.getIdRegUsuario();
            this.nombre_usuario = datos.getNombreUsuario();
            this.telefono = datos.getTelefonoUsuario();
            this.direccio_usuario = datos.getDireccionUsuario();
            this.correo = datos.getCorreo();
            this.Tipouser = datos.getIdTipoUsuario().toString();
            this.Estados = datos.getIdEstado().toString();
            this.Cod_usuario = datos.getCodUsuario();
            this.fecha_nacimiento = datos.getFechaNacimiento();
            this.DUI = datos.getDui();
            this.NIT = datos.getNit();
            this.genero = datos.getGenero();
            if (this.genero == 'M') {
                this.Generos = "Masculino";
            } else {
                this.Generos = "Femenino";
            }
        }

    }

    public List Prueba(String correo) {
        System.out.println("llega" + correo);
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        List<Usuarios> user = matuser.Usuariosid(correo);
//        for (Usuarios u : user) {
//            System.out.println(u.getUsuario());
//        }

        return user;
    }

    public int usuariosCrear(Usuarios user) {
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        int resp = matuser.crearUsuario(user);
        return resp;
    }

    /*metodo de creacion de usuario*/
    public void CrearUsuario(int id) {
        String msg = "";
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        Usuarios user = new Usuarios();
        RegistroUsuario reguser = matuser.ConsultarId(id);
        List<Usuarios> lsUsuarios = Prueba(reguser.getCorreo());
        System.out.println(lsUsuarios);
        if (lsUsuarios == null || lsUsuarios.isEmpty()) {
            user.setIdUsuario(0);
            user.setUsuario(reguser.getCorreo());
            user.setPass("1234");
            user.setIdRegUsuario(reguser);
            int resp = usuariosCrear(user);
            if (resp == 1) {
                msg = "Usuario Creado";
            } else {
                msg = "Usuario no Creado";
            }
        } else {
            for (Usuarios ls : lsUsuarios) {
                if (ls.getUsuario().equals(reguser.getCorreo())) {
                    msg = "Usuarios ya Registrado";
                }
            }

        }
        FacesMessage usuarios = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, usuarios);
    }

    public void actualizar(int id) throws IOException {
        MantenimientoREgUser matuser = new MantenimientoREgUser();
        RegistroUsuario rg = matuser.ConsultarId(id);
        Estado estado = new Estado();
        TipoUsuario tipousuario = new TipoUsuario();
        String msg="";
        
        rg.setNombreUsuario(rg.getNombreUsuario());
        rg.setTelefonoUsuario(rg.getTelefonoUsuario());
        rg.setDireccionUsuario(rg.getDireccionUsuario());
        rg.setGenero(rg.getGenero());
        rg.setFechaNacimiento(rg.getFechaNacimiento());
        rg.setDui(rg.getDui());
        rg.setNit(rg.getNit());
        rg.setIdRegUsuario(rg.getIdRegUsuario());
        
        
        if (matuser.actualizar(rg)==1) {
            System.out.println("1");
            msg="Sus datos han sido actualizados";
             FacesContext.getCurrentInstance().getExternalContext().redirect("vistas/datos.xhtml?faces-redirect=true");
        } else{
            System.out.println("2");
            msg="Sus datos no han sido actualizados";
        }
        FacesMessage usuarios = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, usuarios);
        

    }

}
