package viewController.adminController;


import dto.UserProfileDto;

import dto.tm.UserAccountTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import service.ServiceFactory;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserAccountController {


    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TableColumn<?, ?> colUserID;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private AnchorPane rootUser;

    @FXML
    private TableView<UserAccountTm> userAccountTable;

    UserService us =(UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);
    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadTable();
    }

    private void loadTable() throws SQLException, ClassNotFoundException {
        ArrayList<UserProfileDto> udtos =us.getAll();

        ObservableList<UserAccountTm> list = FXCollections.observableArrayList();
        for (UserProfileDto r: udtos) {
            var tableModel= new UserAccountTm(r.getId(),r.getName(),r.getNic(),r.getUserName(),r.getPassword());
            list.add(tableModel);
        }
        userAccountTable.setItems(list);
    }
    private void setCellValueFactory() {
        colUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

    }

    public void btnManage(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/user-profile-create-admin.fxml"));
        this.rootUser.getChildren().clear();
        this.rootUser.getChildren().add(pane1);
    }

    public void btnDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       String un= userAccountTable.getSelectionModel().getSelectedItem().getUserID();
      boolean isTrue = us.deleteUser(un);
        if (isTrue) {
            new Alert(Alert.AlertType.INFORMATION,"User Deleted").show();
            loadTable();
        } else{
            new Alert(Alert.AlertType.ERROR,"Delete Error").show();

        }
    }
}
