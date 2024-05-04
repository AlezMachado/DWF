package sv.edu.udb.www.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @Column(name = "id_habitacion", nullable = false)
    private Integer id;

    @Column(name = "numero_habitacion", nullable = false, length = 15)
    private String numeroHabitacion;

    @Column(name = "piso", nullable = false, length = 10)
    private String piso;

    @Column(name = "descripcion", nullable = false, length = 80)
    private String descripcion;

    @Column(name = "precio_diario", nullable = false, length = 10)
    private String precioDiario;

    @Column(name = "estado", nullable = false, length = 10)
    private String estado;

    @Column(name = "tipo_habitacion", nullable = false, length = 15)
    private String tipoHabitacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(String precioDiario) {
        this.precioDiario = precioDiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

}