package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.models.TrabajadorModel;

import java.util.List;

public class TrabajadorBean {

    TrabajadorModel modelTrajador = new TrabajadorModel();

    private List<TrabajadorEntity> Trabajador;

    private TrabajadorEntity trabajador;

    public TrabajadorModel getModelTrajador() {
        return modelTrajador;
    }

    public void setModelTrajador(TrabajadorModel modelTrajador) {
        this.modelTrajador = modelTrajador;
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

    public void agregarTrabajador() {

        modelTrajador.insertarTrabajador(this.trabajador);
    }

    public void editarTrabajador() {
        modelTrajador.modificarTrabajador(this.trabajador);
    }

    public void eliminarTrabajador(int idtrabajador) {

        modelTrajador.eliminarTrabajador(idtrabajador);
        this.Trabajador = modelTrajador.listarTrabajador();
    }

    public void CargarTrabajador(TrabajadorEntity trabajador){
        this.trabajador = trabajador;

    }
}
