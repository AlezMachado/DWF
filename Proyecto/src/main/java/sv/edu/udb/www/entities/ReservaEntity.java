package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "reserva", schema = "basereserva", catalog = "")
public class ReservaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idreserva", nullable = false)
    private int idreserva;
    @Basic
    @Column(name = "idhabitacion", nullable = false)
    private int idhabitacion;
    @Basic
    @Column(name = "idcliente", nullable = false)
    private int idcliente;
    @Basic
    @Column(name = "idtrabajador", nullable = false)
    private int idtrabajador;
    @Basic
    @Column(name = "tipo_reserva", nullable = false, length = 20)
    private String tipoReserva;
    @Basic
    @Column(name = "fecha_reserva", nullable = false)
    private Date fechaReserva;
    @Basic
    @Column(name = "fecha_ingresa", nullable = false)
    private Date fechaIngresa;
    @Basic
    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;
    @Basic
    @Column(name = "costo_alojamiento", nullable = false, precision = 2)
    private BigDecimal costoAlojamiento;
    @Basic
    @Column(name = "estado", nullable = false, length = 15)
    private String estado;
    @OneToMany(mappedBy = "reservaByIdreserva")
    private Collection<ConsumoEntity> consumosByIdreserva;
    @OneToMany(mappedBy = "reservaByIdreserva")
    private Collection<PagoEntity> pagosByIdreserva;
    @ManyToOne
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion", nullable = false)
    private HabitacionEntity habitacionByIdhabitacion;
    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idpersona", nullable = false)
    private ClienteEntity clienteByIdcliente;
    @ManyToOne
    @JoinColumn(name = "idtrabajador", referencedColumnName = "idpersona", nullable = false)
    private TrabajadorEntity trabajadorByIdtrabajador;

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaIngresa() {
        return fechaIngresa;
    }

    public void setFechaIngresa(Date fechaIngresa) {
        this.fechaIngresa = fechaIngresa;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(BigDecimal costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
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

        ReservaEntity that = (ReservaEntity) o;

        if (idreserva != that.idreserva) return false;
        if (idhabitacion != that.idhabitacion) return false;
        if (idcliente != that.idcliente) return false;
        if (idtrabajador != that.idtrabajador) return false;
        if (tipoReserva != null ? !tipoReserva.equals(that.tipoReserva) : that.tipoReserva != null) return false;
        if (fechaReserva != null ? !fechaReserva.equals(that.fechaReserva) : that.fechaReserva != null) return false;
        if (fechaIngresa != null ? !fechaIngresa.equals(that.fechaIngresa) : that.fechaIngresa != null) return false;
        if (fechaSalida != null ? !fechaSalida.equals(that.fechaSalida) : that.fechaSalida != null) return false;
        if (costoAlojamiento != null ? !costoAlojamiento.equals(that.costoAlojamiento) : that.costoAlojamiento != null)
            return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idreserva;
        result = 31 * result + idhabitacion;
        result = 31 * result + idcliente;
        result = 31 * result + idtrabajador;
        result = 31 * result + (tipoReserva != null ? tipoReserva.hashCode() : 0);
        result = 31 * result + (fechaReserva != null ? fechaReserva.hashCode() : 0);
        result = 31 * result + (fechaIngresa != null ? fechaIngresa.hashCode() : 0);
        result = 31 * result + (fechaSalida != null ? fechaSalida.hashCode() : 0);
        result = 31 * result + (costoAlojamiento != null ? costoAlojamiento.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<ConsumoEntity> getConsumosByIdreserva() {
        return consumosByIdreserva;
    }

    public void setConsumosByIdreserva(Collection<ConsumoEntity> consumosByIdreserva) {
        this.consumosByIdreserva = consumosByIdreserva;
    }

    public Collection<PagoEntity> getPagosByIdreserva() {
        return pagosByIdreserva;
    }

    public void setPagosByIdreserva(Collection<PagoEntity> pagosByIdreserva) {
        this.pagosByIdreserva = pagosByIdreserva;
    }

    public HabitacionEntity getHabitacionByIdhabitacion() {
        return habitacionByIdhabitacion;
    }

    public void setHabitacionByIdhabitacion(HabitacionEntity habitacionByIdhabitacion) {
        this.habitacionByIdhabitacion = habitacionByIdhabitacion;
    }

    public ClienteEntity getClienteByIdcliente() {
        return clienteByIdcliente;
    }

    public void setClienteByIdcliente(ClienteEntity clienteByIdcliente) {
        this.clienteByIdcliente = clienteByIdcliente;
    }

    public TrabajadorEntity getTrabajadorByIdtrabajador() {
        return trabajadorByIdtrabajador;
    }

    public void setTrabajadorByIdtrabajador(TrabajadorEntity trabajadorByIdtrabajador) {
        this.trabajadorByIdtrabajador = trabajadorByIdtrabajador;
    }
}
