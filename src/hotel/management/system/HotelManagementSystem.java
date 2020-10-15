package hotel.management.system;
import javax.swing.*;  // for managing the Frame
import java.awt.*;  // for Color
import java.awt.event.*;    // for ActionListener

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {


        setBounds(110, 200, 1366, 565); //  frame of the Welcome page


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg")); // for extracting image to be used
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1366, 565);
        add(l1);

        JLabel l2 = new JLabel("HOTEL MANAGEMENT SYSTEM");  //for displaying the LABEL Hotel Management System
        l2.setBounds(20, 435, 1000, 90);     // Dimensioning the Text
        l2.setForeground(Color.WHITE);   // for TEXT Coloring
        l2.setFont(new Font("serif", Font.PLAIN, 50));
        l1.add(l2);   //adding the Label on the image referred bt ImageIcon i1

        JButton b1 = new JButton("NEXT");   // for further entery in the Hotel management system
        b1.setBounds(1050, 470, 120, 40);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);
        //  FOR the blinking of the Label HOTEL MANAGEMENT SYSTEM
        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
        // FOR the blinking of the Label HOTEL MANAGEMENT SYSTEM .....
    }


    public void actionPerformed(ActionEvent ae){   //for performed Action

        new Login().setVisible(true);
        this.setVisible(false);
    }


    public static void main(String [] args ){

        new HotelManagementSystem();
    }
}
