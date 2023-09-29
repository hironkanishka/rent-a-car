package viewController.adminController;

import dto.CustomerDto;
import dto.UserProfileDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.SuperService;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProfileCreateController {
    public AnchorPane rootNewUser;

    public TextField txtName;
    public TextField txtNic;
    public TextField txtUserName;
    public TextField txtPassword;
    public TextField txtUserId;
        UserService service= (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public void btnAddAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        UserProfileDto userProfileDto =new UserProfileDto(
                txtUserId.getText(),
                txtName.getText(),
                txtNic.getText(),
                txtUserName.getText(),
                txtPassword.getText()
                );


        boolean isSaved= service.saveUser(userProfileDto);
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION,"User profile Created").show();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR,"User profile create Error").show();
            clear();
        }



    }

    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/login-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.rootNewUser.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Login");
        stg.show();
    }

    public void btnClearAction(ActionEvent actionEvent) {
        clear();
    }

    public void clear(){
        txtUserId.setText("");
        txtName.setText("");
        txtNic.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
    }

    public void btnGetNow(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
getUserID();
    }
    public void getUserID() throws SQLException, ClassNotFoundException {
        ArrayList<UserProfileDto> udtos=  service.getAll();
        ArrayList<String> userIds =new ArrayList<>();
        if (udtos.isEmpty()) {
            txtUserId.setText("U01");

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
            txtUserId.setText("U0"+newIDINt);
            //System.out.println(txtUserId.getText());

    }}
    public Integer getNextAvailableIdIntPart(int id){
        return ++id;
    }

}
