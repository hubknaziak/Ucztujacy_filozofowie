package Ucztujacy_filozofowie;

import Frame.Result;

import java.util.ArrayList;
import java.util.List;

public class Management {   //class with management functions of simulation

    public static List<Fork> resources = new ArrayList<>();    //list of resources
    public Result desktop;

    public Management(Result desktop) {
        this.desktop = desktop;
    }

    public void create() {     //function creating a resource list

        for (int i = 1; i <= 5; i++) {
            Fork f = new Fork(i, false);    //creating a new fork
            resources.add(f);                     //adding it to the list
        }
    }

    public synchronized boolean takeFirstFork(int number) throws InterruptedException {      //giving a first fork to the philosopher
        //gives a specific fork for a specific philosopher as first
        if (number == 1 && resources.get(0).busy == false) {
            resources.get(0).busy = true;
            resources.get(0).owner = 1;
            desktop.setWidelceField1("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if (number == 2 && resources.get(1).busy == false) {
            resources.get(1).busy = true;
            resources.get(1).owner = 2;
            desktop.setWidelceField2("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if (number == 3 && resources.get(2).busy == false) {
            resources.get(2).busy = true;
            resources.get(2).owner = 3;
            desktop.setWidelceField3("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if (number == 4 && resources.get(3).busy == false) {
            resources.get(3).busy = true;
            resources.get(3).owner = 4;
            desktop.setWidelceField4("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if (number == 5 && resources.get(0).busy == false) {
            resources.get(0).busy = true;
            resources.get(0).owner = 5;
            desktop.setWidelceField1("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
       else{
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return false;
        }
    }
    //functions up and below a comment gives a protection against a deadlock
    //they are synchronized to avoid using the same resource by more than one thread

    public synchronized boolean takeSecondFork(int number) throws InterruptedException {     //giving a second fork to the philosopher
        //gives a specific fork for a specific philosopher as second
        if(number == 1 && resources.get(1).busy == false) {
            resources.get(1).busy = true;
            resources.get(1).owner = 1;
            desktop.setWidelceField2("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if(number == 2 && resources.get(2).busy == false) {
            resources.get(2).busy = true;
            resources.get(2).owner = 2;
            desktop.setWidelceField3("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if(number == 3 && resources.get(3).busy == false) {
            resources.get(3).busy = true;
            resources.get(3).owner = 3;
            desktop.setWidelceField4("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if(number == 4 && resources.get(4).busy == false) {
            resources.get(4).busy = true;
            resources.get(4).owner = 4;
            desktop.setWidelceField5("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        if(number == 5 && resources.get(4).busy == false) {
            resources.get(4).busy = true;
            resources.get(4).owner = 5;
            desktop.setWidelceField5("BUSY");
            Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            return true;
        }
        else{
            Thread.sleep(((int) (Math.random() * 1000)));
            return false;
        }
    }

    public synchronized boolean leaveForks(int number) throws InterruptedException         //putting the forks back on the table
    {
        if(number == 1){
            if(resources.get(0).busy == true && resources.get(0).owner == 1){
                resources.get(0).busy = false;
                desktop.setWidelceField1("FREE");
            }
            if(resources.get(1).busy == true && resources.get(1).owner == 1){
                resources.get(1).busy = false;
                desktop.setWidelceField2("FREE");
                notifyAll();
                Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            }
            return true;
        }
        if(number == 2){
            if(resources.get(1).busy == true && resources.get(1).owner == 2){
                resources.get(1).busy = false;
                desktop.setWidelceField2("FREE");
            }
            if(resources.get(2).busy == true && resources.get(2).owner == 2){
                resources.get(2).busy = false;
                desktop.setWidelceField3("FREE");
                notifyAll();
                Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            }
            return true;
        }
        if(number == 3){
            if(resources.get(2).busy == true && resources.get(2).owner == 3){
                resources.get(2).busy = false;
                desktop.setWidelceField3("FREE");
            }
            if(resources.get(3).busy == true && resources.get(3).owner == 3){
                resources.get(3).busy = false;
                desktop.setWidelceField4("FREE");
                notifyAll();
                Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            }
            return true;
        }
        if(number == 4){
            if(resources.get(3).busy == true && resources.get(3).owner == 4){
                resources.get(3).busy = false;
                desktop.setWidelceField4("FREE");
            }
            if(resources.get(4).busy == true && resources.get(4).owner == 4){
                resources.get(4).busy = false;
                desktop.setWidelceField5("FREE");
                notifyAll();
                Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            }
            return true;
        }
        if(number == 5){
            if(resources.get(0).busy == true && resources.get(0).owner == 5){
                resources.get(0).busy = false;
                desktop.setWidelceField1("FREE");
            }
            if(resources.get(4).busy == true && resources.get(4).owner == 5){
                resources.get(4).busy = false;
                desktop.setWidelceField5("FREE");
                notifyAll();
                Thread.sleep(((int) (Math.random() * (2000 - 500) + 500)));
            }
            return true;
        }
        else {
            return false;
        }
    }
}
