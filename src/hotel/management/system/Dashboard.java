package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb,mb1;
    JButton L,m1,m2;
    Dashboard() {

        mb = new JMenuBar();
        mb.setBackground(Color.CYAN);
        add(mb);
        mb1 = new JMenuBar();
        mb1.setBackground(Color.CYAN);
        add(mb1);



        m1 = new JButton("RECEPTION");
        m1.setBounds(0, 0, 250, 50);
        m1.setForeground(Color.BLUE);
        m1.setBackground(Color.GREEN);
        m1.addActionListener(this);
        mb.add(m1);

        m2 = new JButton("Manager");
        m2.setBounds(350, 0, 250, 50);
        m2.setForeground(Color.BLUE);
        m2.setBackground(Color.GREEN);
        m2.addActionListener(this);
        mb.add(m2);

        mb.setBounds(0, 0, 915, 50);
        mb1.setBounds(915, 0, 100, 50);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/dash.jpg"));
        Image img2=img.getImage().getScaledInstance(1000,1000,Image.SCALE_DEFAULT); //its done to change size of img
        ImageIcon img3 = new ImageIcon(img2);  //we have to change it back to image icon
        JLabel l1= new JLabel(img3); //we need JLabel to place our photos in the frame
        l1.setBounds(0,0,1000,1000);
        add(l1);


        //for adding text on image
        JLabel j2=new JLabel("Vasudhaiva Kutumbakam");
        j2.setForeground(Color.WHITE);
        j2.setFont(new Font("",Font.PLAIN,35));
        j2.setBounds(300,150,500,30);
        l1.add(j2);

        L = new JButton("Logout");   // for further entery in the Hotel management system
        L.setBounds(1000, 0, 50, 50);
        L.setBackground(Color.RED);
        L.setForeground(Color.WHITE);
        L.addActionListener(this);
        mb1.add(L);

        setLayout(null);
        setBounds(220 ,50,1000,700);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==m1) {
             new Reception().setVisible(true);
             this.setVisible(false);
        } else if (ae.getSource()==m2) {
            new LoginAdmin().setVisible(true);
            this.setVisible(false);
        } else  if(ae.getSource()==L){
            new Login().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
