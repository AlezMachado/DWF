package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "cliente", schema = "basereserva", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT e FROM ClienteEntity e "),
        @NamedQuery(name = "ClienteEntity.findById", query = "SELECT e FROM ClienteEntity e WHERE e.idpersona = :idpersona")})

public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpersona", nullable = false)
    private int idpersona;
    @Basic
    @Column(name = "codigo_cliente", nullable = false, length = 10)
    private String codigoCliente;
    @OneToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona", nullable = false)
    private PersonaEntity personaByIdpersona;
    @OneToMany(mappedBy = "clienteByIdcliente")
    private Collection<ReservaEntity> reservasByIdpersona;

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (idpersona != that.idpersona) return false;
        if (codigoCliente != null ? !codigoCliente.equals(that.codigoCliente) : that.codigoCliente != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpersona;
        result = 31 * result + (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return result;
    }

    public PersonaEntity getPersonaByIdpersona() {
        return personaByIdpersona;
    }

    public void setPersonaByIdpersona(PersonaEntity personaByIdpersona) {
        this.personaByIdpersona = personaByIdpersona;
    }

    public Collection<ReservaEntity> getReservasByIdpersona() {
        return reservasByIdpersona;
    }

    public void setReservasByIdpersona(Collection<ReservaEntity> reservasByIdpersona) {
        this.reservasByIdpersona = reservasByIdpersona;
    }
}
