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

        mb = new JMenuBar();
        mb.setBackground(Color.CYAN);
        add(mb);

        mb.setBounds(0, 0, 600, 80);

        JLabel l4 = new JLabel(" Thanks! For Expanding Our Community ");
        l4.setBounds(0, 15, 450, 60);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("serif", Font.PLAIN, 35));
        mb.add(l4);

        b1 = new JButton("Add Employee");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(10,105,200,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Add Driver");
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.BLACK);
        b2.setBounds(10,145,200,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Add Room");
        b3.setBackground(Color.GREEN);
        b3.setForeground(Color.BLACK);
        b3.setBounds(10,185,200,30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("LOGOUT");
        b4.setBackground(Color.RED);
        b4.setForeground(Color.BLACK);
        b4.setBounds(10,250,200,30);
        b4.addActionListener(this);
        add(b4);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/reception.jpeg"));
        Image img2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(265,20,500,500);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(550, 250, 600, 350);
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

            new Dashboard().setVisible(true);
            this.setVisible(false);


        }
    }


    public static void main(String[] args) {
        new AdminTask().setVisible(true);
    }

}