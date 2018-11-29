/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mantenimiento.MantenimientoLogin;
import persistencia.RegistroUsuario;
import persistencia.Usuarios;

/**
 *
 * @author gabriela.chavezUSAM
 */
@ManagedBean
@RequestScoped
public class RequisitoBean {

    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
    HttpSession httpsession = request.getSession(false);

    /**
     * Creates a new instance of RequisitoBean
     */
    public RequisitoBean() {
    }

    private String correo;
    private String fecha, contra1, contra2;

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContra1() {
        return contra1;
    }

    public void setContra1(String contra1) {
        this.contra1 = contra1;
    }

    public String getContra2() {
        return contra2;
    }

    public void setContra2(String contra2) {
        this.contra2 = contra2;
    }

    public String usuariovalidar() {
        MantenimientoLogin ml = new MantenimientoLogin();
        Usuarios us = null;
        us = ml.ExistenciaUsuario(correo);
        String msg = "";
        String g = "";
        if (us != null) {
            int id = Integer.parseInt(us.getIdRegUsuario().toString());
            RegistroUsuario ru = null;
            ru = ml.ConsultarId(id);
            if (ru.getFechaNacimiento().equals(this.fecha)) {

                httpsession.setAttribute("usuario", us.getIdUsuario());

                g = "CambioClave.xhtml?faces-redirect=true";

            } else {
                msg = "Su fecha de nacimiento es incorrecta";
            }

        } else {
            msg = "El correo no existe";

        }
        FacesMessage msg1 = new FacesMessage(msg);
        msg1.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg1);
        System.out.println(g);
        return g;
    }

    public String cambiocontraseña() {
        String msg = "";
        String url = "";
        if (this.contra1.equals(this.contra2)) {
            int id = Integer.parseInt(httpsession.getAttribute("usuario").toString());
            MantenimientoLogin ml = new MantenimientoLogin();
            int res = ml.actualizarcontraseña(contra1, id);
            if (res == 1) {
                httpsession.removeAttribute("usuario");
                FacesMessage msg1 = new FacesMessage("Contraseña actualizada");
                msg1.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext.getCurrentInstance().addMessage(null, msg1);
                msg = "Contraseña actualizada";
                url = "/index.xhtml?faces-redirect=true";
            } else {
                msg = "Error al actualizar contraseña";
            }
        } else {
            msg = "Contraseñas no son iguales";

        }
        FacesMessage msg1 = new FacesMessage(msg);
        msg1.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg1);

        return url;

    }

}
