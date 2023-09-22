package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CarManageController {
    public AnchorPane rootManageCars;
    public TableView tableCars;

    public void btnAddAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/car-add-form.fxml"));
        this.rootManageCars.getChildren().clear();
        this.rootManageCars.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) {
    }

    public void btnUpdateAction(ActionEvent actionEvent) {
    }

    public void mouseClickedCarTable(MouseEvent mouseEvent) {
    }
}
