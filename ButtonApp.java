// Name: Pauline Kang
// Period: 5 - AP CSA
// Date: 8/19/2021
// Project: Learn how to concatenate text together

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ButtonApp extends JFrame implements ActionListener{
    // declare our components or fields
        // a field is a global level variable
    JTextField txtName = new JTextField(20);
    JTextField txtDepartment = new JTextField(20);
    JTextField txtPhone = new JTextField(5);

    // declare textArea
    JTextArea txaPhoneList = new JTextArea("Department:  Name:   Phone" + "\n",10,30);
    JButton btnAdd = new JButton("Add to List");

    // declare variables to hold information
    String departmentString;
    String nameString;
    String phoneString;

    // main is the first method to run - method means function
    public static void main(String[] args) {
        // declare a frame for form
        ButtonApp frame = new ButtonApp();
        frame.setSize(500, 500);
        frame.setVisible(true);


    }
    // declare the constructor for the project
    // the constructor
    public ButtonApp(){
        super("Button Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        // add our components to the form
        add(new JLabel("Name:     "));
        add(txtName);
        add(new JLabel("Department:     "));
        add(txtDepartment);
        add(new JLabel("Phone:     "));
        add(txtPhone);
        add(btnAdd);
        add(txaPhoneList);

        // ** add listener to the button **
        btnAdd.addActionListener(this);

    } // end of constructor

    //when you push the button, the code comes here
    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();

        if(objSource == btnAdd){
            String outputString = "";
            nameString = txtName.getText();
            departmentString = txtDepartment.getText();
            phoneString = txtPhone.getText();

            // concatenate the text together
            outputString = departmentString + "\t" + nameString + "\t" + phoneString + "\n";

            // output to the text area
            txaPhoneList.append(outputString);

            // clear text boxes
            txtName.setText("");
            txtPhone.setText("");
            txtDepartment.setText("");
            txtName.requestFocus();
        }
    }
} // end of the class
