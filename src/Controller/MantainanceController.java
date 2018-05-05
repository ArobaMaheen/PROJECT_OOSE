/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import autosaleandpurchasemanagmentsystemfull.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class MantainanceController implements Initializable {

    @FXML
    private Label Carname;

    /**
     * Initializes the controller class.
     */
    connection c;
    TableView tv;
    @FXML
    private AnchorPane scr;
    @FXML
    private Button add;
    @FXML
    private Pane HomePane;
    @FXML
    private Label hometext;
    @FXML
    private Pane homeico;
    @FXML
    private Pane carpane;
    @FXML
    private Label cars;
    @FXML
    private Pane carico;
    @FXML
    private Pane workerpane;
    @FXML
    private Label workers;
    @FXML
    private Pane workerico;
    @FXML
    private Pane marketpane;
    @FXML
    private Label marketing;
    @FXML
    private Pane markico;
    @FXML
    private Pane compane;
    @FXML
    private Label commission;
    @FXML
    private Pane commico;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    @FXML
    private Label date;
    @FXML
    private Pane ap;
    @FXML
    private Button add1;
    @FXML
    private Button add11;
    public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    date.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    
    ComboBox<String> test;
    ComboBox<String> test2;
    ComboBox<String> test3;
   TextField test4;
    
    ComboBox<String> test1;
    int l=28;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        time();
        c=new connection();
        c.connect();
        
        TableColumn<tablemaint,String> mtype=new TableColumn<>("Maintanance Type");
        mtype.setCellValueFactory(new PropertyValueFactory<>("mtype"));
        mtype.setMaxWidth(118);
        mtype.setMinWidth(118);
      
         TableColumn<tablemaint,String> part=new TableColumn<>("Part");
        part.setCellValueFactory(new PropertyValueFactory<>("part"));
         part.setMaxWidth(118);
        part.setMinWidth(118);
        
         TableColumn<tablemaint,String> task=new TableColumn<>("Task");
        task.setCellValueFactory(new PropertyValueFactory<>("task"));
     task.setMaxWidth(118);
        task.setMinWidth(118);
        
        TableColumn<tablemaint,String> mech=new TableColumn<>("Mechanic");
       mech.setCellValueFactory(new PropertyValueFactory<>("mech"));
        mech.setMaxWidth(118);
        mech.setMinWidth(118);
        
        TableColumn<tablemaint,String> comm=new TableColumn<>("Commission");
        comm.setCellValueFactory(new PropertyValueFactory<>("comm"));
         comm.setMaxWidth(118);
        comm.setMinWidth(118);
        ObservableList<tablemaint> ol=FXCollections.observableArrayList();
         try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+NewClass.id+"'");
            LinkedList<String> ll=new LinkedList<String>();
            while(c.rs.next()){
                ll.add(c.rs.getString("mechid"));
            }
            LinkedList<String> l2=new LinkedList<String>();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic");
            
                for(int i=0;i<ll.size();i++){
                    c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic where ID='"+ll.get(i)+"'");
                    c.rs.next();
                l2.add(c.rs.getString("name"));
               
                }
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+NewClass.id+"'");
            int o=0;
            while(c.rs.next()){
                ol.add(new tablemaint(c.rs.getString("type"),c.rs.getString("part"),c.rs.getString("task"),l2.get(o),c.rs.getString("comm")));
                o++;
            }
            tv=new TableView<>();
            tv.setItems(ol);
            tv.getColumns().addAll(mtype,part,task,mech,comm);
            scr.getChildren().add(tv);
            
        }catch(Exception e){
            e.printStackTrace();
        }
         tv.setMinHeight(120);
         
    add1.setVisible(false);
         tv.setRowFactory(new Callback<TableView<tablemaint>, TableRow<tablemaint>>() {
    public TableRow<tablemaint> call(TableView<tablemaint> p) {
        return new TableRow<tablemaint>() {
            @Override protected double computePrefHeight(double width) { return 30; }
        };
    }
});
         add11.setVisible(false);
              
      
      
