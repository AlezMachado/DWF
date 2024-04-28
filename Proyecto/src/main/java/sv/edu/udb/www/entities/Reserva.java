package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Reserva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reserva", nullable = false)
    private int idReserva;
    @Basic
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "id_trabajador", nullable = false)
    private int idTrabajador;
    @Basic
    @Column(name = "tipo_reserva", nullable = false, length = 15)
    private String tipoReserva;
    @Basic
    @Column(name = "fecha_reserva", nullable = false)
    private Date fechaReserva;
    @Basic
    @Column(name = "fecha_ingreso", nullable = false)
    private Date fechaIngreso;
    @Basic
    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;
    @Basic
    @Column(name = "costo_alojamiento", nullable = false, length = 15)
    private String costoAlojamiento;
    @Basic
    @Column(name = "estado", nullable = false, length = 15)
    private String estado;
    @Basic
    @Column(name = "id_habitacion", nullable = false)
    private int idHabitacion;
    @OneToMany(mappedBy = "reservaByIdReserva")
    private Collection<Consumo> consumosByIdReserva;
    @OneToMany(mappedBy = "reservaByIdReserva")
    private Collection<Pago> pagosByIdReserva;
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    private Cliente clienteByIdCliente;
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = false)
    private Habitacion habitacionByIdHabitacion;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(String costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserva reserva = (Reserva) o;

        if (idReserva != reserva.idReserva) return false;
        if (idCliente != reserva.idCliente) return false;
        if (idTrabajador != reserva.idTrabajador) return false;
        if (idHabitacion != reserva.idHabitacion) return false;
        if (tipoReserva != null ? !tipoReserva.equals(reserva.tipoReserva) : reserva.tipoReserva != null) return false;
        if (fechaReserva != null ? !fechaReserva.equals(reserva.fechaReserva) : reserva.fechaReserva != null)
            return false;
        if (fechaIngreso != null ? !fechaIngreso.equals(reserva.fechaIngreso) : reserva.fechaIngreso != null)
            return false;
        if (fechaSalida != null ? !fechaSalida.equals(reserva.fechaSalida) : reserva.fechaSalida != null) return false;
        if (costoAlojamiento != null ? !costoAlojamiento.equals(reserva.costoAlojamiento) : reserva.costoAlojamiento != null)
            return false;
        if (estado != null ? !estado.equals(reserva.estado) : reserva.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReserva;
        result = 31 * result + idCliente;
        result = 31 * result + idTrabajador;
        result = 31 * result + (tipoReserva != null ? tipoReserva.hashCode() : 0);
        result = 31 * result + (fechaReserva != null ? fechaReserva.hashCode() : 0);
        result = 31 * result + (fechaIngreso != null ? fechaIngreso.hashCode() : 0);
        result = 31 * result + (fechaSalida != null ? fechaSalida.hashCode() : 0);
        result = 31 * result + (costoAlojamiento != null ? costoAlojamiento.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + idHabitacion;
        return result;
    }

    public Collection<Consumo> getConsumosByIdReserva() {
        return consumosByIdReserva;
    }

    public void setConsumosByIdReserva(Collection<Consumo> consumosByIdReserva) {
        this.consumosByIdReserva = consumosByIdReserva;
    }

    public Collection<Pago> getPagosByIdReserva() {
        return pagosByIdReserva;
    }

    public void setPagosByIdReserva(Collection<Pago> pagosByIdReserva) {
        this.pagosByIdReserva = pagosByIdReserva;
    }

    public Cliente getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(Cliente clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    public Habitacion getHabitacionByIdHabitacion() {
        return habitacionByIdHabitacion;
    }

    public void setHabitacionByIdHabitacion(Habitacion habitacionByIdHabitacion) {
        this.habitacionByIdHabitacion = habitacionByIdHabitacion;
    }
}
