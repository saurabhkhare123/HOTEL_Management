package hotel.management.system;
import javax.swing.*;
import java.awt.*; //for colors


public class Dashboard extends  JFrame {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    Dashboard(){
        mb =new JMenuBar();
        add(mb);

        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        mb.add(m1);

        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1=new JMenuItem("RECEPTION");
        m1.add(i1);
        i2=new JMenuItem("ADD EMPLOYEE");
        m2.add(i2);
        i3=new JMenuItem("ADD ROOMS");
        m2.add(i3);
        i4=new JMenuItem("ADD DRIVERS");
        m2.add(i4);
        mb.setBounds(0,0,1000,30);

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




        setLayout(null);
        setBounds(200 ,0,1000,1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}