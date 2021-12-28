package com.example.snakenladders;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Token {


     double currx;
    double curry;
    private int board_loc=0;
    private String Pname;
    private ImageView token;
    private boolean moved;
    private boolean shift;
    private boolean add = true;

    public void setMoved(boolean move)
    {
        this.moved=move;
    }
    public boolean getMoved()
    {
        return this.moved;
    }
    public void setShift(boolean shift)
    {
        this.shift=shift;
    }
    public boolean getShift()
    {
        return this.shift;
    }

    Token(ImageView token,String Pname)
    {
        this.Pname=Pname;
        this.token=token;
    }
    public void UpdateBoard(double x,double y,int loc)
    {
        currx=currx+x;
        curry=curry+y;
        this.board_loc=loc;
    }
    public void UpdateAdd(int des)
    {   int d=des/10;
        if(d%2==0)
        {
            add=true;
        }
        else{
            add=false;
        }
    }
    public void moveToken(int val)
    {   double x=0;
        double y=0;
        this.setMoved(false);

        while (val != 0) {
            //System.out.println("Board value before "+board_loc);
            if (board_loc == 0) {
                if (val == 1) {
                    curry = 343;
                    currx = 13;
                    val--;
                    board_loc++;

                    if(this.Pname.equals("player1")){
                        x=x+ 10;
                        y= y-26;

                    }
                    else{
                        x=x -12;
                        y=y -26;
                    }
                    continue;
                }
            }
            if(board_loc >= 95){
                if(board_loc+val>100){
                    break;
                }
            }

            if (board_loc % 10 == 0) {
                if (board_loc %20==0) {
                    curry = curry - 30;
                    add = true;
                    val--;
                    board_loc++;
                    x=x+0;
                    y=y-30;

                    continue;
                } else {
                    curry = curry - 30;
                    add = false;
                    val--;
                    board_loc++;
                    x=x+0;
                    y=y-30;

                    continue;
                }
            }
            if (add == true) {
                currx = currx + 27.5;
                val--;
                board_loc++;
                x = x+27.5;
                y=y+0;

            } else {
                currx = currx - 27.5;
                val--;
                board_loc++;
                x = x-27.5;
                y=y+0;

            }
        }
        //System.out.println("Board value after "+board_loc);
        Runnable1 rn=new Runnable1(x,y,token,this);
        rn.setPriority(10);
        Platform.runLater(rn);
        // try {
        //     rn.join();
        // }
        // catch (InterruptedException e) {
        //     System.out.println("Interrupted Exception");
        // }
        // gui screen of moving token

        if( board_loc ==100 ){

            HelloController.win = true;
        }

        // ladder={
        // {95.5f,343} - > {123,193},
        // {178,193} - >> {205.5,103},
        // {178,313} - > {150.5,193},
        // {40.5,283}-> {68,193},
        // {13,223}--> {40.5,133},
        // {233,313}-- > {260.5,223}};
        // snake = {
        // {206.5,283}--> { 260.5,343},
        // { 95.5,253} -- >{68,343}
        // {123,73} -- > {40.5,223}
        // {178,223} --> {123,313}
        // {150.5,133} --- > {233,253}
        // {178,73}->> {260.5,133}
        // }
        int sid=Snake.detectSnakes(board_loc);
        int lid=Ladder.detectLadders(board_loc);
        if(!(sid==-1))   //presence of snake head
        {
            Snake s=Snake.getSnake(sid);
            Runnable2 rn1=new Runnable2(s.getDispx(),s.getDispy(),token,this);

            rn1.setPriority(4);
            Platform.runLater(rn1);
            // try {
            //     rn1.sleep(1500);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            this.UpdateBoard(s.getDispx(),s.getDispy(),s.getTail());
            this.UpdateAdd(s.getTail());
        }
        if(!(lid==-1))    //presence of ladder tail
        {
            Ladder l=Ladder.getLadder(lid);
            Runnable2 rn2=new Runnable2(l.getDispx(),l.getDispy(),token,this);

            rn2.setPriority(2);

            Platform.runLater(rn2);
            // try {
            //     rn2.sleep(1500);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
            //     try {
            //     rn2.wait(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            this.UpdateBoard(l.getDispx(),l.getDispy(),l.getHead());
            this.UpdateAdd(l.getHead());
        }

        //ImageView player=p.getImageView();
        //Platform.runLater(new Runnable1(desx,desy,p));
        //this.makeMove(desx,desy);
    }


    public void makeMove(double desx,double desy)
    {

    }

}