package viewController.adminController;

import dto.CategoryDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.CategoryService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;

public class CategoryAddFormController {
    public AnchorPane rootAddCategory;
    public TextField txtCategoryId;
    public TextField txtCategoryName;

    public void btnAddAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
   CategoryService service= (CategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);
       boolean isSaved= service.saveCategory(new CategoryDto(txtCategoryId.getText(),txtCategoryName.getText()));
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION,"New Category Created").show();
            clear();
        } else{
            new Alert(Alert.AlertType.ERROR,"New Category create Error").show();
            clear();
        }
    }

    public void btnClearAction(ActionEvent actionEvent) {
        clear();
    }
    public void btnBackAction(ActionEvent actionEvent) throws IOException {
        Parent node=FXMLLoader.load(getClass().getResource("/view/adminView/category-manage-form.fxml"));
        this.rootAddCategory.getChildren().clear();
        this.rootAddCategory.getChildren().add(node);
    }
    public void clear(){
        txtCategoryId.setText("");
        txtCategoryName.setText("");

    }
}
