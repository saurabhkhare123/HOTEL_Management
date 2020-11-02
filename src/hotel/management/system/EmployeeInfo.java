package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class EmployeeInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;

    EmployeeInfo(){

        t1 = new JTable();
        t1.setBounds(50,60,850,400);
        add(t1);

        JLabel l1=new JLabel("Name");
        l1.setBounds(40,10,70,20);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(170,10,70,20);
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(280,10,70,20);
        add(l3);

        JLabel l4=new JLabel("Department");
        l4.setBounds(390,10,70,20);
        add(l4);

        JLabel l5=new JLabel("Salary");
        l5.setBounds(510,10,70,20);
        add(l5);

        JLabel l6=new JLabel("Phone");
        l6.setBounds(620,10,70,20);
        add(l6);

        JLabel l7=new JLabel("Aadhar");
        l7.setBounds(740,10,70,20);
        add(l7);

        JLabel l8=new JLabel("Email");
        l8.setBounds(850,10,70,20);
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

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(250,150,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            try{

                conn c = new conn();
                String str = "select * from employee";
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

        new EmployeeInfo().setVisible(true);

    }

}
