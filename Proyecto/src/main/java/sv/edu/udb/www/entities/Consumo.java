package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Consumo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_consumo", nullable = false)
    private int idConsumo;
    @Basic
    @Column(name = "id_reserva", nullable = false)
    private int idReserva;
    @Basic
    @Column(name = "id_producto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "precio_venta", nullable = false, precision = 2)
    private BigDecimal precioVenta;
    @Basic
    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumo consumo = (Consumo) o;

        if (idConsumo != consumo.idConsumo) return false;
        if (idReserva != consumo.idReserva) return false;
        if (idProducto != consumo.idProducto) return false;
        if (cantidad != consumo.cantidad) return false;
        if (precioVenta != null ? !precioVenta.equals(consumo.precioVenta) : consumo.precioVenta != null) return false;
        if (estado != null ? !estado.equals(consumo.estado) : consumo.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idConsumo;
        result = 31 * result + idReserva;
        result = 31 * result + idProducto;
        result = 31 * result + cantidad;
        result = 31 * result + (precioVenta != null ? precioVenta.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
