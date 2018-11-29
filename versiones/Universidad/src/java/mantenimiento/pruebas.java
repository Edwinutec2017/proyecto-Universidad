/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import managedbean.BeanRegUser;
import persistencia.Estado;
import persistencia.RegistroUsuario;
import static persistencia.RegistroUsuario_.idEstado;
import persistencia.Usuarios;

/**
 *
 * @author edwin.nolascoUSAM
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here.
//BeanRegUser bean =new BeanRegUser();
//bean.actualizar(36);
//        
//        
//        MantenimientoREgUser user = new MantenimientoREgUser();
//        RegistroUsuario s = new RegistroUsuario();
//        Usuarios use = new Usuarios();
//List<Usuarios> lista=user.Usuariosid("Omar-hernandez98@outlook.es");
//           Iterator it=lista.iterator();
//        while(it.hasNext()){
//            Usuarios d=(Usuarios) it.next();
//            System.out.println("Usuario: " + d.getUsuario());
//            System.out.println("Password: " + d.getPass());
//        }
//        

        RegistroUsuario rg= new RegistroUsuario();
        MantenimientoREgUser mr = new MantenimientoREgUser();
        rg=mr.ConsultarId(39);
        rg.setNombreUsuario("nombreUsuario");
        try {
            if (mr.actualizar(rg)==1) {
            System.out.println("Exito");
        } else{
        
            System.out.println("FRACASO");
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

}
