// NAME: Pauline Kang
// PROJECT: Test Program
// Due Date: 9/__/2021

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class TestProgram extends JFrame implements ActionListener{

    JTextArea txaOutput = new JTextArea("", 15, 30);
    JTextField txtScore = new JTextField(5);
    JButton btnEnter = new JButton("Enter");

    public static void main(String[] args) {
       TestProgram frame = new TestProgram();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public TestProgram() {
        super("Test Score");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Test Score:     "));
        add(txtScore);
        add(btnEnter);
        add(txaOutput);

        btnEnter.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();

        double testScore;

        if(objSource == btnEnter) {
            testScore = Integer.parseInt(txtScore.getText());
            Calculations calcClass = new Calculations((int) testScore);

            txaOutput.setText("Test Score: " + testScore + "\n" +
                              "Letter Grade: " + calcClass.getLetterGrade() + "\n" +"\n" +
                              "Max Score: " + calcClass.getMax() + "\n" +
                              "Average Score: " + calcClass.getAvg());
        }
    }

}
