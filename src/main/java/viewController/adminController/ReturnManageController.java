package viewController.adminController;

import dto.RentDto;
import dto.tm.OverDueRentalTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import service.RentService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ReturnManageController {
    public AnchorPane rootNewRent;
    public TextField txtRentId;
    public TextField txtCarID;
    public TextField txtCustomerID;

    public TextField newTotalPayment;

    public Label labelCurrenTotalPayment;
    public Label labelBalanceLeftToPay;
    public ChoiceBox isReturnedChoice;
    public Label labelOverDueDays;
    public ChoiceBox choiceRentID;
    RentService rs = (RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);


    public void initialize() throws Exception {
        choiceRentID.setItems(getRentID());
        isReturnedChoice.setItems(isreturned());
    }
    public ObservableList<String> getRentID() throws Exception {
        ArrayList<RentDto> rdtos =rs.getAllAvailable("no");
        ObservableList<String> rentIDlist = FXCollections.observableArrayList();
        for (RentDto r :rdtos ) {
            String id = r.getRentID();
            rentIDlist.add(id);
        } return rentIDlist;
    }
    public ObservableList<String> isreturned() throws Exception {

        ObservableList<String> rentIDlist = FXCollections.observableArrayList();
                    rentIDlist.add("yes");
        rentIDlist.add("no");
        return  rentIDlist;
            }
    public void btnClearAction(ActionEvent actionEvent) throws Exception {
        clear();
    }
    public void clear() throws Exception {
        choiceRentID.setItems(getRentID());
        isReturnedChoice.setValue(isreturned());
        labelCurrenTotalPayment.setText("");
        labelBalanceLeftToPay.setText("");
        newTotalPayment.setText("");
    }

    public void btnLoadData(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       String SelectedID= choiceRentID.getSelectionModel().getSelectedItem().toString();
       RentDto r = rs.getRent(SelectedID);
        System.out.println(r.toString());
        labelCurrenTotalPayment.setText(String.valueOf(r.getTotal()));

        LocalDate to = LocalDate.parse(r.getToDate());
        LocalDate today=LocalDate.now();
        int overdueDays=(int) ChronoUnit.DAYS.between(to, today);
        Double extraFee= overdueDays*200.00;
        Double newTotalBalance =(Double.valueOf(r.getBalance())-extraFee);
        labelBalanceLeftToPay.setText(String.valueOf(newTotalBalance));
        newTotalPayment.setText(String.valueOf(-newTotalBalance));
        labelOverDueDays.setText(String.valueOf(overdueDays));
    }
    public void btnAddAction(ActionEvent actionEvent) throws Exception {
        String SelectedID= choiceRentID.getSelectionModel().getSelectedItem().toString();
        RentDto r = rs.getRent(SelectedID);
        Double total = Double.valueOf(newTotalPayment.getText());
        String Isreturned =isReturnedChoice.getSelectionModel().getSelectedItem().toString();
        Double balance =0.0;
        if (Isreturned.equals("yes")) {
            boolean isUpdated= rs.updateRent(new RentDto(
                    SelectedID,
                    r.getFromDate(),
                    r.getToDate(),
                    Double.valueOf(r.getPerDayRent()),
                    Double.valueOf( r.getAdvancedPayment()),
               Double.valueOf( r.getRefundable()),
                    total,
                    balance ,
                    r.getCCustId(),
                    r.getCCarId(),
                    Isreturned )  );
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION,"Rent Updated .Successfully returned the car by Customer").show();
                clear();
            } else{
                new Alert(Alert.AlertType.ERROR," Update Error").show();
                clear();
            }


        }else {
            new Alert(Alert.AlertType.INFORMATION,"Not saved").show();
        }
    }
}
