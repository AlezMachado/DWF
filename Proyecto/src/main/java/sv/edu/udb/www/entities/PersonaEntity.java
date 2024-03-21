package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "persona", schema = "basereserva", catalog = "")
public class PersonaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idpersona", nullable = false)
    private int idpersona;
    @Basic
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;
    @Basic
    @Column(name = "apaterno", nullable = false, length = 20)
    private String apaterno;
    @Basic
    @Column(name = "amaterno", nullable = false, length = 20)
    private String amaterno;
    @Basic
    @Column(name = "tipo_documento", nullable = false, length = 15)
    private String tipoDocumento;
    @Basic
    @Column(name = "num_documento", nullable = false, length = 8)
    private String numDocumento;
    @Basic
    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;
    @Basic
    @Column(name = "telefono", nullable = true, length = 8)
    private String telefono;
    @Basic
    @Column(name = "email", nullable = true, length = 25)
    private String email;
    @OneToOne(mappedBy = "personaByIdpersona")
    private ClienteEntity clienteByIdpersona;
    @OneToOne(mappedBy = "personaByIdpersona")
    private TrabajadorEntity trabajadorByIdpersona;

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
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

        PersonaEntity that = (PersonaEntity) o;

        if (idpersona != that.idpersona) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apaterno != null ? !apaterno.equals(that.apaterno) : that.apaterno != null) return false;
        if (amaterno != null ? !amaterno.equals(that.amaterno) : that.amaterno != null) return false;
        if (tipoDocumento != null ? !tipoDocumento.equals(that.tipoDocumento) : that.tipoDocumento != null)
            return false;
        if (numDocumento != null ? !numDocumento.equals(that.numDocumento) : that.numDocumento != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpersona;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apaterno != null ? apaterno.hashCode() : 0);
        result = 31 * result + (amaterno != null ? amaterno.hashCode() : 0);
        result = 31 * result + (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        result = 31 * result + (numDocumento != null ? numDocumento.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public ClienteEntity getClienteByIdpersona() {
        return clienteByIdpersona;
    }

    public void setClienteByIdpersona(ClienteEntity clienteByIdpersona) {
        this.clienteByIdpersona = clienteByIdpersona;
    }

    public TrabajadorEntity getTrabajadorByIdpersona() {
        return trabajadorByIdpersona;
    }

    public void setTrabajadorByIdpersona(TrabajadorEntity trabajadorByIdpersona) {
        this.trabajadorByIdpersona = trabajadorByIdpersona;
    }
}
