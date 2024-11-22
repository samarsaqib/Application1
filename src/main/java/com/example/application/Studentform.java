package com.example.application;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
//import java.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import java.awt.*;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;


//import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;

public class Studentform extends Application {
    Person[] persons = new Person[5];
    @Override
    public void start(Stage stage) throws IOException {
        Image topbanner = new Image(this.getClass().getResource("/img.png").toExternalForm());
        ImageView imageview = new ImageView(topbanner);
        Text welcome = new Text("Welcome to the Student Form");
        Label name = new Label("Name: ");
        Label father = new Label("Father Name: ");
        Label cnic = new Label("CNIC: ");
        Label city = new Label("City: ");
        TextField studentname = new TextField();
        TextField fathername = new TextField();
        TextField cnicNO = new TextField();
        TextField cityname = new TextField();
        Label gendertext = new Label("Gender: ");
        DatePicker dob = new DatePicker();
        Label doblabel = new Label("DOB: ");
        HBox datepickerbox = new HBox();
        datepickerbox.setPadding(new Insets(10, 10, 10, 10));
        datepickerbox.setSpacing(10);
        datepickerbox.getChildren().addAll(dob, doblabel);
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        HBox genderbox = new HBox();
        ToggleGroup gender = new ToggleGroup();
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        genderbox.getChildren().addAll(male, female);
        GridPane pane = new GridPane();
        Button login = new Button("save");
        //pane.add(imageview, 0, 0,1,1);
        //pane.add(welcome, 2, 0);
        pane.add(name, 1, 1);
        pane.add(father, 1, 2);
        pane.add(cnic, 1, 3);
        pane.add(city, 1, 4);
        pane.add(studentname, 2, 1);
        pane.add(fathername, 2, 2);
        pane.add(cnicNO, 2, 3);
        pane.add(cityname, 2, 4);
        pane.add(doblabel, 1, 5);
        pane.add(datepickerbox, 1, 6);
        pane.add(login, 2, 15);
        pane.add(gendertext, 1, 8);
        pane.add(genderbox, 2, 8);
        pane.add(imageview,2,0);
                dob.valueProperty().addListener(new ChangeListener<LocalDate>() {
                    @Override
                    public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                        int age = LocalDate.now().getYear() - newValue.getYear();
                        if (newValue.getMonthValue() > LocalDate.now().getMonthValue()
                                || (newValue.getMonthValue() == LocalDate.now().getMonthValue())
                                && (newValue.getDayOfMonth() > LocalDate.now().getDayOfMonth())) {
                            age--;
                        }

                        doblabel.setText("DOB: " + age);
                    }
                });
            Scene scene = new Scene(pane, 500, 200);
            stage.setScene(scene);
            stage.setTitle("Student Form");
            stage.show();

        }

    public static void main(String[] args) {
        launch();
    }
}