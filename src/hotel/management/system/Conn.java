package hotel.management.system;

import java.sql.*;

public class Conn {
  Connection c;
  Statement s;

  public Conn(){
      try{

      Class.forName("com.mysql.jdbc.Driver");
      c=DriverManager.getConnection("jdbc:mysql:///HotelManage","root","kutta123");
      s=c.createStatement();
      }catch(Exception e){
          e.printStackTrace();

      }
  }
}
