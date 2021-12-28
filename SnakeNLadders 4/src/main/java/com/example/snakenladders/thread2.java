package com.example.snakenladders;

import javafx.scene.control.Label;

public class thread2 implements Runnable{
    private Label number;
    private int val;
    thread2(Label number,int val)
    {
        this.number=number;
        this.val=val;
    }
    @Override
    public void run() {
        number.setText(" " + val);
    }
}
