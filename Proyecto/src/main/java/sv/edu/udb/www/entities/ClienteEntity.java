package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
@NamedQueries(
        {@NamedQuery(name="ClienteEntity.findAll",query = "SELECT e FROM ClienteEntity  e"),
                @NamedQuery(name = "ClienteEntity.findById", query = "SELECT e FROM ClienteEntity  e WHERE e.id = :id_cliente")})

public class ClienteEntity {
    @Id
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @Column(name = "nombre_cliente", nullable = false, length = 75)
    private String nombreCliente;

    @Column(name = "apellido_cliente", nullable = false, length = 75)
    private String apellidoCliente;

    @Column(name = "tipo_documento", nullable = false, length = 20)
    private String tipoDocumento;

    @Column(name = "num_documento", nullable = false, length = 25)
    private String numDocumento;

    @Column(name = "direccion", nullable = false, length = 250)
    private String direccion;

    @Column(name = "pais", nullable = false, length = 25)
    private String pais;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "email", length = 30)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}