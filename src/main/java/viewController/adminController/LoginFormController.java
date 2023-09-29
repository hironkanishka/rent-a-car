package viewController.adminController;

import dto.UserProfileDto;
import jakarta.xml.bind.DatatypeConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.ServiceFactory;
import service.UserService;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginFormController {

    public TextField txtUsername;
    public PasswordField txtPassword;
    public AnchorPane rootLogin;

    public void linkRegisterAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/user-profile-create.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.rootLogin.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("admin Dashboard");
        stg.show();

    }

    public void btnLoginAction(ActionEvent actionEvent) throws IOException, SQLException, NoSuchAlgorithmException, ClassNotFoundException {
      boolean Istrue=checkCredentials(txtUsername.getText() ,txtPassword.getText());

      if(Istrue){

           Parent pane1 = FXMLLoader.load(getClass().getResource("/view/userView/user-dashboard-form.fxml"));
           Scene scn =new Scene(pane1);
           Stage stg = (Stage) this.rootLogin.getScene().getWindow();
           stg.setScene(scn);
           stg.setTitle("User Dashboard");
           stg.show();

        } else{new Alert(Alert.AlertType.ERROR,"invalid credentials").show(); }
    }

    public boolean checkCredentials(String u ,String p) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(p.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

        UserService us=(UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);
        ArrayList<UserProfileDto> udtos =us.getAll();

        for ( UserProfileDto d : udtos  ) {

            if (  d.getUserName().equals(u ) && d.getPassword().equals(myHash) ){

                return true;

            }

        }
        return false;
    }

    public boolean checkCredentialsAdmin(String u ,String p) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(p.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

            if(  u.equals("admin")  && myHash.equals("202cb962ac59075b964b07152d234b70")  ){
                return true;
            }else{
                new Alert(Alert.AlertType.ERROR,"invalid admin credentials").show();
                return false ;

            }

        }

    public void btnAdminLogin(ActionEvent actionEvent) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException, IOException {
        if (checkCredentialsAdmin(txtUsername.getText() ,txtPassword.getText())) {
            Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
            Scene scn =new Scene(pane1);
            Stage stg = (Stage) this.rootLogin.getScene().getWindow();
            stg.setScene(scn);
            stg.setTitle("admin Dashboard");
            stg.show();

        }
    }
}
