package controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import principal.Barbearia;

public class TelaPrincipalControlador {
    @FXML
    private Label lblStatus;
            
    @FXML
    private TextField inputUsuario;
    
    @FXML
    private TextField inputSenha;
    
    public void login(ActionEvent event){
        if(inputUsuario.getText().equals("admin") && inputSenha.getText().equals("admin")){
            lblStatus.setText("Logado com sucesso");
            Barbearia.trocarTela("seg");
        }else{
            lblStatus.setText("Tente novamente");
        }
    }
}
