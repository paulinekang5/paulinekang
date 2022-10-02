// NAME: Pauline Kang
// PROJECT: Craps Game
// Due Date: 9/__/ 2021

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class CrapsUpgrade extends JFrame implements ActionListener {

    JTextField txtNum = new JTextField(5);

    JTextArea txaOutput = new JTextArea("", 15, 30);
    JButton btnRoll = new JButton("PLAY");

    //int dice0;
    int dice1;
    int numPlayed;

    int numWins = 0;



    public static void main(String[] args) {
        CrapsUpgrade frame = new  CrapsUpgrade();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public CrapsUpgrade() {
        super("Craps Game Upgrade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Play # of Times:     "));
        add(txtNum);
        add(btnRoll);
        add(txaOutput);

        btnRoll.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();
        numPlayed = Integer.parseInt(txtNum.getText());

        for(int x = 0; x < numPlayed; x++){
            Calculations calcClass = new Calculations();
            if (calcClass.getWinLose()){
                numWins++;
            }
        }

        txaOutput.setText("- - SUMMARY --" + "\n" +
                        "You played " + numPlayed + " games and won " + numWins + "\n" +
                        "Your probability of winning CRAPS! is " + Math.round((double)numWins/numPlayed*100) + "%");

        numWins = 0;

    }
}

