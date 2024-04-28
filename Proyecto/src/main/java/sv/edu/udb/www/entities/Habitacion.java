package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
public class Habitacion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_habitacion", nullable = false)
    private int idHabitacion;
    @Basic
    @Column(name = "numero_habitacion", nullable = false, length = 15)
    private String numeroHabitacion;
    @Basic
    @Column(name = "piso", nullable = false, length = 10)
    private String piso;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 80)
    private String descripcion;
    @Basic
    @Column(name = "precio_diario", nullable = false, length = 10)
    private String precioDiario;
    @Basic
    @Column(name = "estado", nullable = false, length = 10)
    private String estado;
    @Basic
    @Column(name = "tipo_habitacion", nullable = false, length = 15)
    private String tipoHabitacion;

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Habitacion that = (Habitacion) o;

        if (idHabitacion != that.idHabitacion) return false;
        if (numeroHabitacion != null ? !numeroHabitacion.equals(that.numeroHabitacion) : that.numeroHabitacion != null)
            return false;
        if (piso != null ? !piso.equals(that.piso) : that.piso != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (precioDiario != null ? !precioDiario.equals(that.precioDiario) : that.precioDiario != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (tipoHabitacion != null ? !tipoHabitacion.equals(that.tipoHabitacion) : that.tipoHabitacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHabitacion;
        result = 31 * result + (numeroHabitacion != null ? numeroHabitacion.hashCode() : 0);
        result = 31 * result + (piso != null ? piso.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (precioDiario != null ? precioDiario.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (tipoHabitacion != null ? tipoHabitacion.hashCode() : 0);
        return result;
    }
}
