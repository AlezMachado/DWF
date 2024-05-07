package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "consumo")
@NamedQueries(
        {@NamedQuery(name="ConsumoEntity.findAll",query = "SELECT e FROM ConsumoEntity  e"),
                @NamedQuery(name = "ConsumoEntity.findById", query = "SELECT e FROM ConsumoEntity  e WHERE e.id = :id_consumo")})

public class ConsumoEntity {
    @Id
    @Column(name = "id_consumo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    private ReservaEntity idReservaEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity idProductoEntity;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_venta", nullable = false, precision = 15, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReservaEntity getIdReserva() {
        return idReservaEntity;
    }

    public void setIdReserva(ReservaEntity idReservaEntity) {
        this.idReservaEntity = idReservaEntity;
    }

    public ProductoEntity getIdProducto() {
        return idProductoEntity;
    }

    public void setIdProducto(ProductoEntity idProductoEntity) {
        this.idProductoEntity = idProductoEntity;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
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

}