package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReturnManageController {
    public AnchorPane rootNewRent;
    public TextField txtRentId;
    public TextField txtCarID;
    public TextField txtCustomerID;

    public TextField newTotalPayment;

    public Label labelCurrenTotalPayment;
    public Label labelBalanceLeftToPay;
    public ChoiceBox isReturnedChoice;

    public void btnAddAction(ActionEvent actionEvent) throws IOException {

    }



    public void btnClearAction(ActionEvent actionEvent) {
    }
}
