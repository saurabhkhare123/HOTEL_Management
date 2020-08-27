package hotel.management.system;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
        setBounds(300,100,728,546);   //it can be used as alt for both setSize and setLocation
       // setSize(400,400);                    it is used to control size of the frame

       // setLocation(300,500); //it is used to control the location of appearance of frame
        ImageIcon Img= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hot1.jpg"));
        JLabel j1=new JLabel(Img);
        j1.setBounds(0,0,728,546);
        add(j1);
        JLabel j2=new JLabel("Welcome");
        j2.setBounds(200,256,356,60);
        j2.setForeground(Color.BLUE);
        j2.setFont(new Font("serif",Font.PLAIN,70));
        j1.add(j2);


        JButton b1=new JButton("Next");
        b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.setBounds(600,460,90,40);
       b1.addActionListener(this);
        j1.add(b1);

        setLayout(null);
        setVisible(true);
        while (true) {
            j2.setVisible(false); //it will make the welcome not to appear for first 500ml sec
            try {
                Thread.sleep(500);

            } catch (Exception e) {

            }
            j2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }



    }
    public void  actionPerformed(ActionEvent ae)
    {
        new login().setVisible(true);
        this.setVisible(false); //this function will make the welcome screen disappear
    }
    public static void main(String[] args) {
        new HotelManagementSystem();

    }
}
