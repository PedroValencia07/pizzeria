
package cliente;

import javax.swing.*;
import java.sql.*;

public class conexion {
    
    public String db = "pizzamozarella";
    public String url = "jdbc:mysql://localhost:3306/" +db +"?characterEncoding=latin1&useConfigs=maxPerformance";
    public String user = "root";
    public String pass = "password";
    
    public conexion() {
        
    }
    
    public Connection conexion() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error public connection conexion"  +"\n" +e);
        }
        return link;
    }
}