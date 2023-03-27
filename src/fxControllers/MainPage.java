package fxControllers;

import hibernateControllers.GenericController;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import model.*;

import javax.persistence.EntityManagerFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
//    @FXML
//    public ListView<TruckListParams> truckListView;
    public ListView<Cargo> cargoListField;
    public TextField titleField;
    public TextField weightField;
    public ComboBox CargoTypeField;
    public TextField customerField;
    public TextArea descriptionField;
    @FXML
    public TableView<DriverTableParams> driverTable;

    public TableColumn<DriverTableParams, Integer> idCol;
    public TableColumn<DriverTableParams, String> loginCol;
    public TableColumn<DriverTableParams, String> nameCol;
    public TableColumn<DriverTableParams, String> licenseCol;
    @FXML
    public TableView<ManagerTableParams> managerTable;
    public TableColumn<ManagerTableParams, Integer> mIdCol;
    public TableColumn<ManagerTableParams, String> mLoginCol;
    public TableColumn<ManagerTableParams, String> mNameCol;
    public TableColumn<ManagerTableParams, String> mEmailCol;

    private User loggedUser;
    private EntityManagerFactory entityManagerFactory;
    private GenericController genericController;
    private ObservableList<DriverTableParams> driverData = FXCollections.observableArrayList();
    private ObservableList<ManagerTableParams> managerData = FXCollections.observableArrayList();
    private List<Truck> truckList;
    private List<Cargo> cargoList;

//    private ObservableList<Truck> truckObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        driverTable.setEditable(true);
        idCol.setCellValueFactory(new PropertyValueFactory<>("idCol"));
        loginCol.setCellValueFactory(new PropertyValueFactory<>("loginCol"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameCol"));
        licenseCol.setCellValueFactory(new PropertyValueFactory<>("licenseCol"));
        mIdCol.setCellValueFactory(new PropertyValueFactory<>("mIdCol"));
        mLoginCol.setCellValueFactory(new PropertyValueFactory<>("mLoginCol"));
        mNameCol.setCellValueFactory(new PropertyValueFactory<>("mNameCol"));
        mEmailCol.setCellValueFactory(new PropertyValueFactory<>("mEmailCol"));
    }


    public void setInfo(User user, EntityManagerFactory entityManagerFactory) {
        this.loggedUser = user;
        this.entityManagerFactory = entityManagerFactory;
        this.genericController = new GenericController(entityManagerFactory);
        loadDriverData();
        loadManagerData();
        loadTruckData();
        loadCargoData();
    }

    private void loadTruckData() {
        truckList = genericController.getAllRecords(Truck.class);
        ObservableList<Truck> truckObservableList = FXCollections.observableArrayList(truckList);
        for(Truck t: truckList) {
            truckListField.getItems().add(t);
        }
    }

    private void loadCargoData() {
        cargoList = genericController.getAllRecords(Cargo.class);
        ObservableList<Cargo> cargoObservableList = FXCollections.observableArrayList(cargoList);
        for(Cargo c: cargoList) {
            cargoListField.getItems().add(c);
        }
    }

    private void loadManagerData() {
        List<Manager> managerList = genericController.getAllRecords(Manager.class);
        for (Manager m : managerList) {
            ManagerTableParams managerTableParams = new ManagerTableParams();
            managerTableParams.setmIdCol(m.getId());
            managerTableParams.setmLoginCol(m.getLogin());
            managerTableParams.setmNameCol(m.getName());
            managerTableParams.setmEmailCol(m.getEmail());
            managerData.add(managerTableParams);
        }

        managerTable.setItems(managerData);
    }

    private void loadDriverData() {
        List<Driver> driverList = genericController.getAllRecords(Driver.class);
        for (Driver d : driverList) {
            DriverTableParams driverTableParams = new DriverTableParams();
            driverTableParams.setIdCol(d.getId());
            driverTableParams.setLoginCol(d.getLogin());
            driverTableParams.setNameCol(d.getName());
            driverTableParams.setLicenseCol(d.getDriverLicenseNo());
            driverData.add(driverTableParams);
        }

        driverTable.setItems(driverData);

    }

    public void changeFields(MouseEvent mouseEvent) {
        truckListField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Truck>() {
            @Override
            public void changed(ObservableValue<? extends Truck> observable, Truck oldValue, Truck newValue) {
                if (newValue != null) {
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
        Truck truck = new Truck(makeField.getText(), modelField.getText(), Integer.parseInt(yearField.getText()), Double.parseDouble(odometerField.getText()), Double.parseDouble(fuelCapacityField.getText()), TyreType.valueOf(String.valueOf(tyreTypeField.getSelectionModel().getSelectedItem())));
        genericController.create(truck);
        truckListField.getItems().add(truck);

    }


    public void updateTruck() {
        Truck selectedTruck = truckListField.getSelectionModel().getSelectedItem();
        int index = truckListField.getSelectionModel().getSelectedIndex();
        selectedTruck.setMake(makeField.getText());
        selectedTruck.setModel(modelField.getText());
        selectedTruck.setYear(Integer.parseInt(yearField.getText()));
        selectedTruck.setOdometer(Double.parseDouble(odometerField.getText()));
        selectedTruck.setFuelTankCapacity(Double.parseDouble(fuelCapacityField.getText()));
        selectedTruck.setTyreType(TyreType.valueOf(String.valueOf(tyreTypeField.getSelectionModel().getSelectedItem())));
        System.out.println(index);
        truckListField.getItems().set(index, selectedTruck);
        genericController.update(selectedTruck);
    }

    public void deleteTruck() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Item");
        alert.setContentText("Are you sure you want to delete this item?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Truck selectedTruck = truckListField.getSelectionModel().getSelectedItem();
            truckListField.getItems().remove(selectedTruck);
            genericController.delete(selectedTruck);
        }


    }

    public void createCargo() {
        Cargo cargo = new Cargo(titleField.getText(), Double.parseDouble(weightField.getText()), CargoType.valueOf(String.valueOf(CargoTypeField.getSelectionModel().getSelectedItem())), descriptionField.getText(), customerField.getText());
        genericController.create(cargo);
        cargoListField.getItems().add(cargo);
    }

    public void deleteCargo() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete Item");
        alert.setContentText("Are you sure you want to delete this item?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Cargo cargo = cargoListField.getSelectionModel().getSelectedItem();
            genericController.delete(cargo);
            cargoListField.getItems().remove(cargo);
        }

    }

    public void updateCargo() {
        Cargo cargo = cargoListField.getSelectionModel().getSelectedItem();
        int index = cargoListField.getSelectionModel().getSelectedIndex();
        cargo.setTitle(titleField.getText());
        cargo.setCargoType(CargoType.valueOf(String.valueOf(CargoTypeField.getSelectionModel().getSelectedItem())));
        cargo.setWeight(Double.parseDouble(weightField.getText()));
        cargo.setCustomer(customerField.getText());
        cargo.setDescription(descriptionField.getText());
        cargoListField.getItems().set(index, cargo);
        genericController.update(cargo);
    }


    public void changeCargo(MouseEvent mouseEvent) {
        cargoListField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cargo>() {
            @Override
            public void changed(ObservableValue<? extends Cargo> observable, Cargo oldValue, Cargo newValue) {
                titleField.setText(newValue.getTitle());
                weightField.setText(String.valueOf(newValue.getWeight()));
                customerField.setText(newValue.getCustomer());
                descriptionField.setText(newValue.getDescription());
            }


        });
    }
}
