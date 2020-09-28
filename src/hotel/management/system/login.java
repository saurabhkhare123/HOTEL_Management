package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    login(){
        l1= new JLabel("Username");
         l1.setBounds(40,20,100,30);
         add(l1);
         l2= new JLabel("Password");
         l2.setBounds(40,70,100,30);
         add(l2);

         t1=new JTextField();
         t1.setBounds(150,20,150,30);
         add(t1);

         t2=new JPasswordField();
         t2.setBounds(150,70,150,30);
         add(t2);

         b1 = new JButton("Login");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(40,150,120,30);
        b1.addActionListener(this);

         add(b1);


         b2= new JButton("Cancel");
         b2.setBounds(180,150,120,30);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.addActionListener(this);
         add(b2);

         ImageIcon Img= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/lady.jpg"));
         Image Img2=Img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon Img3=new ImageIcon(Img2);
         JLabel l3=new JLabel(Img3);
         l3.setBounds(350,10,200,200);
          add(l3);


          getContentPane().setBackground(Color.WHITE); //for setting background color of image


        setLayout(null);
        setBounds(350,210,600,300);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1)
       {
         String username= t1.getText();

         String password =t2.getText();
           Conn c=new Conn();

           String str="select * from login where username = '"+username+"' and password = '"+password+"'";
        try{ //below statements define what would happen after adding info
           ResultSet rs= c.s.executeQuery(str);
            if (rs.next()) {
                new Dashboard().setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                this.setVisible(false);
            }
            this.setVisible(false);
        }catch(Exception e){

        }
        //cancel button
       }else if(ae.getSource()==b2)
       {
           System.exit(0);
       }
        }


    public static void main(String[] args) {
        new login();
    }
}
