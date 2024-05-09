package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.entities.TrabajadorEntity;
import sv.edu.udb.www.models.HabitacionModel;
import sv.edu.udb.www.models.TrabajadorModel;

import java.util.List;
@ManagedBean
@SessionScoped
public class TrabajadorBean {

    private TrabajadorModel modelTrabajador = new TrabajadorModel();
    private List<TrabajadorEntity> trabajadores;
    private TrabajadorEntity trabajador = new TrabajadorEntity();

    public TrabajadorBean() {
        trabajador = new TrabajadorEntity();
    }

    public TrabajadorModel getModelTrabajador() {
        return modelTrabajador;
    }

    public void setModelTrabajador(TrabajadorModel modelTrabajador) {
        this.modelTrabajador = modelTrabajador;
    }

    public List<TrabajadorEntity> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<TrabajadorEntity> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public TrabajadorEntity getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorEntity trabajador) {
        this.trabajador = trabajador;
    }

    public void agregarTrabajador() {
        modelTrabajador.insertarTrabajador(trabajador);
    }

    public void editarTrabajador() {
        modelTrabajador.modificarTrabajador(trabajador);
    }

    public void eliminarTrabajador(int idTrabajador) {
        modelTrabajador.eliminarTrabajador(idTrabajador);
        trabajadores = modelTrabajador.listarTrabajador();
    }

    public void cargarTrabajadores() {
        trabajadores = modelTrabajador.listarTrabajador();
    }
}
