package com.example.snakenladders;

import javafx.scene.image.ImageView;

public class Player {
    private boolean turn;
    private Dice d;
    private Token t;
    boolean unlock=false;
    private ImageView token;
    private String Pname;
    Player(String Pname, boolean turn, Token t, ImageView token)
    {   this.Pname=Pname;
        this.turn=turn;
        this.t=t;
        this.token=token;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public String getPname()
    {
        return Pname;
    }
    public ImageView getImageView()
    {
        return this.token;
    }
    public boolean getTurn()
    {
        return turn;
    }

    public void setUnlock(boolean unlock)
    {
        this.unlock=unlock;
    }
    public void turn(Dice d)
    {   //showarrow();
        d.roll();
        if(!unlock)
        {
            if(d.getVal()==1) {

                this.setUnlock(true);
            }
        }
        if(unlock) {
            t.moveToken(d.getVal());
        }

    }
}
