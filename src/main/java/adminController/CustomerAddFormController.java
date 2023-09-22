package adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CustomerAddFormController {
    public AnchorPane rootAddCustomer;
    public TextField txtCustId;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtCustName;
    public TextField txtPhone;

    public void btnAddAction(ActionEvent actionEvent) {
    }

    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/customer-manage-form.fxml"));
        this.rootAddCustomer.getChildren().clear();
        this.rootAddCustomer.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) {
    }
}
