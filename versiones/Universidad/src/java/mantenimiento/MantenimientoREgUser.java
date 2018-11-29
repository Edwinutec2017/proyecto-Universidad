/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento;

/**
 *
 * @author edwin.nolascoUSAM
 */
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import persistencia.Estado;
import persistencia.RegistroUsuario;
import persistencia.TipoUsuario;
import persistencia.Usuarios;

public class MantenimientoREgUser {

    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
    int flag = 0;

    /*metodo de insertar datos a la bd*/
    public int guardarDatos(RegistroUsuario regUsuario) {
        em=JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(regUsuario);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }

    /*metodo de consyltar  todos los datos*/
    public List consultar() {
        List<RegistroUsuario> listuser = null;

        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT r FROM RegistroUsuario r");/*lleva el mismo nombre de la persistencia */
            em.getTransaction().commit();
            listuser = query.getResultList();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listuser;
    }

    /*lista para llenar una lista desplegable */
    public List ConsultarTipoUsuario() {
        List<TipoUsuario> listuser = null;

        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT t FROM TipoUsuario t");/*lleva el mismo nombre de la persistencia */
            em.getTransaction().commit();
            listuser = query.getResultList();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return listuser;
    }

    /*metodo de elimninar */
    public int Eliminar(int id) {
        em.getTransaction().begin();
        System.out.println(id);
        try {
            RegistroUsuario delete = em.find(RegistroUsuario.class, id);
            em.remove(delete);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = 0;
        } finally {
            em.close();
        }
        return flag;
    }

    /*metodo para consultar por  id */
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

    /*metodo de creacion de usuarios*/
    public int crearUsuario(Usuarios usuarios) {

      em.getTransaction().begin();

        try {
            em.persist(usuarios);
            em.getTransaction().commit();
            flag = 1;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            flag = 0;
        } finally {

            em.close();
        }
        System.out.println(flag);
        return flag;
    }

    /*------------------------------------*/
 /*metodo de consulta de usuario si existe*/
    public List SeleccUsuario() {

        List<Usuarios> listuser = null;
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("SELECT u FROM Usuarios u");/*lleva el mismo nombre de la persistencia */
            em.getTransaction().commit();
            listuser = query.getResultList();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }finally{
        em.close();
        }
        return listuser;
    }
    
      /*metodo para consultar por  id de usuarios  */
    public List Usuariosid(String  Correo) {
        List<Usuarios>consultaid = null;
        em.getTransaction().begin();
        try {
           Query query=em.createQuery("SELECT u FROM Usuarios u WHERE u.usuario = :usuario");
            query.setParameter("usuario", Correo);           
            em.getTransaction().commit();
            consultaid=query.getResultList();
 
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
           em.close();
        }

        return consultaid;
    }
    public int actualizar (RegistroUsuario rg){
    em.getTransaction().begin();
        try {
           
            em.merge(rg);
            em.getTransaction().commit();
            flag=1;
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag=0;
             } 
        finally{
        em.close();
        }
        return flag;
    }

}
