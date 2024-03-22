package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "habitacion", schema = "basereserva", catalog = "")
public class HabitacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idhabitacion", nullable = false)
    private int idhabitacion;
    @Basic
    @Column(name = "numero", nullable = false, length = 4)
    private String numero;
    @Basic
    @Column(name = "piso", nullable = false, length = 2)
    private String piso;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "caracteristicas", nullable = true, length = 512)
    private String caracteristicas;
    @Basic
    @Column(name = "precio_diario", nullable = false, precision = 2)
    private BigDecimal precioDiario;
    @Basic
    @Column(name = "estado", nullable = false, length = 15)
    private String estado;
    @Basic
    @Column(name = "tipo_habitacion", nullable = false, length = 20)
    private String tipoHabitacion;
    @OneToMany(mappedBy = "habitacionByIdhabitacion")
    private Collection<ReservaEntity> reservasByIdhabitacion;

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public BigDecimal getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(BigDecimal precioDiario) {
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

        HabitacionEntity that = (HabitacionEntity) o;

        if (idhabitacion != that.idhabitacion) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (piso != null ? !piso.equals(that.piso) : that.piso != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (caracteristicas != null ? !caracteristicas.equals(that.caracteristicas) : that.caracteristicas != null)
            return false;
        if (precioDiario != null ? !precioDiario.equals(that.precioDiario) : that.precioDiario != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (tipoHabitacion != null ? !tipoHabitacion.equals(that.tipoHabitacion) : that.tipoHabitacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idhabitacion;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (piso != null ? piso.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (caracteristicas != null ? caracteristicas.hashCode() : 0);
        result = 31 * result + (precioDiario != null ? precioDiario.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (tipoHabitacion != null ? tipoHabitacion.hashCode() : 0);
        return result;
    }

    public Collection<ReservaEntity> getReservasByIdhabitacion() {
        return reservasByIdhabitacion;
    }

    public void setReservasByIdhabitacion(Collection<ReservaEntity> reservasByIdhabitacion) {
        this.reservasByIdhabitacion = reservasByIdhabitacion;
    }
}
