package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pacientes;


public class PacientesDAO extends DAO {

    public void registrar(Pacientes pac) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO PACIENTE (NOMPAC,APEPAC,SEXPAC,DNIPAC,FNPAC,DIRPAC,UBIPAC) values(?,?,?,?,?,?,?)");
            st.setString(1, pac.getNOMPAC());
            st.setString(2, pac.getAPEPAC());
            st.setString(3, pac.getSEXPAC());
            st.setString(4, pac.getDNIPAC());
            st.setString(5, pac.getFNPAC());
            st.setString(6, pac.getDIRPAC());
            st.setString(7, pac.getUBIPAC());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }

    public List<Pacientes> listar() throws Exception{
        List<Pacientes> lista;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT NUMPAC, NOMPAC,APEPAC,SEXPAC,DNIPAC,FNPAC,DIRPAC,UBIPAC FROM PACIENTE");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Pacientes pac = new Pacientes();
                pac.setNUMPAC(rs.getInt("NUMPAC"));
                pac.setNOMPAC(rs.getString("NOMPAC"));
                pac.setAPEPAC(rs.getString("APEPAC"));
                pac.setSEXPAC(rs.getString("SEXPAC"));
                pac.setDNIPAC(rs.getString("DNIPAC"));
                pac.setFNPAC(rs.getString("FNPAC"));
                pac.setDIRPAC(rs.getString("DIRPAC"));
                pac.setUBIPAC(rs.getString("UBIPAC"));                
                lista.add(pac);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return lista;
       } 
    
    public Pacientes leerID(Pacientes pac) throws Exception{
        Pacientes paci = null;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT NUMPAC, NOMPAC,APEPAC,SEXPAC,DNIPAC,FNPAC,DIRPAC,UBIPAC FROM PACIENTE WHERE NUMPAC=?");
            st.setInt(1, pac.getNUMPAC());
            rs = st.executeQuery();
            while(rs.next()){
                paci = new Pacientes();
                paci.setNUMPAC(rs.getInt("NUMPAC"));
                paci.setNOMPAC(rs.getString("NOMPAC"));
                paci.setAPEPAC(rs.getString("APEPAC"));
                paci.setSEXPAC(rs.getString("SEXPAC"));
                paci.setDNIPAC(rs.getString("DNIPAC"));
                paci.setFNPAC(rs.getString("FNPAC"));
                paci.setDIRPAC(rs.getString("DIRPAC"));
                paci.setUBIPAC(rs.getString("UBIPAC"));
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return paci;
       } 
    
    public void modificar(Pacientes pac) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE PACIENTE SET NOMPAC=?,APEPAC=?,SEXPAC=?,DNIPAC=?,FNPAC=?,DIRPAC=?,UBIPAC =? WHERE NUMPAC = ?");
            st.setString(1, pac.getNOMPAC());
            st.setString(2, pac.getAPEPAC());
            st.setString(3, pac.getSEXPAC());
            st.setString(4, pac.getDNIPAC());
            st.setString(5, pac.getFNPAC());
            st.setString(6, pac.getDIRPAC());
            st.setString(7, pac.getUBIPAC());
            st.setInt(8, pac.getNUMPAC());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
        
    public void eliminar(Pacientes pac) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM PACIENTE WHERE NUMPAC = ?");
            st.setInt(1, pac.getNUMPAC());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
}
