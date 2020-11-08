package hotel.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    CustomerInfo(){

        t1 = new JTable();
        t1.setBounds(50,60,850,400);
        add(t1);

        JLabel l1=new JLabel("Document Type");
        l1.setBounds(50,10,150,20);
        add(l1);

        JLabel l2=new JLabel("Document Number");
        l2.setBounds(150,10,150,20);
        add(l2);

        JLabel l3=new JLabel("Name");
        l3.setBounds(300,10,70,20);
        add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(400,10,70,20);
        add(l4);

        JLabel l5=new JLabel("Country");
        l5.setBounds(490,10,70,20);
        add(l5);

        JLabel l6=new JLabel("Room Number");
        l6.setBounds(600,10,150,20);
        add(l6);

        JLabel l7=new JLabel("Status");
        l7.setBounds(720,10,70,20);
        add(l7);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(820,10,70,20);
        add(l8);

        b1 = new JButton("Load Data");
        b1.setBounds(200,500,200,50);
        b1.setBackground(Color.GREEN);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(550,500,200,50);
        b2.setBackground(Color.RED);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setBounds(250,150,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            try{

                conn c = new conn();
                String str = "select * from customer";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));


            }catch(Exception e){

            }

        }else if(ae.getSource() == b2){

            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {

        new CustomerInfo().setVisible(true);

    }

}
