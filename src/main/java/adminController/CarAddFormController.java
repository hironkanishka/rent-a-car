package adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CarAddFormController {
    public AnchorPane rootCarAdd;
    public TextField txtCarId;
    public TextField txtYear;
    public TextField txtModel;
    public TextField txtBrand;
    public TextField txtPPday;
    public TextField txtVehicleNo;
    public TextField txtCategory;

    public void btnAddAction(ActionEvent actionEvent) {
    }

    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/car-manage-form.fxml"));
        this.rootCarAdd.getChildren().clear();
        this.rootCarAdd.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) {
    }
}
