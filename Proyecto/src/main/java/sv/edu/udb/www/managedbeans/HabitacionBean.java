package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.entities.HabitacionEntity;
import sv.edu.udb.www.entities.TrabajadorEntity;
import sv.edu.udb.www.models.HabitacionModel;

import java.util.List;

@ManagedBean
@SessionScoped
public class HabitacionBean {

    private HabitacionModel modelHabitacion = new HabitacionModel();
    private List<HabitacionEntity> habitaciones;
    private HabitacionEntity habitacion = new HabitacionEntity();

    public HabitacionBean() {
        habitacion = new HabitacionEntity();
    }

    public List<HabitacionEntity> getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(List<HabitacionEntity> habitaciones) {
        this.habitaciones = habitaciones;
    }
    public HabitacionEntity getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(HabitacionEntity habitacion) {
        this.habitacion = habitacion;
    }


    public void agregarHabitacion() {
        modelHabitacion.insertarhabitacion(habitacion);
    }

    public void editarHabitacion() {
        modelHabitacion.modificarHabitacion(habitacion);
    }

    public void eliminarHabitacion(int idHabitacion) {
        modelHabitacion.eliminarHabitacion(idHabitacion);
        habitaciones = modelHabitacion.listarhabitaciones();
    }

    public void cargarHabitaciones() {
        habitaciones = modelHabitacion.listarhabitaciones();
    }
}

