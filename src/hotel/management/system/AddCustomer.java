package hotel.management.system;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener{

    private JTextField t1,t2,t3,t4,t5,t6;
    private JButton b1,b2;
    private JComboBox c1;
    private Choice c2;
    private JRadioButton r1,r2;


    AddCustomer(){
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100,20,350,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.BOLD,20));
        add(l1);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(50,100,200,30);
        add(l2);

        c1= new JComboBox(new String[] {"Voter ID","Driving License","Aadhar Card"});
        c1.setBounds(250,100,150,30);
        add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(50,140,200,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(250,140,150,30);
        add(t1);


        JLabel l4 = new JLabel("Name");
        l4.setBounds(50,180,200,30);
        add(l4);

        t2=new JTextField();
        t2.setBounds(250,180,150,30);
        add(t2);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(50,220,200,30);
        add(l5);

        r1=new JRadioButton("Male");
        r1.setBounds(250,220,80,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(330,220,80,30);
        add(r2);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        JLabel l11 = new JLabel("Phone Number");
        l11.setBounds(50,260,200,30);
        add(l11);
        t6=new JTextField();
        t6.setBounds(250,260,150,30);
        add(t6);

        JLabel l6 = new JLabel("City");
        l6.setBounds(50,300,200,30);
        add(l6);

        t3=new JTextField();
        t3.setBounds(250,300,150,30);
        add(t3);

        JLabel l7 = new JLabel("Allocated Room No. ");
        l7.setBounds(50,340,200,30);
        add(l7);

        c2=new Choice();
        try{

            conn c = new conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }

        }catch(Exception e){

        }
        c2.setBounds(250,340,150,30);
        add(c2);


        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(50,380,200,30);
        add(l8);

        t4=new JTextField();
        t4.setBounds(250,380,150,30);
        add(t4);

        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(50,420,200,30);
        add(l9);

        t5=new JTextField();
        t5.setBounds(250,420,150,30);
        add(t5);



        b1 = new JButton("Add Customer");
        b1.setBounds(50,480,150,30);
        b1.setBackground(Color.GREEN);
        b1.addActionListener(this);
        add(b1);

         b2 = new JButton("Back");
        b2.setBounds(250,480,150,30);
        b2.setBackground(Color.RED);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        JLabel l10 = new JLabel(i1);
        l10.setBounds(300,50,600,400);
        add(l10);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,150,750,580);
        setVisible(true);

    }

    public static void main(String [] args){

        new AddCustomer().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == b1){
                String id = (String) c1.getSelectedItem();
                String number = t1.getText();
                String name = t2.getText();
                String gender = null;

                if(r1.isSelected()){
                    gender="Male";
                }else if(r2.isSelected()){
                    gender="Female";
                }

                String city = t3.getText();
                String room = c2.getSelectedItem();
                String status = t4.getText();
                String deposit = t5.getText();
                String phone=t6.getText();
                int count =0;


                if(phone.matches("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$" )) {
                    t6.setBackground(Color.green);
                    count +=1;

                }else{
                    t6.setBackground(new Color(255,102,102));

                }
                if((id=="Aadhar Card" && number.matches("^[2-9][0-9]{3}\\s\\d{4}\\s\\d{4}$") )|| (id=="Driving License" && number.matches("(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$"))
                        || (id=="Voter ID"&& number.matches("^[A-Z]{3}\\d{4}$"))){
                    t1.setBackground(Color.green);
                    count += 1;

                }else{
                    t1.setBackground(new Color(255,102,102));

                }

                String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+phone+"','"+city+"','"+room+"','"+status+"','"+deposit+"')";
                String str2 = "update room set available = 'Occupied' where room_number='"+room+"'";
                try{
                    if(count==2) {


                        conn c = new conn();
                        c.s.executeUpdate(str);
                        c.s.executeUpdate(str2);

                        JOptionPane.showMessageDialog(null, "New Customer Added");
                        new Reception().setVisible(true);
                        this.setVisible(false);
                    }else {

                        JOptionPane.showMessageDialog(null, "Please Check your entries");

                    }

                }catch(Exception e){

                    System.out.println(e);


                }
            }else if(ae.getSource() == b2){
                new Reception().setVisible(true);
                this.setVisible(false);

            }

    }
}
