package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.www.entities.ConsumoEntity;
import sv.edu.udb.www.entities.ProductoEntity;
import sv.edu.udb.www.entities.ReservaEntity;
import sv.edu.udb.www.models.ConsumoModel;
import sv.edu.udb.www.models.ProductoModel;
import sv.edu.udb.www.models.ReservaModel;

import java.util.List;
@ManagedBean
@SessionScoped

public class ConsumoBean {

    ConsumoModel modelConsumo = new ConsumoModel();
    ReservaModel modelReserva = new ReservaModel();
    ProductoModel modelProducto = new ProductoModel();

    private List<ConsumoEntity> Consumo;
    private List<ReservaEntity> Reserva;
    private List<ProductoModel> Producto;

    private ConsumoEntity consumo;
    private ReservaEntity reserva;
    private ProductoEntity producto;

    public ConsumoModel getModelConsumo() {
        return modelConsumo;
    }

    public void setModelConsumo(ConsumoModel modelConsumo) {
        this.modelConsumo = modelConsumo;
    }

    public ReservaModel getModelReserva() {
        return modelReserva;
    }

    public void setModelReserva(ReservaModel modelReserva) {
        this.modelReserva = modelReserva;
    }

    public ProductoModel getModelProducto() {
        return modelProducto;
    }

    public void setModelProducto(ProductoModel modelProducto) {
        this.modelProducto = modelProducto;
    }

    public List<ConsumoEntity> getConsumo() {
        return Consumo;
    }

    public void setConsumo(ConsumoEntity consumo) {
        this.consumo = consumo;
    }

    public void setConsumo(List<ConsumoEntity> consumo) {
        Consumo = consumo;
    }

    public List<ReservaEntity> getReserva() {
        return Reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public void setReserva(List<ReservaEntity> reserva) {
        Reserva = reserva;
    }

    public List<ProductoModel> getProducto() {
        return Producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public void setProducto(List<ProductoModel> producto) {
        Producto = producto;
    }


    public void agregarConsumo() {
        this.consumo.setIdReserva(modelReserva.obtenerReserva(this.reserva.getId()));
        this.consumo.setIdProducto(modelProducto.obtenerProducto(this.producto.getId()));
         modelConsumo.insertarconsumo(this.consumo);
    }

    public void editarConsumo() {
        this.consumo.setIdReserva(modelReserva.obtenerReserva(this.reserva.getId()));
        this.consumo.setIdProducto(modelProducto.obtenerProducto(this.producto.getId()));
        modelConsumo.modificarConsumo(this.consumo);
        this.consumo = null;

    }

    public void eliminarConsumo(int idconsumo) {
        modelConsumo.eliminarConsumo(idconsumo);
        this.Consumo = modelConsumo.listarconsumos();

    }

    public void cargarConsumo(ConsumoEntity consumo) {
        this.consumo = consumo;
    }
}
