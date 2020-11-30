package clientes;

import conexion.conexion;
import java.sql.*;
import javax.swing.*;

public class cliente {
    
    //ATRIBUTOS OBLIGATORIOS PARA PODER LLAMAR LOS METODOS CLIENTE
    private String numero;
    private String nombre;
    private String password;
    //ATRIBUTOS OBLIGATORIOS PARA PODER LLAMAR LOS METODOS CLIENTE
    
    //constructor del objeto cliente. Para que no se puedan usar sus metodos si los campos no son correctos
    public cliente(String numero, String nombre, String password) {
        this.numero = numero;
        this.nombre = nombre;
        this.password = password;
    }
    //constructor del objeto cliente. Para que no se puedan usar sus metodos si los campos no son correctos
    
    //IMPLEMENTACION DE ATRIBUTOS OBLIGATORIOS PARA EL USO ADECUADO DEL OBJETO CLIENTE
    public String direccion1;
    public String direccion2;
    public String direccion3;
    
    public String referencia1;
    public String referencia2;
    public String referencia3;
    //IMPLEMENTACION DE ATRIBUTOS OBLIGATORIOS PARA EL USO ADECUADO DEL OBJETO CLIENTE
    
    //CONSTRUCTOR DEL OBJETO CLIENTE CON TODOS LOS ATRIBUTOS EN CONJUNTO PARA EL FUNCIONAMIENTO ADECUADO DE LOS METODOS QUE CONLLEVAN OTROS OBJETOS
    
    public cliente(String numero, String nombre, String password, String direccion1, String direccion2, String direccion3, String referencia1, String referencia2, String referencia3) {
        this.numero = numero;
        this.nombre = nombre;
        this.password = password;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.direccion3 = direccion3;
        this.referencia1 = referencia1;
        this.referencia2 = referencia2;
        this.referencia3 = referencia3;
    }
    //CONSTRUCTOR DEL OBJETO CLIENTE CON TODOS LOS ATRIBUTOS EN CONJUNTO PARA EL FUNCIONAMIENTO ADECUADO DE LOS METODOS QUE CONLLEVAN OTROS OBJETOS
    
    //Metodo registro usuario para crear un nuevo usuario
    void register(String registrarNum, String registrarNom, String registrarContraseña, String registrarDir1, String registrarRef1) {
        
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        /*
            Insertar a la tabla "tblClientes" 
            *registrarNum
            *registrarNom
            *registrarApe
            *registrarContra
            *registrarDir1
            *registrarDir2
            *registrarDir3
            *registrarRef1
            *registrarRef2
            *registrarRef3
        */
        sSQL = "INSERT INTO tblClientes (dbNT, dbN, dbPass, dbDir1, dbDir2, dbDir3, dbRef1, dbRef2, dbRef3) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement pst = conn.prepareStatement(sSQL);
            
            //IDENTIFICADOR
            pst.setString(1, registrarNum);
            //IDENTIFICADOR
            
            //ATRIBUTOS DE IDENTIFICACION PERSONAL
            pst.setString(2, registrarNom);
            pst.setString(3, registrarContraseña);
            //ATRIBUTOS DE IDENTIFICACION PERSONAL
            
            //DIRECCIONES [3]
            
            //direccion 1 es obligatorio
            pst.setString(4, registrarDir1);
            //direccion 1 es obligatorio
            
            pst.setString(5, "");
            pst.setString(6, "");
            //DIRECCIONES [3]
            
            //REFERENCIAS [3]
            
            //referencia 1 es obligatorio
            pst.setString(7, registrarRef1);
            //referencia 1 es obligatorio
            
            pst.setString(8, "");
            pst.setString(9, "");
            //REFERENCIAS [3]
            
            int n = pst.executeUpdate();
            
            if ( n > 0 ) {
                JOptionPane.showMessageDialog(null, "CLIENTE METHOD REGISTER SAYS CORRECT");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CLIENTE METHOD REGISTER SAYS... " +"\n" +e);
        }
    }
    //Metodo registro usuario para crear un nuevo usuario
    
    //Metodo inicio sesión para poder ingresar a la aplicacion
    
    //Metodo inicio sesión para poder ingresar a la aplicacion
    
    public int login(String registrarNum, String loginNom, String loginContra) {
        int indicador = 0;
        String sSQL = "";
        
        conexion sql = new conexion();
        Connection conn = sql.conexion();
        
        sSQL = "SELECT dbNT, dbN, dbPass FROM tblClientes WHERE dbNT = " +registrarNum;
        
        String lnt, ln, lp;
        
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                
                lnt = rs.getString("dbNT");
                ln = rs.getString("dbN");
                lp = rs.getString("dbPass");
                
                String contra = "";
                
                char [] contraseña = lp.toCharArray();
                for ( int x = 0 ; x<contraseña.length; x++) {
                    contra+= contraseña[x];
                }
                
                if(registrarNum.equals(lnt) && loginNom.equals(ln) && loginContra.equals(lp)) {
                    JOptionPane.showMessageDialog(null, "CORRECTO");
                    indicador = 1;
                    
                } else {
                    JOptionPane.showMessageDialog(null, "INCORRECTO");
                    indicador = 0;
                }
            }
            
        } catch ( Exception e ) {
            JOptionPane.showMessageDialog(null, "CLIENTE METHOD LOGIN SAYS... " +"\n" +e);
        }
        return indicador;
    }
    
    //Metodo editar informacion personal para editar los atributos del objeto cliente y que se vean reflejados en la db
    void infoEdit(String numero) {
        
    }
    //Metodo editar informacion personal para editar los atributos del objeto cliente y que se vean reflejados en la db
    
    //Metodo borrar usuario para borrar los registros de un usuario
    void eraseProfile() {
        
    }
    //Metodo borrar usuario para borrar los registros de un usuario
}