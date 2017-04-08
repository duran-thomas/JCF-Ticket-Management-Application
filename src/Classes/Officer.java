package Classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Officer extends User{
	
	public int badge;
	public String precinct;
	private String pass;
        
        
	
	public Officer(){
		badge = 00000;
		precinct = "";
		pass = "oop";
	}
	
	public Officer(int bdge, String prcnt){
		badge = bdge;
		precinct = prcnt;
	}

	public int getBadge() {
		return badge;
	}

	public void setBadge(int badge) {
		this.badge = badge;
	}

	public String getPrecinct() {
		return precinct;
	}

	public void setPrecinct(String precinct) {
		this.precinct = precinct;
	}
	
	public void addofficer(){
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			// Create Insert Statement
			String add = "INSERT INTO officer(FirstName, LastName, Precinct)"
					+ "VALUES(?, ?, ?)";
			
			PreparedStatement insert = conn.prepareStatement(add);
			insert.setString(1, "John");
			insert.setString(2, "Brown");
			insert.setString(3, "May Pen");
			
			insert.execute();
			insert.close();
			
		} catch (SQLException ex) {
			System.err.println("Error - Unable To Add New officer!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
	
	public void removeofficer(){
		try {
			// Establish Connection To Database
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

			// Create Insert Statement
			String del = "DELETE FROM officer WHERE Badge = ?";
			
			PreparedStatement remove = conn.prepareStatement(del);
			remove.setInt(1, 1234);
			
			remove.execute();
			remove.close();
			
		} catch (SQLException ex) {
			System.err.println("Error - Unable To Remove New officer!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
	}
        
        public boolean policeValidate(int bdge, String passW) {
            try {
                // Establish Connection To Database
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "oop", pass);
                
             
                Statement st = conn.createStatement();
			
			String logsql = "SELECT * FROM officer_logins";
			ResultSet rs = st.executeQuery(logsql);
                            while(rs.next()){
                                this.setBadge(rs.getInt("Badge"));
                                this.setPassword(rs.getString("Password"));
                                    if (this.getBadge() == bdge && this.getPassword().equals(passW)) {                                        
                                        return true;                                      
                                    }
                                    break;
                            }
                
                } catch (SQLException ex) {
			System.err.println("Error - Unable To Remove New officer!");
			System.err.println(ex);
		}catch (Exception e){
			System.err.println("Class Not Found");
			System.err.println(e);
		}
        return false;
    }
        
    public Object[][] viewOff() {
        Object[][] tmpofficer = new Object[8][8];
            try {
                // Establish Connection To Database
                String myDriver = "org.gjt.mm.mysql.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "oop", pass);
                int cnt = 0;
                Statement st = conn.createStatement();
			
                String logsql = "SELECT of.Badge, of.FirstName, of.LastName, of.Precinct, ol.Password FROM officer of INNER JOIN officer_logins ol ON of.Badge = ol.Badge";
		ResultSet rs = st.executeQuery(logsql);
                    while (rs.next()) {
                        tmpofficer[cnt][0] = rs.getString("Badge");
                        tmpofficer[cnt][1] = rs.getString("FirstName");
                        tmpofficer[cnt][2] = rs.getString("LastName");
                        tmpofficer[cnt][3] = rs.getString("Precinct");
                        tmpofficer[cnt][4] = rs.getString("Password");
                        cnt++;
                    }
                rs.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Officer.class.getName()).log(Level.SEVERE, null, ex);
            }
    return tmpofficer;
    }
    
    public Object[][] viewBadgeOfficer(int badge) {
		Object[][] officerInfo = new Object[15][10];
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
			String quer = "SELECT * FROM officer WHERE Badge = '" + badge + "'";
			ResultSet rs = st.executeQuery(quer);

			while (rs.next()) {

				int bdge = rs.getInt(1);
				String fname = rs.getString(5);
				String lname = rs.getString(2);
				String precinct = rs.getString(3);
				String pass = rs.getString(4);
				
				// Adding Data to Object
				officerInfo[cnt][0] = rs.getString(1);
				officerInfo[cnt][1] = rs.getString(2);
				officerInfo[cnt][2] = rs.getString(3);
				officerInfo[cnt][3] = rs.getString(4);
				officerInfo[cnt][4] = rs.getString(5);
				
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
		return officerInfo;
	}
    
    
}