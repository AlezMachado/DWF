package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@NamedQueries(
        {@NamedQuery(name="ReservaEntity.findAll",query = "SELECT e FROM ReservaEntity  e"),
                @NamedQuery(name = "ReservaEntity.findById", query = "SELECT e FROM ReservaEntity  e WHERE e.id = :idReserva")})

public class ReservaEntity {
    @Id
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteEntity idClienteEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_trabajador", nullable = false)
    private TrabajadorEntity idTrabajadorEntity;

    @Column(name = "tipo_reserva", nullable = false, length = 15)
    private String tipoReserva;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "costo_alojamiento", nullable = false, length = 15)
    private String costoAlojamiento;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private HabitacionEntity idHabitacionEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getIdCliente() {
        return idClienteEntity;
    }

    public void setIdCliente(ClienteEntity idClienteEntity) {
        this.idClienteEntity = idClienteEntity;
    }

    public TrabajadorEntity getIdTrabajador() {
        return idTrabajadorEntity;
    }

    public void setIdTrabajador(TrabajadorEntity idTrabajadorEntity) {
        this.idTrabajadorEntity = idTrabajadorEntity;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
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

    public HabitacionEntity getIdHabitacion() {
        return idHabitacionEntity;
    }

    public void setIdHabitacion(HabitacionEntity idHabitacionEntity) {
        this.idHabitacionEntity = idHabitacionEntity;
    }

}