package hotel.management.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    Choice c1;
    JButton b1,b2;
    JTextField t1;
    Department(){

        JLabel l = new JLabel("DEPARETMENT  -------  BUDGET ");
        l.setFont(new Font("Tahoma",Font.BOLD,30));
        l.setForeground(Color.BLUE);
        l.setBounds(100,50,500,40);
        add(l);


        JLabel l1 = new JLabel("Select Department  --->");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLACK);
        l1.setBounds(20,130,300,30);
        add(l1);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            while(rs.next()){
                c1.add(rs.getString("department"));
            }

        }catch(Exception e){}
        c1.setBounds(350,130,300,30);
        add(c1);

        JLabel l2 = new JLabel("Budget   ------>");
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        l2.setForeground(Color.BLACK);
        l2.setBounds(20,180,300,30);
        add(l2);

        t1=new JTextField();
        t1.setBounds(350,180,300,30);
        add(t1);


        b1 = new JButton("Load");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(175,250,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(380,250,120,30);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(320,150,700,350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String dep = c1.getSelectedItem();
                String str = "select * from department where department = '"+dep+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()) {
                    t1.setText(rs.getString("budget"));
                }

            }catch(Exception e){}

        }else if(ae.getSource()==b2){

            new AdminTask().setVisible(true);
            this.setVisible(false);


        }


    }
    public static void main(String[] args) {
        new Department().setVisible(true);
    }
}

