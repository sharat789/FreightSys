package fxControllers;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Truck;
import model.TyreType;
import model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainPage implements Initializable {
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
    public ComboBox<TyreType> tyreTypeField;

    @FXML
    public ListView<Truck> truckListField;
//    Observable<Truck> items = FXCollections.observableArrayList();

    private User loggedUser;


//    private List<Truck> truckList = new ArrayList<>();
@Override
public void initialize(URL location, ResourceBundle resources) {

}


    public void setInfo(User user){
        this.loggedUser = user;
    }
    public MainPage(){
        truckListField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Truck>() {
            @Override
            public void changed(ObservableValue<? extends Truck> observable, Truck oldValue, Truck newValue) {
                if(newValue != null){
                    makeField.setText(newValue.getMake());
                    modelField.setText(newValue.getModel());
                    yearField.setText(String.valueOf(newValue.getYear()));
                    odometerField.setText(String.valueOf(newValue.getOdometer()));
                    fuelCapacityField.setText(String.valueOf(newValue.getFuelTankCapacity()));


                }
            }
        });
    }

    public void createTruck() {
//        System.out.println(loggedUser);
        Truck truck = new Truck(makeField.getText(), modelField.getText(),Integer.parseInt(yearField.getText()), Double.parseDouble(odometerField.getText()), Double.parseDouble(fuelCapacityField.getText()),  TyreType.valueOf(String.valueOf(tyreTypeField.getSelectionModel().getSelectedItem())));
//        truckList.add(truck);
        truckListField.getItems().add(truck);
//        if(truckList!= null) {
//            for (Truck truck1 : truckList) {
//                truckListField.getItems().add(truck1);
//
//            }
//        }

    }

    public void updateTruck() {
//        System.out.println(truckList);

        Truck selectedTruck = truckListField.getSelectionModel().getSelectedItem();
        int index = truckListField.getSelectionModel().getSelectedIndex();
        selectedTruck.setMake(makeField.getText());
        selectedTruck.setModel(modelField.getText());
        selectedTruck.setYear(Integer.parseInt(yearField.getText()));
        selectedTruck.setOdometer(Double.parseDouble(odometerField.getText()));
        selectedTruck.setFuelTankCapacity(Double.parseDouble(fuelCapacityField.getText()));
        selectedTruck.setTyreType(TyreType.valueOf(String.valueOf(tyreTypeField.getSelectionModel().getSelectedItem())));
        System.out.println(index);
        truckListField.getItems().set(index,selectedTruck);
//        truckList.set(index, selectedTruck);
//        if(truckList!= null) {
//            for (Truck truck1 : truckList) {
//                truckListField.getItems().add(truck1);
//            }
//        }

    }

    public void deleteTruck() {
    }


}
