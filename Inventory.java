import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.KeyListener;
import java.util.Collections;

public class Inventory extends JFrame implements ActionListener{

    JTextField txtItem = new JTextField(20);
    JTextField txtPrice = new JTextField(10);
    JTextField txtQuantity = new JTextField(10);
    JTextField txtCustomerSat = new JTextField(20);
    JTextField txtProductQual = new JTextField(10);

    JTextArea txaOutput = new JTextArea(10,30);

    JButton btnAdd = new JButton("Add Inventory");
    JButton btnOutput = new JButton("Output Inventory");


    private ArrayList<QualityControl> products;
    private int max;
    ArrayList<String> less20 = new ArrayList<String>();
    ArrayList<String> less5 = new ArrayList<String>();



    public Inventory(){

        super("Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set our layout manager
        setLayout(new FlowLayout());

        add(new JLabel("Item:"));
        add(txtItem);

        add(new JLabel("Price:"));
        add(txtPrice);

        add(new JLabel("Quantity:"));
        add(txtQuantity);

        add(new JLabel("Customer Satisfaction:"));
        add(txtCustomerSat);

        add(new JLabel("Product Quality:"));
        add(txtProductQual);

        add(btnAdd);
        add(btnOutput);
        //add the text Area
        add(txaOutput);

        //add the listeners
        btnAdd.addActionListener(this);
        btnOutput.addActionListener(this);
        txtPrice.addActionListener(this);
        txtItem.addActionListener(this);
        txtQuantity.addActionListener(this);
        txtCustomerSat.addActionListener(this);
        txtProductQual.addActionListener(this);


        products = new ArrayList<QualityControl>();
        max = 10;
    }


    public void actionPerformed(ActionEvent event) {

        //declare our local variables
        String litem;
        double lprice;
        int lquanitity;
        int lcustomerSat;
        int lproductQual;

        //listen for which button being pressed
        Object objSource = event.getSource();

        if (objSource == btnAdd) {
            litem = txtItem.getText();
            lprice= Double.parseDouble(txtPrice.getText());
            lquanitity = Integer.parseInt(txtQuantity.getText());
            lcustomerSat= Integer.parseInt(txtCustomerSat.getText());
            lproductQual = Integer.parseInt(txtProductQual.getText());

            QualityControl q = new QualityControl(litem, lprice, lquanitity, lcustomerSat, lproductQual);
            for(int x = 0; x < products.size(); x++){
                if(products.get(x).getItem().compareTo(litem) > 0){
                    products.add(x, q);
                    return;
                }
            }
            products.add(q);

            txtPrice.setText("");
            txtItem.setText("");
            txtCustomerSat.setText("");
            txtQuantity.setText("");
            txtProductQual.setText("");
        }

        if(objSource == btnOutput)
        {
            txaOutput.setText("");
            for (QualityControl q : products){
                txaOutput.append(q.getItem() + " - " + q.getPrice() + " - " + q.getQuantity() + " - " + q.getCustomerSat() + " - "
                        + q.getProductQual() + "\n");
            }

            lessThan5();
            txaOutput.append("Less than 5 on Customer Satisfaction or Product Quality:\n");
            for(int x = 0; x < less5.size(); x++){
                txaOutput.append(less5.get(x) + " ");
            }
            txaOutput.append("\n");

            mustOrder();
            txaOutput.append("Less than 20 in quantity:\n");
            for(int x = 0; x < less20.size(); x++){
                txaOutput.append(less20.get(x) + " ");
            }
            txaOutput.append("\n");
        }

    }
    /*
    public void addNewProduct(String name, double cost, int amount, int customerSat, int productQual){
        QualityControl q = new QualityControl(name, cost, amount, customerSat, productQual);
        // put code to sort alphabetically
        for(int x = 0; x < products.size(); x++){
            if(products.get(x).getItem().compareTo(name) > 0){
                products.add(x, q);
                return;
            }
        }
        products.add(q);
    }
*/

    public ArrayList<String> mustOrder(){

        for(QualityControl q: products){
            if(q.getQuantity() < 20){
                less20.add(q.getItem());
            }
        }
        return less20;
    }

    public ArrayList<String> lessThan5(){

        for(QualityControl q: products){
            if(q.getCustomerSat() < 5 || q.getProductQual() <5){
                less5.add(q.getItem());
            }
        }
        return less5;
    }

    public void displayProduct(){
        for (QualityControl q : products){
            txaOutput.append(q.getItem() + " - " + q.getPrice() + " - " + q.getQuantity() + " - " + q.getCustomerSat() + " - "
            + q.getProductQual() + "\n");
        }
    }


}
