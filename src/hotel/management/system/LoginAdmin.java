
//This class is reponsible for login to the Hotel  Management System , also provides authentication for the user

package hotel.management.system;  // location of the stored project project
import java.awt.event.*;  //for action performed
import javax.swing.*;    // for JFrame , setBounds etc
import java.awt.*;      // for Color
import java.sql.ResultSet;

class LoginAdmin extends JFrame implements ActionListener {    // ActionListener is an Interface

    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JButton b1,b2;
    JMenuBar mb;

    LoginAdmin(){



        l1 = new JLabel("USERNAME  : ");
        l1.setBounds(40,110,100,30); // to set Locations
        add(l1);    // to add on the frame
        l2 = new JLabel("PASSWORD  : ");
        l2.setBounds(40,150,100,30);
        add(l2);

        mb = new JMenuBar();
        mb.setBackground(Color.CYAN);
        add(mb);

        mb.setBounds(0, 0, 580, 80);

        JLabel l4 = new JLabel("   Welcome Back , ADMIN ! ");
        l4.setBounds(40, 15, 450, 60);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("serif", Font.PLAIN, 40));
        mb.add(l4);

        t1 = new JTextField();     // for text , visible to the user
        t1.setBounds(150,110,170,30);
        add(t1);
        t2 = new JPasswordField(); // for passwords , invisible to user
        t2.setBounds(150,150,170,30);
        add(t2);

        b1 = new JButton("Login   >>> ");
        b1.setBounds(180,230,125,30);
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);    // for taking the action to be performed
        add(b1);
        b2 = new JButton("Cancel XXX ");
        b2.setBounds(30,230,125,30);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);  // for taking the action
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/lady.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(220,220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);                  //  for adding image to the frame
        JLabel l3 = new JLabel(i3);
        l3.setBounds(330,95,210,210);
        add(l3);

        getContentPane().setBackground(Color.WHITE);  // for coloring the complete frame as WHITE

        setLayout(null);
        setBounds(400,250,580,350);
        setVisible(true);     // to show the Frame

    }

    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()==b1){    // if the choice is to LOGIN
            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();

            String str = "select * from loginadmin where username='"+username+"' and password='"+password+"'";
            try{
                ResultSet rs =c.s.executeQuery(str);

                if(rs.next()){
                    new AdminTask().setVisible(true);
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
        new LoginAdmin();
    }
}
