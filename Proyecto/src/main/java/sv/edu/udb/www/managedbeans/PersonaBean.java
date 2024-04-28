package sv.edu.udb.www.managedbeans;

import sv.edu.udb.www.models.PersonaModel;

import java.util.List;

public class PersonaBean {
     PersonaModel modelPersona = new PersonaModel();

     private List<PersonaEntity> Persona;

     private PersonaEntity persona;

    public PersonaModel getModelPersona() {
        return modelPersona;
    }

    public void setModelPersona(PersonaModel modelPersona) {
        this.modelPersona = modelPersona;
    }

    public List<PersonaEntity> getPersona() {
        return Persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public void setPersona(List<PersonaEntity> persona) {
        Persona = persona;
    }

    public void agregarPersona() {

        modelPersona.insertarPersona(this.persona);
    }

    public void editarPersona() {
        modelPersona.modificarPersona(this.persona);
    }

    public void eliminarPersona(int idpersona) {

        modelPersona.eliminarPersona(idpersona);
        this.Persona = modelPersona.listarPersonas();
    }

    public void CargarPersona(PersonaEntity persona){
        this.persona = persona;

    }

}
