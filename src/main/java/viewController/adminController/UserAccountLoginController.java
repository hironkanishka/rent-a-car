package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserAccountLoginController {
    public AnchorPane rootLogin;
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void btnLoginAction(ActionEvent actionEvent) throws IOException {
        if (txtUsername.getText().equals("admin")&& txtPassword.getText().equals("123")) {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/user-account-table.fxml"));
        Scene scn =new Scene(pane1);
         Stage stg = (Stage) this.rootLogin.getScene().getWindow();
              stg.setScene(scn);
             stg.setTitle("admin login");
             stg.show();

        }else{
            new Alert(Alert.AlertType.ERROR,"Invalid Credintiols").show();
        }
    }

    public void btnHome(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
        Scene scn =new Scene(node);
        Stage stg = (Stage) this.rootLogin.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("HomePage");
        stg.show();
    }
}
