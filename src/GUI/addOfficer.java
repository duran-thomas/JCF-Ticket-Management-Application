package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class addOfficer {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String pass = "oop";
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addOfficer window = new addOfficer();
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
	public addOfficer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstname = new JLabel("First Name:");
		lblFirstname.setBounds(97, 86, 89, 15);
		frame.getContentPane().add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setBounds(97, 110, 89, 15);
		frame.getContentPane().add(lblLastname);
		
		JLabel lblPrecinct = new JLabel("Precinct:");
		lblPrecinct.setBounds(97, 137, 70, 15);
		frame.getContentPane().add(lblPrecinct);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(97, 164, 89, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblBadge = new JLabel("Badge:");
		lblBadge.setBounds(97, 61, 89, 15);
		frame.getContentPane().add(lblBadge);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(204, 59, 114, 19);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 84, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 111, 114, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(204, 135, 114, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(204, 162, 114, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					String add = "INSERT INTO officer(Badge, FirstName, LastName, Precinct)"
							+ "VALUES(?, ?, ?, ?)";
					
					String addLogin = "INSERT INTO officer_logins(Badge, Password)"
							+ "VALUES(?, ?)";
					
					PreparedStatement insert = conn.prepareStatement(add);
					insert.setString(1, textField.getText());
					insert.setString(2, textField_1.getText());
					insert.setString(3, textField_2.getText());
					insert.setString(4, textField_3.getText());
					
					PreparedStatement insertLogin = conn.prepareStatement(addLogin);
					insertLogin.setString(1, textField.getText());
					insertLogin.setString(2, textField_4.getText());
					
					insert.execute();
					insertLogin.execute();
					insertLogin.close();
					insert.close();
					
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Success!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Add New Officer Account!");
				}
			}
		});
		btnCreate.setBounds(169, 218, 117, 25);
		frame.getContentPane().add(btnCreate);
		
		lblNewLabel = new JLabel("Add Officer");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(169, 12, 149, 35);
		frame.getContentPane().add(lblNewLabel);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
