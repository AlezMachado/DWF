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

    private ClienteEntity clienteEntity;

    public ClienteModel getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ClienteModel modelCliente) {
        this.modelCliente = modelCliente;
    }

    public List<ClienteEntity> getCliente() {
        return ClienteEntity;
    }

    public void setCliente(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public void setCliente(List<ClienteEntity> clienteEntity) {
        ClienteEntity = clienteEntity;
    }

    public void agregarCliente() {

        modelCliente.insertarCliente(this.clienteEntity);
    }

    public void editarCliente() {
        modelCliente.modificarCliente(this.clienteEntity);
    }

    public void eliminarCliente(int idcliente) {

        modelCliente.eliminarCliente(idcliente);
        this.ClienteEntity = modelCliente.listarClientes();
    }

    public void CargarCliente(ClienteEntity cliente){
        this.clienteEntity = cliente;

    }


}
