package modelo;

import control.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class usuario {
    
    private int ID;
    public int rol;
    private String nombre;
    private String numero;
    private String password;
    private String direccion1;
    private String direccion2;
    private String direccion3;
    private String referencia1;
    private String referencia2;
    private String referencia3;

    public usuario(String nombre,String numero,String password) {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "SELECT * FROM clientes WHERE telefono = " +numero;
        
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while ( rs.next() ) {
                
                this.ID = rs.getInt("idCliente");
                this.rol = rs.getInt("rol");
                this.nombre = rs.getString("nombre");
                this.numero = rs.getString("telefono");
                this.password = rs.getString("password");
                this.direccion1 = rs.getString("dir1");
                this.direccion2 = rs.getString("dir2");
                this.direccion3 = rs.getString("dir3");
                this.referencia1 = rs.getString("ref1");
                this.referencia2 = rs.getString("ref2");
                this.referencia3 = rs.getString("ref3");
                
            }
            
            if ( this.nombre.equals(nombre) && this.numero.equals(numero) && this.password.equals(password)) {
                
                conexion hc = new conexion();
                hc.inicioConexion(this.ID);
                
            } else {
                
                this.ID = 0;
                this.rol = 0;
                this.nombre = "";
                this.numero = "";
                this.password = "";
                this.direccion1 = "";
                this.direccion2 = "";
                this.direccion3 = "";
                this.referencia1 = "";
                this.referencia2 = "";
                this.referencia3 = "";
                
                JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS SON INCORRECTOS");
            }
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "USUARIO NO EXISTE");
        }
    }
    
    public int register(int rol,String nombre,String numero,String password,String dir1,String dir2,String dir3,String ref1,String ref2,String ref3) {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "INSERT INTO clientes (rol, nombre, telefono, password, dir1, dir2, dir3, ref1, ref2, ref3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement pst = conn.prepareStatement(sSQL);
            
            pst.setInt(1, rol);
            pst.setString(2, nombre);
            pst.setString(3, numero);
            pst.setString(4, password);
            pst.setString(5, dir1);
            pst.setString(6, dir2);
            pst.setString(7, dir3);
            pst.setString(8, ref1);
            pst.setString(9, ref2);
            pst.setString(10, ref3);
            
            int n = pst.executeUpdate();
            
            if ( n > 0 ) {
                return 1;
            }
            return 0;
        } catch ( Exception e ) {
            return 0;
        }
    }

    public int update(String nombre, String numero, String password, String dir1, String dir2, String dir3, String ref1, String ref2, String ref3) {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "UPDATE clientes SET WHERE idCliente = " +this.ID;
        
        try {
            
            PreparedStatement pst = conn.prepareStatement(sSQL);
            
            pst.setString(2, nombre);
            pst.setString(3, numero);
            pst.setString(4, password);
            pst.setString(5, dir1);
            pst.setString(6, dir2);
            pst.setString(7, dir3);
            pst.setString(8, ref1);
            pst.setString(9, ref2);
            pst.setString(10, ref3);
            
            int n = pst.executeUpdate();
            
            if ( n > 0 ) {
                return 1;
            } else {
                return 0;
            }
        } catch ( Exception e ) {
            return 0;
        }
    }
    
    public int erase() {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "DELETE * FROM clientes WHERE idCliente = " +this.ID;
        
        try {
            
            PreparedStatement pst = conn.prepareStatement(sSQL); 
               
                int m = pst.executeUpdate();
                 if (m > 0) {
                     return 1;
                 } else {
                     return 0;
                 }
                 
        } catch ( Exception e ) {
            return 0;
        }
    }
}