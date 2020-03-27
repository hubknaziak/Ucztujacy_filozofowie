package Ucztujacy_filozofowie;

public class Fork {     //class of a forks used by threads

    public int number;      //number of a specific fork
    public int owner;       //tells which philosopher currently has the fork in the hand
    public boolean busy;    //'1' if fork is busy, '0' if not

    Fork(int number, boolean busy){     //constructor

        this.number = number;
        this.busy = busy;
    }
}
