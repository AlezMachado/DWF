package sv.edu.udb.www.models;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import sv.edu.udb.www.utils.JpaUtil;

public class PersonaModel {

    public List<PersonaEntity> listarPersonas(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

                Query consulta = em.createNamedQuery("PersonaEntity.findAll");
            List<PersonaEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public PersonaEntity obtenerPersona(int idpersona){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            PersonaEntity persona = em.find(PersonaEntity.class, idpersona);
            em.close();
            return  persona;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarPersona(PersonaEntity persona){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(persona);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarPersona(PersonaEntity persona){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(persona);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarPersona(int Persona){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            PersonaEntity persona = em.find(PersonaEntity.class, Persona);
            if(persona !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(persona);
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
