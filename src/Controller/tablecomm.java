package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;


public class tablecomm {
    
    String name;
    String carname;
    String comm;
    String date;
    String status;
    String carid;
    CheckBox box;
    Button b;

    public void setB(Button b) {
        this.b = b;
    }

    public Button getB() {
        return b;
    }

    public tablecomm(String name, String carname, String comm, String date, String status, String carid, Button b) {
        this.name = name;
        this.carname = carname;
        this.comm = comm;
        this.date = date;
        this.status = status;
        this.carid = carid;
        this.box = box;
        this.b = b;
    }
    

    public void setBox(CheckBox box) {
        this.box = box;
    }

    public CheckBox getBox() {
        return box;
    }

    public tablecomm(String name, String carname, String comm, String date, String status, String carid, CheckBox box) {
        this.name = name;
        this.carname = carname;
        this.comm = comm;
        this.date = date;
        this.status = status;
        this.carid = carid;
        this.box = box;
    }
    
    
    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getCarid() {
        return carid;
    }

    
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getCarname() {
        return carname;
    }

    public String getComm() {
        return comm;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
    
    

}
