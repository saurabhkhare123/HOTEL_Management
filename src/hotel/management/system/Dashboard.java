package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard() {

        mb = new JMenuBar();
        mb.setBackground(Color.CYAN);
        add(mb);

        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        mb.add(m1);

        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1 = new JMenuItem("RECEPTION");
        m1.add(i1);
        i1.addActionListener(this);

        i2 = new JMenuItem("ADD EMPLOYEE");
        m2.add(i2);
        i2.addActionListener(this);

        i3 = new JMenuItem("ADD ROOMS");
        m2.add(i3);
        i3.addActionListener(this);

        i4 = new JMenuItem("ADD DRIVERS");
        m2.add(i4);
        i4.addActionListener(this);

        mb.setBounds(0, 0, 1000, 30);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image img2=img.getImage().getScaledInstance(1400,1000,Image.SCALE_DEFAULT); //its done to change size of img
        ImageIcon img3 = new ImageIcon(img2);  //we have to change it back to image icon
        JLabel l1= new JLabel(img3); //we need JLabel to place our photos in the frame
        l1.setBounds(0,0,1400,1000);
        add(l1);


        //for adding text on image
        JLabel j2=new JLabel("Vasudhaiva Kutumbakam");
        j2.setForeground(Color.BLUE);
        j2.setFont(new Font("",Font.PLAIN,40));
        j2.setBounds(450,80,500,50);
        l1.add(j2);


        setLayout(null);
        setBounds(80 ,50,1400,780);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("RECEPTION")) {
             new AddEmployee().setVisible(true);
        } else if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms().setVisible(true);
        }
        else if (ae.getActionCommand().equals("ADD DRIVERS")){
        new AddDriver().setVisible(true);
        }


    }


    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
