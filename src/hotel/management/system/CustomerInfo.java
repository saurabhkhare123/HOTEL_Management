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
        t1.setBounds(50,40,1400,700);
        add(t1);

        JLabel l1=new JLabel("Document Type");
        l1.setBounds(80,10,150,20);
        add(l1);

        JLabel l2=new JLabel("Document Number");
        l2.setBounds(220,10,150,20);
        add(l2);

        JLabel l3=new JLabel("Name");
        l3.setBounds(420,10,70,20);
        add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(580,10,70,20);
        add(l4);

        JLabel l5=new JLabel("Country");
        l5.setBounds(750,10,70,20);
        add(l5);

        JLabel l6=new JLabel("Room Number");
        l6.setBounds(950,10,150,20);
        add(l6);

        JLabel l7=new JLabel("Status");
        l7.setBounds(1130,10,70,20);
        add(l7);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(1300,10,70,20);
        add(l8);

        b1 = new JButton("Load Data");
        b1.setBounds(450,740,200,50);
        b1.setBackground(Color.GREEN);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(800,740,200,50);
        b2.setBackground(Color.RED);
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setBounds(30,40,1500,850);
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
