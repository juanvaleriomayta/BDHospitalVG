package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;


public class PersonaDAO extends DAO{
    
    public void registrar(Persona per) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO persona (nombres,apellidos) values(?,?)");
            st.setString(1, per.getNombres());
            st.setString(2, per.getApellidos());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }

    public List<Persona> listar() throws Exception{
        List<Persona> lista;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT id,nombres,apellidos FROM persona");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                              
                lista.add(per);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return lista;
       } 
    
    public Persona leerID(Persona per) throws Exception{
        Persona pers = null;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id, nombres,apellidos FROM persona WHERE id=?");
            st.setInt(1, per.getId());
            rs = st.executeQuery();
            while(rs.next()){
                pers = new Persona();
                pers.setId(rs.getInt("id"));
                pers.setNombres(rs.getString("nombres"));
                pers.setApellidos(rs.getString("apellidos"));
                
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return pers;
       } 
    
    public void modificar(Persona per) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE persona SET nombres=?,apellidos=? WHERE id = ?");
            st.setString(1, per.getNombres());
            st.setString(2, per.getApellidos());
            st.setInt(3, per.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
        
    public void eliminar(Persona per) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM persona WHERE id = ?");
            st.setInt(1, per.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
    
}
