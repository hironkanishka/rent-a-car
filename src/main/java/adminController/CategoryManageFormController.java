package adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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

    public void btnAddAction(ActionEvent actionEvent) {
    }


}
