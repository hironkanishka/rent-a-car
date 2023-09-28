package viewController.adminController.userController;

import dto.CarDto;
import dto.CategoryDto;
import dto.CustomerDto;
import dto.RentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.*;

import java.io.IOException;
import java.sql.SQLException;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserRentFormController {
    public AnchorPane root;
    public ChoiceBox choiceBoxCar;
    public DatePicker fromDate;
    public DatePicker toDate;
        public ChoiceBox choiceBoxCarType;
    public TextField phone;
      public TextField address;
    public TextField nic;
    public TextField txtName;
    public Label balanceLabel;
    public Label totalLabel;
    public ChoiceBox oldCustomerChoice;

    public TextField txtRefundableDeposit;
    public TextField txtAdvancedPayment;
    public TextField txtNewCustId;
    public Label labelPerDayRent;
    public TextField txtNewRentID;
    CarService cs= (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);
    CustomerService customerService=(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    RentService rentService =(RentService)  ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);
    public void initialize() throws SQLException, ClassNotFoundException {
        ObservableList<String> catIdlist=getAllCategory();
        choiceBoxCarType.setItems(catIdlist);
        choiceBoxCar.setItems(getAllCar());
        oldCustomerChoice.setItems(getAllOldCustomers());

    }

    public ObservableList<String> getAllOldCustomers() throws SQLException, ClassNotFoundException {

        ObservableList<String> oldIdList= FXCollections.observableArrayList();
        ArrayList<CustomerDto> cdtos =customerService.getAll();

        for (CustomerDto c: cdtos) {
            String oldID =c.getCustId();
            oldIdList.add(oldID);
        }

        return oldIdList;
    }
    public void btnRentNow(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        LocalDate to = toDate.getValue();
        LocalDate from =fromDate.getValue();
        LocalDate toMax =LocalDate.now().plusDays(30);
        boolean isDateRange=false;
        //System.out.println(toMax.toString());
       if (from.isBefore(LocalDate.now()) ) {
           new Alert(Alert.AlertType.ERROR,"Wrong 'from Date'. From date should begin from today or after today date").show();
        }else   if ( toMax.isBefore(to)) {

           new Alert(Alert.AlertType.ERROR,"Wrong 'To date'.Vallid Rent period is 1 month").show();
        } else{
           isDateRange=true;

       }
        if (isDateRange) {
           String fromdate = fromDate.getValue().toString();
            String todate = toDate.getValue().toString();

           String carid =choiceBoxCar.getSelectionModel().getSelectedItem().toString();
/////////////////////////////////////////////
            boolean isOld =false;
            ObservableList<String> oldIdlist = getAllOldCustomers();
            Object [] ids = oldIdlist.toArray();
            System.out.println(Arrays.toString(ids));
            String idd= txtNewCustId.getText();
            for (int i = 0; i < ids.length; i++) {

                if (ids[i].equals(idd)) {
                    System.out.println("already");
                    isOld =true;
                }
            }
            String NewRentID=txtNewRentID.getText();
           if (!isOld){
                            boolean isCustomerSaved= customerService.saveCustomer(new CustomerDto(txtNewCustId.getText(),
                                    txtName.getText(),nic.getText(),address.getText(),phone.getText()
                            ));


                            boolean isRentSaved=  rentService.saveRent(new RentDto(NewRentID,
                                    fromdate,
                                    todate,
                                    Double.valueOf( labelPerDayRent.getText()),
                                    Double.valueOf( txtAdvancedPayment.getText()),
                                    Double.valueOf(  txtRefundableDeposit.getText()),
                                    Double.valueOf(   totalLabel.getText()),
                                    Double.valueOf(   balanceLabel.getText()),
                                    txtNewCustId.getText(),
                                    carid ,"no")

                            );



                            if (isRentSaved) {
                                new Alert(Alert.AlertType.INFORMATION,"New Rent Created").show();
                                clear();
                            } else{
                                new Alert(Alert.AlertType.ERROR,"New Rent create Error").show();
                                clear();
                            }

                        } else {

               boolean isRentSaved=  rentService.saveRent(new RentDto(NewRentID,
                       fromdate,
                       todate,
                       Double.valueOf( labelPerDayRent.getText()),
                       Double.valueOf( txtAdvancedPayment.getText()),
                       Double.valueOf(  txtRefundableDeposit.getText()),
                       Double.valueOf(   totalLabel.getText()),
                       Double.valueOf(   balanceLabel.getText()),
                       txtNewCustId.getText(),
                       carid,"no")

               );



               if (isRentSaved) {
                   new Alert(Alert.AlertType.INFORMATION,"New Rent Created").show();
                   clear();
               } else{
                   new Alert(Alert.AlertType.ERROR,"New Rent create Error").show();
                   clear();
               }
                        }

        }

    }

    public void btnHome(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/userView/user-dashboard-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Home");
        stg.show();
    }

    public void btnReset(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        clear();
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
    public ObservableList<String> getAllCar() throws SQLException, ClassNotFoundException {
        CarService cs= (CarService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CAR);
                ObservableList<String> carIdlist= FXCollections.observableArrayList();
        ArrayList<CarDto> cdtos =cs.getAll();
        for (CarDto c: cdtos) {
            String catID =c.getCarId();
            carIdlist.add(catID);
        }
        return carIdlist;
    }


    public ObservableList<String> getAllCarByCategory() throws Exception {

        String id =choiceBoxCarType.getSelectionModel().getSelectedItem().toString();

        ObservableList<String> carIdlist= FXCollections.observableArrayList();
        ArrayList<CarDto> cdtos =cs.getAllById(id);

        ObservableList<String> availableCarIdlist= FXCollections.observableArrayList();
        ArrayList<RentDto> rentDtos = rentService.getAllAvailable("yes");
        for (CarDto c: cdtos) {
            String carID =c.getCarId();
            //carIdlist.add(catID);
            for (RentDto r: rentDtos) {
                String availableCarID =r.getCCarId();
                if (carID.equals(availableCarID)) {
                    availableCarIdlist.add(availableCarID);
                }else{
                    new Alert(Alert.AlertType.ERROR,"All cars are rent in this Category").show();
}
 }        }
        choiceBoxCar.setItems(availableCarIdlist);
        return availableCarIdlist;
    }

    public String getPerDayRent() throws SQLException, ClassNotFoundException {
        String id =choiceBoxCar.getSelectionModel().getSelectedItem().toString();
        //ObservableList<String> carIdlist= FXCollections.observableArrayList();
         CarDto cdto =cs.getCar(id);
        String perDayRent =cdto.getPricePerDay().toString();
        return perDayRent;
        }

    public Integer getNextAvailableIdIntPart(int id){
                       return ++id;
    }

    public void btnGetNewCustId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      ArrayList<CustomerDto> cdtos=  customerService.getAll();
        ArrayList<String> custIds =new ArrayList<>();
        if (cdtos.isEmpty()) {
            txtNewCustId.setText("C01");

        }
        else{
            for (CustomerDto c : cdtos) {
                String custId= c.getCustId();
                custIds.add(custId);
            }
            //System.out.println("last"+ custIds.get(custIds.size()-1));
            String str = custIds.get(custIds.size()-1);
            //str="C02";
            String[] part = str.split("0",0);

            int newIDINt= getNextAvailableIdIntPart(Integer.parseInt(part[1]));
            System.out.println(newIDINt);
            txtNewCustId.setText("C0"+newIDINt);
            System.out.println(txtNewCustId.getText());
        }

    }
    private void clear() throws SQLException, ClassNotFoundException {
        txtNewRentID.setText("");
        txtNewCustId.setText("");
        phone.setText("");
        address.setText("");
        nic.setText("");
        txtName.setText("");
        balanceLabel.setText("Balance");
        totalLabel.setText("Total");
        txtRefundableDeposit.setText("");
        txtAdvancedPayment.setText("");
        choiceBoxCarType.setItems(getAllCategory());
        choiceBoxCar.setItems(getAllCar());
        oldCustomerChoice.setItems(getAllOldCustomers());
        toDate.setValue(null);
        fromDate.setValue(null);
        labelPerDayRent.setText("");
    }
    @FXML
    private void choiceCarTypeRequest(MouseEvent event) throws Exception {
        getAllCarByCategory();

    }

    public void choiceCarCategoryAgain(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        choiceBoxCarType.setItems(getAllCategory());
        choiceBoxCar.setItems(getAllCar());
    }
    public void btnLoadOldCustomerData(ActionEvent actionEvent) throws Exception {
        String oldId =oldCustomerChoice.getSelectionModel().getSelectedItem().toString();
        System.out.println(oldId);
        CustomerDto cdto =  customerService.getCustomer(oldId);


        ArrayList<RentDto> rentDtos = rentService.getAllAvailable("no");

        for (RentDto r: rentDtos) {
            String alreadyRentCutomerID =r.getCCustId();
            if (oldId.equals(alreadyRentCutomerID)) {
                new Alert(Alert.AlertType.ERROR,"You have already rented a Car.Please return it first.").show();
            }else{
                txtNewCustId.setText(oldId);
                txtName.setText(cdto.getName());
                nic.setText(cdto.getNic());
                address.setText(cdto.getAddress());
                phone.setText(cdto.getPhone());
            }

        }


    }

    public void btnGetPerDayRent(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        labelPerDayRent.setText(getPerDayRent());
    }

    public void toDateAction(MouseEvent mouseEvent) {
    }

    public void btnGetTotalBalance(ActionEvent actionEvent) {
        setTotalAndBalance();
    }

    private void setTotalAndBalance() {
        Period period = Period.between(fromDate.getValue(), toDate.getValue());
        int rentDays=period.getDays();
        Double rentTotal = rentDays* Double.valueOf(labelPerDayRent.getText());
        // System.out.println(rentTotal);
        totalLabel.setText(rentTotal.toString());
        Double rentBalance=rentTotal -( Double.valueOf(txtRefundableDeposit.getText()) + Double.valueOf(txtAdvancedPayment.getText() ) );
        // System.out.println(rentBalance);
        balanceLabel.setText("-"+rentBalance.toString());
    }

    public void btnGetNewRentID(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<RentDto> rdtos=  rentService.getAll();
        ArrayList<String> rentIds =new ArrayList<>();
        System.out.println(Arrays.toString(rdtos.toArray()));
        if (rdtos.isEmpty()) {
            txtNewRentID.setText("R01");
        }else{

            for (RentDto c : rdtos) {
                String rentId= c.getRentID();
                rentIds.add(rentId);
            }

            String str = rentIds.get(rentIds.size()-1);
           // System.out.println(str);
            String[] part = str.split("0",0);
            System.out.println(Arrays.toString(part));
            int newRentIDINt= getNextAvailableIdIntPart(Integer.parseInt(part[1]));
            System.out.println(newRentIDINt);
            txtNewRentID.setText("R0"+newRentIDINt);
            System.out.println("newRentID  "+txtNewRentID.getText());
        }

    }

}
