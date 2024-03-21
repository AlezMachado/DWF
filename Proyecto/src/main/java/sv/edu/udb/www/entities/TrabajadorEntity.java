package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "trabajador", schema = "basereserva", catalog = "")
public class TrabajadorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpersona", nullable = false)
    private int idpersona;
    @Basic
    @Column(name = "sueldo", nullable = false, precision = 2)
    private BigDecimal sueldo;
    @Basic
    @Column(name = "acceso", nullable = false, length = 15)
    private String acceso;
    @Basic
    @Column(name = "login", nullable = false, length = 15)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
    @OneToMany(mappedBy = "trabajadorByIdtrabajador")
    private Collection<ReservaEntity> reservasByIdpersona;
    @OneToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona", nullable = false)
    private PersonaEntity personaByIdpersona;

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
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

        TrabajadorEntity that = (TrabajadorEntity) o;

        if (idpersona != that.idpersona) return false;
        if (sueldo != null ? !sueldo.equals(that.sueldo) : that.sueldo != null) return false;
        if (acceso != null ? !acceso.equals(that.acceso) : that.acceso != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpersona;
        result = 31 * result + (sueldo != null ? sueldo.hashCode() : 0);
        result = 31 * result + (acceso != null ? acceso.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<ReservaEntity> getReservasByIdpersona() {
        return reservasByIdpersona;
    }

    public void setReservasByIdpersona(Collection<ReservaEntity> reservasByIdpersona) {
        this.reservasByIdpersona = reservasByIdpersona;
    }

    public PersonaEntity getPersonaByIdpersona() {
        return personaByIdpersona;
    }

    public void setPersonaByIdpersona(PersonaEntity personaByIdpersona) {
        this.personaByIdpersona = personaByIdpersona;
    }
}
