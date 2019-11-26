package principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.sqlite.ClienteSQLiteDAO;

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
        consultaScene = new Scene(fxmlConsulta,400,400);
        
        primeiroStage.setScene(principalScene);
        primeiroStage.show();
    }
    
    public static void trocarTela(String str, Object userData){
        switch(str){
            case "princ":
                stage.setScene(principalScene);
                notifyAllListeners("princ", userData);
                break;
            case "seg":
                stage.setScene(segundaScene);
                notifyAllListeners("seg", userData);
                break;
            case "age":
                stage.setScene(agendamentoScene);
                notifyAllListeners("age", userData);
                break;
            case "con":
                stage.setScene(consultaScene);
                notifyAllListeners("con", userData);
                break;
        }        
    }
    
    //sobrecarga do método anterior para evitar erro de quantidade de parametros enviados
    public static void trocarTela(String str){
        trocarTela(str,null);
    }
    //-------------- atualização dos dados da tabela --------------------------
    public static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    
    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData);
    }
    
    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }
    
    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l: listeners) l.onScreenChanged(newScreen, userData);
    }
    //--------------
    public static void main(String[] args) {
        launch(args);
    }
    
}
