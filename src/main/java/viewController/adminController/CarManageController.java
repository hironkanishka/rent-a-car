package viewController.adminController;

import dto.CarDto;
import dto.CategoryDto;
import dto.tm.CarTm;
import dto.tm.CategoryTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.CarService;
import service.CategoryService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarManageController {
    public AnchorPane rootManageCars;

    @FXML
    private ChoiceBox<String> choiceCategory;

    @FXML
    private TableColumn<?, ?> colBrand;

    @FXML
    private TableColumn<?, ?> colCarId;

    @FXML
    private TableColumn<?, ?> colCcategoryId;

    @FXML
    private TableColumn<?, ?> colModel;

    @FXML
    private TableColumn<?, ?> colPPday;

    @FXML
    private TableColumn<?, ?> colVehicleNo;

    @FXML
    private TableColumn<?, ?> colYear;

    @FXML
    private TableView<CarTm> tableCars;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtCarId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPPday;

    @FXML
    private TextField txtVehicleNo;

    @FXML
    private TextField txtYear;
    public String currentID="";
            CarService carService= (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);
    public void btnAddAction(ActionEvent actionEvent) throws IOException {
        Parent node= FXMLLoader.load(getClass().getResource("/view/adminView/car-add-form.fxml"));
        this.rootManageCars.getChildren().clear();
        this.rootManageCars.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       clear();

    }

    public void btnUpdateAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean isUpdated=  carService.updateCar(new CarDto(
                txtCarId.getText(),txtBrand.getText(),txtModel.getText() ,txtYear.getText(),
                txtVehicleNo.getText(),Double.valueOf(txtPPday.getText()) ,choiceCategory.getSelectionModel().getSelectedItem().toString()
        ) , currentID);
        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION,"Car Updated").show();
            loadAll();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR," Car update Error").show();
            clear();
        }


    }

    public void mouseClickedCarTable(MouseEvent mouseEvent) {
    txtCarId.setText(tableCars.getSelectionModel().getSelectedItem().getCarId());
    txtBrand.setText(tableCars.getSelectionModel().getSelectedItem().getBrand());
    txtModel.setText(tableCars.getSelectionModel().getSelectedItem().getModel());
    txtYear.setText(tableCars.getSelectionModel().getSelectedItem().getYear());
    txtVehicleNo.setText(tableCars.getSelectionModel().getSelectedItem().getVehicleNo());
    txtPPday.setText(tableCars.getSelectionModel().getSelectedItem().getPricePerDay().toString());
    choiceCategory.setValue(tableCars.getSelectionModel().getSelectedItem().getCCategoryId());

    setCurrentId(tableCars.getSelectionModel().getSelectedItem().getCarId());
    }
    public void setCurrentId(String id){
        this.currentID=id;
    }
    public void btnDeleteAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted=  carService.deleteCar(txtCarId.getText());
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION,"Car Deleted").show();
            loadAll();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR," Car delete Error").show();
            clear();
        }

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<String> catIdlist =getAllCategory();
        choiceCategory.setItems(catIdlist);
        setCellValueFactory();
        loadAll();

    }
    public ObservableList<String> getAllCategory() throws SQLException, ClassNotFoundException {
        CategoryService cs= (CategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);

        ObservableList<String> catIdlist= FXCollections.observableArrayList();
        ArrayList<CategoryDto> cdtos =cs.getAll();
        for (CategoryDto c: cdtos) {
            String catID =c.getCategoryId();

            catIdlist.add(catID);
        }
        return catIdlist;
    }

    public void loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<CarDto> cdtoList= carService.getAll();
        ObservableList<CarTm> list = FXCollections.observableArrayList();
        for (CarDto c: cdtoList) {
            var tableModel= new CarTm(
                    c.getCarId(),c.getBrand(),c.getModel(),c.getYear(),c.getVehicleNo(),c.getPricePerDay(),c.getCCategoryId()

            );
            list.add(tableModel);
        }
        tableCars.setItems(list);

    }
    private void setCellValueFactory() {
        colCarId.setCellValueFactory(new PropertyValueFactory<>("carId"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colPPday.setCellValueFactory(new PropertyValueFactory<>("pricePerDay"));
        colCcategoryId.setCellValueFactory(new PropertyValueFactory<>("cCategoryId"));


    }
    public void clear() throws SQLException, ClassNotFoundException { txtCarId.setText("");
        txtModel.setText("");
        txtPPday.setText("");
        txtVehicleNo.setText("");
        txtYear.setText("");
        txtBrand.setText("");
        choiceCategory.setItems(getAllCategory());
    }
}
