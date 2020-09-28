package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame {

    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;

    AddRooms(){
        JLabel l1 = new JLabel("ADD ROOMS");
        l1.setFont(new Font("TAHOMA",Font.BOLD,14));
        l1.setBounds(200,20,100,20);
        add(l1);

        JLabel roomnumber = new JLabel("ROOM NUMBER ");
        roomnumber.setFont(new Font("TAHOMA",Font.PLAIN,14));
        roomnumber.setBounds(60,80,120,30);
        add(roomnumber);

        t1 = new JTextField();
        t1.setBounds(200,80,120,30);
        add(t1);

        JLabel available = new JLabel("AVAILABLE ROOM ");
        available.setFont(new Font("TAHOMA",Font.PLAIN,14));
        available.setBounds(60,130,120,30);
        add(available);

        JLabel status = new JLabel("CLEANING STATUS ");
        status.setFont(new Font("TAHOMA",Font.PLAIN,14));
        status.setBounds(60,180,120,30);
        add(status);

        JLabel price = new JLabel("PRICE ");
        price.setFont(new Font("TAHOMA",Font.PLAIN,14));
        price.setBounds(60,230,120,30);
        add(price);

        JLabel bed = new JLabel("BED TYPE ");
        bed.setFont(new Font("TAHOMA",Font.PLAIN,14));
        bed.setBounds(60,280,120,30);
        add(bed);

        t2 = new JTextField();
        t2.setBounds(200,230,120,30);
        add(t2);

        c1=new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(200,130,120,30);
        add(c1);

        c2=new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(200,180,120,30);
        add(c2);

        c3=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(200,280,120,30);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBounds(40,360,130,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,360,130,30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        add(b2);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(370,20,400,400);
        add(l15);

        getContentPane().setBackground(Color.WHITE);


        setBounds(450,200,800,500);
        setLayout(null);
        setVisible(true);
    }


    public static void main(String [] args){

        new AddRooms().setVisible(true);
    }
}
