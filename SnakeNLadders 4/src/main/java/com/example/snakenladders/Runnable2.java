package com.example.snakenladders;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Runnable2 extends Thread {
    private double x;
    private double y;
    private Token t;
    private Player p;
    private ImageView token;

    Runnable2(double x,double y,ImageView token, Token t) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.token=token;

    }

    @Override
    public void run() {

        t.setShift(false);
        while(!t.getMoved())
        {
            try {
                this.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (t.getMoved()) {

            TranslateTransition move = new TranslateTransition();

            move.setNode(token);

            move.setDuration(Duration.millis(550));
            move.setByX(x);
            move.setByY(y);
            move.play();
            t.setShift(true);
        }
        // try {
        //     Thread.sleep(5000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // TranslateTransition move = new TranslateTransition();

        // move.setNode(token);
        // move.setDuration(Duration.millis(550));
        // move.setByX(x);
        // move.setByY(y);
        // move.play();
        // System.out.println("both done board_val="+t.board_loc);
    }
}