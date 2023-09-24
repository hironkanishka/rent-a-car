package viewController.adminController.userController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRentFormController {
    public AnchorPane root;
    public ChoiceBox choiceBoxCar;
    public DatePicker fromDate;
    public DatePicker toDate;
    public ChoiceBox choiceBoxRefundable;
    public ChoiceBox choiceBoxAdvanced;
    public ChoiceBox choiceBoxCarType;
    public TextField phone;
      public TextField address;
    public TextField nic;
    public TextField txtName;
    public Label balanceLabel;
    public Label totalLabel;
    public ChoiceBox oldCustomerChoice;
    public ChoiceBox newCustomerChoice;

    public void btnRentNow(ActionEvent actionEvent) {
    }

    public void btnHome(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/userView/user-dashboard-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Home");
        stg.show();
    }

    public void btnReset(ActionEvent actionEvent) {
    }
}
