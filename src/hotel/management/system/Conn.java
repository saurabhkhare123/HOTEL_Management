package hotel.management.system;

import java.sql.*;

public class Conn {
  Connection c;
  Statement s;

  public Conn(){
      try{

          Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms?serverTimezone=UTC", "root", "");
      s=c.createStatement();
      }catch(Exception e){
          e.printStackTrace();

      }
  }
}
