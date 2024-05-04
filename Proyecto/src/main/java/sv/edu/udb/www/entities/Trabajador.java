package sv.edu.udb.www.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @Column(name = "id_trabajador", nullable = false)
    private Integer id;

    @Column(name = "nombre_trabajador", nullable = false, length = 75)
    private String nombreTrabajador;

    @Column(name = "apellido_trabajador", nullable = false, length = 75)
    private String apellidoTrabajador;

    @Column(name = "cargo", nullable = false, length = 15)
    private String cargo;

    @Column(name = "login", nullable = false, length = 20)
    private String login;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}