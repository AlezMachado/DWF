package sv.edu.udb.www.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.ProductoEntity;
import sv.edu.udb.www.utils.JpaUtil;

import java.util.List;

public class ProductoModel {
    public List<ProductoEntity> listarProductos(){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            Query consulta = em.createNamedQuery("ProductoEntity.findAll");
            List<ProductoEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public ProductoEntity obtenerProducto(int idproducto){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ProductoEntity producto = em.find(ProductoEntity.class, idproducto);
            em.close();
            return  producto;
        }catch (Exception e){
            em.close();
            return null;
        }
    }
    public int insertarProducto(ProductoEntity producto){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.persist(producto);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarProductos(ProductoEntity producto){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tra = em.getTransaction();
        try{
            tra.begin();
            em.merge(producto);
            tra.commit();
            em.close();
            return 1;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
    public int eliminarProducto(int Producto){
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try{
            ProductoEntity producto = em.find(ProductoEntity.class, Producto);
            if(producto !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(producto);
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
