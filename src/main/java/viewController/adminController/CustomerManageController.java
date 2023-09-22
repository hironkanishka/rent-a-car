package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomerManageController {
    public AnchorPane rootManageCustomer;
    public TableView tableCars;

    public void btnAddAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/customer-add-form.fxml"));
        this.rootManageCustomer.getChildren().clear();
        this.rootManageCustomer.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) {
    }

    public void mouseClickedCustomerTable(MouseEvent mouseEvent) {
    }

    public void btnUpdateAction(ActionEvent actionEvent) {
    }
}
