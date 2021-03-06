package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4, t5,t6,t7;
    private JComboBox comboBox, comboBox_1;
    JButton b1,b2;
    Choice c1;

    AddDriver(){

        setBounds(200, 130,1000, 500);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        add(l15);

        JLabel l10 = new JLabel("ADD DRIVERS");
        l10.setFont(new Font("Tahoma", Font.BOLD, 25));
        l10.setBounds(90, 10, 200, 25);
        contentPane.add(l10);



        JLabel l1 = new JLabel("Name");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 110, 22);
        contentPane.add(l1);
        t1 = new JTextField();
        t1.setBounds(220, 70, 156, 20);
        contentPane.add(t1);


        JLabel l2 = new JLabel("Age");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 110, 22);
        contentPane.add(l2);
        t2 = new JTextField();
        t2.setBounds(220, 110, 156, 20);
        contentPane.add(t2);


        JLabel l3 = new JLabel("Gender");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 110, 22);
        contentPane.add(l3);
        comboBox = new JComboBox(new String[] { "Male", "Female" });
        comboBox.setBounds(220, 150, 154, 20);
        contentPane.add(comboBox);

        JLabel l4 = new JLabel("Driver Contact");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 120, 22);
        contentPane.add(l4);
        t3 = new JTextField();
        t3.setBounds(220, 190, 156, 20);
        contentPane.add(t3);

        JLabel l5 = new JLabel("Car Brand");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 110, 22);
        contentPane.add(l5);
        t4 = new JTextField();
        t4.setBounds(220, 230, 156, 20);
        contentPane.add(t4);


        JLabel l6 = new JLabel("Car Number");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 270, 110, 22);
        contentPane.add(l6);
        t6 = new JTextField();
        t6.setBounds(220, 270, 156, 20);
        contentPane.add(t6);


        JLabel l7 = new JLabel("DL Number");
        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 310, 110, 22);
        contentPane.add(l7);
        t5 = new JTextField();
        t5.setBounds(220, 310, 156, 20);
        contentPane.add(t5);





        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 400, 111, 33);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBounds(198, 400, 111, 33);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);


        contentPane.setBackground(Color.WHITE);


    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    conn c = new conn();
                    String name = t1.getText();
                    String age = t2.getText();
                    String gender = (String)comboBox.getSelectedItem();
                    String company  = t3.getText();
                    String brand = t4.getText();
                    String dl = t5.getText();
                    String carNumber = t6.getText();
                    String avail=null;
                    int count = 0;

                    if (!t1.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty() && !t2.getText().isEmpty() ){
                        count++;
                    }

                    if(company.matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$" )) {
                        t3.setBackground(Color.green);
                        count++;

                    }else {
                        t3.setBackground(new Color(255, 102, 102));

                    }



                    if(carNumber.matches("^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$")) {
                        t6.setBackground(Color.green);
                        count++;

                    }else {
                        t6.setBackground(new Color(255, 102, 102));

                    }

                    if(dl.matches("(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$")) {
                        t5.setBackground(Color.green);
                        count++;

                    }else {
                        t5.setBackground(new Color(255, 102, 102));

                    }

                    if(count==4) {

                        String str = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','" + company + "', '" + brand + "', '" + dl + "','" + carNumber + "','" + avail + "')";


                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                        new AdminTask().setVisible(true);
                        this.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Please check your details..");
                    }

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
        new AddDriver().setVisible(true);
    }

}
