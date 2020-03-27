package Ucztujacy_filozofowie;
import Frame.Result;
import main.main;

import javax.swing.*;
import java.sql.PreparedStatement;

public class Philosopher implements Runnable {  //thread class of a philosopher

    public Result desktop;
    public  Management manager;     //object of manager class for using synchronized resources methods
    public long timer = 0;          //tells about a time which pass
    public int hands = 0;           //tells about a number of forks use by a philosopher
    public boolean eating;          //tells, if the thread eat
    public boolean thinking;        //tells, if the thread think
    public int number;              //number of a current philosopher
    public String name;             //name of the philosopher

    public Philosopher(int number, Result desktop) {     //constructor, setting up all fields of an object
        this.manager = new Management(desktop);
        this.desktop = desktop;
        this.number = number;
        this.eating = false;
        this.thinking = true;
        if(number == 1) this.name = "Sokrates";
        else if (number == 2)  this.name = "Platon";
        else if (number == 3)  this.name = "Arystoteles";
        else if (number == 4)  this.name = "Shopenhauer";
        else this.name = "Kartezjusz";
    }

    public void thinking() throws InterruptedException {

        int waiting = (int) (Math.random() * (5000 - 2000) + 2000);

        if (number == 1) { desktop.setSokrateActionTextField("Thinking"); desktop.setSokratesDurationTextField(String.valueOf(waiting) + "ms"); }
        if (number == 2) { desktop.setPlatonActionTextField("Thinking");  desktop.setPlatonDurationTextField(String.valueOf(waiting) + "ms");}
        if (number == 3) { desktop.setArystotelesActionTextField("Thinking"); desktop.setArystotelesDurationTextField(String.valueOf(waiting) + "ms");}
        if (number == 4) { desktop.setShopenhauerActionTextField("Thinking"); desktop.setShopenhauerDurationTextField(String.valueOf(waiting) + "ms");}
        if (number == 5) { desktop.setKartezjuszActionTextField("Thinking");  desktop.setKartezjuszDurationTextField(String.valueOf(waiting) + "ms");} //initializing the action parameter

        thinking = true;
        eating = false;

        Thread.sleep(waiting);
    }

    public void eating() throws InterruptedException {

        int waiting = (int) (Math.random() * (5000 - 2000) + 2000);

        if (number == 1) { desktop.setSokrateActionTextField("Eating");  desktop.setSokratesDurationTextField(String.valueOf(waiting) + "ms"); }
        if (number == 2) { desktop.setPlatonActionTextField("Eating");  desktop.setPlatonDurationTextField(String.valueOf(waiting) + "ms"); }
        if (number == 3) { desktop.setArystotelesActionTextField("Eating");  desktop.setArystotelesDurationTextField(String.valueOf(waiting) + "ms"); }
        if (number == 4) { desktop.setShopenhauerActionTextField("Eating");  desktop.setShopenhauerDurationTextField(String.valueOf(waiting) + "ms"); }
        if (number == 5) { desktop.setKartezjuszActionTextField("Eating");   desktop.setKartezjuszDurationTextField(String.valueOf(waiting) + "ms");}   //initializing the action parameter

        thinking = false;
        eating = true;

        Thread.sleep(waiting);
    }

    @Override
    public void run() {     //this function is running, when the thread had started

        timer = System.currentTimeMillis();

        while (true) {        //it works until the user stop the thread

            try {               //the philosopher starts to think
                thinking();
                desktop.setTextArea(name + " is thinking");
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            if (thinking == true && hands == 0) {           //taking the first fork in the hand
                try {
                    if (manager.takeFirstFork(number) == true) {
                        hands = 1;
                        desktop.setTextArea(name + " took his first fork");
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            if(thinking == true && hands == 1){            //taking the second fork in the hand
                try {
                    if(manager.takeSecondFork(number) == true){
                        hands = 2;
                        desktop.setTextArea(name + " took his second fork");
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            if (hands == 2){       //starting to eat, if the philosopher has all 2 forks
                try {
                    eating();
                    desktop.setTextArea(name + " is eating");
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            if(eating == true){     //giving back the forks after eating
                try {
                    if(manager.leaveForks(number) == true) {
                        hands = 0;
                        thinking = true;
                        eating = false;
                        desktop.setTextArea(name + " has gave back his forks");
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }
}