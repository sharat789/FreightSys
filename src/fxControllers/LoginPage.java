package fxControllers;

import hibernateControllers.GenericController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Driver;
import model.Manager;
import model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class LoginPage {
    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FreightSys");
    GenericController genericController = new GenericController(entityManagerFactory);

    public void validate() throws Exception {
//        Driver user = genericController.findDriverByCredentials(loginField.getText(), passwordField.getText());

            User user = genericController.findUserByCredentials(loginField.getText(), passwordField.getText());
            if(user != null) {
                FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/main-page.fxml"));
                Parent parent = fxmlLoader.load();
                MainPage mainPage = fxmlLoader.getController();
                mainPage.setInfo(user, entityManagerFactory);
                Scene scene = new Scene(parent);
                Stage stage = (Stage) loginField.getScene().getWindow();
                stage.setTitle("FreightSystem");
                stage.setScene(scene);
                stage.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Login Failed");
                alert.setContentText("The username or password is incorrect.");
                alert.showAndWait();
            }
    }

    public void register() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/registration-page.fxml"));
        Parent parent = fxmlLoader.load();
        RegistrationPage registrationPage = fxmlLoader.getController();
        registrationPage.setData(entityManagerFactory);
//        MainPage mainPage = fxmlLoader.getController();
//        mainPage.setInfo(user);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) loginField.getScene().getWindow();
        stage.setTitle("FreightSystem");
        stage.setScene(scene);
        stage.show();
    }
}
