package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Productos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "nombre_prod", nullable = false, length = 100)
    private String nombreProd;
    @Basic
    @Column(name = "descripcion_prod", nullable = false, length = 100)
    private String descripcionProd;
    @Basic
    @Column(name = "precio_venta", nullable = false, precision = 2)
    private BigDecimal precioVenta;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @OneToMany(mappedBy = "productosByIdProducto")
    private Collection<Consumo> consumosByIdProducto;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Productos productos = (Productos) o;

        if (idProducto != productos.idProducto) return false;
        if (cantidad != productos.cantidad) return false;
        if (nombreProd != null ? !nombreProd.equals(productos.nombreProd) : productos.nombreProd != null) return false;
        if (descripcionProd != null ? !descripcionProd.equals(productos.descripcionProd) : productos.descripcionProd != null)
            return false;
        if (precioVenta != null ? !precioVenta.equals(productos.precioVenta) : productos.precioVenta != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProducto;
        result = 31 * result + (nombreProd != null ? nombreProd.hashCode() : 0);
        result = 31 * result + (descripcionProd != null ? descripcionProd.hashCode() : 0);
        result = 31 * result + (precioVenta != null ? precioVenta.hashCode() : 0);
        result = 31 * result + cantidad;
        return result;
    }

    public Collection<Consumo> getConsumosByIdProducto() {
        return consumosByIdProducto;
    }

    public void setConsumosByIdProducto(Collection<Consumo> consumosByIdProducto) {
        this.consumosByIdProducto = consumosByIdProducto;
    }
}
