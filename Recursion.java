/*
* NAME: PAULINE KANG
* PERIOD: APCSA 5
* PROJECT: RECURSION
* */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class Recursion extends JFrame implements ActionListener{

    JTextArea txaOutput = new JTextArea(15,30);
    JTextField txtPositiveNumber = new JTextField(5);
    JButton btnDivide = new JButton("Divide by 3");
    JButton btnOdd = new JButton("Output Odd Numbers");
    JTextField txtPositiveNumber2 = new JTextField(5);
    JButton btnGCF = new JButton("Greatest Factor?");

    String posNum = "";
    double num1 = 0;
    double num2 = 0;
    double GCFval = 0;


    public static void main(java.lang.String[] args) {
        Recursion frame = new Recursion();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public Recursion() {
        super("Recursion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        add(new JLabel("Input a Positive Number (Divide):     "));
        add(txtPositiveNumber);
        add(btnDivide);
        add(btnOdd);

        add(new JLabel("Input Another Positive Number:     "));
        add(txtPositiveNumber2);
        add(btnGCF);
        add(txaOutput);

        btnDivide.addActionListener(this);
        btnOdd.addActionListener(this);
        btnGCF.addActionListener(this);

    }

    // METHODS
    public double divideBy3(double value){
        String output = value + "\n";
        txaOutput.append(output);
        if(value < 1)
            return value;
        else
        {
            return(divideBy3(value/3));
        }
    }

    public double oddNum(double value, double num){
        String output = num + "\n";
        txaOutput.append(output);

        if(value <= 1)
            return num;
        else
        {
            return(oddNum(value-=1, num+=2));
        }
    }

    public double findGCF(double value0, double counter, double max){

        if (counter != value0-1.0){
            if(value0%counter == 0.0 && value0 > max){
                max = counter;
            }
            return(findGCF(value0, counter+=1.0, max));
        }
        else{
            return max;
        }
    }


    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();

        if (objSource == btnDivide) {
            num1 = Double.parseDouble(txtPositiveNumber.getText());
            divideBy3(num1);
            txaOutput.append("\n");
        }

        if (objSource == btnOdd){
            num1 = Double.parseDouble(txtPositiveNumber.getText());
            oddNum(num1, 1);
            txaOutput.append("\n");
        }

        if(objSource == btnGCF){
            double counter = 1.0;
            num1 = Double.parseDouble(txtPositiveNumber.getText());
            num2 = Double.parseDouble(txtPositiveNumber2.getText());
            GCFval = findGCF(num1, counter, 0);
            if (GCFval == num2){
                txaOutput.append(num2 + " is the greatest factor" + "\n");
            }
            else{
                txaOutput.append(num2 + " is not the greatest factor \n");
            }

        }
    }
}
