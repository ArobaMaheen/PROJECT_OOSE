package Controller;

import text.*;


public class worktable {
    String name;
    String id;
    String cnic;
    String pno;
    String add;
    String zone;
    String email;
    String date;

    public worktable(String name, String id, String cnic, String pno, String add, String zone, String email, String date) {
        this.name = name;
        this.id = id;
        this.cnic = cnic;
        this.pno = pno;
        this.add = add;
        this.zone = zone;
        this.email = email;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCnic() {
        return cnic;
    }

    public String getPno() {
        return pno;
    }

    public String getAdd() {
        return add;
    }

    public String getZone() {
        return zone;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }
    

}
