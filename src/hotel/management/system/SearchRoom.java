package hotel.management.system;


import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;

 public class SearchRoom extends JFrame implements ActionListener {
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    SearchRoom(){
        JLabel l1 = new JLabel("Search For Room");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setBounds(400,30,200,30);
        add(l1);
        JLabel l2 = new JLabel("Room Bed Type");
        l2.setBounds(50,100,200,20);
        add(l2);

        c1= new JComboBox(new String [] {"Single Bed", "Double Bed"});
        c1.setBounds(175,100,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Only display Available");
        c2.setBounds(650,100,200,25);
        add(c2);






        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);


        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350,520,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550,520,120,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(50,160,100,20);
        add(l3);
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(270,160,100,20);
        add(l4);
        JLabel l5 = new JLabel("Cleaning Status");
        l5.setBounds(450,160,150,20);
        add(l5);
        JLabel l6 = new JLabel("price");
        l6.setBounds(670,160,100,20);
        add(l6);
        JLabel l7 = new JLabel("Bed Type");
        l7.setBounds(870,160,100,20);
        add(l7);


    //    getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(200,80,1000,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            try {
                String str = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
                String str2 ="Select * from room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs ;



              if(c2.isSelected()){
                    rs = c.s.executeQuery(str2);
              } else {
                    rs = c.s.executeQuery(str);

              }
                t1.setModel(DbUtils.resultSetToTableModel(rs));


            }catch (Exception e){}
        }else if(ae.getSource() == b2){
            new Reception(). setVisible(true);
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }
}

