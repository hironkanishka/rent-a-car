package viewController.adminController;


import dto.CategoryDto;
import dto.RentDto;
import dto.tm.CategoryTm;
import dto.tm.RentalTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.RentService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalsController {
    RentService rs =(RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);
    public AnchorPane rootRent;

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colCarID;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colIsReturned;

    @FXML
    private TableColumn<?, ?> colRentID;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableView<RentalTm> tableRent;

    public void mouseClickedRentTable(MouseEvent mouseEvent) {
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadTable();
    }

    private void loadTable() throws SQLException, ClassNotFoundException {
        ArrayList<RentDto> rdtos =rs.getAll();

        ObservableList<RentalTm> list = FXCollections.observableArrayList();
        for (RentDto r: rdtos) {
            var tableModel= new RentalTm(r.getRentID(),r.getCCustId(),r.getCCarId(),r.getTotal(),r.getBalance(),r.getIsReturned());
            list.add(tableModel);
        }
        tableRent.setItems(list);
    }
    private void setCellValueFactory() {
        colRentID.setCellValueFactory(new PropertyValueFactory<>("rentID"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customer_customerId"));
        colCarID.setCellValueFactory(new PropertyValueFactory<>("car_carId"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        colIsReturned.setCellValueFactory(new PropertyValueFactory<>("Is_returned"));


    }


    public void btnOverDueRentals(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/overDue-rentals.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.rootRent.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("OverDue Rentals");
        stg.show();

    }
}
