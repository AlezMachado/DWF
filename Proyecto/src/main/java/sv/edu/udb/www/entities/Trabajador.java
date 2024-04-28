package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Trabajador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_trabajador", nullable = false)
    private int idTrabajador;
    @Basic
    @Column(name = "nombre_trabajador", nullable = false, length = 75)
    private String nombreTrabajador;
    @Basic
    @Column(name = "apellido_trabajador", nullable = false, length = 75)
    private String apellidoTrabajador;
    @Basic
    @Column(name = "cargo", nullable = false, length = 15)
    private String cargo;
    @Basic
    @Column(name = "login", nullable = false, length = 20)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "estado", nullable = false, length = 15)
    private String estado;
    @OneToMany(mappedBy = "trabajadorByIdTrabajador")
    private Collection<Reserva> reservasByIdTrabajador;

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoTrabajador() {
        return apellidoTrabajador;
    }

    public void setApellidoTrabajador(String apellidoTrabajador) {
        this.apellidoTrabajador = apellidoTrabajador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trabajador that = (Trabajador) o;

        if (idTrabajador != that.idTrabajador) return false;
        if (nombreTrabajador != null ? !nombreTrabajador.equals(that.nombreTrabajador) : that.nombreTrabajador != null)
            return false;
        if (apellidoTrabajador != null ? !apellidoTrabajador.equals(that.apellidoTrabajador) : that.apellidoTrabajador != null)
            return false;
        if (cargo != null ? !cargo.equals(that.cargo) : that.cargo != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrabajador;
        result = 31 * result + (nombreTrabajador != null ? nombreTrabajador.hashCode() : 0);
        result = 31 * result + (apellidoTrabajador != null ? apellidoTrabajador.hashCode() : 0);
        result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<Reserva> getReservasByIdTrabajador() {
        return reservasByIdTrabajador;
    }

    public void setReservasByIdTrabajador(Collection<Reserva> reservasByIdTrabajador) {
        this.reservasByIdTrabajador = reservasByIdTrabajador;
    }
}
