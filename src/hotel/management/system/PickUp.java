package hotel.management.system;


import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

public class PickUp extends JFrame implements ActionListener {
    Choice c1;
    JButton b1,b2;
    JTable t1;
    PickUp(){
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setBounds(430,30,200,30);
        add(l1);
        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(50,100,200,20);
        add(l2);

        c1=new Choice();
        try{
            conn c =new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while (rs.next()){
                c1.add(rs.getString("brand"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

       c1.setBounds(150,100,200,25);
        add(c1);

        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);


        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350,520,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550,520,120,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(30,160,100,20);
        add(l3);
        JLabel l4 = new JLabel("Age");
        l4.setBounds(200,160,100,20);
        add(l4);
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(330,160,150,20);
        add(l5);
        JLabel l6 = new JLabel("Company");
        l6.setBounds(460,160,100,20);
        add(l6);
        JLabel l7 = new JLabel("Modal");
        l7.setBounds(630,160,100,20);
        add(l7);
        JLabel l8 = new JLabel("Availability");
        l8.setBounds(740,160,100,20);
        add(l8);
        JLabel l9 = new JLabel("Location");
        l9.setBounds(890,160,100,20);
        add(l9 );



        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(200,80,1000,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try {
                String str = "select * from driver where brand = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));


            }catch (Exception e){}
        }else if(ae.getSource() == b2){
            new Reception(). setVisible(true);
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new PickUp().setVisible(true);
    }
}

