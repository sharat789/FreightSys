package fxControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Manager;
import model.User;

import java.io.IOException;
import java.time.LocalDate;

public class LoginPage {
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;

    //temp
    User user = new Manager("admin", "admin", "admin", "admin", LocalDate.parse("2000-01-01"),"asdasd","asdasf");
    public void validate() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/main-page.fxml"));
        Parent parent = fxmlLoader.load();
        MainPage mainPage = fxmlLoader.getController();
        mainPage.setInfo(user);
        Scene scene = new Scene(parent);
        Stage stage = (Stage)loginField.getScene().getWindow();
        stage.setTitle("FreightSystem");
        stage.setScene(scene);
        stage.show();
    }

    public void register() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/registration-page.fxml"));
        Parent parent = fxmlLoader.load();
//        MainPage mainPage = fxmlLoader.getController();
//        mainPage.setInfo(user);
        Scene scene = new Scene(parent);
        Stage stage = (Stage)loginField.getScene().getWindow();
        stage.setTitle("FreightSystem");
        stage.setScene(scene);
        stage.show();
    }
}
