package Classes;

import java.sql.*;

import java.util.*;

public class Login {
	// Commuter com;
	User log;
	private String pass;

	public Login() {
		// com = new Commuter();
		log = new User();
		pass = "oop";
	}

	public Login(String trn, String fn, String ln, String pass) {

		// com = new Commuter(trn, x, x, x);
		log = new User(fn, ln, pass);

	}

	public void createCommuterLogin() {
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			String add = "INSERT INTO commuter_Logins(TRN, Password)" + "VALUE(?, ?)";

			PreparedStatement insert = conn.prepareStatement(add);
			insert.setString(1, "123");
			insert.setString(2, "rans");

			insert.execute();
			insert.close();
		} catch (SQLException ex) {
			System.err.println("Error - Unable To Create Login!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
	
	public void removeCommuterLogin() {
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			String rem = "DELETE FROM commuter_Logins WHERE TRN = ?";

			PreparedStatement delete = conn.prepareStatement(rem);
			delete.setString(1, "123456");

			delete.execute();
			delete.close();
		} catch (SQLException ex) {
			System.err.println("Error - Unable To Delete Login!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
	
	public void createOfficerLogin() {
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			String add = "INSERT INTO officer_logins(Badge, Password)" + "VALUE(?, ?)";

			PreparedStatement insert = conn.prepareStatement(add);
			insert.setString(1, "5001");
			insert.setString(2, "1234");

			insert.execute();
			insert.close();
		} catch (SQLException ex) {
			System.err.println("Error - Unable To Create Login!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
}