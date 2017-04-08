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

public class removeRecord {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String pass = "oop";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					removeRecord window = new removeRecord();
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
	public removeRecord() {
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
		
		JLabel lblRemoveRecord = new JLabel("Remove Record");
		lblRemoveRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveRecord.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRemoveRecord.setBounds(119, 0, 206, 29);
		frame.getContentPane().add(lblRemoveRecord);
		
		JLabel lblCommuter = new JLabel("Commuter");
		lblCommuter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommuter.setBounds(55, 41, 106, 15);
		frame.getContentPane().add(lblCommuter);
		
		JLabel lblOfficer = new JLabel("Officer");
		lblOfficer.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfficer.setBounds(270, 41, 106, 15);
		frame.getContentPane().add(lblOfficer);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicket.setBounds(61, 146, 106, 15);
		frame.getContentPane().add(lblTicket);
		
		JLabel lblWarrant = new JLabel("Warrant");
		lblWarrant.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarrant.setBounds(270, 146, 106, 15);
		frame.getContentPane().add(lblWarrant);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					String dellog = "DELETE FROM commuter_logins WHERE TRN = ?";
					String del = "DELETE FROM commuter WHERE TRN = ?";
					
					PreparedStatement remlog = conn.prepareStatement(dellog);
					PreparedStatement remove = conn.prepareStatement(del);
					remlog.setString(1, textField.getText());
					remove.setString(1, textField.getText());
					
					remlog.execute();
					remove.execute();
					remove.close();
					remlog.close();
					
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Commuter Removed!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Remove Commuter!");
				}
			}
		});
		btnRemove.setBounds(61, 94, 117, 25);
		frame.getContentPane().add(btnRemove);
		
		textField = new JTextField();
		textField.setText("Enter TRN");
		textField.setBounds(34, 63, 156, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter Badge #");
		textField_1.setColumns(10);
		textField_1.setBounds(245, 63, 156, 19);
		frame.getContentPane().add(textField_1);
		
		JButton button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					String dellog = "DELETE FROM officer_logins WHERE Badge = ?";
					String del = "DELETE FROM officer WHERE Badge = ?";
					
					PreparedStatement remlog = conn.prepareStatement(dellog);
					PreparedStatement remove = conn.prepareStatement(del);
					remlog.setString(1, textField_1.getText());
					remove.setString(1, textField_1.getText());
					
					remlog.execute();
					remove.execute();
					remove.close();
					remlog.close();
					
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Officer Removed!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Remove Officer!");
				}
			}
		});
		button.setBounds(270, 94, 117, 25);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Remove");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					String del = "DELETE FROM ticket WHERE TicketNum = ?";
					
					PreparedStatement remove = conn.prepareStatement(del);
					remove.setString(1, textField_2.getText());
					
					remove.execute();
					remove.close();
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Ticket Removed!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Remove Ticket!");
				}
			}
		});
		button_1.setBounds(61, 199, 117, 25);
		frame.getContentPane().add(button_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Enter Ticket Number");
		textField_2.setColumns(10);
		textField_2.setBounds(35, 168, 155, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Enter Ticket Number");
		textField_3.setColumns(10);
		textField_3.setBounds(245, 168, 156, 19);
		frame.getContentPane().add(textField_3);
		
		JButton button_2 = new JButton("Remove");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Establish Connection To Database
					String myDriver = "org.gjt.mm.mysql.Driver";
					String myUrl = "jdbc:mysql://localhost:3306/JCF?autoReconnect=true&useSSL=false";
					Class.forName(myDriver);
					Connection conn = DriverManager.getConnection(myUrl, "oop", pass);

					// Create Insert Statement
					String del = "DELETE FROM warrant WHERE TicketNum = ?";
					
					PreparedStatement remove = conn.prepareStatement(del);
					remove.setString(1, textField_3.getText());
					
					remove.execute();
					remove.close();
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Warrant Removed!");
				} catch (Exception ex) {
					Component rootPane = null;
					JOptionPane.showMessageDialog(rootPane, "Unable To Remove Warrant!");
				}
			}
		});
		button_2.setBounds(270, 199, 117, 25);
		frame.getContentPane().add(button_2);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        
			}
		});
		btnClose.setBounds(194, 236, 73, 25);
		frame.getContentPane().add(btnClose);
	}
}
