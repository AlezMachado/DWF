package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente", schema = "basereserva", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpersona", nullable = false)
    private int idpersona;
    @Basic
    @Column(name = "codigo_cliente", nullable = false, length = 10)
    private String codigoCliente;

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
}
