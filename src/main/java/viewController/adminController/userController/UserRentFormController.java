package viewController.adminController.userController;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UserRentFormController {
    public AnchorPane root;
    public ChoiceBox choiceBoxCar;
    public DatePicker fromDate;
    public DatePicker toDate;
    public ChoiceBox choiceBoxRefundable;
    public ChoiceBox choiceBoxAdvanced;
    public ChoiceBox choiceBoxCarType;
    public TextField phone;
    public TextField txtId;
    public TextField address;
    public TextField nic;
    public TextField txtName;
    public Label balanceLabel;
    public Label totalLabel;

    public void btnRentNow(ActionEvent actionEvent) {
    }

    public void btnHome(ActionEvent actionEvent) {
    }

    public void btnReset(ActionEvent actionEvent) {
    }
}
