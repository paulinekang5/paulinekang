// NAME: Pauline Kang
// PERIOD: 5 APCSA
// PROJECT: BMI
// DUE DATE: 8/31/2021
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BMI extends JFrame implements ActionListener {
    // declare our components or fields
    // a field is a global level variable
    JTextField txtWeight = new JTextField(5);
    JTextField txtFeet = new JTextField(5);
    JTextField txtInches = new JTextField(5);


    // declare textArea
    JTextArea txaOutput = new JTextArea("",10,30);
    JButton btnCalculate = new JButton("Calculate");

    // declare variables to hold information
    double inchesDouble;
    double feetDouble;
    double weightDouble;
    int totalPeople;
    double totalBMI;
    double avgBMI;

    // main is the first method to run - method means function
    public static void main(String[] args) {
        // declare a frame for form
        BMI frame = new BMI();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    // declare the constructor for the project
    // the constructor
    public BMI(){
        super("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        // add our components to the form
        add(new JLabel("Height (Feet):     "));
        add(txtFeet);
        add(new JLabel("Height (Inches):     "));
        add(txtInches);
        add(new JLabel("Weight (Pounds):     "));
        add(txtWeight);
        add(btnCalculate);
        add(txaOutput);

        // ** add listener to the button **
        btnCalculate.addActionListener(this);

    } // end of constructor

    //when you push the button, the code comes here
    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();

        double heightDouble;
        double weightDouble;
        double bmi = 0;

        if(objSource == btnCalculate){
            totalPeople += 1;
            String outputString = "";
            heightDouble = Double.parseDouble(txtFeet.getText());
            heightDouble *= 12;
            heightDouble += Double.parseDouble(txtInches.getText());
            weightDouble = Double.parseDouble(txtWeight.getText());

            bmi = calculateBMI(weightDouble, heightDouble);
            // concatenate the text together
            avgBMI = Math.round(((totalBMI/totalPeople) * 10.0) / 10.0);

            outputString = "Weight: " + txtWeight.getText() + " lbs" + "\n" + "Height: " + txtFeet.getText() +"\'" + txtInches.getText() + "\n"
            + "BMI: " + bmi + "\n" + "Total People: " + totalPeople + "\n" + "Average BMI: " + avgBMI;

            // output to the text area
            txaOutput.setText(outputString);

            // clear text boxes
            txtWeight.setText("");
            txtInches.setText("");
            txtFeet.setText("");
            txtWeight.requestFocus();
        }
    }

    public double calculateBMI(double weight, double height){
        double theirBMI = 0;
        theirBMI = (weight/height/height)*703;
        theirBMI = Math.round(theirBMI * 10.0) / 10.0;
        totalBMI += theirBMI;
        return theirBMI;
    }
} // end of the class
