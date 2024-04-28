package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "nombre_cliente", nullable = false, length = 75)
    private String nombreCliente;
    @Basic
    @Column(name = "apellido_cliente", nullable = false, length = 75)
    private String apellidoCliente;
    @Basic
    @Column(name = "tipo_documento", nullable = false, length = 20)
    private String tipoDocumento;
    @Basic
    @Column(name = "num_documento", nullable = false, length = 25)
    private String numDocumento;
    @Basic
    @Column(name = "direccion", nullable = false, length = 250)
    private String direccion;
    @Basic
    @Column(name = "pais", nullable = false, length = 25)
    private String pais;
    @Basic
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;
    @Basic
    @Column(name = "email", nullable = true, length = 30)
    private String email;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idCliente != cliente.idCliente) return false;
        if (nombreCliente != null ? !nombreCliente.equals(cliente.nombreCliente) : cliente.nombreCliente != null)
            return false;
        if (apellidoCliente != null ? !apellidoCliente.equals(cliente.apellidoCliente) : cliente.apellidoCliente != null)
            return false;
        if (tipoDocumento != null ? !tipoDocumento.equals(cliente.tipoDocumento) : cliente.tipoDocumento != null)
            return false;
        if (numDocumento != null ? !numDocumento.equals(cliente.numDocumento) : cliente.numDocumento != null)
            return false;
        if (direccion != null ? !direccion.equals(cliente.direccion) : cliente.direccion != null) return false;
        if (pais != null ? !pais.equals(cliente.pais) : cliente.pais != null) return false;
        if (telefono != null ? !telefono.equals(cliente.telefono) : cliente.telefono != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (nombreCliente != null ? nombreCliente.hashCode() : 0);
        result = 31 * result + (apellidoCliente != null ? apellidoCliente.hashCode() : 0);
        result = 31 * result + (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        result = 31 * result + (numDocumento != null ? numDocumento.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
