/*
* NAME: Pauline Kang
* PROJECT: 2D Array
* */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TwoDArray extends JFrame implements ActionListener{

    JTextArea txaOutput = new JTextArea("Array Info",15,30);
    JTextField txtRows = new JTextField(5);
    JTextField txtColumns = new JTextField(5);
    JButton btnCreate = new JButton("Create a 2D Array");

    int numOfRows;
    int keepTrack[] = new int[100];
    int numOfColumns;
    String allNumbers = "";
    String countNumbers = "";

    public static void main(String[] args) {
        TwoDArray frame = new TwoDArray();
        frame.setSize(400, 600);
        frame.setVisible(true);
    }

    public TwoDArray() {
        super("2D Array");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set layout manager
        setLayout(new FlowLayout());
        add(new JLabel("# of Rows:     "));
        add(txtRows);
        add(new JLabel("# of Columns:     "));
        add(txtColumns);
        add(txaOutput);
        add(btnCreate);

        btnCreate.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object objSource = event.getSource();
        if (objSource == btnCreate){
            numOfRows = Integer.parseInt(txtRows.getText());
            numOfColumns = Integer.parseInt(txtColumns.getText());

            int numbers[][] = new int[numOfRows][numOfColumns];


            int totalScores = 0;
            int average = 0;
            // create 2D Array & finding average
            for(int r = 0; r < numOfRows; r++){
                for(int c = 0; c < numOfColumns; c++){
                    numbers[r][c] = (int)(Math.random()*100+0);
                    totalScores += numbers[r][c];
                    allNumbers += numbers[r][c] + " ";
                    keepTrack[numbers[r][c]-1] += 1;
                }
            }
            average = totalScores/(numOfColumns*numOfRows);

            int smallest = numbers[0][0];
            int highest = -1;
            // look for smallest and biggest number
            for(int x = 0; x < numOfRows; x++){
                for(int y = 0; y < numOfColumns; y++){
                    if(highest < numbers[x][y]){
                        highest = numbers[x][y];
                    }
                    if (smallest > numbers[x][y]){
                        smallest = numbers[x][y];
                    }
                }
            }

            for(int b = 0; b < 100; b++){
                countNumbers += b+1 + ": " + keepTrack[b] + "  ";
                if(b!=0 && b%10 == 0){
                    countNumbers += "\n";
                }
            }

            txaOutput.setText("Test Scores: " + allNumbers + "\n" + "\n" +
                    "Average of Test Scores: " + average + "\n" + "\n" +
                    "Highest Score: " + highest + "\n" + "\n" +
                    "Lowest Score: " + smallest + "\n" + "\n" +
                    "Occurrences: " + "\n" + countNumbers + "\n" + "\n");

        }

    }
}
