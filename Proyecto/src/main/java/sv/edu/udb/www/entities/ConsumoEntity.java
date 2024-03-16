package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "consumo", schema = "basereserva", catalog = "")
public class ConsumoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idconsumo", nullable = false)
    private int idconsumo;
    @Basic
    @Column(name = "idreserva", nullable = false)
    private int idreserva;
    @Basic
    @Column(name = "idproducto", nullable = false)
    private int idproducto;
    @Basic
    @Column(name = "cantidad", nullable = false, precision = 2)
    private BigDecimal cantidad;
    @Basic
    @Column(name = "precio_venta", nullable = false, precision = 2)
    private BigDecimal precioVenta;
    @Basic
    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    public int getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(int idconsumo) {
        this.idconsumo = idconsumo;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
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

        ConsumoEntity that = (ConsumoEntity) o;

        if (idconsumo != that.idconsumo) return false;
        if (idreserva != that.idreserva) return false;
        if (idproducto != that.idproducto) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;
        if (precioVenta != null ? !precioVenta.equals(that.precioVenta) : that.precioVenta != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idconsumo;
        result = 31 * result + idreserva;
        result = 31 * result + idproducto;
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        result = 31 * result + (precioVenta != null ? precioVenta.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
