
//This class is reponsible for login to the Hotel  Management System , also provides authentication for the user

package hotel.management.system;  // location of the stored project project
import java.awt.event.*;  //for action performed
import javax.swing.*;    // for JFrame , setBounds etc
import java.awt.*;      // for Color
import java.sql.ResultSet;

class Login extends JFrame implements ActionListener {    // ActionListener is an Interface

    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;

    Login(){
        l1 = new JLabel("USERNAME  : ");
        l1.setBounds(40,30,100,30); // to set Locations
        add(l1);    // to add on the frame
        l2 = new JLabel("PASSWORD  : ");
        l2.setBounds(40,70,100,30);
        add(l2);

        t1 = new JTextField();     // for text , visible to the user
        t1.setBounds(150,30,150,30);
        add(t1);
        t2 = new JPasswordField(); // for passwords , invisible to user
        t2.setBounds(150,70,150,30);
        add(t2);

        b1 = new JButton("Login   >>> ");
        b1.setBounds(180,160,125,30);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);    // for taking the action to be performed
        add(b1);
        b2 = new JButton("Cancel XXX ");
        b2.setBounds(30,160,125,30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);  // for taking the action
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/lady.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(220,220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);                  //  for adding image to the frame
        JLabel l3 = new JLabel(i3);
        l3.setBounds(340,18,200,200);
        add(l3);

        getContentPane().setBackground(Color.WHITE);  // for coloring the complete frame as WHITE

        setLayout(null);
        setBounds(500,300,590,280);
        setVisible(true);     // to show the Frame

    }

    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()==b1){    // if the choice is to LOGIN
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();

            String str = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                ResultSet rs =c.s.executeQuery(str);

                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD ....");
                }
            }catch(Exception e){

            }
        }else if (ae.getSource()==b2){ // if choice is to CANCEL
            System.exit(0);
        }
    }

    public static void main(String[] args) {    // Main Method
        new Login();
    }
}
