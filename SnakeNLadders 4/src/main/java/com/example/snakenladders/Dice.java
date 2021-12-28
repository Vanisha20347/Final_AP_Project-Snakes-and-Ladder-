package com.example.snakenladders;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int val; //value on face of dice (from 1 to 6)
    private Label number;
    Dice(Label number)
    {
        this.number=number;
    }
    public void roll() {
//        int no;
//        no = ThreadLocalRandom.current().nextInt(1, 7);
        Random r=new Random();
        val=r.nextInt(6)+1;

        Platform.runLater(new thread2(number,val));


    }
    public int getVal()
    {
        return val;
    }
}
