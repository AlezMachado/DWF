package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "pago", schema = "basereserva", catalog = "")
public class PagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpago", nullable = false)
    private int idpago;
    @Basic
    @Column(name = "idreserva", nullable = false)
    private int idreserva;
    @Basic
    @Column(name = "tipo_comprobante", nullable = false, length = 20)
    private String tipoComprobante;
    @Basic
    @Column(name = "num_comprobante", nullable = false, length = 20)
    private String numComprobante;
    @Basic
    @Column(name = "igv", nullable = false, precision = 2)
    private BigDecimal igv;
    @Basic
    @Column(name = "total_pago", nullable = false, precision = 2)
    private BigDecimal totalPago;
    @Basic
    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;
    @Basic
    @Column(name = "fecha_pago", nullable = false)
    private Date fechaPago;
    @ManyToOne
    @JoinColumn(name = "idreserva", referencedColumnName = "idreserva", nullable = false)
    private ReservaEntity reservaByIdreserva;

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
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

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
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

        PagoEntity that = (PagoEntity) o;

        if (idpago != that.idpago) return false;
        if (idreserva != that.idreserva) return false;
        if (tipoComprobante != null ? !tipoComprobante.equals(that.tipoComprobante) : that.tipoComprobante != null)
            return false;
        if (numComprobante != null ? !numComprobante.equals(that.numComprobante) : that.numComprobante != null)
            return false;
        if (igv != null ? !igv.equals(that.igv) : that.igv != null) return false;
        if (totalPago != null ? !totalPago.equals(that.totalPago) : that.totalPago != null) return false;
        if (fechaEmision != null ? !fechaEmision.equals(that.fechaEmision) : that.fechaEmision != null) return false;
        if (fechaPago != null ? !fechaPago.equals(that.fechaPago) : that.fechaPago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpago;
        result = 31 * result + idreserva;
        result = 31 * result + (tipoComprobante != null ? tipoComprobante.hashCode() : 0);
        result = 31 * result + (numComprobante != null ? numComprobante.hashCode() : 0);
        result = 31 * result + (igv != null ? igv.hashCode() : 0);
        result = 31 * result + (totalPago != null ? totalPago.hashCode() : 0);
        result = 31 * result + (fechaEmision != null ? fechaEmision.hashCode() : 0);
        result = 31 * result + (fechaPago != null ? fechaPago.hashCode() : 0);
        return result;
    }

    public ReservaEntity getReservaByIdreserva() {
        return reservaByIdreserva;
    }

    public void setReservaByIdreserva(ReservaEntity reservaByIdreserva) {
        this.reservaByIdreserva = reservaByIdreserva;
    }
}
