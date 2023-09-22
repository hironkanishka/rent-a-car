package viewController.adminController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryAddFormController {
    public AnchorPane rootAddCategory;
    public TextField txtCategoryId;
    public TextField txtCategoryName;

    public void btnAddAction(ActionEvent actionEvent) {
    }

    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/category-manage-form.fxml"));
        this.rootAddCategory.getChildren().clear();
        this.rootAddCategory.getChildren().add(node);
    }

    public void btnClearAction(ActionEvent actionEvent) {
    }
}
