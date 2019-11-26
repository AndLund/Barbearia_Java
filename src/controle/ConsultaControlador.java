package controle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modelo.Cliente;
import principal.Barbearia;

public class ConsultaControlador {
    
    @FXML
    protected ListView<Cliente> lvClientes;
    
    //trabalha como um construtor
    @FXML
    protected void initialize(){
        Barbearia.addOnChangeScreenListener(new Barbearia.OnChangeScreen(){
            @Override
            public void onScreenChanged(String newScreen, Object userData){
                if(newScreen.equals("con")){
                    updateList();
                }
            }
        });
        
        updateList();
    }
    
    @FXML
    protected void apagar(ActionEvent event){
        ObservableList<Cliente> ol = lvClientes.getSelectionModel().getSelectedItems();
        
        if (!ol.isEmpty()){
            Cliente c = ol.get(0);
            c.delete();
            updateList();
        }
    }
    //--------------------
    @FXML
    protected void editar(ActionEvent event){
        ObservableList<Cliente> ol = lvClientes.getSelectionModel().getSelectedItems();
        
        if (!ol.isEmpty()){
            Cliente c = ol.get(0);
            Barbearia.trocarTela("age", c);
        }
    }
    //--------------------------
    private void updateList(){
        
        lvClientes.getItems().clear();
        for(Cliente c: Cliente.all()){
            lvClientes.getItems().add(c);
        }
    }
    
    public void voltarSegundaTela(ActionEvent event){
        Barbearia.trocarTela("seg");
    }
}
