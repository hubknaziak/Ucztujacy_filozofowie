package Frame;

import Ucztujacy_filozofowie.Management;
import Ucztujacy_filozofowie.Philosopher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Result {
    private JLabel title;
    private JLabel sokratesLabel;
    private JLabel platonLabel;
    private JLabel arystotelesLabel;
    private JLabel shopenhauerLabel;
    private JLabel kartezjuszLabel;
    private  JTextField sokratesStateTextField;
    private  JTextField sokrateActionTextField;
    private  JTextField sokratesDurationTextField;
    private  JTextField platonActionTextField;
    private  JTextField platonDurationTextField;
    private  JTextField ArystotelesDurationTextField;
    private  JTextField ArystotelesActionTextField;
    private  JTextField ShopenhauerDurationTextField;
    private  JTextField ShopenhauerActionTextField;
    private  JTextField KartezjuszDurationTextField;
    private  JTextField KartezjuszActionTextField;
    private  JTextField platonStateTextField;
    private  JTextField ArystotelesStateTextField;
    private  JTextField ShopenhauerStateTextField;
    private  JTextField KartezjuszStateTextField;
    private JLabel stateLabel;
    private JLabel actionLabel;
    private JLabel durationLabel;
    private JButton SokratesTerminateButton;
    private JButton PlatonTerminateButton;
    private JButton ArystotelesTerminateButton;
    private JButton ShopenhauerTerminateButton;
    private JButton KartezjuszTerminateButton;
    public JPanel Result;
    private JButton startButton;
    private JLabel widelceLabel;
    private JTextField widelceField1;
    private JTextField widelceField2;
    private JTextField widelceField3;
    private JTextField widelceField4;
    private JTextField widelceField5;
    private JTextArea TextArea1;
    private JScrollPane scroll;

    public Management manager = new Management(this);   //creating a manager object to create resources

    //initializing all threads of a program

    Thread sokrates = new Thread(new Philosopher(1, this));
    Thread platon  = new Thread(new Philosopher(2,this));
    Thread arystoteles = new Thread(new Philosopher(3, this));
    Thread shopenhauer  = new Thread(new Philosopher(4,this));
    Thread kartezjusz  = new Thread(new Philosopher(5,this));

    //setters of TextFields witch are in GUI

    public void setSokratesStateTextField(String text){
        sokratesStateTextField.setText(text);
    }
    public void setSokrateActionTextField(String text){
        sokrateActionTextField.setText(text);
    }
    public void setSokratesDurationTextField(String text){
        sokratesDurationTextField.setText(text);
    }

    public void setPlatonActionTextField(String text){
        platonActionTextField.setText(text);
    }
    public void setPlatonDurationTextField(String text){
        platonDurationTextField.setText(text);
    }
    public void setPlatonStateTextField(String text){
        platonStateTextField.setText(text);
    }

    public void setArystotelesActionTextField(String text){
        ArystotelesActionTextField.setText(text);
    }
    public void setArystotelesDurationTextField(String text){
        ArystotelesDurationTextField.setText(text);
    }
    public void setArystotelesStateTextField(String text){
        ArystotelesStateTextField.setText(text);
    }

    public void setShopenhauerDurationTextField(String text){
        ShopenhauerDurationTextField.setText(text);
    }
    public void setShopenhauerActionTextField(String text){
        ShopenhauerActionTextField.setText(text);
    }
    public void setShopenhauerStateTextField(String text){
        ShopenhauerStateTextField.setText(text);
    }

    public void setKartezjuszStateTextField(String text){
        KartezjuszStateTextField.setText(text);
    }
    public void setKartezjuszDurationTextField(String text){
        KartezjuszDurationTextField.setText(text);
    }
    public void setKartezjuszActionTextField(String text){
        KartezjuszActionTextField.setText(text);
    }

    public void setWidelceField1(String text){widelceField1.setText(text);}
    public void setWidelceField2(String text){widelceField2.setText(text);}
    public void setWidelceField3(String text){widelceField3.setText(text);}
    public void setWidelceField4(String text){widelceField4.setText(text);}
    public void setWidelceField5(String text){widelceField5.setText(text);}

    public void setTextArea(String text){TextArea1.append(text + "\n");}


    //action listerners of a buttons in a GUI
    //terminating threads for a click of a button
    public Result() {

        scroll.setViewportView(TextArea1);

        SokratesTerminateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    manager.leaveForks(1);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                sokrates.stop();
                sokratesStateTextField.setText("TERMINATED");
            }
        });
        PlatonTerminateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    manager.leaveForks(2);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                platon.stop();
                platonStateTextField.setText("TERMINATED");
            }
        });
        ArystotelesTerminateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    manager.leaveForks(3);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                arystoteles.stop();
                ArystotelesStateTextField.setText("TERMINATED");
            }
        });
        ShopenhauerTerminateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    manager.leaveForks(4);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                shopenhauer.stop();
                ShopenhauerStateTextField.setText("TERMINATED");
            }
        });
        KartezjuszTerminateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    manager.leaveForks(5);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                kartezjusz.stop();
                KartezjuszStateTextField.setText("TERMINATED");
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {  //starting threads and initializing state fields
                manager.create();         //creating a resources
                TextArea1.setText("");
                widelceField1.setText("FREE");  //initializing text fields
                widelceField2.setText("FREE");
                widelceField3.setText("FREE");
                widelceField4.setText("FREE");
                widelceField5.setText("FREE");
                sokrates.start();                               //starting threads
                sokratesStateTextField.setText("RUNNABLE");     //and initializing text fields
                platon.start();
                platonStateTextField.setText("RUNNABLE");
                arystoteles.start();
                ArystotelesStateTextField.setText("RUNNABLE");
                shopenhauer.start();
                ShopenhauerStateTextField.setText("RUNNABLE");
                kartezjusz.start();
                KartezjuszStateTextField.setText("RUNNABLE");

                startButton.setEnabled(false);  //turning off the button to avoid another start of currently running threads
            }
        });
    }
}