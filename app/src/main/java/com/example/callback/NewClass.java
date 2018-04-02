package com.example.callback;

/**
 * Created by aruna on 1/10/18.
 */

public class NewClass {

    private NewInterface mainClass;

    public NewClass(NewInterface mClass){
        mainClass = mClass;
    }

    public void calledFromMain(){
        //Do somthing...

        //call back main
        mainClass.callback(new Data("Aruna"));
    }
}
