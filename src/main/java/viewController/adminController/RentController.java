package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RentController {
    public AnchorPane rootRent;
    public TableView tableRent;

    public void btnAddAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/new-rent-form.fxml"));
        this.rootRent.getChildren().clear();
        this.rootRent.getChildren().add(node);
    }

    public void mouseClickedRentTable(MouseEvent mouseEvent) {
    }

    public void btnUpdateAction(ActionEvent actionEvent) {
    }
}
