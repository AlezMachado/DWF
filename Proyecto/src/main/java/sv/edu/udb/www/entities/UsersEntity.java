package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "basereserva", catalog = "")
@NamedQueries({
        @NamedQuery(name = "UsersEntity.findAll", query = "SELECT e FROM UsersEntity e "),
        @NamedQuery(name = "UsersEntity.findById", query = "SELECT e FROM UsersEntity e WHERE e.idusers = :Idusers")})

public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idusers", nullable = false)
    private int idusers;
    @Basic
    @Column(name = "user", nullable = false, length = 45)
    private String user;
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "idpersona", nullable = false)
    private int idpersona;
    @ManyToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona", nullable = false)
    private PersonaEntity personaByIdpersona;

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idusers != that.idusers) return false;
        if (idpersona != that.idpersona) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idusers;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + idpersona;
        return result;
    }

    public PersonaEntity getPersonaByIdpersona() {
        return personaByIdpersona;
    }

    public void setPersonaByIdpersona(PersonaEntity personaByIdpersona) {
        this.personaByIdpersona = personaByIdpersona;
    }
}
