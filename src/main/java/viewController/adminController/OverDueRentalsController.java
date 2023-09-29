package viewController.adminController;


import dto.RentDto;
import dto.tm.OverDueRentalTm;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.RentService;
import service.ServiceFactory;

import java.io.IOException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

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
    private TableView<OverDueRentalTm> tableOverdue;
RentService rs = (RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);
    public void initialize() throws Exception {
        setCellValueFactory();
        loadTable();
    }

    private void loadTable() throws Exception {
        ArrayList<RentDto> rdtos =rs.getAllAvailable("no");
        ObservableList<OverDueRentalTm> list = FXCollections.observableArrayList();

        for (RentDto r: rdtos) {

            LocalDate to = LocalDate.parse(r.getToDate());
            LocalDate today=LocalDate.now();
            int overdueDays=(int) ChronoUnit.DAYS.between(to, today);
            Double extraFee= overdueDays*200.00;
            Double newTotalBalance =Double.valueOf(r.getBalance())-extraFee;

            var tableModel =new OverDueRentalTm(r.getRentID(),r.getCCustId(),r.getCCarId(),r.getTotal(),r.getBalance()
            ,overdueDays,extraFee,newTotalBalance
            );
            list.add(tableModel);
        }
        tableOverdue.setItems(list);
    }
    private void setCellValueFactory() {
        colRentID.setCellValueFactory(new PropertyValueFactory<>("rentID"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCarID.setCellValueFactory(new PropertyValueFactory<>("carId"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        colOverdueDays.setCellValueFactory(new PropertyValueFactory<>("overDueDays"));
        colExtraFee.setCellValueFactory(new PropertyValueFactory<>("extraFee"));
        colNewTotalBalance.setCellValueFactory(new PropertyValueFactory<>("NewTotalBalance"));
    }

    public void btnHome(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.rootRent.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Home");
        stg.show();
    }
}
