package Controller;

import autosaleandpurchasemanagmentsystemfull.*;


public class sundaytable {
    String carid;
    String carname;
    String date;
    String charges;

    public sundaytable(String carid, String carname, String date, String charges) {
        this.carid = carid;
        this.carname = carname;
        this.date = date;
        this.charges = charges;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getCarid() {
        return carid;
    }

    public String getCarname() {
        return carname;
    }

    public String getDate() {
        return date;
    }

    public String getCharges() {
        return charges;
    }
    
    

}
