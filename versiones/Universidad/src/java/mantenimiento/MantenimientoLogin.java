package mantenimiento;

import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.Query;
import persistencia.RegistroUsuario;
import persistencia.Usuarios;


public class MantenimientoLogin {

   EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

   
     
    public Usuarios consultarTodoLogin(String usuario, String pass) {
       
            Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.usuario =:usuario AND u.pass =:pass");
            query.setParameter("usuario", usuario);
            query.setParameter("pass", pass);
            
           Usuarios usuarios=null;
           List <Usuarios> lista =  query.getResultList();
           
           for (Usuarios object : lista) {
               usuarios = object;

            
        }
           return usuarios;
    
//    Query q = em.createNamedQuery("Usuarios.findByUsuario", Usuarios.class).setParameter("usuario", usuario);
//    List <Usuarios> lista = q.getResultList();
//    
//        if (!lista.isEmpty()) {
//            Query qe = em.createNamedQuery("Usuarios.findByPass", Usuarios.class).setParameter("pass", pass);
//            List <Usuarios> lista1 =qe.getResultList();
//            if (!lista1.isEmpty()) {
//                return lista.get(0);
//                
//              } else{
//                System.out.println("Error en su contraseña");
//            }
//        } else{
//            System.out.println("Error en su usuario");
//                    }
//        return null;
//        }
    }
    
     public RegistroUsuario ConsultarId(int id) {
        RegistroUsuario consultaid = null;
        em.getTransaction().begin();
        try {
            consultaid = em.find(RegistroUsuario.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
           em.close();
        }
        return consultaid;
    }
     
       public Usuarios ExistenciaUsuario (String usuario) {
           System.out.println(usuario);
            Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.usuario =:usuario");
            query.setParameter("usuario", usuario);
           
            
           Usuarios usuarios=null;
           List <Usuarios> lista =  query.getResultList();
           
           for (Usuarios object : lista) {
               usuarios = object;

            
        }
           
            return usuarios;
       }
       //Metodo para cambiar contraseña
       public int actualizarcontraseña(String contraseña, int id){
       int flag=0;
       em.getTransaction().begin();
           try {
               Usuarios us = em.find(Usuarios.class, id);
               us.setPass(contraseña);
               em.getTransaction().commit();
               flag=1;
               
           } catch (Exception e) {
              em.getTransaction().rollback();
           }
           finally{
           em.close();
           }
           return flag;
       }
     

}
   


