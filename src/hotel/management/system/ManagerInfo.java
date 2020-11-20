package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;

    ManagerInfo(){
        JLabel l1 = new JLabel("Manager Information  ->");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(20,0,300,30);
        add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(20,60,150,20);
        add(l2);

        t1=new JTextField();
        t1.setBounds(150,60,150,20);
        add(t1);

        JLabel l3 = new JLabel("Age");
        l3.setBounds(20,100,150,20);
        add(l3);

        t2=new JTextField();
        t2.setBounds(150,100,150,20);
        add(t2);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(20,140,150,20);
        add(l4);

        t3=new JTextField();
        t3.setBounds(150,140,150,20);
        add(t3);

        JLabel l5 = new JLabel("Phone");
        l5.setBounds(20,180,150,20);
        add(l5);

        t4=new JTextField();
        t4.setBounds(150,180,150,20);
        add(t4);

        JLabel l6 = new JLabel("Aadhar");
        l6.setBounds(20,220,150,20);
        add(l6);

        t5=new JTextField();
        t5.setBounds(150,220,150,20);
        add(t5);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(20,260,150,20);
        add(l7);

        t6=new JTextField();
        t6.setBounds(150,260,150,20);
        add(t6);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/emp.jpg"));
        Image i3 = i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(320,20,250,250);
        add(l15);

        b1=new JButton("Show");
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(350,280,80,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.BLACK);
        b2.setBounds(470,280,80,30);
        b2.addActionListener(this);
        add(b2);


        setLayout(null);
        setBounds(350,250,620,350);
        setVisible(true);

    }




    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1) {

            String s1 = "Manager";
            //String room = null;
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from employee where job = '" + s1 + "'");
                while (rs.next()) {
                    t1.setText(rs.getString("name"));
                    t2.setText(rs.getString("age"));
                    t3.setText(rs.getString("gender"));
                    t4.setText(rs.getString("phone"));
                    t5.setText(rs.getString("aadhar"));
                    t6.setText(rs.getString("email"));
                }
                /*ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next()){


                }*/

            } catch (Exception e) {
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String [] args){ new ManagerInfo().setVisible(true); }

}

