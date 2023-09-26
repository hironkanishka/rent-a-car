package viewController.adminController;

import dto.CarDto;
import dto.CategoryDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import service.CarService;
import service.CategoryService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CarAddFormController {
    public AnchorPane rootCarAdd;
    public TextField txtCarId;
    public TextField txtYear;
    public TextField txtModel;
    public TextField txtBrand;
    public TextField txtPPday;
    public TextField txtVehicleNo;

    public ChoiceBox choiceCategory;

    CarService cs= (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);
    public void btnAddAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

       boolean isSaved=  cs.saveCar(new CarDto(
                txtCarId.getText(),txtBrand.getText(),txtModel.getText() ,txtYear.getText(),
                txtVehicleNo.getText(),Double.valueOf(txtPPday.getText()) ,choiceCategory.getSelectionModel().getSelectedItem().toString()
        ));
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION,"New Car Created").show();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR,"New Car create Error").show();
            clear();
        }

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<String> catIdlist=getAllCategory();
        choiceCategory.setItems(catIdlist);


    }
    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/car-manage-form.fxml"));
        this.rootCarAdd.getChildren().clear();
        this.rootCarAdd.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       clear();
    }
    public void clear() throws SQLException, ClassNotFoundException {
          txtCarId.setText("");
        txtYear.setText("");
          txtModel.setText("");
        txtBrand.setText("");
       txtPPday.setText("");
        txtVehicleNo.setText("");
        choiceCategory.setItems(getAllCategory());

    }
    public ObservableList<String> getAllCategory() throws SQLException, ClassNotFoundException {
        CategoryService cs= (CategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);

        ObservableList<String> catIdlist=FXCollections.observableArrayList();
        ArrayList<CategoryDto> cdtos =cs.getAll();
        for (CategoryDto c: cdtos) {
            String catID =c.getCategoryId();

            catIdlist.add(catID);
        }
        return catIdlist;
    }

}
