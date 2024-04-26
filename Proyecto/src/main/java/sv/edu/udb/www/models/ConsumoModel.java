package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.ConsumoEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class ConsumoModel {
    public List<ConsumoEntity> listarconsumos(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("ConsumoEntity.findAll");
            List<ConsumoEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public ConsumoEntity obtenerconsumos(int idconsumo){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ConsumoEntity consumo = em.find(ConsumoEntity.class, idconsumo);
            em.close();
            return  consumo;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarconsumo(ConsumoEntity consumo){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(consumo);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarConsumo(ConsumoEntity consumo){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(consumo);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarConsumo(int Consumo){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            ConsumoEntity consumo = em.find(ConsumoEntity.class, Consumo);
            if(consumo !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(consumo);
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
