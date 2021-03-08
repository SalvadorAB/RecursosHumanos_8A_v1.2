package dep.rh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionSQL {
    
    Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/RecursosHumanos";
    
    public Connection conexion(String user, String pass){
        
        con = null;
        
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            if(con != null){
                JOptionPane.showMessageDialog(null, "Conexión establecida");
            }
            
        } catch (ClassNotFoundException |  SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexion: "+e.getMessage());
        }
        return con;
        
    }
    
    public boolean probarConexion(String user, String pass){
        con = null;
        boolean b = false;
        
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            if(con != null){
                b = true;
                JOptionPane.showMessageDialog(null, "Conexión establecida");
            }
            
        } catch (ClassNotFoundException |  SQLException e){
            b = false;
            JOptionPane.showMessageDialog(null, "Error de conexion: "+e.getMessage());
        }
        return b;
    }
            
}