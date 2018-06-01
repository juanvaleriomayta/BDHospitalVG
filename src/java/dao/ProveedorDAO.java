package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;


public class ProveedorDAO extends DAO{
    public void registrar(Proveedor pro) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO PROVEEDOR (RAZPROV,RUCPROV,DIRPROV,TELFPROV,NUMUBI) values(?,?,?,?,?)");
            st.setString(1, pro.getRAZPROV());
            st.setString(2, pro.getRUCPROV());
            st.setString(3, pro.getDIRPROV());
            st.setString(4, pro.getTELFPROV());
            st.setString(5, pro.getNUMUBI());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }

    public List<Proveedor> listar() throws Exception{
        List<Proveedor> lista;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT NUMPROV, RAZPROV,RUCPROV,DIRPROV,TELFPROV,NUMUBI FROM PROVEEDOR");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Proveedor pro = new Proveedor();
                pro.setNUMPROV(rs.getInt("NUMPROV"));
                pro.setRAZPROV(rs.getString("RAZPROV"));
                pro.setRUCPROV(rs.getString("RUCPROV"));
                pro.setDIRPROV(rs.getString("DIRPROV"));
                pro.setTELFPROV(rs.getString("TELFPROV"));
                pro.setNUMUBI(rs.getString("NUMUBI"));               
                lista.add(pro);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return lista;
       } 
    
    public Proveedor leerID(Proveedor pro) throws Exception{
        Proveedor prov = null;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT NUMPROV, RAZPROV,RUCPROV,DIRPROV,TELFPROV,NUMUBI FROM PROVEEDOR WHERE NUMPROV=?");
            st.setInt(1, pro.getNUMPROV());
            rs = st.executeQuery();
            while(rs.next()){
                prov = new Proveedor();
                prov.setNUMPROV(rs.getInt("NUMPROV"));
                prov.setRAZPROV(rs.getString("RAZPROV"));
                prov.setRUCPROV(rs.getString("RUCPROV"));
                prov.setDIRPROV(rs.getString("DIRPROV"));
                prov.setTELFPROV(rs.getString("TELFPROV"));
                prov.setNUMUBI(rs.getString("NUMUBI"));
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return prov;
       } 
    
    public void modificar(Proveedor pro) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE PROVEEDOR SET RAZPROV=?,RUCPROV=?,DIRPROV=?,TELFPROV=?,NUMUBI=? WHERE NUMPROV = ?");
            st.setString(1, pro.getRAZPROV());
            st.setString(2, pro.getRUCPROV());
            st.setString(3, pro.getDIRPROV());
            st.setString(4, pro.getTELFPROV());
            st.setString(5, pro.getNUMUBI());
            st.setInt(6, pro.getNUMPROV());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
        
    public void eliminar(Proveedor pro) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM PROVEEDOR WHERE NUMPROV = ?");
            st.setInt(1, pro.getNUMPROV());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
}
