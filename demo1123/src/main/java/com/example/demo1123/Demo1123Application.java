package com.example.demo1123;

import com.example.demo1123.ui.Ui;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1123Application extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {

        launch(Demo1123Application.class, Ui.class , args);
    }

}
