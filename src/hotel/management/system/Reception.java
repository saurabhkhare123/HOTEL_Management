package hotel.management.system;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    Reception(){

        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(10,45,200,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room");
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.BLACK);
        b2.setBounds(10,85,200,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Department");
        b3.setBackground(Color.GREEN);
        b3.setForeground(Color.BLACK);
        b3.setBounds(10,125,200,30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("All Employee Info");
        b4.setBackground(Color.GREEN);
        b4.setForeground(Color.BLACK);
        b4.setBounds(10,165,200,30);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.setBackground(Color.GREEN);
        b5.setForeground(Color.BLACK);
        b5.setBounds(10,205,200,30);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBackground(Color.GREEN);
        b6.setForeground(Color.BLACK);
        b6.setBounds(10,245,200,30);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBackground(Color.GREEN);
        b7.setForeground(Color.BLACK);
        b7.setBounds(10,285,200,30);
        b7.addActionListener(this);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.GREEN);
        b8.setForeground(Color.BLACK);
        b8.setBounds(10,325,200,30);
        b8.addActionListener(this);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.GREEN);
        b9.setForeground(Color.BLACK);
        b9.setBounds(10,365,200,30);
        b9.addActionListener(this);
        add(b9);

        b10 = new JButton("Pick Up Service");
        b10.setBackground(Color.GREEN);
        b10.setForeground(Color.BLACK);
        b10.setBounds(10,405,200,30);
        b10.addActionListener(this);
        add(b10);

        b11 = new JButton("Search Room");
        b11.setBackground(Color.GREEN);
        b11.setForeground(Color.BLACK);
        b11.setBounds(10,445,200,30);
        b11.addActionListener(this);
        add(b11);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/reception.jpeg"));
        Image img2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(265,20,500,500);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(300, 100, 850, 580);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b2){

            new Room().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b3){
            new Department().setVisible(true);
            this.setVisible(false);



        }else if(ae.getSource() == b4){

            new EmployeeInfo().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b5){

            new CustomerInfo().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b6){

            new ManagerInfo().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b7){
            new CheckOut().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b8){
            new UpdateCheck().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource() == b9){
            new UpdateRoom().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource() == b10){
            new PickUp().setVisible(true);
            this.setVisible(false);

        }else if(ae.getSource() == b11){
            new SearchRoom().setVisible(true);
            this.setVisible(false);



        }else if(ae.getSource() == b12){

            new Login().setVisible(true);
            this.setVisible(false);




        }
    }


    public static void main(String[] args) {
        new Reception().setVisible(true);
    }

}