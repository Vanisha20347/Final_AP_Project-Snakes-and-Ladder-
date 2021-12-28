package com.example.snakenladders;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class HelloController {


    @FXML
    private Label number;

    @FXML
    private ImageView dice;

    private Player p1;
    private Player p2;

    private Dice d;

    private Token t1;
    private Token t2;

    private thread1 th1;
    private thread1 th2;

    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;

    public void initialize()
    {   this.t1=new Token(player1,"player1");
        this.t2=new Token(player2,"player2");
        this.p1=new Player("player1",true,t1,player1);
        this.p2=new Player("player2",false,t2,player2);

        this.d=new Dice(number);

        //adding snakes
        Snake.addSnake(new Snake(37,3,-27.5,90));
        Snake.addSnake(new Snake(28,10,54,60));
        Snake.addSnake(new Snake(47,16,-55,90));
        Snake.addSnake(new Snake(75,32,82.5,120));
        Snake.addSnake(new Snake(94,71,82.5,60));
        Snake.addSnake(new Snake(96,42,-82.5,150));

        //adding ladders
        Ladder.addLadder(new Ladder(58,22,27.5,-90));
        Ladder.addLadder(new Ladder(56,4,27.5,-150));
        Ladder.addLadder(new Ladder(55,14,-27.5,-120));
        Ladder.addLadder(new Ladder(50,12,27.5,-90));
        Ladder.addLadder(new Ladder(79,41,27.5,-90));
        Ladder.addLadder(new Ladder(88,54,27.5,-90));

    }

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public static boolean win=false;

    public void loading(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("page2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void main(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("page3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void game(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("page4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void win(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("winning.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(MouseEvent event) throws IOException {

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void diceClick(MouseEvent event) throws IOException, InterruptedException {
        if(p1.getTurn())
        {
            this.th1 = new thread1(p1,d);
            this.th1.start();
            th1.join();
            p1.setTurn(false);
            p2.setTurn(true);
        }
        else{
            this.th2 = new thread1(p2,d);
            this.th2.start();

            p2.setTurn(false);
            p1.setTurn(true);
        }

    }

}

