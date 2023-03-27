package fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DriverTableParams {

    private final SimpleIntegerProperty idCol  = new SimpleIntegerProperty();
    private final SimpleStringProperty loginCol  = new SimpleStringProperty();
    private final SimpleStringProperty nameCol  = new SimpleStringProperty();
    private final SimpleStringProperty licenseCol  = new SimpleStringProperty();

    public DriverTableParams() {

    }

    public int getIdCol() {
        return idCol.get();
    }

    public SimpleIntegerProperty idColProperty() {
        return idCol;
    }

    public void setIdCol(int idCol) {
        this.idCol.set(idCol);
    }

    public String getLoginCol() {
        return loginCol.get();
    }

    public SimpleStringProperty loginColProperty() {
        return loginCol;
    }

    public void setLoginCol(String loginCol) {
        this.loginCol.set(loginCol);
    }

    public String getNameCol() {
        return nameCol.get();
    }

    public SimpleStringProperty nameColProperty() {
        return nameCol;
    }

    public void setNameCol(String nameCol) {
        this.nameCol.set(nameCol);
    }

    public String getLicenseCol() {
        return licenseCol.get();
    }

    public SimpleStringProperty licenseColProperty() {
        return licenseCol;
    }

    public void setLicenseCol(String licenseCol) {
        this.licenseCol.set(licenseCol);
    }
}
