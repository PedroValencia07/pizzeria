package conexion;

import java.sql.*;
import javax.swing.*;

public class conexion {
    private final String db = "dbPizzaMozza";
    private final String url = "jdbc:mysql://localhost:3306/" +db +"?characterEncoding=latin1&useConfigs=maxPerformance";
    private final String user = "root";
    private final String password = "password";
    
    public conexion() {
        
    }
    
    public Connection conexion() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.password);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error public connection conexion"  +"\n" +e);
        }
        return link;
    }
}
