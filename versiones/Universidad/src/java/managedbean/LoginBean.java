/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

//import javax.faces.application.FacesMessage;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mantenimiento.MantenimientoLogin;
import org.primefaces.context.RequestContext;
import persistencia.RegistroUsuario;
//import org.primefaces.context.RequestContext;
import persistencia.Usuarios;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String usuario;
    private String pass;
    private String login;
    private int l;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

//    public String validar(){
//    
//        MantenimientoLogin man=new MantenimientoLogin();
//        
//        Usuarios u=man.consultarTodoLogin(login, pass);
//        
//        if (u!=null) {
//            usuario=u.getUsuario();
//            return "admin";
//            
//        }
//        return "index";
//    
//    
//    }
//    
    public void validar() {

        MantenimientoLogin man = new MantenimientoLogin();
        Usuarios u = man.consultarTodoLogin(usuario, pass);

        l = u.getIdRegUsuario().getIdTipoUsuario().getIdTipoUsuario();

    }

    public String ir() {
        MantenimientoLogin man = new MantenimientoLogin();
        Usuarios u = man.consultarTodoLogin(usuario, pass);
        RegistroUsuario ru = null;
        String msg = "";
        String n = "";

        if (u != null) {
            int id = Integer.parseInt(u.getIdRegUsuario().toString());
            ru = man.ConsultarId(id);

            String tipo = ru.getIdTipoUsuario().toString();
            String estado = ru.getIdEstado().toString();
            if (estado.equals("Activo")) {
            switch (tipo) {
                            case "Administrador":
                                msg = "Bienvenido Admin";
                                n = "vistas/Usuarios.xhtml?faces-redirect=true";
                                break;
                            case "Docente":
                                msg = "Bienvenido Docente";
                                n = "vistas/menu.xhtml?faces-redirect=true";
                                break;
                            case "Alumno":
                                msg = "Bienvenido Alumno";
                                n = "vistas/menu.xhtml?faces-redirect=true";
                                break;
                        }

            } else {
                msg = "Usuario Inactivo";

            }

        } else {
          msg="Revise usuario o contraseña incorrecta";

        }
        FacesMessage msg1 = new FacesMessage(msg);
        msg1.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg1);

        return n;
    }
    

    public static void main(String[] args) {
        MantenimientoLogin man = new MantenimientoLogin();

        Usuarios u = man.consultarTodoLogin("user", "123");
        System.out.println(u.getIdRegUsuario().getIdTipoUsuario().getIdTipoUsuario());
    }

}
