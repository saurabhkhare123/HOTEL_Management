package hotel.management.system;

import java.sql.*;
 class conn {

    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms?serverTimezone=UTC","root","");

            s =c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
