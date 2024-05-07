package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.PagoEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class PagoModel {
    public List<PagoEntity> listarPagos(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("PagoEntity.findAll");
            List<PagoEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public PagoEntity obtenerPagos(int idpago){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            PagoEntity consumo = em.find(PagoEntity.class, idpago);
            em.close();
            return  consumo;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarPago(PagoEntity pago){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(pago);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarPago(PagoEntity pago){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(pago);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarPago(int Pago){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            PagoEntity pago = em.find(PagoEntity.class, Pago);
            if(pago !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(pago);
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
