package com.example.snakenladders;

import java.util.ArrayList;

public class Snake {
    private static ArrayList<Snake> snakes=new ArrayList<Snake>();

    private int id;
    private int head;
    private int tail;
    double dispx;
    double dispy;
    private static int ctr=0;
    Snake(int head,int tail,double dispx,double dispy)
    {   this.id=ctr;
        ctr++;
        this.head=head;
        this.tail=tail;
        this.dispx=dispx;
        this.dispy=dispy;

    }
    public int getTail()
    {
        return this.tail;
    }
    public double getDispx()
    {
        return this.dispx;
    }
    public double getDispy()
    {
        return this.dispy;
    }
    public static int detectSnakes(int board_loc)
    //returns -1 when snake not detected else if snake is detected it returns the snake id
    {   Snake s;
        int flag=0;
        int sid=-1;
        for(int i=0;i<snakes.size();i++)
        {
            s=snakes.get(i);
            if(s.head==board_loc)
            {   sid=s.id;
                flag=1;
                break;
            }

        }
        if(flag==1)
        {
            return sid;
        }
        else
        {
            return -1;
        }
    }
    public static void addSnake(Snake s)
    {
        snakes.add(s);
    }
    public static Snake getSnake(int id)
    {
        return snakes.get(id);
    }
}
