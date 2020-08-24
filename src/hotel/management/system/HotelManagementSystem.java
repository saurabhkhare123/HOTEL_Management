package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class HotelManagementSystem extends JFrame {
    HotelManagementSystem(){
        setBounds(300,100,728,546);   //it can be used as alt for both setSize and setLocation
       // setSize(400,400);                    it is used to control size of the frame

       // setLocation(300,500); //it is used to control the location of appearance of frame
        ImageIcon Img= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hot1.jpg"));
        JLabel j1=new JLabel(Img);
        j1.setBounds(0,0,728,546);
        add(j1);
        JLabel j2=new JLabel("Welcome");
        j2.setBounds(200,257,356,60);
        j2.setForeground(Color.BLUE);
        j2.setFont(new Font("serif",Font.PLAIN,70));
        j1.add(j2);


        JButton b1=new JButton("Next");
        b1.setBackground(Color.GRAY);
        b1.setBackground(Color.WHITE);
        b1.setBounds(300,350,90,40);
        j1.add(b1);
        setLayout(null);
        setVisible(true);
        while (true) {
            j2.setVisible(false);
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
    public static void main(String[] args) {
        new HotelManagementSystem();

    }
}
