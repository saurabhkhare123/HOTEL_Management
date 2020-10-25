package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener{

    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    Choice c1;

    UpdateCheck(){

        JLabel l1 =new JLabel("Check In Details");
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(50,30,200,30);
        add(l1);

        JLabel l2 =new JLabel("Customer ID");
        l2.setBounds(20,100,150,30);
        add(l2);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }

        }catch(Exception e){}
        c1.setBounds(300,100,150,30);
        add(c1);

        JLabel l3 =new JLabel("Room Number");
        l3.setBounds(20,150,150,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(300,150,150,30);
        add(t1);

        JLabel l4 =new JLabel("Name");
        l4.setBounds(20,200,150,30);
        add(l4);

        t2=new JTextField();
        t2.setBounds(300,200,150,30);
        add(t2);

        JLabel l5 =new JLabel("Check In");
        l5.setBounds(20,250,150,30);
        add(l5);

        t3=new JTextField();
        t3.setBounds(300,250,150,30);
        add(t3);

        JLabel l6 =new JLabel("Amount Paid");
        l6.setBounds(20,300,150,30);
        add(l6);

        t4=new JTextField();
        t4.setBounds(300,300,150,30);
        add(t4);

        JLabel l7 =new JLabel("Amount Pending");
        l7.setBounds(20,350,150,30);
        add(l7);

        t5=new JTextField();
        t5.setBounds(300,350,150,30);
        add(t5);

        b1=new JButton("Check");
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(10,420,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.BLACK);
        b2.setBounds(170,420,120,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBackground(Color.RED);
        b3.setForeground(Color.BLACK);
        b3.setBounds(330,420,120,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine1.png"));
        Image img2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img2);
        JLabel li = new JLabel(i3);
        li.setBounds(450,5,500,500);
        add(li);



        setLayout(null);
        setBounds(300,200,1000,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String deposit=null;
                int amountPaid;
                String price=null;
                String id = c1.getSelectedItem();
                String str = "select * from customer where number = '"+id+"'";
                String room = null;
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
                while(rs2.next()){
                    t5.setText(rs2.getString("price"));
                    price = rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));

                }

            }catch(Exception e){}

        }else if(ae.getSource()==b2){


        }else if(ae.getSource()==b3){

            new Reception().setVisible(true);
            this.setVisible(false);


        }

    }

    public static void main (String [] args ){

        new UpdateCheck().setVisible(true);
    }
}
