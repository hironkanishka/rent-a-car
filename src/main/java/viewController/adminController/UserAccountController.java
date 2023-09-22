package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserAccountController {
    public AnchorPane rootUser;
    public TableView userAccountTable;

    public void btnAddAction(ActionEvent actionEvent) {
    }

    public void btnHomeAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
        Scene scn =new Scene(node);
        Stage stg = (Stage) this.rootUser.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("HomePage");
        stg.show();
    }

    public void btnDeleteAction(ActionEvent actionEvent) {
    }

    public void btnUpdateAction(ActionEvent actionEvent) {
    }
}
