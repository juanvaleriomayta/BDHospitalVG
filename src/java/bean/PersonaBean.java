package bean;


import dao.PersonaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;


public class PersonaBean {
    
    private Persona persona = new Persona();
    private List<Persona> lstPersona;
    private String accion;

    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                break;
            case "Modificar":
                this.modificar();
                break;
        }
    }

    public void limpiar() {
        persona = new Persona();
    }

    public void registrar() throws Exception {
        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            dao.registrar(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            lstPersona = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Persona per) throws Exception {
        PersonaDAO dao;
        Persona temp;

        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);

            if (temp != null) {
                this.persona = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            dao.modificar(persona);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Persona per) throws Exception {
        PersonaDAO dao;

        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    
    
    /*getter y setter*/

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    
    
}
