package viewController.adminController;

import dto.CategoryDto;

import dto.tm.CategoryTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import service.CategoryService;
import service.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryManageFormController {
    public AnchorPane rootCategoryManage;
    public TextField txtCategoryNameFeild;
    public TextField txtCategoryIdFeild;

    /*public TableColumn colCategoryID;
    public TableColumn colCategoryName;*/

    @FXML
    private TableColumn<?, ?> colCategoryID;

    @FXML
    private TableColumn<?, ?> colCategoryName;


    @FXML
    private TableView<CategoryTm> tableCategory;
    CategoryService cs= (CategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);
    public Scene getScene(String url) throws IOException {
        return  new Scene(FXMLLoader.load(getClass().getResource(url)));  }


    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadTable();

    }



    private void setCellValueFactory() {
        colCategoryID.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

    }

    public void btnDeleteAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        boolean isDeleted= cs.deleteCategory(txtCategoryIdFeild.getText());
        if (isDeleted) {
            txtCategoryIdFeild.setText(""); txtCategoryNameFeild.setText("");
            new Alert(Alert.AlertType.INFORMATION,"Deleted Successfully").show();
            loadTable();

        } else{
            new Alert(Alert.AlertType.ERROR,"Category Delete Error").show();

        }
    }


    public void mouseClickedOnTable(MouseEvent mouseEvent) {
       String [] rawdata =  {tableCategory.getSelectionModel().getSelectedItem().getCategoryId() ,
        tableCategory.getSelectionModel().getSelectedItem().getCategoryName()};
         txtCategoryIdFeild.setText(rawdata[0]);
         txtCategoryNameFeild.setText(rawdata[1]);

    }

    public void btnUpdateAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CategoryDto cdto=new CategoryDto(txtCategoryIdFeild.getText() ,txtCategoryNameFeild.getText());
        boolean isUpdated= cs.updateCategory(cdto);
        if (isUpdated) {
            txtCategoryIdFeild.setText(""); txtCategoryNameFeild.setText("");
            new Alert(Alert.AlertType.INFORMATION,"Updated Successfully").show();
            loadTable();

        } else{
            new Alert(Alert.AlertType.ERROR,"Category update Error").show();

        }
    }

    public void btnAddAction(ActionEvent actionEvent) throws IOException {
        Parent pane1 = FXMLLoader.load(getClass().getResource("/view/adminView/category-add-form.fxml"));

        this.rootCategoryManage.getChildren().clear();
        this.rootCategoryManage.getChildren().add(pane1);

    }

   
public void loadTable() throws SQLException, ClassNotFoundException {
    ArrayList<CategoryDto> cdtos =cs.getAll();

       ObservableList<CategoryTm> list = FXCollections.observableArrayList();
    for (CategoryDto c: cdtos) {
       var tableModel= new CategoryTm(c.getCategoryId() ,c.getCategoryName());
       list.add(tableModel);
    }
    tableCategory.setItems(list);

    }

}





