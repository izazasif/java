import java.sql.*;

class Mysql{
  public	Mysql(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			Statement stmt = con.createStatement();
			 String username = "user";
			 String password = "22222";
		     int id		= 1;
		  String sql = "INSERT INTO `user`(`id`, `username`, `password`) VALUES ("+id+",'"+username+"',"+"'"+password+"')";
			
			
			
			int a = stmt.executeUpdate(sql);
			System.out.println(a);
			con.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
  }
}