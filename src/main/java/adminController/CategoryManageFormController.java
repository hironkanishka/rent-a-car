package adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryManageFormController {
    public AnchorPane rootCategoryManage;
     public TableView tableCategory;

    public Scene getScene(String url) throws IOException {
        return  new Scene(FXMLLoader.load(getClass().getResource(url)));  }
    public void btnDeleteAction(ActionEvent actionEvent) {

    }

    public void mouseClickedOnTable(MouseEvent mouseEvent) {

    }

    public void btnUpdateAction(ActionEvent actionEvent) {

    }

    public void btnAddAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/category-add-form.fxml"));

        this.rootCategoryManage.getChildren().clear();
        this.rootCategoryManage.getChildren().add(pane1);

    }


}
