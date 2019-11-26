package modelo;

import java.util.List;
import modelo.sqlite.ClienteSQLiteDAO;

public class Cliente {
    private int _id;
    
    private String nome;
    private String hora;
    private String dia;

    public Cliente(String nome, String hora, String dia) {
        this.nome = nome;
        this.hora = hora;
        this.dia = dia;
    }

    public Cliente(int _id, String nome, String hora, String dia) {
        this._id = _id;
        this.nome = nome;
        this.hora = hora;
        this.dia = dia;
    }

    public int getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    @Override
    public String toString(){
        return "Cliente("+_id+"\t"+nome+"\t"+hora+"\t"+dia+")";
    }
    
    //---------------------- DAO --------------------------------
    
    private static ClienteSQLiteDAO dao = new ClienteSQLiteDAO();
    
    //substitui o create e o update
    public void save(){
        if(dao.find(_id) != null) dao.update(this);
        else dao.create(this);
    }
    
//    public void update(){
//        dao.update(this);
//    }
    
    public void delete(){
        if(dao.find(_id) != null) dao.delete(this);
    }
    
    public static List<Cliente> all(){
        return dao.all();
    }
    
    public static Cliente find(int pk){
        return dao.find(pk);
    }
    
}
