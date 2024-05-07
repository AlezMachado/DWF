package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.www.entities.ProductoEntity;
import sv.edu.udb.www.models.ProductoModel;

import java.util.List;
@ManagedBean
@SessionScoped
public class ProductoBean {

    ProductoModel modelProducto = new ProductoModel();

    private List<ProductoEntity> Producto;

    private ProductoEntity producto;

    public ProductoModel getModelProducto() {
        return modelProducto;
    }

    public void setModelProducto(ProductoModel modelProducto) {
        this.modelProducto = modelProducto;
    }

    public List<ProductoEntity> getProducto() {
        return Producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public void setProducto(List<ProductoEntity> producto) {
        Producto = producto;
    }

    public void agregarProducto() {

        modelProducto.insertarProducto(this.producto);
    }

    public void editarProducto() {
        modelProducto.modificarProductos(this.producto);
    }

    public void eliminarProducto(int idproducto)
    {

        modelProducto.eliminarProducto(idproducto);
        this.Producto =  modelProducto.listarProductos();
    }

    public void CargarProducto(ProductoEntity producto){
        this.producto = producto;

    }
}
