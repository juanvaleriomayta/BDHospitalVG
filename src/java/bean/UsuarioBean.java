package bean;

import dao.UsuarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Usuario;


public class UsuarioBean {
    private Usuario usuario = new Usuario();
    private List<Usuario> lstUsuario;
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
        usuario = new Usuario();
    }

    public void registrar() throws Exception {
        UsuarioDAO dao;

        try {
            dao = new UsuarioDAO();
            dao.registrar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        UsuarioDAO dao;

        try {
            dao = new UsuarioDAO();
            lstUsuario = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Usuario usu) throws Exception {
        UsuarioDAO dao;
        Usuario temp;

        try {
            dao = new UsuarioDAO();
            temp = dao.leerID(usu);

            if (temp != null) {
                this.usuario = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        UsuarioDAO dao;

        try {
            dao = new UsuarioDAO();
            dao.modificar(usuario);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Usuario usu) throws Exception {
        UsuarioDAO dao;

        try {
            dao = new UsuarioDAO();
            dao.eliminar(usu);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    /* getter and setter*/

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    
    
}
