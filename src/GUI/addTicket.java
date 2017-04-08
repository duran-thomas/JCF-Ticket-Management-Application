package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class addTicket {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String pass = "oop";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTicket window = new addTicket();
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
	public addTicket() {
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
		
		JLabel lblCreateTicket = new JLabel("Create Ticket");
		lblCreateTicket.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCreateTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateTicket.setBounds(110, 12, 201, 32);
		frame.getContentPane().add(lblCreateTicket);
		
		JLabel lblNewLabel = new JLabel("TRN:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 67, 96, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Offence:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(61, 97, 96, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Location:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(61, 124, 96, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Amount Due:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(61, 154, 96, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Badge #:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(71, 181, 86, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(175, 65, 148, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 95, 148, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 122, 148, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 152, 148, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(175, 179, 148, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

						insert.setString(1, textField_1.getText());
						insert.setString(2, textField_2.getText());
						insert.setString(3, textField_3.getText());
						insert.setString(4, textField.getText());
						insert.setString(5, textField_4.getText());
						insert.setDate(6, issueDate);
						insert.setDate(7, issueDate);

						insert.execute();
						mod.execute();

						insert.execute();
						insert.close();

						Component rootPane = null;
						JOptionPane.showMessageDialog(rootPane, "Ticket Generated");
					} catch (Exception ex) {
						Component rootPane = null;
						JOptionPane.showMessageDialog(rootPane, "Unable To Generate Ticket");
					}
					
				}
		});
		btnNewButton.setBounds(175, 222, 117, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
