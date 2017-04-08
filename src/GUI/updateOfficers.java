package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class updateOfficers {

	private JFrame frame;
	private JTextField search;
	private JTextField badge;
	private JTextField fname;
	private JTextField lname;
	private JTextField prec;
	private JTextField Pass;
	private boolean found;
	
	private String pass = "oop";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateOfficers window = new updateOfficers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateOfficers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUpdateOfficers = new JLabel("Update Officers");
		lblUpdateOfficers.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateOfficers.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUpdateOfficers.setBounds(132, 11, 181, 31);
		frame.getContentPane().add(lblUpdateOfficers);
		
		JLabel lblNewLabel = new JLabel("Badge:");
		lblNewLabel.setBounds(129, 138, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBounds(32, 193, 59, 14);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(225, 193, 59, 14);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblPrecinct = new JLabel("Precinct:");
		lblPrecinct.setBounds(32, 248, 46, 14);
		frame.getContentPane().add(lblPrecinct);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(225, 248, 59, 14);
		frame.getContentPane().add(lblPassword);
		
		search = new JTextField();
		search.setBounds(211, 67, 134, 20);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		badge = new JTextField();
		badge.setBounds(173, 135, 114, 20);
		frame.getContentPane().add(badge);
		badge.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(88, 190, 114, 20);
		frame.getContentPane().add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(283, 190, 114, 20);
		frame.getContentPane().add(lname);
		
		prec = new JTextField();
		prec.setColumns(10);
		prec.setBounds(88, 245, 114, 20);
		frame.getContentPane().add(prec);
		
		Pass = new JTextField();
		Pass.setColumns(10);
		Pass.setBounds(283, 245, 114, 20);
		frame.getContentPane().add(Pass);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					
					//Retrieve record into JtTextBoxes		
				
					String rec = "Select * FROM officer";
					
					PreparedStatement st = conn.prepareStatement(rec);
					
					ResultSet rs = st.executeQuery(rec);
					
					Object[] row= new Object[5];				
					
				do
				{	
					row[0] = badge.getText();
					row[1] = fname.getText();
					row[2] = lname.getText();
					row[3] = prec.getText();
					row[4] = Pass.getText();
									
					
					if(row[0].equals(search))
					{
						System.out.println("Is the same");
						found = true;
						break;
					}
					
					else
					{
						System.out.println("Is not the sane");
						found = false;
					}
					
				}while(rs.next());
					
				
				if(found== true)
				{
					String update = "UPDATE officer set Badge = '"+badge.getText()+"', Firstname = '"+fname.getText()+"' ,"
												 + " Lastname = '"+lname.getText()+"', prec = '"+prec.getText()+"' WHERE TRN = '"+search.getText()+"' ";
					
					PreparedStatement update_db = conn.prepareStatement(update);
					update_db.execute(update);
					
					
					String update_Login = "UPDATE officer_logins set Badge = '"+badge.getText()+"', Password = '"+Pass.getText()+"' "
										+ "Where Badge = '"+search.getText()+"' ";
					
					PreparedStatement update_login = conn.prepareStatement(update_Login);
					update_login.execute(update_Login);
				}
				
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Record Updated!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Update Record!");
				}
			}
		});
		btnNewButton.setBounds(173, 299, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblEnterBadgeOf = new JLabel("Enter badge of Officer to be Updated:");
		lblEnterBadgeOf.setBounds(21, 70, 195, 14);
		frame.getContentPane().add(lblEnterBadgeOf);
		
		
	}

}
