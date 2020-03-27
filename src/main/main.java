package main;

import Frame.Result;
import Ucztujacy_filozofowie.Philosopher;

import javax.swing.*;

public class main {

    public static JFrame result;

    public static void main(String args[]){     //main function initializing GUI

        result = new JFrame("RESULT");
        result.setContentPane(new Result().Result);
        result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        result.pack();
        result.setBounds(100, 100, 1100, 570);
        result.setVisible(true);
    }
}
