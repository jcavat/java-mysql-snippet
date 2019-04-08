package ch.hepia;

//STEP 1. Import required packages
import java.sql.*;

public class App {
   // JDBC driver name and database URL
   static final String driver = "com.mysql.cj.jdbc.Driver";
   static final String dbUrl = "jdbc:mysql://localhost:3306/conf?useSSL=false";

   // Database credentials
   static final String user = "root";
   static final String pass = "test";

   public static void main(String[] args) throws ClassNotFoundException {

      Class.forName(driver);

      try (Connection con = DriverManager.getConnection(dbUrl, user, pass);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Conference");
            ResultSet rs = ps.executeQuery()) {

         while (rs.next()) {
            int id = rs.getInt("id_conference");
            String name = rs.getString("name");
            String price = rs.getString("price");
            System.out.println(id + ": " + name + ", " + price);
         }
         System.out.println("Goodbye");
      } catch (SQLException e) {
         e.printStackTrace();
     }
   }
}