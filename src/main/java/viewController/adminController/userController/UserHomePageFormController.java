package viewController.adminController.userController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserHomePageFormController {
    public AnchorPane rootUserCarDashboardBranch;
    public AnchorPane root;

    public void btnRentCars(ActionEvent actionEvent) throws IOException {

        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/userView/user-rent-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Rent");
        stg.show();
    }

    public void btnLogoutAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/login-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Login");
        stg.show();
    }
}
