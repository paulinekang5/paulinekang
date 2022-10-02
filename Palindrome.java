import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class Palindrome extends JFrame implements ActionListener{

    JTextArea txaOutput = new JTextArea(15,30);
    JTextField txtPalindrome = new JTextField(10);
    JButton btnCheck = new JButton("Enter");

    String userInput = "";
    String testString = "";


    public static void main(java.lang.String[] args) {
        Palindrome frame = new Palindrome();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public Palindrome() {
        super("Palindrome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        add(new JLabel("Enter A String or Sentence:     "));
        add(txtPalindrome);
        add(btnCheck);
        add(txaOutput);

        btnCheck.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();

        if (objSource == btnCheck) {
            userInput = txtPalindrome.getText();
            testString = txtPalindrome.getText();
            userInput = userInput.replaceAll("\\s", "");

            CheckIfPal checking = new CheckIfPal(userInput);
            if(checking.getIsPal()==true){
                txaOutput.setText(testString + " is a palindrome!");
            }
            else{
                txaOutput.setText(testString + " is NOT a palindrome!");
            }
        }
    }
}
