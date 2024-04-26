package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.UsersEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class UserModel {
    public List<UsersEntity> listarUsers(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("UsersEntity.findAll");
            List<UsersEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public UsersEntity obtenerUsers(int idusers){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            UsersEntity users = em.find(UsersEntity.class, idusers);
            em.close();
            return  users;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarUsers(UsersEntity users){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(users);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarUsers(UsersEntity users){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(users);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarUsers(int Users){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            UsersEntity users = em.find(UsersEntity.class, Users);
            if(users !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(users);
                tran.commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        }catch(Exception e){
            em.close();
            return 0;
        }

    }

}
