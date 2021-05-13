
package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Paginacion {
    
    Connection con;
    
    public Paginacion(Connection c){
        con = c;
    }
    
    public String count(String tabla){
        String sql = "select count(*) from "+tabla;
        String c = null;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            c = rs.getString("count(*)");
            
        } catch(Exception e){
        }
        return c;
    }
    
}
