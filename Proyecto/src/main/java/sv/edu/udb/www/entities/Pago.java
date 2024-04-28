package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Pago {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "id_reserva", nullable = false)
    private int idReserva;
    @Basic
    @Column(name = "tipo_comprobante", nullable = false, length = 10)
    private String tipoComprobante;
    @Basic
    @Column(name = "num_comprobante", nullable = false, length = 15)
    private String numComprobante;
    @Basic
    @Column(name = "total_pago", nullable = false, precision = 2)
    private BigDecimal totalPago;
    @Basic
    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;
    @Basic
    @Column(name = "fecha_pago", nullable = false)
    private Date fechaPago;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pago pago = (Pago) o;

        if (idPago != pago.idPago) return false;
        if (idReserva != pago.idReserva) return false;
        if (tipoComprobante != null ? !tipoComprobante.equals(pago.tipoComprobante) : pago.tipoComprobante != null)
            return false;
        if (numComprobante != null ? !numComprobante.equals(pago.numComprobante) : pago.numComprobante != null)
            return false;
        if (totalPago != null ? !totalPago.equals(pago.totalPago) : pago.totalPago != null) return false;
        if (fechaEmision != null ? !fechaEmision.equals(pago.fechaEmision) : pago.fechaEmision != null) return false;
        if (fechaPago != null ? !fechaPago.equals(pago.fechaPago) : pago.fechaPago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPago;
        result = 31 * result + idReserva;
        result = 31 * result + (tipoComprobante != null ? tipoComprobante.hashCode() : 0);
        result = 31 * result + (numComprobante != null ? numComprobante.hashCode() : 0);
        result = 31 * result + (totalPago != null ? totalPago.hashCode() : 0);
        result = 31 * result + (fechaEmision != null ? fechaEmision.hashCode() : 0);
        result = 31 * result + (fechaPago != null ? fechaPago.hashCode() : 0);
        return result;
    }
}
