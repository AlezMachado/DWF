package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class ClienteModel {

    public List<ClienteEntity> listarClientes(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("ClienteEntity.findAll");
            List<ClienteEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public ClienteEntity obtenerCliente(int idcliente){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ClienteEntity cliente = em.find(ClienteEntity.class, idcliente);
            em.close();
            return  cliente;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarCliente(ClienteEntity cliente){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(cliente);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarCliente(ClienteEntity cliente){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(cliente);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarCliente(int Cliente){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            ClienteEntity cliente = em.find(ClienteEntity.class, Cliente);
            if(cliente !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(cliente);
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
