package principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Barbearia extends Application {
    
    private static Stage stage;
    
    private static Scene principalScene;
    private static Scene segundaScene;
    private static Scene agendamentoScene;
    private static Scene consultaScene;
    
    @Override
    public void start(Stage primeiroStage) throws Exception {
        stage = primeiroStage;
        
        Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("/visao/telaPrincipal.fxml"));
        principalScene = new Scene(fxmlPrincipal,300,300);
        
        Parent fxmlSegunda = FXMLLoader.load(getClass().getResource("/visao/segundaTela.fxml"));
        segundaScene = new Scene(fxmlSegunda,300,300);
        
        Parent fxmlAgendamento = FXMLLoader.load(getClass().getResource("/visao/agendamento.fxml"));
        agendamentoScene = new Scene(fxmlAgendamento,300,300);
        
        Parent fxmlConsulta = FXMLLoader.load(getClass().getResource("/visao/consulta.fxml"));
        consultaScene = new Scene(fxmlConsulta,300,300);
        
        primeiroStage.setScene(principalScene);
        primeiroStage.show();
    }
    
    public static void trocarTela(String str){
        switch(str){
            case "princ":
                stage.setScene(principalScene);
                break;
            case "seg":
                stage.setScene(segundaScene);
                break;
            case "age":
                stage.setScene(agendamentoScene);
                break;
            case "con":
                stage.setScene(consultaScene);
                break;
        }        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
