package bean;

import dao.ProveedorDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Proveedor;

public class ProveedorBean {
    
    
    private Proveedor proveedor = new Proveedor();
    private List<Proveedor> lstProveedor;
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
        proveedor = new Proveedor();
    }

    public void registrar() throws Exception {
        ProveedorDAO dao;

        try {
            dao = new ProveedorDAO();
            dao.registrar(proveedor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        ProveedorDAO dao;

        try {
            dao = new ProveedorDAO();
            lstProveedor = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Proveedor pro) throws Exception {
        ProveedorDAO dao;
        Proveedor temp;

        try {
            dao = new ProveedorDAO();
            temp = dao.leerID(pro);

            if (temp != null) {
                this.proveedor = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ProveedorDAO dao;

        try {
            dao = new ProveedorDAO();
            dao.modificar(proveedor);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Proveedor pro) throws Exception {
        ProveedorDAO dao;

        try {
            dao = new ProveedorDAO();
            dao.eliminar(pro);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /*getter and setter*/

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(List<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    
    
}
