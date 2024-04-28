package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class TrabajadorModel {
    public List<TrabajadorEntity> listarTrabajador(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("TrabajadorEntity.findAll");
            List<TrabajadorEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public TrabajadorEntity obtenerTrabajador(int idtrabajador){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            TrabajadorEntity trabajador = em.find(TrabajadorEntity.class, idtrabajador);
            em.close();
            return  trabajador;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarTrabajador(TrabajadorEntity trabajador){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(trabajador);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarTrabajador(TrabajadorEntity trabajador){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(trabajador);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarTrabajador(int Trabajador){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            TrabajadorEntity trabajador = em.find(TrabajadorEntity.class, Trabajador);
            if(trabajador !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(trabajador);
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
