package fxControllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Truck;
import model.TyreType;

public class MainPage {
    @FXML
    public TextField makeField;
    @FXML
    public TextField modelField;
    @FXML
    public TextField yearField;
    @FXML
    public TextField odometerField;
    @FXML
    public TextField fuelCapacityField;
    @FXML
    public ComboBox tyreTypeField;
    @FXML
    public ListView truckListField;

    public void createTruck() {
        Truck truck = new Truck(makeField.getText(), modelField.getText(),Integer.parseInt(yearField.getText()), Double.parseDouble(odometerField.getText()), Double.parseDouble(fuelCapacityField.getText()), TyreType.TYRE_1);
        truckListField.getItems().add(truck);
    }
}
