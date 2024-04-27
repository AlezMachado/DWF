package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.PagoEntity;
import sv.edu.udb.www.entities.ReservaEntity;
import sv.edu.udb.www.models.PagoModel;
import sv.edu.udb.www.models.ReservaModel;

import java.util.List;

public class PagoBean {
    PagoModel modelPago = new PagoModel();
    ReservaModel modelReserva = new ReservaModel();

    private List<PagoEntity> Pago;
    private List<ReservaEntity> Reserva;

    private PagoEntity pago;
    private ReservaEntity reserva;

    public PagoModel getModelPago() {
        return modelPago;
    }

    public void setModelPago(PagoModel modelPago) {
        this.modelPago = modelPago;
    }

    public ReservaModel getModelReserva() {
        return modelReserva;
    }

    public void setModelReserva(ReservaModel modelReserva) {
        this.modelReserva = modelReserva;
    }

    public List<PagoEntity> getPago() {
        return Pago;
    }

    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }

    public void setPago(List<PagoEntity> pago) {
        Pago = pago;
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

    public void agregarPago() {
        this.pago.setReservaByIdreserva(modelReserva.obtenerReserva(this.reserva.getIdreserva()));
        modelPago.insertarPago(this.pago);
    }

    public void editarPago() {
        this.pago.setReservaByIdreserva(modelReserva.obtenerReserva(this.reserva.getIdreserva()));
        modelPago.modificarPago(this.pago);
        this.pago = null;

    }

    public void eliminarPago(int idpago) {
        modelPago.eliminarPago(idpago);
        this.Pago = modelPago.listarPagos();

    }

    public void cargarPago( PagoEntity pago) {
        this.pago = pago;

    }
}
