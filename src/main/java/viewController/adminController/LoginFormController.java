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

public class LoginFormController {

    public TextField txtUsername;
    public PasswordField txtPassword;
    public AnchorPane rootLogin;

    public void linkRegisterAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/user-profile-create.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.rootLogin.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("admin Dashboard");
        stg.show();

    }

    public void btnLoginAction(ActionEvent actionEvent) throws IOException {
////temp for testing


       if (txtUsername.getText().equals("admin")&& txtPassword.getText().equals("123")) {
           Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
           Scene scn =new Scene(pane1);
           Stage stg = (Stage) this.rootLogin.getScene().getWindow();
           stg.setScene(scn);
           stg.setTitle("admin Dashboard");
           stg.show();

        }else{
           ////temp for testing
           Parent pane1 = FXMLLoader.load(getClass().getResource("/view/userView/user-dashboard-form.fxml"));
           Scene scn =new Scene(pane1);
           Stage stg = (Stage) this.rootLogin.getScene().getWindow();
           stg.setScene(scn);
           stg.setTitle("admin Dashboard");
           stg.show();

        }

    }
}
