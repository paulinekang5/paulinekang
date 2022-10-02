
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class Payroll extends JFrame implements ActionListener {
    // declare our components or fields
    // a field is a global level variable
    JTextField txtName = new JTextField(20);
    JTextField txtHours = new JTextField(20);
    JTextField txtRate = new JTextField(5);

    // declare textArea
    JTextArea txaPayRoll = new JTextArea("Name:   " + "Your Pay:    " + "\n",10,30);
    JButton btnAdd = new JButton("Calculate");

    // declare variables to hold information
    String nameString;
    int totalPeople = 0;

    // main is the first method to run - method means function
    public static void main(String[] args) {
        // declare a frame for form
        Payroll frame = new Payroll();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    // declare the constructor for the project
    // the constructor
    public Payroll(){
        super("Button Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        // add our components to the form
        add(new JLabel("Name:     "));
        add(txtName);
        add(new JLabel("Hours Worked:     "));
        add(txtHours);
        add(new JLabel("Pay Rate:     "));
        add(txtRate);
        add(btnAdd);
        add(txaPayRoll);

        // ** add listener to the button **
        btnAdd.addActionListener(this);

    } // end of constructor

    //when you push the button, the code comes here
    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();

        double rateDouble;
        double hoursDouble;
        double payDouble;
        int totalPeople;

        if(objSource == btnAdd) {
            try {
                String outputString = "";
                nameString = txtName.getText();
                rateDouble = Double.parseDouble(txtRate.getText());
                hoursDouble = Double.parseDouble(txtHours.getText());

                //payDouble = rateDouble * hoursDouble;
                // payDouble = payProcess(hoursDouble, rateDouble);

                // connect the interface with the calculations class
                // instantiating an object
                CalculationsClass thePayClass = new CalculationsClass(rateDouble, hoursDouble);

                payDouble = thePayClass.getPay();

                //NumberFormat fmtCurrency = NumberFormat.getCurrencyInstance();
                //outputString = fmtCurrency.format(payDouble);

                // connect the interface to the localFormat class
                LocalFormat fmtLocal = new LocalFormat();
                outputString = fmtLocal.FormatCurrency(payDouble);


                txaPayRoll.append(nameString + " makes " + outputString);


                // output to the text area
                //txaPayRoll.append(outputString);

                // clear text boxes
                txtName.setText("");
                txtHours.setText("");
                txtRate.setText("");
                txtName.requestFocus();

            }
            catch(NumberFormatException err) {
                txaPayRoll.setText("Data Error");
            }
        }
    }

    /* public double payProcess(double theHours, double theRate){
        double theirPay = 0;
        totalPeople += 1;
        theirPay = theHours*theRate;
        return theirPay;
    }*/
} // end of the class
