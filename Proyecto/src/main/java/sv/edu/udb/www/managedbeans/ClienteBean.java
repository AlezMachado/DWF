package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import sv.edu.udb.www.entities.ClienteEntity;
import sv.edu.udb.www.models.ClienteModel;

import java.util.List;
@ManagedBean
@SessionScoped

public class ClienteBean {


    ClienteModel modelCliente = new ClienteModel();


    private List<ClienteEntity> ClienteEntity;

    private ClienteEntity cliente;

    public ClienteBean() {
        cliente = new ClienteEntity();
    }

    public ClienteModel getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ClienteModel modelCliente) {
        this.modelCliente = modelCliente;
    }

    public List<sv.edu.udb.www.entities.ClienteEntity> getClienteEntity() {
        return ClienteEntity;
    }

    public void setClienteEntity(List<sv.edu.udb.www.entities.ClienteEntity> clienteEntity) {
        ClienteEntity = clienteEntity;
    }

    public sv.edu.udb.www.entities.ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(sv.edu.udb.www.entities.ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void agregarCliente() {

        modelCliente.insertarCliente(this.cliente);
    }

    public void editarCliente() {
        modelCliente.modificarCliente(this.cliente);
    }

    public void eliminarCliente(int idcliente) {

        modelCliente.eliminarCliente(idcliente);
        this.ClienteEntity = modelCliente.listarClientes();
    }

    public void cargarClientes() {
        ClienteEntity = modelCliente.listarClientes();
    }


}
