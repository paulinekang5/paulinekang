// NAME: Pauline Kang
// PROJECT: Craps Game
// Due Date: 9/28/ 2021
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
public class CrapsGame extends JFrame implements ActionListener {
    JTextArea txaOutput = new JTextArea("", 15, 30);
    JButton btnRoll = new JButton("PLAY");
    int dice0;
    int dice1;
    public static void main(String[] args) {
        CrapsGame frame = new CrapsGame();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    public CrapsGame() {
        super("Craps Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(btnRoll);
        add(txaOutput);
        btnRoll.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();
        DiceRoll rollClass = new DiceRoll();
        Calculations calcClass = new Calculations(rollClass.getDice0(),
                rollClass.getDice0());
        txaOutput.setText("-- DICE --" + "\n" +
                        "DICE1: " + rollClass.getDice0() + " DICE2: " + rollClass.getDice0() + "\n" +
                        "--C R A P S--" + "\n" +
                        "Sum of Die: " + calcClass.getSum() + "\n" + "\n" +
                        calcClass.getOutput());

    }
}