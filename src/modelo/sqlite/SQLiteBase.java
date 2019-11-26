package modelo.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteBase {
    
    protected Connection conn;
    
    public Connection open(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:Agenda");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void close(){
        try {
            if(conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
