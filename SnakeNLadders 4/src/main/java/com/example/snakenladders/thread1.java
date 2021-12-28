package com.example.snakenladders;

public class thread1 extends Thread  {
    private Dice d;
    private Player p;

    thread1(Player p,Dice d)
    {   this.p=p;
        this.d=d;
    }
    public void run()
    {
       p.turn(d);

    }
}
