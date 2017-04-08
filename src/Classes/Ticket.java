package Classes;

import java.sql.*;
import java.util.Calendar;

public class Ticket {

//	public static int count = 1000;
//	public int ticketNum;
	User offender;

	Commuter offenderCar;
	public String description;
	public String location;
	public Float totalDue;
	User officer;
	Officer officerInfo;
	private String pass;

	public Ticket() {
//		ticketNum = count();
		offender = new User();
		offenderCar = new Commuter();
		description = "";
		location = "";
		totalDue = (float) 0;
		officer = new User();
		officerInfo = new Officer();
		pass = "oop";
	}

	public Ticket(int ticketNum, User offender, Commuter offenderCar, String description,
			String location, Float totalDue, User officer, Officer officerInfo) {
//		this.ticketNum = ticketNum;
		this.offender = offender;

		this.offenderCar = offenderCar;
		this.description = description;
		this.location = location;
		this.totalDue = totalDue;
		this.officer = officer;
		this.officerInfo = officerInfo;
	}

//	public int count() {
//		return count++;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Float totalDue) {
		this.totalDue = totalDue;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void addTicket() {
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			String add = "INSERT INTO ticket(Description, Location, TotalDue, TRN, Badge, IssueDate, CourtDate)"
					+ "VALUE(?, ?, ?, ?, ?, ?, ?)";

			String update = "UPDATE ticket SET CourtDate = DATE_ADD(IssueDate, INTERVAL 3 MONTH)";

			Calendar now = Calendar.getInstance();
			java.sql.Date issueDate = new java.sql.Date(now.getTime().getTime());

			PreparedStatement insert = conn.prepareStatement(add);
			PreparedStatement mod = conn.prepareStatement(update);

			insert.setString(1, "Driving");
			insert.setString(2, "MayPen");
			insert.setFloat(3, 2500);
			insert.setString(4, "123456");
			insert.setInt(5, 5000);
			insert.setDate(6, issueDate);
			insert.setDate(7, issueDate);

			insert.execute();
			mod.execute();

			insert.execute();
			insert.close();

		} catch (SQLException ex) {
			System.err.println("Error - Unable To Generate Ticket");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}

	public Object[][] viewAllTicket() {
		Object[][] ticketInfo = new Object[15][9];
		int cnt = 0;
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			Statement st = conn.createStatement();

			String quer = "SELECT * FROM ticket";
			ResultSet rs = st.executeQuery(quer);

			while (rs.next()) {
				int ticketNum = rs.getInt(1);
				String trn = rs.getString(5);
				String offence = rs.getString(2);
				String location = rs.getString(3);
				Float total = rs.getFloat(4);
				int badge = rs.getInt(6);

				// Adding Data to Object
				ticketInfo[cnt][0] = rs.getString(1);
				ticketInfo[cnt][1] = rs.getString(2);
				ticketInfo[cnt][2] = rs.getString(3);
				ticketInfo[cnt][3] = rs.getString(4);
				ticketInfo[cnt][4] = rs.getString(5);
				ticketInfo[cnt][5] = rs.getString(6);
				ticketInfo[cnt][6] = rs.getString(7);
				ticketInfo[cnt][7] = rs.getString(8);
				ticketInfo[cnt][8] = rs.getString(9);
				cnt++;
//
//				System.out.println(
//						ticketNum + " " + trn + " " + offence + " " + location + " " + total + " " + " " + badge);
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println("Error - Unable To Generate Ticket List");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
		return ticketInfo;
	}

	public Object[][] viewTRNTicket(int trn) {
		Object[][] ticketInfo = new Object[15][10];
		int cnt = 0;
		String thing = null;
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			Statement st = conn.createStatement();
			// PreparedStatement state = conn.prepareStatement("SELECT * FROM
			// Ticket WHERE TRN = ?");

			// state.setString(trn, thing);
			String quer = "SELECT * FROM ticket WHERE TRN = '" + trn + "'";
			ResultSet rs = st.executeQuery(quer);

			while (rs.next()) {

				int ticketNum = rs.getInt(1);
				String trnn = rs.getString(5);
				String offence = rs.getString(2);
				String location = rs.getString(3);
				Float total = rs.getFloat(4);
				int badge = rs.getInt(6);

				// Adding Data to Object
				ticketInfo[cnt][0] = rs.getString(1);
				ticketInfo[cnt][1] = rs.getString(2);
				ticketInfo[cnt][2] = rs.getString(3);
				ticketInfo[cnt][3] = rs.getString(4);
				ticketInfo[cnt][4] = rs.getString(5);
				ticketInfo[cnt][5] = rs.getString(6);
				ticketInfo[cnt][6] = rs.getString(7);
				ticketInfo[cnt][7] = rs.getString(8);
				ticketInfo[cnt][8] = rs.getString(9);
				cnt++;

//				System.out.println(
//						ticketNum + " " + trnn + " " + offence + " " + location + " " + total + " " + " " + badge);
			}

		} catch (SQLException ex) {
			System.out.println("Error - Unable To Generate Ticket List");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
		return ticketInfo;
	}

	public void makePayment(int tnum) {
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);
			
			Statement st = conn.createStatement();
			// PreparedStatement state = conn.prepareStatement("SELECT * FROM
			// Ticket WHERE TRN = ?");

			
			String quer = "UPDATE ticket SET TotalDue = 0, Stat = 1 WHERE TicketNum = '" + tnum + "'";
						
			PreparedStatement insert = conn.prepareStatement(quer);
			
			insert.executeUpdate();
		
		} catch (SQLException ex) {
			System.out.println("Error - Ticket Not Found");
			System.err.println(ex);
		} catch (Exception e) {
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
}