scr.getChildren().add(ap);
        
        
    }    
 boolean b=false;
         boolean b1=false;
         boolean b2=false;
         boolean b3=false;
         boolean b4=false;
         int i=0;
    @FXML
    private void ad(ActionEvent event) {
      /*  Stage st=new Stage();
        ComboBox<String> cb=new ComboBox<>();
        cb.setPromptText("Maintanance Type");
        cb.getItems().addAll("Engine","Body Parts","Under The Hood");
        ComboBox<String> cb2=new ComboBox();
        ComboBox<String> cb3=new ComboBox();
        TextField tf=new TextField();
        ComboBox<String> cb4=new ComboBox();
        
        LinkedList<String> ll=new LinkedList<String>();
        tf.setPromptText("EnterCommission");
        
        
        ComboBox<String> cb5=new ComboBox();
        cb.setMinWidth(20);
        cb2.setMinWidth(20);
        cb3.setMinWidth(20);
        
        FlowPane hb=new FlowPane();
        hb.setMinWidth(20);
        hb.setHgap(8);
        hb.setVgap(8);
        hb.setPadding(new Insets(40, 28, 40, 28));
        hb.getChildren().add(cb);
        Button b=new Button("Save");
        b.setMinWidth(20);
        tf.setOnMouseClicked(e->{
            try{
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Mechanic");
                while(c.rs.next()){
                    ll.add(c.rs.getString("name"));
                }}
            catch(Exception ex){
                        ex.printStackTrace();
                        }
            cb4.getItems().addAll(ll);
        hb.getChildren().add(cb4);
        
        });
        cb.setOnAction(e -> {
            if(cb.getSelectionModel().getSelectedItem().equals("Engine")){
                try{
                    c.st=c.con.createStatement();
                    c.rs=c.st.executeQuery("Select * from Engine");
                   
                    while(c.rs.next()){
                        cb2.getItems().add(c.rs.getString("name"));
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }else if(cb.getSelectionModel().getSelectedItem().equals("Body Parts")){
                 try{
                    c.st=c.con.createStatement();
                    c.rs=c.st.executeQuery("Select * from BodyParts");
                   
                    while(c.rs.next()){
                        cb2.getItems().add(c.rs.getString("name"));
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }else if(cb.getSelectionModel().getSelectedItem().equals("Under The Hood")){
                 try{
                    c.st=c.con.createStatement();
                    c.rs=c.st.executeQuery("Select * from UTHood");
                   
                    while(c.rs.next()){
                        cb2.getItems().add(c.rs.getString("name"));
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            cb2.setPromptText("Select Part");
            hb.getChildren().add(cb2);
            
        });
        
        cb2.setOnAction(e -> {
            try{
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Task");
                
                while(c.rs.next()){
                    cb3.getItems().add(c.rs.getString("name"));
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            cb3.setPromptText("Select Task");
            hb.getChildren().add(cb3);
            
        });
        
        cb3.setOnAction(e->{
        hb.getChildren().add(tf);
        
        });
         cb4.setOnAction(e->{
        hb.getChildren().add(b);
        
        });
        b.setOnAction(e->{
            String ty=cb.getValue();
        String part=cb2.getValue();
        String ser=cb3.getValue();
        String com=tf.getText();
        String m=cb4.getValue();
        String mid;
        try{
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Mechanic where name='"+m+"'");
                c.rs.next();
                mid=c.rs.getString("ID");
                System.out.println(mid);
                c.st=c.con.createStatement();
                c.st.executeUpdate("INSERT INTO Maintanance values('"+NewClass.id+"','"+ty+"','"+part+"','"+ser+"','"+mid+"','"+com+"')");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        ObservableList<tablemaint> ol=FXCollections.observableArrayList();
         try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+NewClass.id+"'");
            LinkedList<String> ll2=new LinkedList<String>();
            while(c.rs.next()){
                ll2.add(c.rs.getString("mechid"));
            }
            LinkedList<String> l2=new LinkedList<String>();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic");
            
                for(int i=0;i<ll2.size();i++){
                    c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic where ID='"+ll2.get(i)+"'");
                    c.rs.next();
                l2.add(c.rs.getString("name"));
               
                }
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+NewClass.id+"'");
            int o=0;
            while(c.rs.next()){
                ol.add(new tablemaint(c.rs.getString("type"),c.rs.getString("part"),c.rs.getString("task"),l2.get(o),c.rs.getString("comm")));
                o++;
            }
            
            tv.setItems(ol);
         }catch(Exception exx){
             exx.printStackTrace();
         }
        });
        Scene sc=new Scene(hb,350,130);
        st.initModality(Modality.APPLICATION_MODAL);
        st.setScene(sc);
        st.showAndWait();*/
      add11.setVisible(true);
        ap.setVisible(true);
        try {
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+NewClass.id+"'");
            while(c.rs.next()){
                l+=30;
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MantainanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
            test=new ComboBox();
        test.setMinWidth(108);
        test.setMaxWidth(108);
         ap.getChildren().add(test);
         System.out.println(l);
          ap.setLayoutY(l);
         ap.setLayoutX(6);
            test1=new ComboBox();
        test1.setMinWidth(108);
         test1.setMaxWidth(108);
        test1.setLayoutX(118);
         ap.getChildren().add(test1);
         
           test2=new ComboBox();
        test2.setMinWidth(108);
        test2.setMaxWidth(108);
        test2.setLayoutX(236);
         ap.getChildren().add(test2);
         
           test3=new ComboBox();
        test3.setMinWidth(108);
        test3.setMaxWidth(108);
        test3.setLayoutX(354);
         ap.getChildren().add(test3);
         
          test4=new TextField();
        test4.setMaxWidth(102);
        test4.setLayoutX(472);
         ap.getChildren().add(test4);
         
         
         
      test.setPromptText("Select");
        test.getItems().addAll("Engine","Body Parts","Under The Hood");
        
         test.setOnAction(e -> {
               b=true;
               System.out.println("inside");
               add1.setVisible(false);
               b1=false;
            if(test.getSelectionModel().getSelectedItem().equals("Engine")){
                try{
                    c.st=c.con.createStatement();
                    c.rs=c.st.executeQuery("Select * from Engine");
                   test1.getItems().clear();
                    while(c.rs.next()){
                        test1.getItems().add(c.rs.getString("name"));
                    }
                  
                    
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }else if(test.getSelectionModel().getSelectedItem().equals("Body Parts")){
                 try{
                    c.st=c.con.createStatement();
                    c.rs=c.st.executeQuery("Select * from BodyParts");
                   test1.getItems().clear();
                    while(c.rs.next()){
                        test1.getItems().add(c.rs.getString("name"));
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }else if(test.getSelectionModel().getSelectedItem().equals("Under The Hood")){
                 try{
                    c.st=c.con.createStatement();
                    c.rs=c.st.executeQuery("Select * from UTHood");
                   test1.getItems().clear();
                    while(c.rs.next()){
                        test1.getItems().add(c.rs.getString("name"));
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
         test1.setPromptText("Select");
         
         });
         test1.setOnAction(e ->{
         test2.setPromptText("Select");
         b1=true;
         if(b && b1 && b2 && b3 && b4){
                        add1.setVisible(true);
                    }
         
         });
         
         test2.setOnAction(e ->{
              b2=true;
         if(b && b1 && b2 && b3 && b4){
                        add1.setVisible(true);
                    }
         test3.setPromptText("Select");
         
         });
         
         test3.setOnAction(e ->{
              b3=true;
         if(b && b1 && b2 && b3 && b4){
                        add1.setVisible(true);
                    }
        
         
         });
         
         test4.setOnMouseClicked(e ->{
              b4=true;
              System.out.println(b+""+b1+""+b2+""+b3+""+b4);
         if(b && b1 && b2 && b3 && b4){
                        add1.setVisible(true);
                    }
        
         
         });
     
            try{
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Task");
                
                while(c.rs.next()){
                   test2.getItems().add(c.rs.getString("name"));
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
           
             try{
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Mechanic where d='n'");
                while(c.rs.next()){
                    test3.getItems().add(c.rs.getString("name"));
                }}
            catch(Exception ex){
                        ex.printStackTrace();
                        }
           
        
      test4.setPromptText("Enter Commission");
      add.setDisable(true);
    }

    @FXML
    private void homepaneexit(MouseEvent event) {
       transformsize(1, 0.3, homeico);
         HomePane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void homepaneenter(MouseEvent event) {
        transformsize(1.5, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
    private void carpmouseexit(MouseEvent event) {
        
    }

    @FXML
    private void carpmouseenter(MouseEvent event) {
        
    }

    public void transformsize(double size,double duration,Node node){
        ScaleTransition st=new ScaleTransition(Duration.seconds(duration),node);
        st.setToX(size);
        st.setToY(size);
        st.play();
    }
    @FXML
    private void wmouseexit(MouseEvent event) {
        transformsize(1, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void wmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
    private void commouseexit(MouseEvent event) {
        transformsize(1, 0.3, commico);
        compane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void commouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, commico);
        compane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
    private void homepaneclick(MouseEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DashbaordDesign.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }
    
    @FXML
    private void carpaneclick(MouseEvent event) throws IOException {
         try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
    private void workerpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void markpaneexit(MouseEvent event) {
        transformsize(1, 0.3, markico);
        marketpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void markpaneenter(MouseEvent event) {
         transformsize(1.5, 0.3, markico);
        marketpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
    private void marketpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Advertisment.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
Parent root;
    @FXML
    private void commissionpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
    private void minbutact(ActionEvent event) {
        NewClass.p.setIconified(true);
    }

    @FXML
    private void svw(ActionEvent event) {
        add11.setVisible(false);
         String ty=test.getValue();
        String part=test1.getValue();
        String ser=test2.getValue();
        String m=test3.getValue();
        String com=test4.getText();
        String mid;
        try{
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from Mechanic where name='"+m+"'");
                c.rs.next();
                mid=c.rs.getString("ID");
                System.out.println(mid);
                c.st=c.con.createStatement();
                c.st.executeUpdate("INSERT INTO Maintanance values('"+NewClass.id+"','"+ty+"','"+part+"','"+ser+"','"+mid+"','"+com+"')");
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
          try {
            root = FXMLLoader.load(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Mantainance.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        i=0;
        add.setDisable(false);
    }

    @FXML
    private void cancel(ActionEvent event) {
        ap.getChildren().clear();
        b=false;
        b1=false;
        b2=false;
        b3=false;
        b4=false;
        add1.setVisible(false);
        add11.setVisible(false);
        l=l-i*30;
        i=0;
        add.setDisable(false);
    }
    
    
    
}
