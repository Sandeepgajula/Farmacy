package projects;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrationForm {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
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
	public RegistrationForm() {
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
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(35, 41, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(35, 72, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 107, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(91, 38, 86, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(91, 69, 86, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(91, 104, 86, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(120, 160, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get values from text fields
				String name = textFieldName.getText();
				String email = textFieldEmail.getText();
				String password = textFieldPassword.getText();
				
				// Connect to the database
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					// Load the JDBC driver
					Class.forName("com.mysql.jdbc.Driver");
					
					// Open a connection to the database
					connection = DriverManager.getConnection("jdbc:mysql:///cse","root","rgukt123");
					
					// Create a prepared statement to insert data into the database
					preparedStatement = connection.prepareStatement("INSERT INTO chart(name,email,password) VALUES (?,?,?)");
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, email);
					preparedStatement.setString(3, password);
					
					// Execute the prepared statement
					preparedStatement.executeUpdate();
					
					// Show success message
					JOptionPane.showMessageDialog(null, "User registered successfully");
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					// Close the prepared statement and the connection
					try {
						if (preparedStatement != null) {
							preparedStatement.close();
						}
						
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
	}

}

