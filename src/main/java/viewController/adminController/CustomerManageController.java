package viewController.adminController;

import dto.CategoryDto;
import dto.CustomerDto;
import dto.RentDto;
import dto.tm.CategoryTm;
import dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import service.CategoryService;
import service.CustomerService;
import service.RentService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerManageController {
    public AnchorPane rootManageCustomer;
    public TextField txtCustId;
    public TextField txtAddress;
    public TextField txtNic;
    public TextField txtCostName;
    public TextField txtPhone;
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCostId;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPhone;

        @FXML
    private TableView<CustomerTm> tableCustomers;
    RentService rs= (RentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RENT);
    CustomerService cs= (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadTable();

    }
    private void setCellValueFactory() {
       colCostId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

    }
    public void loadTable() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDto> cdtos =cs.getAll();

        ObservableList<CustomerTm> list = FXCollections.observableArrayList();
        for (CustomerDto c: cdtos) {
            var tableModel= new CustomerTm(c.getCustId(),c.getName(),c.getNic(),c.getAddress(),c.getPhone());
            list.add(tableModel);
        }
        tableCustomers.setItems(list);

    }
    public void btnAddAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
       boolean isSaved=cs.saveCustomer(new CustomerDto(
               txtCustId.getText(),txtCostName.getText(),txtNic.getText(),txtAddress.getText(),txtPhone.getText()
       ));
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION,"Saved").show();
            clear();
            loadTable();
        } else{
            new Alert(Alert.AlertType.ERROR,"Save Error").show();
            clear();
        }
    }

    public void btnClearAction(ActionEvent actionEvent) { clear();
    }

    private void clear() {
        txtCustId.setText("");txtCostName.setText("");txtNic.setText("");txtAddress.setText("");txtPhone.setText("");
    }

    public void mouseClickedCustomerTable(MouseEvent mouseEvent) {
        txtCustId.setText( tableCustomers.getSelectionModel().getSelectedItem().getCustomerId());
        txtCostName.setText(tableCustomers.getSelectionModel().getSelectedItem().getCustomerName() );
        txtNic.setText( tableCustomers.getSelectionModel().getSelectedItem().getNic());
        txtAddress.setText(tableCustomers.getSelectionModel().getSelectedItem().getAddress() );
        txtPhone.setText( tableCustomers.getSelectionModel().getSelectedItem().getPhone());
    }

public void btnUpdateAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

    System.out.println(txtCostName.getText() +" "+txtNic.getText() );
      boolean isUpdated=  cs.updateCustomer(new CustomerDto(
              txtCustId.getText(),txtCostName.getText(),txtNic.getText(),txtAddress.getText(),txtPhone.getText()
      ));
    if (isUpdated) {
        new Alert(Alert.AlertType.INFORMATION,"Updated").show();
                loadTable();
                clear();
    } else{
        new Alert(Alert.AlertType.ERROR,"Update Error").show();

    }
    }

public void btnDeleteAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ArrayList<RentDto> rdtos = rs.getAll();
        ArrayList<String> ids = new ArrayList<>();
        for (RentDto r : rdtos) {
            String id = r.getCCustId();
            ids.add(id);
        }
        String selectedID = tableCustomers.getSelectionModel().getSelectedItem().getCustomerId();
        //System.out.println(selectedID);
        Object[] cids = ids.toArray();
        for (int i = 0; i < cids.length; i++) {
            if (cids[i].equals(selectedID)) {
                new Alert(Alert.AlertType.ERROR, "Cannot delete Customer Because He has involved to a rental").show();
            } else {
                boolean isDeleted =cs.deleteCustomer(selectedID);
                if (isDeleted) {
                    new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
                    loadTable();clear();
                } else{
                    new Alert(Alert.AlertType.ERROR,"Delete Error").show();

                }


            }
        }
    }
  }

