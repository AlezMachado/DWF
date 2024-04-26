package sv.edu.udb.www.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "producto", schema = "basereserva", catalog = "")
@NamedQueries({
        @NamedQuery(name = "ProductoEntity.findAll", query = "SELECT e FROM ProductoEntity e "),
        @NamedQuery(name = "ProductoEntity.findById", query = "SELECT e FROM ProductoEntity e WHERE e.idproducto = :Idproducto")})

public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproducto", nullable = false)
    private int idproducto;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "unidad_medida", nullable = false, length = 20)
    private String unidadMedida;
    @Basic
    @Column(name = "precio_venta", nullable = false, precision = 2)
    private BigDecimal precioVenta;
    @OneToMany(mappedBy = "productoByIdproducto")
    private Collection<ConsumoEntity> consumosByIdproducto;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (idproducto != that.idproducto) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (unidadMedida != null ? !unidadMedida.equals(that.unidadMedida) : that.unidadMedida != null) return false;
        if (precioVenta != null ? !precioVenta.equals(that.precioVenta) : that.precioVenta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproducto;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (unidadMedida != null ? unidadMedida.hashCode() : 0);
        result = 31 * result + (precioVenta != null ? precioVenta.hashCode() : 0);
        return result;
    }

    public Collection<ConsumoEntity> getConsumosByIdproducto() {
        return consumosByIdproducto;
    }

    public void setConsumosByIdproducto(Collection<ConsumoEntity> consumosByIdproducto) {
        this.consumosByIdproducto = consumosByIdproducto;
    }
}
