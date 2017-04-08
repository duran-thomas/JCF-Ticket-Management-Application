package Classes;

import java.sql.*;

public class Warrant {
	
	Commuter offender;
	Ticket offence;
	private String pass = "oop";
	
	public Warrant(){
		
		offence = new Ticket();
		offender = new Commuter();
	}
	
	public void addWarrant(){
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);
			
			String add = "INSERT INTO warrant(TRN, Offence)" + "VALUE(?, ?)";
			
			PreparedStatement insert = conn.prepareStatement(add);
			insert.setString(1, "123");
			insert.setString(2, "Speed");
			
			insert.execute();
			insert.close();
			
		} catch (SQLException ex) {
			System.err.println("ERROR - Could Not Add Warrant!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
	
	public void removeWarrant(){
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			String del = "DELETE FROM warrant WHERE TRN = ?";

			PreparedStatement remove = conn.prepareStatement(del);
			remove.setString(1, "123456");
			
			remove.execute();
			remove.close();

		} catch (SQLException ex) {
			System.err.println("ERROR - Could Not Remove Warrant!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}

	public Object[][] viewWarrants() {
            Object[][] warrantInfo = new Object[5][8];
            int cnt = 0;
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			String ret = "SELECT * FROM warrant";
			
			Statement retrieve = conn.createStatement();
			
			ResultSet rs = retrieve.executeQuery(ret);
			
			while(rs.next()){
				String trn = rs.getString("TRN");
				String off = rs.getString("Offence");
				String tnum = rs.getString("TicketNum");
                                
                                warrantInfo[cnt][0] = rs.getString("TRN");
                                warrantInfo[cnt][1] = rs.getString("Offence");
                                warrantInfo[cnt][2] = rs.getString("TicketNum");
				cnt++;
//				System.out.println("TRN: " + trn + " Offence: " + off);
			}
			retrieve.close();
		} catch (SQLException ex) {
			System.err.println("ERROR - Unable To Retrieve Warrant List");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
        return warrantInfo;
	}
}
