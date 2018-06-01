package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;


public class UsuarioDAO extends DAO{
    
    public void registrar(Usuario usu) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO USUARIO (NOMUSU,APEUSU,PWDUSU,DNIUSU,LEVUSU) values(?,?,?,?,?)");
            st.setString(1, usu.getNOMUSU());
            st.setString(2, usu.getAPEUSU());
            st.setString(3, usu.getPWDUSU());
            st.setString(4, usu.getDNIUSU());
            st.setString(5, usu.getLEVUSU());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }

    public List<Usuario> listar() throws Exception{
        List<Usuario> lista;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT NUMUSU, NOMUSU,APEUSU,PWDUSU,DNIUSU,LEVUSU FROM USUARIO");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setNUMUSU(rs.getInt("NUMUSU"));
                usu.setNOMUSU(rs.getString("NOMUSU"));
                usu.setAPEUSU(rs.getString("APEUSU"));
                usu.setPWDUSU(rs.getString("PWDUSU"));
                usu.setDNIUSU(rs.getString("DNIUSU"));
                usu.setLEVUSU(rs.getString("LEVUSU"));            
                lista.add(usu);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return lista;
       } 
    
    public Usuario leerID(Usuario usu) throws Exception{
        Usuario usua = null;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT NUMUSU, NOMUSU,APEUSU,PWDUSU,DNIUSU,LEVUSU FROM USUARIO WHERE NUMUSU=?");
            st.setInt(1, usu.getNUMUSU());
            rs = st.executeQuery();
            while(rs.next()){
                usua = new Usuario();
                usua.setNUMUSU(rs.getInt("NUMUSU"));
                usua.setNOMUSU(rs.getString("NOMUSU"));
                usua.setAPEUSU(rs.getString("APEUSU"));
                usua.setPWDUSU(rs.getString("PWDUSU"));
                usua.setDNIUSU(rs.getString("DNIUSU"));
                usua.setLEVUSU(rs.getString("LEVUSU"));
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return usua;
       } 
    
    public void modificar(Usuario usu) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE USUARIO SET NOMUSU,APEUSU,PWDUSU,DNIUSU,LEVUSU WHERE NUMUSU = ?");
            st.setString(1, usu.getNOMUSU());
            st.setString(2, usu.getAPEUSU());
            st.setString(3, usu.getPWDUSU());
            st.setString(4, usu.getDNIUSU());
            st.setString(5, usu.getLEVUSU());
            st.setInt(6, usu.getNUMUSU());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
        
    public void eliminar(Usuario usu) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM USUARIO WHERE NUMUSU = ?");
            st.setInt(1, usu.getNUMUSU());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
}
