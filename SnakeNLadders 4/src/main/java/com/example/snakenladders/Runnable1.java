package com.example.snakenladders;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.StandardSocketOptions;

public class Runnable1 extends Thread {
    private double x;
    private double y;
    private Token t;
    private Player p;
    private ImageView token;

    Runnable1(double x,double y,ImageView token,Token t) {
        this.x = x;
        this.y = y;
        this.token=token;
        this.t=t;
    }

    @Override
    public void run() {

        TranslateTransition move = new TranslateTransition();
        move.setNode(token);
        move.setDuration(Duration.millis(500));
        move.setByX(x);
        move.setByY(y);
        move.play();
//        System.out.println("translation done board_val="+t.board_loc);
        t.setMoved(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(token.getX()==t.currx && token.getY()==t.curry)
        {
            t.setMoved(true);
        }
//        else{
//            System.out.println("translation nhii huaa");
//
//        }
//        move.setDelay(Duration.millis(3000));
//        int sid=Snake.detectSnakes(t.board_loc);
//        int lid=Ladder.detectLadders(t.board_loc);
//        if(!(sid==-1))   //presence of snake head
//        {
//            Snake s=Snake.getSnake(sid);
//
//            move.setDuration(Duration.millis(550));
//            move.setByX(s.getDispx());
//            move.setByY(s.getDispy());
//            move.play();
//
//            t.UpdateBoard(s.getDispx(),s.getDispy(),s.getTail());
//            t.UpdateAdd(s.getTail());
//            System.out.println("snake done board_val="+t.board_loc);
//        }
//        else if(!(lid==-1))    //presence of ladder tail
//        {
//            Ladder l=Ladder.getLadder(lid);
//
//            move.setDuration(Duration.millis(550));
//            move.setByX(l.getDispx());
//            move.setByY(l.getDispy());
//            move.play();
//            t.UpdateBoard(l.getDispx(),l.getDispy(),l.getHead());
//            t.UpdateAdd(l.getHead());
//            System.out.println("ladder done board_val="+t.board_loc);
//        }
//
    }
}