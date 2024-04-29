package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.models.ClienteModel;

import java.util.List;

public class ClienteBean {

    ClienteModel modelCliente = new ClienteModel();


    private List<ClienteEntity> Cliente;

    private ClienteEntity cliente;

    public ClienteModel getModelCliente() {
        return modelCliente;
    }

    public void setModelCliente(ClienteModel modelCliente) {
        this.modelCliente = modelCliente;
    }

    public List<ClienteEntity> getCliente() {
        return Cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setCliente(List<ClienteEntity> cliente) {
        Cliente = cliente;
    }

    public void agregarCliente() {

        modelCliente.insertarCliente(this.cliente);
    }

    public void editarCliente() {
        modelCliente.modificarCliente(this.cliente);
    }

    public void eliminarCliente(int idcliente) {

        modelCliente.eliminarCliente(idcliente);
        this.Cliente = modelCliente.listarClientes();
    }

    public void CargarCliente(ClienteEntity cliente){
        this.cliente = cliente;

    }


}
