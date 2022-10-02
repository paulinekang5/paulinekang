// NAME: Pauline Kang
// PROJECT:

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class CarRentalUpgrade extends JFrame implements ActionListener{


    JTextField txtName = new JTextField(20);
    JTextField txtAddress = new JTextField(20);
    JTextField txtCity = new JTextField(20);
    JTextField txtZipCode = new JTextField(10);
    JTextField txtState = new JTextField(5);
    JTextField txtBeginning = new JTextField(20);
    JTextField txtEnding = new JTextField(20);
    JTextField txtDays = new JTextField(10);

    JTextArea txaOutput = new JTextArea("", 15, 30);
    JButton btnCalculate = new JButton("Calculate");

    String nameString;
    int totalCars = 0;
    double totalAmountCollected;


    public static void main(String[] args) {
        CarRentalUpgrade frame = new CarRentalUpgrade();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public CarRentalUpgrade() {
        super("Car Rental");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Name:     "));
        add(txtName);
        add(new JLabel("Address:     "));
        add(txtAddress);
        add(new JLabel("City:     "));
        add(txtCity);
        add(new JLabel("Zip Code:     "));
        add(txtZipCode);
        add(new JLabel("State:     "));
        add(txtState);
        add(new JLabel("Beginning Odometer:     "));
        add(txtBeginning);
        add(new JLabel("Ending Odometer:     "));
        add(txtEnding);
        add(new JLabel("Number of Days:     "));
        add(txtDays);

        add(btnCalculate);
        add(txaOutput);

        btnCalculate.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();

        double beginning;
        double ending;
        int numOfDays;
        double totalCost;


        if (objSource == btnCalculate) {
            try {

                String outputString = "";
                nameString = txtName.getText();
                beginning = Double.parseDouble(txtBeginning.getText());
                ending = Double.parseDouble(txtEnding.getText());
                numOfDays = Integer.parseInt(txtDays.getText());

                Calculations calcClass = new Calculations(beginning, ending, numOfDays);

                totalCost = calcClass.getTotal();
                totalCars = calcClass.getCars();



                totalAmountCollected += totalCost;
                NumberFormat fmtCurrency = NumberFormat.getCurrencyInstance();
                outputString = fmtCurrency.format(totalCost);

                txaOutput.setText("-- CUSTOMER INFO. --" + "\n" +
                        "Name: " + txtName.getText() + "\n" +
                        "Address: " + txtAddress.getText() + "\n" +
                        "City: " + txtCity.getText() + "\n" +
                        "Zip Code: " + txtZipCode.getText() + "\n" +
                        "State: " + txtState.getText() + "\n" + "\n" +

                        "Miles Drive: " + (ending - beginning) + "miles \n" +
                        "Num. Of Days Rented: " + numOfDays + "days \n" +

                        "Total Cost: " + outputString + "\n" + "\n" +

                        " --MANAGER INFO--" + "\n" +
                        "Total Amount Received: " + fmtCurrency.format(totalAmountCollected) + "\n" +
                        "Number Of Cars Returned: " + totalCars + "\n" +
                        "Average Spent By Customers: " + fmtCurrency.format(calcClass.getAvg()));


                // clear text boxes
                txtName.setText("");
                txtAddress.setText("");
                txtCity.setText("");
                txtDays.setText("");
                txtState.setText("");
                txtBeginning.setText("");
                txtEnding.setText("");
                txtZipCode.setText("");

                txtName.requestFocus();

            } catch (NumberFormatException err) {
                txaOutput.setText("Data Error");
            }
        }
    }
}
