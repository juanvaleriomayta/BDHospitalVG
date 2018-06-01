package bean;

import dao.PacientesDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Pacientes;

@ManagedBean
@SessionScoped
public class PacientesBean implements Serializable{

    private Pacientes pacientes = new Pacientes();
    private List<Pacientes> lstPacientes;
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
        pacientes = new Pacientes();
    }

    public void registrar() throws Exception {
        PacientesDAO dao;

        try {
            dao = new PacientesDAO();
            dao.registrar(pacientes);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        PacientesDAO dao;

        try {
            dao = new PacientesDAO();
            lstPacientes = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Pacientes pac) throws Exception {
        PacientesDAO dao;
        Pacientes temp;

        try {
            dao = new PacientesDAO();
            temp = dao.leerID(pac);

            if (temp != null) {
                this.pacientes = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        PacientesDAO dao;

        try {
            dao = new PacientesDAO();
            dao.modificar(pacientes);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Pacientes pac) throws Exception {
        PacientesDAO dao;

        try {
            dao = new PacientesDAO();
            dao.eliminar(pac);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    /*getter y setter*/
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public List<Pacientes> getLstPacientes() {
        return lstPacientes;
    }

    public void setLstPacientes(List<Pacientes> lstPacientes) {
        this.lstPacientes = lstPacientes;
    }
}
