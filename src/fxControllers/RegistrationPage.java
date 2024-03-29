package fxControllers;

import hibernateControllers.GenericController;
import hibernateControllers.UserHib;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Driver;
import model.Manager;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RegistrationPage implements Initializable {
    public TextField loginField;
    public TextField nameField;
    public TextField surnameField;
    public DatePicker birthDateField;
    public RadioButton radioD;
    public RadioButton radioM;
    public CheckBox isAdminChk;
    public TextField phoneNoField;
    public TextField managerEmailField;
    public TextField medCertNumField;
    public TextField driverLicenseField;
    public DatePicker medCertDateField;
    public PasswordField pwField;
    public PasswordField confirmPwField;

    private EntityManagerFactory entityManagerFactory;
    private UserHib userHib;
    private GenericController genericController;

    public void setData(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
        this.userHib = new UserHib(entityManagerFactory);
        this.genericController = new GenericController(entityManagerFactory);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioD.setSelected(true);
        managerEmailField.setDisable(true);
        isAdminChk.setVisible(false);

    }

    public void createNewUser() {
        if(radioD.isSelected()){
            Driver driver = new Driver(loginField.getText(), pwField.getText(), nameField.getText(), surnameField.getText(), LocalDate.parse(birthDateField.getValue().toString()), phoneNoField.getText(), LocalDate.parse(medCertDateField.getValue().toString()), medCertNumField.getText(), driverLicenseField.getText());
//            userHib.createDriver(driver);
            genericController.create(driver);

        }
        else{
            Manager manager = new Manager(loginField.getText(), pwField.getText(), nameField.getText(), surnameField.getText(), LocalDate.parse(birthDateField.getValue().toString()), phoneNoField.getText(), managerEmailField.getText());
//            userHib.createManager(manager);
            genericController.create(manager);

        }
    }

    public void returnToPrevious() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("../view/login-page.fxml"));
        Parent parent = fxmlLoader.load();
//        MainPage mainPage = fxmlLoader.getController();
//        mainPage.setInfo(user);
        Scene scene = new Scene(parent);
        Stage stage = (Stage)loginField.getScene().getWindow();
        stage.setTitle("FreightSystem");
        stage.setScene(scene);
        stage.show();
    }

    public void disableFields() {
        if(radioD.isSelected()){
            managerEmailField.setDisable(true);
            medCertDateField.setDisable(false);
            medCertNumField.setDisable(false);
            driverLicenseField.setDisable(false);
        }
        else{
            managerEmailField.setDisable(false);
            medCertDateField.setDisable(true);
            medCertNumField.setDisable(true);
            driverLicenseField.setDisable(true);
        }

    }
}
