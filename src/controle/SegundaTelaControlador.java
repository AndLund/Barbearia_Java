package controle;

import javafx.event.ActionEvent;
import principal.Barbearia;

public class SegundaTelaControlador {
    public void cliqueAgendamento(ActionEvent event){
        Barbearia.trocarTela("age");
    }
    public void cliqueConsulta(ActionEvent event){
        Barbearia.trocarTela("con");
    }
    public void cliqueVoltar(ActionEvent event){
        Barbearia.trocarTela("princ");
    }
}
