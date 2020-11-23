package hotel.management.system;


import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateCar extends JFrame  implements ActionListener{
    Choice c1;
    JButton b1,b2,b3;
    JTextField t4,t5,t6;

    UpdateCar(){
        JLabel l1 = new JLabel("UPDATE CAR AVAILABILITY");
        l1.setFont(new Font("Tahoma", Font.BOLD,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(40,30,300,30);
        add(l1);


        JLabel l3 = new JLabel("Driver Name");
        l3.setBounds(30,80,150,20);
        add(l3);
       /* t3=new JTextField();
        t3.setBounds(200,80,150,20);
        add(t3);*/
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }

        }catch(Exception e){}
        c1.setBounds(200,80,150,20);
        add(c1);

        JLabel l4 = new JLabel("Car Brand");
        l4.setBounds(30,120,150,20);
        add(l4);
        t4=new JTextField();
        t4.setBounds(200,120,150,20);
        add(t4);

        JLabel l5 = new JLabel("Driver Contact");
        l5.setBounds(30,160,150,20);
        add(l5);
        t5=new JTextField();
        t5.setBounds(200,160,150,20);
        add(t5);

        JLabel l6 = new JLabel("Car Availability");
        l6.setBounds(30,200,150,20);
        add(l6);
        t6=new JTextField();
        t6.setBounds(200,200,150,20);
        add(t6);



        b1 = new JButton("View");
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.BLACK);
        b1.setBounds(30,260,80,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.BLACK);
        b2.setBounds(130,260,80,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.RED);
        b3.setForeground(Color.BLACK);
        b3.setBounds(230,260,80,30);
        b3.addActionListener(this);
        add(b3);



        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,200,380,350);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1) {


            conn c = new conn();
            try {
                String id = c1.getSelectedItem();
                String str = "select * from driver where name = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()) {
                    //t3.setText(rs.getString("name"));
                    t4.setText(rs.getString("brand"));
                    t5.setText(rs.getString("contact"));
                    t6.setText(rs.getString("available"));

                }
            } catch (Exception e) {
            }
        }else if(ae.getSource()==b2) {
            try {
                conn c = new conn();
                String id = c1.getSelectedItem();
                String bra = t4.getText();
                String con = t5.getText();
                String ava = t6.getText();

                String str = "update driver set contact ='" + con + "',brand ='" + bra + "',available='" + ava + "' where name = '" + id + "'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);


            } catch (Exception e) {
            System.out.println(e);
            }


        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new UpdateCar().setVisible(true);
    }
}