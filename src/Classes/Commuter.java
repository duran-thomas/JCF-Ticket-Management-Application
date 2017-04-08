package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Commuter extends User {

	public String TRN;
	public String plateNumber;
	User commuter;
	private String pass;

	public Commuter() {
		TRN = "";
		plateNumber = "";
		pass = "oop";
	}

	public Commuter(String TRN, String plateNumber, User commuter, String pass) {
		this.TRN = TRN;
		this.plateNumber = plateNumber;
		this.commuter = commuter;
		this.pass = pass;
	}

	public Commuter(String TRN, String plateNumber, User commuter, String pass, String fn, String ln, String pword) {
		super(fn, ln, pword);
		this.TRN = TRN;
		this.plateNumber = plateNumber;
		this.commuter = commuter;
		this.pass = pass;
	}

	public String getTRN() {
		return TRN;
	}

	public void setTRN(String TRN) {
		this.TRN = TRN;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public User getcommuter() {
		return commuter;
	}

	public void setcommuter(User commuter) {
		this.commuter = commuter;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addcommuter() {
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			// Create Insert Statement
			String add = "INSERT INTO commuter(TRN, FirstName, LastName, PlateNumber)" + "VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement insert = conn.prepareStatement(add);
			insert.setString(1, "123");
			insert.setString(2, "Random");
			insert.setString(3, "Name");
			insert.setString(4, "1234DC");

			// Execute Insert Statement
			insert.execute();

			// Close Connection
			conn.close();

		} catch (SQLException ex) {
			System.err.println("Error - Unable To Add New commuter!");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}

	public void removecommuter() {
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			// Create Insert Statement
			String remove = "DELETE FROM commuter WHERE TRN = ?";
			PreparedStatement del = conn.prepareStatement(remove);
			del.setString(1, "123456");

			// Execute Insert Statement
			del.execute();

			// Close Connection
			conn.close();

		} catch (SQLException ex) {
			System.err.println("Error - Unable To Remove commuter!");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}

	public ArrayList<Commuter> viewCommutor(String trn) { // Im passing in a trn
															// to get related
															// data from the DB
		ArrayList<Commuter> commutorInfo = new ArrayList<Commuter>();
		int cnt = 0;
		String thing = null;
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			Statement st = conn.createStatement();
			String quer = "SELECT * FROM commuter WHERE TRN = '" + trn + "'";
			ResultSet rs = st.executeQuery(quer);

			while (rs.next()) {
				Commuter com = new Commuter();
				// Adding Data to Object
				com.setTRN(rs.getString("TRN"));
				com.setFirstName(rs.getString("FirstName"));
				com.setLastName(rs.getString("LastName"));
				com.setPlateNumber(rs.getString("PlateNumber"));
				commutorInfo.add(com);
				cnt++;
			}
		} catch (SQLException ex) {
			System.out.println("Error - Unable To Generate Ticket List");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
		return commutorInfo;
	}

	public Object[][] viewcommuter() {
		Object[][] tmpOfficer = new Object[12][6];
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);
			int cnt = 0;
			Statement st = conn.createStatement();

			String logsql = "SELECT co.TRN, co.FirstName, co.LastName, co.PlateNumber, co.DOB, col.Password FROM commuter co INNER JOIN commuter_logins col ON co.TRN = col.TRN";
			ResultSet rs = st.executeQuery(logsql);
			while (rs.next()) {
				tmpOfficer[cnt][0] = rs.getString("TRN");
				tmpOfficer[cnt][1] = rs.getString("FirstName");
				tmpOfficer[cnt][2] = rs.getString("LastName");
				tmpOfficer[cnt][3] = rs.getString("PlateNumber");
				tmpOfficer[cnt][4] = rs.getString("DOB");
				tmpOfficer[cnt][5] = rs.getString("Password");
				cnt++;
			}
			rs.close();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tmpOfficer;
	}
}