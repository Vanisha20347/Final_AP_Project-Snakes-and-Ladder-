package com.example.snakenladders;

import java.util.ArrayList;

public class Ladder {
    private static ArrayList<Ladder> Ladders=new ArrayList<Ladder>();
    private int id;
    private int head;
    private int tail;
    private double dispx;
    private double dispy;
    private static int ctr=0;
    Ladder(int head,int tail,double dispx,double dispy)
    //returns -1 when snake not detected else if snake is detected it returns the ladder id
    {   this.id=ctr;
        ctr++;
        this.head=head;
        this.tail=tail;
        this.dispx=dispx;
        this.dispy=dispy;
    }
    public double getDispx()
    {
        return this.dispx;
    }
    public double getDispy()
    {
        return this.dispy;
    }
    public int getHead()
    {
        return this.head;
    }
    public static int detectLadders(int board_loc)
    {   Ladder l;
        int flag=0;
        int lid=-1;
        for(int i=0;i<Ladders.size();i++)
        {
            l=Ladders.get(i);
            if(l.tail==board_loc)
            {   lid=l.id;
                flag=1;
                break;
            }

        }
        if(flag==1)
        {
            return lid;
        }
        else
        {
            return -1;
        }
    }
    public static void addLadder(Ladder L)
    {
        Ladders.add(L);
    }
    public static Ladder getLadder(int id)
    {
        return Ladders.get(id);
    }
}
