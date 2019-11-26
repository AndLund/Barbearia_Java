package controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Cliente;
import principal.Barbearia;

public class AgendamentoControlador {
    
    private Cliente clienteAtual;
    
    @FXML
    private Label lblStat;
    
    @FXML
    private TextField inputNome;
            
    @FXML
    private TextField inputHora;
    
    @FXML
    private TextField inputData;
    
    //---------------------------------------
//    protected void initialize(){
//        Barbearia.addOnChangeScreenListener(new Barbearia.OnChangeScreen() {
//            @Override
//            public void onScreenChanged(String newScreen, Object userData) {
//                //System.out.println("ENTREI");
//                if(newScreen.equals("age")){
//                    //System.out.println("ENTREI");
//                    if(userData != null){
//                        //System.out.println("ENTREI");
//                        clienteAtual = (Cliente) userData;
//                        
//                        inputNome.setText(clienteAtual.getNome());
//                        inputHora.setText(clienteAtual.getHora());
//                        inputData.setText(clienteAtual.getDia());
//                    }else{
//                        clienteAtual = null;
//                        
//                        inputNome.setText("");
//                        inputHora.setText("");
//                        inputData.setText("");
//                    }
//                }
//            }
//        });
//    }
    //----------------------------------------
    
    
    public void confirmacao(ActionEvent event){
        if(inputNome.getText().isEmpty() || inputHora.getText().isEmpty() || inputData.getText().isEmpty()){
            lblStat.setText("Preencha todos os campos");
        }else{
            //Não está entrando no if
            if(clienteAtual != null){
                clienteAtual.setNome(inputNome.getText());
                clienteAtual.setHora(inputHora.getText());
                clienteAtual.setDia(inputData.getText());
                
                clienteAtual.save();
            }else{
                Cliente c = new Cliente(
                inputNome.getText(),
                inputHora.getText(),
                inputData.getText());
            
                c.save();
            }
            
            Barbearia.trocarTela("seg");
        }
    }
}