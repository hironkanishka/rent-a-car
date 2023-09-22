import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/login-form.fxml"));
        Scene scn1=new Scene(pane1);
        stage.setScene(scn1);
        stage.setTitle("Rent A Car - System Login");
        stage.show();

    }
}
