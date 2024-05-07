package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pago")
@NamedQueries(
        {@NamedQuery(name="PagoEntity.findAll",query = "SELECT e FROM PagoEntity  e"),
                @NamedQuery(name = "PagoEntity.findById", query = "SELECT e FROM PagoEntity  e WHERE e.id = :idPago")})

public class PagoEntity {
    @Id
    @Column(name = "id_pago", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    private ReservaEntity idReservaEntity;

    @Column(name = "tipo_comprobante", nullable = false, length = 10)
    private String tipoComprobante;

    @Column(name = "num_comprobante", nullable = false, length = 15)
    private String numComprobante;

    @Column(name = "total_pago", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalPago;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

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

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

}