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

public class updateCommuter {

	private JFrame frame;
	private final JLabel lblUpdateCommuter = new JLabel("Update Commuter");
	private JTextField search;
	private JTextField TRN;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField plate_number;
	private JTextField DOB;
	private JTextField password;
	private boolean found;
	private JLabel lblEnterTrnFor;	
	private String pass = "oop";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateCommuter window = new updateCommuter();
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
	public updateCommuter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblUpdateCommuter.setBounds(174, 11, 181, 31);
		frame.getContentPane().add(lblUpdateCommuter);
		lblUpdateCommuter.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateCommuter.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Trn:");
		lblNewLabel.setBounds(10, 146, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setBounds(137, 146, 61, 14);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setBounds(318, 146, 61, 14);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblPlatenumber = new JLabel("Plate Number:");
		lblPlatenumber.setBounds(10, 219, 74, 14);
		frame.getContentPane().add(lblPlatenumber);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(154, 219, 74, 14);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(318, 219, 61, 14);
		frame.getContentPane().add(lblPassword);
		
			
		search = new JTextField();
		search.setBounds(219, 73, 86, 20);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		TRN = new JTextField();
		TRN.setBounds(37, 143, 86, 20);
		frame.getContentPane().add(TRN);
		TRN.setColumns(10);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(198, 143, 101, 20);
		frame.getContentPane().add(firstname);
		
		
		lastname = new JTextField();
		lastname.setBounds(378, 143, 86, 20);
		frame.getContentPane().add(lastname);
		lastname.setColumns(10);
		
		
		plate_number = new JTextField();
		plate_number.setBounds(79, 216, 61, 20);
		frame.getContentPane().add(plate_number);
		plate_number.setColumns(10);
		
		DOB = new JTextField();
		DOB.setBounds(219, 216, 86, 20);
		frame.getContentPane().add(DOB);
		DOB.setColumns(10);
		
		password = new JTextField();
		password.setBounds(378, 216, 86, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					
					//Retrieve record into JtTextBoxes		
				
					String rec = "Select * FROM commuter";
					
					PreparedStatement st = conn.prepareStatement(rec);
					
					ResultSet rs = st.executeQuery(rec);
					
					Object[] row= new Object[6];				
					
				do
				{	
					row[0] = TRN.getText();
					row[1] = firstname.getText();
					row[2] = lastname.getText();
					row[3] = plate_number.getText();
					row[4] = DOB.getText();
					row[5] = password.getText();	
				
					
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
					String update = "UPDATE commuter set TRN = '"+TRN.getText()+"', Firstname = '"+firstname.getText()+"' ,"
													 + " Lastname = '"+lastname.getText()+"', PlateNumber = '"+plate_number.getText()+"',"
													 + " DOB = '"+DOB.getText()+"' WHERE TRN = '"+search.getText()+"' ";
					
					PreparedStatement update_db = conn.prepareStatement(update);
					update_db.execute(update);
					
					
					String update_Login = "UPDATE commuter_logins set TRN = '"+TRN.getText()+"', Password = '"+password.getText()+"' "
										+ "Where TRN = '"+search.getText()+"' ";
					
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
		btnUpdate.setBounds(210, 268, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		lblEnterTrnFor = new JLabel("Enter trn for Commuter to Update:");
		lblEnterTrnFor.setBounds(37, 76, 191, 14);
		frame.getContentPane().add(lblEnterTrnFor);
						
	}
}
