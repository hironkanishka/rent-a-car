package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewRentFormController {
    public AnchorPane rootNewRent;
    public TextField txtRentId;
    public TextField txtCarID;
    public TextField txtCustomerID;
    public TextField txtAdvance;
    public TextField txtTotal;
    public TextField txtRefundable;
    public DatePicker txtFromDate;
    public DatePicker txtToDate;

    public void btnAddAction(ActionEvent actionEvent) throws IOException {

    }

    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/rent-form.fxml"));
        this.rootNewRent.getChildren().clear();
        this.rootNewRent.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) {
    }
}
