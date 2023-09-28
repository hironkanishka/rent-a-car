package viewController.adminController;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OverDueRentalsController {
    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colCarID;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colExtraFee;

    @FXML
    private TableColumn<?, ?> colNewTotalBalance;

    @FXML
    private TableColumn<?, ?> colOverdueDays;

    @FXML
    private TableColumn<?, ?> colRentID;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private AnchorPane rootRent;

    @FXML
    private TableView<?> tableOverdue;

    public void btnHome(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.rootRent.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Home");
        stg.show();
    }
}
