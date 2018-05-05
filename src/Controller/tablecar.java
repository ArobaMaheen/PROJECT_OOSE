package Controller;

import autosaleandpurchasemanagmentsystem.Views.*;
import javafx.scene.control.Button;


public class tablecar {
    String id;
    String name;
    String year;
    String color;
    String price;
    Button b;
    public tablecar(String id, String name, String year, String color, String price,Button b) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.price = price;
        this.b=b;
    }

    public void setB(Button b) {
        this.b = b;
    }

    public Button getB() {
        return b;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    
    

}
