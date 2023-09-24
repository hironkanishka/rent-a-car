package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageFormController {
    public AnchorPane root;
    public AnchorPane rootBranch;


    public void btnDashboardAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/dashboard-form.fxml"));
        Scene scn =new Scene(node);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("HomePage");
        stg.show();
    }

    public void btnManageCategories(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/category-manage-form.fxml"));
        this.rootBranch.getChildren().clear();
        this.rootBranch.getChildren().add(node);

    }

    public void btnManageCars(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/car-manage-form.fxml"));
        this.rootBranch.getChildren().clear();
        this.rootBranch.getChildren().add(node);
    }

    public void btnManageCustomers(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/customer-manage-form.fxml"));
        this.rootBranch.getChildren().clear();
        this.rootBranch.getChildren().add(node);
    }

    public void btnRentals(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/rentals.fxml"));
        this.rootBranch.getChildren().clear();
        this.rootBranch.getChildren().add(node);
    }

    public void btnLogoutAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/login-form.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Login");
        stg.show();
    }

    public void btnUserAccountManage(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/user-acount-login-control.fxml"));
        Scene scn =new Scene(pane1);
        Stage stg = (Stage) this.root.getScene().getWindow();
        stg.setScene(scn);
        stg.setTitle("Admin Login");
        stg.show();
    }

    public void btnReturnManage(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/return-manage.fxml"));
        this.rootBranch.getChildren().clear();
        this.rootBranch.getChildren().add(node);
    }
}
