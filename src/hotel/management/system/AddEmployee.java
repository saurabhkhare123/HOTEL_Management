package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1,t2,t5,t6,t7,t8;
    JButton b1,b2;
    JRadioButton r1,r2;
    JComboBox c1;
    AddEmployee() {


        JLabel name = new JLabel("NAME");
        name.setFont(new Font("", Font.PLAIN, 17));
        name.setBounds(60, 30, 120, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200, 30, 150, 30);
        add(t1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("", Font.PLAIN, 17));
        age.setBounds(60, 80, 120, 30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200, 80, 150, 30);
        add(t2);


        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("", Font.PLAIN, 17));
        gender.setBounds(60, 130, 120, 30);

        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("", Font.PLAIN, 13));
        r1.setBounds(200, 130, 70, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("", Font.PLAIN, 13));
        r2.setBounds(270, 130, 90, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        //to make sure only one button can get selected at a time we use ButtonGroup
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("", Font.PLAIN, 17));
        job.setBounds(60, 180, 120, 30);
        add(job);

        String str[] = {"Porters", "HouseKeepers", "Front Desk Clerks", "Kitchen staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        c1 = new JComboBox(str);
        c1.setBounds(200, 180, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        JLabel Salary = new JLabel("SALARY");
        Salary.setFont(new Font("", Font.PLAIN, 17));
        Salary.setBounds(60, 230, 120, 30);
        add(Salary);

        t5 = new JTextField();
        t5.setBounds(200, 230, 150, 30);
        add(t5);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("", Font.PLAIN, 17));
        phone.setBounds(60, 280, 120, 30);
        add(phone);

        t6 = new JTextField();
        t6.setBounds(200, 280, 150, 30);
        add(t6);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("", Font.PLAIN, 17));
        aadhar.setBounds(60, 330, 120, 30);
        add(aadhar);

        t7 = new JTextField();
        t7.setBounds(200, 330, 150, 30);
        add(t7);

        JLabel email = new JLabel("E-MAIL");
        email.setFont(new Font("", Font.PLAIN, 17));
        email.setBounds(60, 380, 120, 30);
        add(email);

        t8 = new JTextField();
        t8.setBounds(200, 380, 150, 30);
        add(t8);

        b1 = new JButton("SUBMIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLUE);
        b1.setBounds(50, 450, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.RED);
        b2.setBounds(220, 450, 120, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/dash3.jpg"));
        Image img2 = img.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel l1 = new JLabel(img3);
        l1.setBounds(380, 60, 450, 450);
        add(l1);

        JLabel j = new JLabel("ADD EMPLOYEE DETAILS");
        j.setForeground(Color.BLUE);
        j.setBounds(420, 30, 400, 30);
        j.setFont(new Font("", Font.PLAIN, 30));
        add(j);


        getContentPane().setBackground(Color.WHITE);


        setLayout(null);
        setBounds(350, 230, 850, 530);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    String name = t1.getText();
                    String age = t2.getText();
                    String Salary = t5.getText();
                    String phone = t6.getText();
                    String aadhar = t7.getText();
                    String email = t8.getText();

                    String gender = null;
                    if (r1.isSelected()) {
                        gender = "Male";
                    } else if (r2.isSelected()) {
                        gender = "Female";
                    }
                    String job = (String)c1.getSelectedItem();
                    conn c = new conn();
                    String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+Salary+"','"+phone+"','"+aadhar+"','"+email+"')";

                    c.s.executeUpdate(str); //executeUpdate is used when we want to update anything in database
                    JOptionPane.showMessageDialog(null,"New Employee Added");
                    new AdminTask().setVisible(true);
                    this.setVisible(false);

                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                new AdminTask().setVisible(true);
                this.setVisible(false);
            }
        }catch(Exception eee){

        }
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }
}