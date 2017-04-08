package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class addCommuter {

	private JFrame frame;
	private String pass = "oop";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCommuter window = new addCommuter();
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
	public addCommuter() {
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
		
		JLabel lblAddCommuter = new JLabel("Add Commuter");
		lblAddCommuter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCommuter.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAddCommuter.setBounds(130, 12, 190, 25);
		frame.getContentPane().add(lblAddCommuter);
		
		JLabel lblFirstName = new JLabel("TRN:");
		lblFirstName.setBounds(77, 49, 100, 15);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("First Name");
		lblLastName.setBounds(77, 78, 100, 15);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Last Name:");
		lblDateOfBirth.setBounds(77, 105, 100, 15);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblTrn = new JLabel("Plate Number:");
		lblTrn.setBounds(77, 132, 115, 15);
		frame.getContentPane().add(lblTrn);
		
		JLabel lblPlateNumber = new JLabel("Date Of Birth:");
		lblPlateNumber.setBounds(77, 161, 115, 15);
		frame.getContentPane().add(lblPlateNumber);
		
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
						String add = "INSERT INTO commuter(TRN, FirstName, LastName, PlateNumber, DOB)" + "VALUES(?, ?, ?, ?, ?)";
						
						String addLogin = "INSERT INTO commuter_logins(TRN, Password)"
								+ "VALUES(?, ?)";
						PreparedStatement insert = conn.prepareStatement(add);
						insert.setString(1, textField.getText());
						insert.setString(2, textField_1.getText());
						insert.setString(3, textField_2.getText());
						insert.setString(4, textField_3.getText());
						insert.setString(5, textField_4.getText());
						
						PreparedStatement insertLogin = conn.prepareStatement(addLogin);
						insertLogin.setString(1, textField.getText());
						insertLogin.setString(2, textField_5.getText());

						// Execute Insert Statement
						insert.execute();
						insertLogin.execute();

						// Close Connection
						insert.close();
						insertLogin.close();
						conn.close();

						Component rootPane = null;
						JOptionPane.showMessageDialog(rootPane, "Success!");
					} catch (Exception ex) {
						Component rootPane = null;
						JOptionPane.showMessageDialog(rootPane, "Unable To Add New Commuter Account!");
					}
				}
		});
		btnCreate.setBounds(165, 224, 117, 25);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(77, 188, 115, 15);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(206, 49, 136, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 76, 136, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 103, 136, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 130, 136, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(206, 157, 136, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(206, 186, 136, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
	}
}
