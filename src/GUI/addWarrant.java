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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class addWarrant {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String pass = "oop";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addWarrant window = new addWarrant();
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
	public addWarrant() {
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
		
		JLabel lblOffendersTrn = new JLabel("Offender's TRN:");
		lblOffendersTrn.setHorizontalAlignment(SwingConstants.CENTER);
		lblOffendersTrn.setBounds(71, 69, 116, 15);
		frame.getContentPane().add(lblOffendersTrn);
		
		JLabel lblNewLabel = new JLabel("Create Warrant");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(132, 12, 195, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Offence:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(71, 123, 116, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblTicketNumber = new JLabel("Ticket Number:");
		lblTicketNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketNumber.setBounds(81, 96, 106, 15);
		frame.getContentPane().add(lblTicketNumber);
		
		textField = new JTextField();
		textField.setBounds(205, 67, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 94, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 121, 114, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);
					
					String add = "INSERT INTO warrant(TRN, Offence, TicketNum)" + "VALUE(?, ?, ?)";
					
					PreparedStatement insert = conn.prepareStatement(add);
					insert.setString(1, textField.getText());
					insert.setString(2, textField_2.getText());
					insert.setString(3, textField_1.getText());
					
					insert.execute();
					insert.close();
					
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Success!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Generate Warrant!");
				}
			}
		});
		btnNewButton.setBounds(155, 180, 117, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
