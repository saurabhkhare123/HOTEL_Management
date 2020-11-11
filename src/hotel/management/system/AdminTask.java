package hotel.management.system;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;


public class AdminTask extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4;
    JMenuBar mb;
    JLabel l4;

    AdminTask(){



        b1 = new JButton("Add Employee");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(10,27,200,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Add Driver");
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.BLACK);
        b2.setBounds(10,70,200,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Add Room");
        b3.setBackground(Color.GREEN);
        b3.setForeground(Color.BLACK);
        b3.setBounds(10,113,200,30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Budget");
        b4.setBackground(Color.GREEN);
        b4.setForeground(Color.BLACK);
        b4.setBounds(10,153,200,30);
        b4.addActionListener(this);
        add(b4);

        b4 = new JButton("LogOut");
        b4.setBackground(Color.RED);
        b4.setForeground(Color.BLACK);
        b4.setBounds(10,193,200,30);
        b4.addActionListener(this);
        add(b4);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Manager.png"));
        Image img2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(250,27,200,200);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400, 170, 480, 300);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            new AddEmployee().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b2){

            new AddDriver().setVisible(true);
            this.setVisible(false);


        }else if(ae.getSource() == b3){
            new AddRooms().setVisible(true);
            this.setVisible(false);



        }else if(ae.getSource() == b4){

            new Department().setVisible(true);
            this.setVisible(false);


        }
        else if(ae.getSource() == b4){

            new Dashboard().setVisible(true);
            this.setVisible(false);
    }}


    public static void main(String[] args) {
        new AdminTask().setVisible(true);
    }

}