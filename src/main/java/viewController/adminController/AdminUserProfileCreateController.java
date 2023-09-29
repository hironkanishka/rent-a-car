package viewController.adminController;

import dto.CarDto;
import dto.UserProfileDto;
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
import service.ServiceFactory;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminUserProfileCreateController {
    public AnchorPane rootNewUser;
    public TextField txtNic;
    public TextField txtName;
    public TextField txtUserName;
    public TextField txtPassword;

    public ChoiceBox choiceOldUser;

    public TextField txtUserID;
    UserService us =(UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);
    public void btnClearAction(ActionEvent actionEvent) {
        clear();
    }
    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/user-account-table.fxml"));
        this.rootNewUser.getChildren().clear();
        this.rootNewUser.getChildren().add(pane1);
    }
    private void clear() {
        txtName.setText(""); txtNic.setText("");txtPassword.setText("");txtUserName.setText("");
    }
    public void btnAddAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean isTrue=us.saveUser(new UserProfileDto(
                txtUserID.getText(), txtName.getText(),txtNic.getText(),txtUserName.getText(),txtPassword.getText()
        ));
        if (isTrue) {
            new Alert(Alert.AlertType.INFORMATION,"User Created").show();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR,"User create Error").show();

        }
    }


    public void btnUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isTrue=us.updateUser(new UserProfileDto(
            txtUserID.getText(),txtName.getText(),txtNic.getText(),txtUserName.getText(),txtPassword.getText()
        ));
        if (isTrue) {
            new Alert(Alert.AlertType.INFORMATION,"User Updated").show();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR,"Update Error").show();

        }
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        choiceOldUser.setItems(getDefault());
    }

    public void btnLoadData(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println(choiceOldUser.getSelectionModel().getSelectedItem().toString());
       UserProfileDto dto = us.getUser(choiceOldUser.getSelectionModel().getSelectedItem().toString());

       txtUserID.setText(choiceOldUser.getSelectionModel().getSelectedItem().toString());
       txtUserName.setText(dto.getUserName());
       txtPassword.setText(dto.getPassword());
       txtNic.setText(dto.getNic());
       txtName.setText(dto.getName());
    }
    public ObservableList<String> getAllUser() throws SQLException, ClassNotFoundException {

        ObservableList<String> userIdlist= FXCollections.observableArrayList();
        ArrayList<UserProfileDto> dtos =us.getAll();
        if(dtos.isEmpty()){ new Alert(Alert.AlertType.ERROR,"No Old Users.Please get New User ID").show(); }
        else{  for (UserProfileDto u: dtos) {
            String userID =u.getId();
            userIdlist.add(userID);
                     }
            return userIdlist;   }
        return null;
    }

    public void btnGetNow(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
getUserID();
    }

    public void getUserID() throws SQLException, ClassNotFoundException {
        ArrayList<UserProfileDto> udtos=  us.getAll();
        ArrayList<String> userIds =new ArrayList<>();
        if (udtos.isEmpty()) {
            txtUserID.setText("U01");

        }
        else{
            for (UserProfileDto u : udtos) {
                String userID= u.getId();
                userIds.add(userID);
            }

            String str = userIds.get(userIds.size()-1);

            String[] part = str.split("0",0);

            int newIDINt= getNextAvailableIdIntPart(Integer.parseInt(part[1]));
            //System.out.println(newIDINt);
            txtUserID.setText("U0"+newIDINt);
            //System.out.println(txtUserId.getText());

        }}
    public Integer getNextAvailableIdIntPart(int id){
        return ++id;
    }

    public void btnLoadOldUsers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        choiceOldUser.setItems(getAllUser());
    }
    public ObservableList<String> getDefault() throws SQLException, ClassNotFoundException {

        ObservableList<String> userIdlist= FXCollections.observableArrayList();
       userIdlist.add("Default");
            return userIdlist;

    }
}
