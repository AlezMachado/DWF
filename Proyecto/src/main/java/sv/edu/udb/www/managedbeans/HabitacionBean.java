package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.models.HabitacionModel;

import java.util.List;

public class HabitacionBean {

    HabitacionModel modelHabitacion = new HabitacionModel();

    private List<HabitacionEntity> Habitacion;
    private HabitacionEntity habitacion;


    public HabitacionModel getModelHabitacion() {
        return modelHabitacion;
    }

    public void setModelHabitacion(HabitacionModel modelHabitacion) {
        this.modelHabitacion = modelHabitacion;
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

    public void agregarHabitacion() {

        modelHabitacion.insertarhabitacion(this.habitacion);
    }

    public void editarHabitacion() {
        modelHabitacion.modificarHabitacion(this.habitacion);
    }

    public void eliminarHabitacion(int idhabitacion) {

        modelHabitacion.eliminarHabitacion(idhabitacion);
        this.Habitacion = modelHabitacion.listarhabitaciones();
    }

    public void cargarHabitacion(HabitacionEntity habitacion){
this.habitacion = habitacion;

    }
}
