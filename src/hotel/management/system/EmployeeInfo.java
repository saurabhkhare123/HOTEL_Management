package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
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
        l1.setBounds(50,10,70,20);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(170,10,70,20);
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(250,10,70,20);
        add(l3);

        JLabel l4=new JLabel("Depart.");
        l4.setBounds(340,10,90,20);
        add(l4);

        JLabel l5=new JLabel("Salary");
        l5.setBounds(420,10,70,20);
        add(l5);

        JLabel l6=new JLabel("Phone");
        l6.setBounds(530,10,70,20);
        add(l6);

        JLabel l7=new JLabel("Aadhar");
        l7.setBounds(620,10,70,20);
        add(l7);

        JLabel l8=new JLabel("Email");
        l8.setBounds(780,10,70,20);
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
        setBounds(200,100,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            try{

                conn c = new conn();
                String str = "select * from employee";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                t1.getColumnModel().getColumn(6).setPreferredWidth(100);
                t1.getColumnModel().getColumn(7).setPreferredWidth(170);
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
