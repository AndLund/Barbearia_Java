package controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import principal.Barbearia;

public class AgendamentoControlador {
    
    @FXML
    private Label lblStat;
    
    @FXML
    private TextField inputNome;
            
    @FXML
    private TextField inputHora;
    
    @FXML
    private TextField inputData;
    
    public void confirmacao(ActionEvent event){
        if(inputNome.getText().isEmpty() || inputHora.getText().isEmpty() || inputData.getText().isEmpty()){
            lblStat.setText("Preencha todos os campos");
        }else{
            lblStat.setText("Cadastrado com sucesso");
            Barbearia.trocarTela("seg");
        }
    }
}
