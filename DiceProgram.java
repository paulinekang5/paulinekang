// NAME: Pauline Kang
// PROJECT: Dice Program
// Due Date: 9/14/ 2021

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class DiceProgram extends JFrame implements ActionListener{

    JTextArea txaOutput = new JTextArea("", 15, 30);
    JButton btnRoll = new JButton("Roll");

    int dice0;
    int dice1;

    public static void main(String[] args) {
        DiceProgram frame = new DiceProgram();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public DiceProgram() {
        super("Dice Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(btnRoll);
        add(txaOutput);

        btnRoll.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();
        dice0 = (int) (Math.random()*(6)+1);
        dice1 = (int) (Math.random()*(6)+1);
        Calculations calcClass = new Calculations(dice0, dice1);

        txaOutput.setText("-- DICE --" + "\n" +
                          "DICE1: " + dice0 + "  DICE2: " + dice1 + "\n" +
                          "--STATS--" + "\n" +
                            "Times Each Sum was Rolled: \n " +
                            "Sum of 2: " + calcClass.getProb2() + "\n" +
                            "Sum of 3: " + calcClass.getProb3() + "\n" +
                            "Sum of 4: " + calcClass.getProb4() + "\n" +
                            "Sum of 5: " + calcClass.getProb5() + "\n" +
                            "Sum of 6: " + calcClass.getProb6() + "\n" +
                            "Sum of 7: " + calcClass.getProb7() + "\n" +
                            "Sum of 8: " + calcClass.getProb8() + "\n" +
                            "Sum of 9: " + calcClass.getProb9() + "\n" +
                            "Sum of 10: " + calcClass.getProb10() + "\n" +
                            "Sum of 11: " + calcClass.getProb11() + "\n" +
                            "Sum of 12: " + calcClass.getProb12() + "\n" + "\n" +
                            "Probability of Each Sum: \n" +
                            "Sum of 2: " + calcClass.getPercent2() + "%\n" +
                            "Sum of 3: " + calcClass.getPercent3() + "%\n" +
                            "Sum of 4: " + calcClass.getPercent4() + "%\n" +
                            "Sum of 5: " +calcClass.getPercent5() + "%\n" +
                            "Sum of 6: " + calcClass.getPercent6() + "%\n" +
                            "Sum of 7: " + calcClass.getPercent7() + "%\n" +
                            "Sum of 8: " + calcClass.getPercent8() + "%\n" +
                            "Sum of 9: " + calcClass.getPercent9() + "%\n" +
                            "Sum of 10: " + calcClass.getPercent10() + "%\n" +
                            "Sum of 11: " + calcClass.getPercent11() + "%\n" +
                            "Sum of 12: " + calcClass.getPercent12() + "%\n");
    }

}
