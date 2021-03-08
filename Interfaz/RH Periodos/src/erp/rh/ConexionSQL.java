/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.rh;

import java.sql.*;

public class ConexionSQL {
    public Connection conexion(){
        String conexion = "jdbc:sqlserver://localhost:1433;" + "databaseName=RecursosHumanos;";
        Connection con = null;
        Statement stm = null;
        ResultSet resultado = null; 
        
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(conexion, "sa", "123");
            System.out.println("Conexion Exitosa");
        }
        catch(Exception e)
        {
            System.out.println("Error de Conexion");
        }  
        return con;
    }
}

