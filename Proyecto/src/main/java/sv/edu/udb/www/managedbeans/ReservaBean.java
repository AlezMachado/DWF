package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.entities.ReservaEntity;
import sv.edu.udb.www.entities.TrabajadorEntity;
import sv.edu.udb.www.models.ClienteModel;
import sv.edu.udb.www.models.HabitacionModel;
import sv.edu.udb.www.models.ReservaModel;
import sv.edu.udb.www.models.TrabajadorModel;

import java.util.List;

public class ReservaBean {

    ReservaModel modelReserva = new ReservaModel();
    HabitacionModel modelHabitacion = new HabitacionModel();
    ClienteModel modelCliente = new ClienteModel();
    TrabajadorModel modelTrabajador = new TrabajadorModel();
    private List<ReservaEntity> Reserva;
    private List<HabitacionEntity> Habitacion;
    private List<ClienteEntity> Cliente;
    private List<TrabajadorEntity> Trabajador;

    private ReservaEntity reserva;
    private HabitacionEntity habitacion;
    private ClienteEntity cliente;
    private TrabajadorEntity trabajador;

    public ReservaModel getModelReserva() {
        return modelReserva;
    }

    public void setModelReserva(ReservaModel modelReserva) {
        this.modelReserva = modelReserva;
    }

    public HabitacionModel getModelHabitacion() {
        return modelHabitacion;
    }

    public void setModelHabitacion(HabitacionModel modelHabitacion) {
        this.modelHabitacion = modelHabitacion;
    }

    public ClienteModel getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ClienteModel modelCliente) {
        this.modelCliente = modelCliente;
    }

    public TrabajadorModel getModelTrabajador() {
        return modelTrabajador;
    }

    public void setModelTrabajador(TrabajadorModel modelTrabajador) {
        this.modelTrabajador = modelTrabajador;
    }

    public List<ReservaEntity> getReserva() {
        return Reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public void setReserva(List<ReservaEntity> reserva) {
        Reserva = reserva;
    }

    public List<HabitacionEntity> getHabitacion() {
        return Habitacion;
    }

    public void setHabitacion(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }

    public void setHabitacion(List<HabitacionEntity> habitacion) {
        Habitacion = habitacion;
    }

    public List<ClienteEntity> getCliente() {
        return Cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setCliente(List<ClienteEntity> cliente) {
        Cliente = cliente;
    }

    public List<TrabajadorEntity> getTrabajador() {
        return Trabajador;
    }

    public void setTrabajador(TrabajadorEntity trabajador) {
        this.trabajador = trabajador;
    }

    public void setTrabajador(List<TrabajadorEntity> trabajador) {
        Trabajador = trabajador;
    }

    public void agregarReserva() {
        this.reserva.setHabitacionByIdhabitacion(modelHabitacion.obtenerhabitacion(this.habitacion.getIdhabitacion()));
        this.reserva.setClienteByIdcliente(modelCliente.obtenerCliente(this.cliente.getIdpersona()));
        this.reserva.setTrabajadorByIdtrabajador(modelTrabajador.obtenerTrabajador(this.trabajador.getIdpersona()));
        modelReserva.insertarReserva(this.reserva);

    }

    public void editarReserva() {
        this.reserva.setHabitacionByIdhabitacion(modelHabitacion.obtenerhabitacion(this.habitacion.getIdhabitacion()));
        this.reserva.setClienteByIdcliente(modelCliente.obtenerCliente(this.cliente.getIdpersona()));
        this.reserva.setTrabajadorByIdtrabajador(modelTrabajador.obtenerTrabajador(this.trabajador.getIdpersona()));
        modelReserva.modificarReserva(this.reserva);
        this.reserva = null;
    }

    public void eliminarReserva(int idreserva) {
        modelReserva.eliminarReserva(idreserva);
        this.Reserva = modelReserva.listarReserva();


    }

    public void cargarReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

}