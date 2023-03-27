package fxControllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ManagerTableParams {

    private final SimpleIntegerProperty mIdCol  = new SimpleIntegerProperty();
    private final SimpleStringProperty mLoginCol  = new SimpleStringProperty();
    private final SimpleStringProperty mNameCol  = new SimpleStringProperty();
    private final SimpleStringProperty mEmailCol  = new SimpleStringProperty();

    public ManagerTableParams() {
    }

    public int getmIdCol() {
        return mIdCol.get();
    }

    public SimpleIntegerProperty mIdColProperty() {
        return mIdCol;
    }

    public void setmIdCol(int mIdCol) {
        this.mIdCol.set(mIdCol);
    }

    public String getmLoginCol() {
        return mLoginCol.get();
    }

    public SimpleStringProperty mLoginColProperty() {
        return mLoginCol;
    }

    public void setmLoginCol(String mLoginCol) {
        this.mLoginCol.set(mLoginCol);
    }

    public String getmNameCol() {
        return mNameCol.get();
    }

    public SimpleStringProperty mNameColProperty() {
        return mNameCol;
    }

    public void setmNameCol(String mNameCol) {
        this.mNameCol.set(mNameCol);
    }

    public String getmEmailCol() {
        return mEmailCol.get();
    }

    public SimpleStringProperty mEmailColProperty() {
        return mEmailCol;
    }

    public void setmEmailCol(String mEmailCol) {
        this.mEmailCol.set(mEmailCol);
    }
}
