import java.sql.*;
import java.util.ResourceBundle;

class Main {
  public static void main(String args[]) {
    try {
      ResourceBundle rb = ResourceBundle.getBundle("config");
      Class.forName(rb.getString("dbdriver"));
      // DriverManager.registerDriver(new sqlserver.EncpsulatedMSSQLDriver());
      DriverManager.getConnection(rb.getString("dburl"), rb.getString("dbuser"), rb.getString("dbpassword"));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
