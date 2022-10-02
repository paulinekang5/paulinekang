// Name: Pauline Kang
// Project: MadLibs

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class madLibs extends JFrame implements ActionListener{

    // variables
    JTextField txtNoun0 = new JTextField(20);
    JTextField txtNoun1 = new JTextField(20);
    JTextField txtNoun2 = new JTextField(20);
    JTextField txtNoun3 = new JTextField(20);
    JTextField txtVerb0 = new JTextField(20);
    JTextField txtVerb1 = new JTextField(20);
    JTextField txtVerb2 = new JTextField(20);
    JTextField txtAdj0 = new JTextField(20);
    JTextField txtAdj1 = new JTextField(20);
    JTextField txtAdj2 = new JTextField(20);

    // declare textArea
    JTextArea txaStory = new JTextArea("Create a MadLib",15,30);
    JButton btnStory = new JButton("Create Story");

    // variables to hold information
    String noun0;
    String noun1;
    String noun2;
    String noun3;
    String verb0;
    String verb1;
    String verb2;
    String adj0;
    String adj1;
    String adj2;

    public static void main(String[] args) {
        madLibs frame = new madLibs();
        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    public madLibs(){
        super("MadLibs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        // add our components to the form
        add(new JLabel("A Animal:     "));
        add(txtNoun0);
        add(new JLabel("A Name:     "));
        add(txtNoun1);
        add(new JLabel("A food:     "));
        add(txtNoun2);
        add(new JLabel("A Noun:     "));
        add(txtNoun3);
        add(new JLabel("An adjective:     "));
        add(txtAdj0);
        add(new JLabel("An Adjective:     "));
        add(txtAdj1);
        add(new JLabel("An Adj (-ly):     "));
        add(txtAdj2);
        add(new JLabel("Present Verb:     "));
        add(txtVerb0);
        add(new JLabel("Past Verb:     "));
        add(txtVerb1);
        add(new JLabel("A Verb -ing:     "));
        add(txtVerb2);
        add(btnStory);
        add(txaStory);

        // ** add listener to the button **
        btnStory.addActionListener(this);
    } // end of constructor

    public void actionPerformed(ActionEvent event){
        Object objSource = event.getSource();
        if(objSource == btnStory){
            String outputString = "";
            noun0 = txtNoun0.getText();
            noun1 = txtNoun1.getText();
            noun2 = txtNoun2.getText();
            noun3 = txtNoun3.getText();
            adj0 = txtAdj0.getText();
            adj1 = txtAdj1.getText();
            adj2 = txtAdj2.getText();
            verb0 = txtVerb0.getText();
            verb1 = txtVerb1.getText();
            verb2 = txtVerb2.getText();

            // concatenate the text together
            outputString = "Once upon a time, there was a(n) " + noun0 + " named " + noun1 + "."
            + " One day " + noun1 + " decided to " + verb0 + ". " + noun1 + " liked to eat " + noun2
                    + "even though it was allergic to it. One day it ate so much it started feeling sick" +
                    "so it went to the doctor. The doctor had a " + adj0 + " coat and " + adj1 + " socks." +
                    "The doctor told " + noun0 + "to go " + verb1 + "in the lake. So the next day, " + noun0 +
                    " went down to the lake, and " + verb1 + adj2 + ". " + "After it " + verb1 + ", " + noun0 +
                    " felt better and was grateful for the doctor and went " + verb2 + " to the doctor to say thank " +
                    "you and gave the doctor a " + noun3 + ". ";

            // output to the text area
            txaStory.setText(outputString);
            txaStory.setLineWrap(true);

            // clear text boxes
            txtNoun0.setText("");
            txtNoun1.setText("");
            txtNoun2.setText("");
            txtNoun3.setText("");
            txtAdj0.setText("");
            txtAdj1.setText("");
            txtAdj2.setText("");
            txtVerb0.setText("");
            txtVerb1.setText("");
            txtVerb2.setText("");

            txtNoun0.requestFocus();
        }
    }
}
