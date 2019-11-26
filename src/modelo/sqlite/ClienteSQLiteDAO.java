package modelo.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

public class ClienteSQLiteDAO extends SQLiteBase{
    
    public ClienteSQLiteDAO(){
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Agenda ("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "nome TEXT,"+
                    "hora TEXT,"+
                    "dia TEXT);");
            stm.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ClienteSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
    }
    
    public void create(Cliente c){
        open();
        try {
            PreparedStatement stm = conn.prepareStatement("INSERT INTO Agenda VALUES(?,?,?,?);");
            
            stm.setString(2, c.getNome());
            stm.setString(3, c.getHora());
            stm.setString(4, c.getDia());
            
            stm.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(ClienteSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
    }
    
    public List<Cliente> all(){
        ArrayList<Cliente> result = new ArrayList<>();
        
        open();
        
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Agenda ORDER BY id ASC;");
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente(
                    rs.getInt(1), //id
                    rs.getString(2), //nome
                    rs.getString(3), //hora
                    rs.getString(4)); //dia
                
                result.add(c);
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ClienteSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return result;
    }
    
    public void update(Cliente c){
        conn = open();
        
        try {
            PreparedStatement stm = conn.prepareStatement("UPDATE Agenda SET "+
                    "nome = ?, "+
                    "hora = ?, "+
                    "dia = ? "+
                    "WHERE id = ?;");
            
            stm.setString(1, c.getNome());
            stm.setString(2, c.getHora());
            stm.setString(3, c.getDia());
            stm.setInt(4, c.getId());
            
            stm.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(ClienteSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
    }
    
    public void delete(Cliente c){
        conn = open();
        
        try {
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Agenda WHERE id = ?;");
            
            stm.setInt(1, c.getId());
            
            stm.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(ClienteSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
    }
    
    public Cliente find(int pk){ //primarykey
        Cliente result = null;
        
        conn = open();
        
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Agenda WHERE id = ?;");
            
            stm.setInt(1,pk);
            
            ResultSet rs = stm.executeQuery();
            
            if(rs.next()){
                Cliente c = new Cliente(
                    rs.getInt(1), //id
                    rs.getString(2), //nome
                    rs.getString(3), // hora
                    rs.getString(4)); //dia
                result = c;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ClienteSQLiteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }
        return result;
    }
}
