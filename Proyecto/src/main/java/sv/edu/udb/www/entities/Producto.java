package sv.edu.udb.www.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @Column(name = "nombre_prod", nullable = false, length = 100)
    private String nombreProd;

    @Column(name = "descripcion_prod", nullable = false, length = 100)
    private String descripcionProd;

    @Column(name = "precio_venta", nullable = false, precision = 15, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}