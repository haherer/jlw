package com.example.demo1123.controller;

import com.example.demo1123.Demo1123Application;
import com.example.demo1123.service.FooService;
import com.example.demo1123.ui.Hi;
import com.example.demo1123.ui.Ui;
import de.felixroske.jfxsupport.FXMLController;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class ViewController {

    @Autowired
    private Hi hi;

    @Autowired
    private Ui ui;

    @Autowired
    private FooService fooService;

    public void toHi() {
        System.out.println(fooService.service());
        Demo1123Application.getScene().setRoot(hi.getView());
    }

    public void toHello() {
        Demo1123Application.getScene().setRoot(ui.getView());
    }
}
