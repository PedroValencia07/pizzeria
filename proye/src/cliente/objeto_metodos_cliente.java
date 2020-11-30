package cliente;

import java.sql.*;
import javax.swing.*;

public class objeto_metodos_cliente {
    
    private int ID;
    private String nombre;
    private String nt;
    private String password;
    private String dir1;
    private String dir2;
    private String dir3;
    private String ref1;
    private String ref2;
    private String ref3;

    //OBJETO CLIENTE
    
    public objeto_metodos_cliente(int ID, String nombre, String nt, String password, String dir1, String dir2, String dir3, String ref1, String ref2, String ref3) {
        this.ID = ID;
        this.nombre = nombre;
        this.nt = nt;
        this.password = password;
        this.dir1 = dir1;
        this.dir2 = dir2;
        this.dir3 = dir3;
        this.ref1 = ref1;
        this.ref2 = ref2;
        this.ref3 = ref3;
    }
    
    //FIN CONSTRUCTOR OBJETO CLIENTE
    
    //METODOS CLIENTE
    
    //Registrar nuevo cliente
    void registroCliente(String nombre, String numeroTelefono, String password, String dir1, String ref1) {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "INSERT INTO clientes(nombre, numeroTelefono, password, direccion1, direccion2, direccion3, referencia1, referencia2, referencia3) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement pst = conn.prepareStatement(sSQL);
            
            pst.setString(1, nombre);
            pst.setString(2, numeroTelefono);
            pst.setString(3, password);
            pst.setString(4, dir1);
            pst.setString(5, "");
            pst.setString(6, "");
            pst.setString(7, ref1);
            pst.setString(8, "");
            pst.setString(9, "");
            
            int n = pst.executeUpdate();
            
            if ( n > 0 ) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error metodo registro cliente" +"\n" +e);
        }
        
    }
    //Fin registrar nuevo cliente
    
    //Autenticar sesión
    void authSes(int ID) {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "";
        
        try {
            
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "Error metodo authSes" +"\n" +e);
        }
        
    }
    //Fin autenticacion sesion
    
    //METODOS CLIENTE
}
