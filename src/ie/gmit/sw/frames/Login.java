package ie.gmit.sw.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	private JFrame loginFrame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	// Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Construct new instance of login frame
					Login login = new Login();
					// Get new login frame & set its location to centre
					login.getLoginFrame().setLocationRelativeTo(null);
					// Set the login frame to be visible
					login.getLoginFrame().setVisible(true);
				}// End of try
				catch (Exception e) {
					e.printStackTrace();
				}// End of catch
			}// End of run
		});// End of Runnable
	}// End of main


	// Create the application
	public Login() {
		// Initialize all components
		initialize();
	}// End of Login


	// Initialization of the contents of the frame
	private void initialize() {
		setLoginFrame(new JFrame());
		getLoginFrame().setTitle("Recipe-It");
		getLoginFrame().setForeground(Color.WHITE);
		getLoginFrame().setFont(new Font("Cambria", Font.BOLD, 14));
		getLoginFrame().setBounds(100, 100, 762, 391);
		getLoginFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getLoginFrame().getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Recipe-It");
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 34));
		lblWelcome.setBounds(392, 11, 344, 59);
		panel.add(lblWelcome);
		
		JLabel lblUnderline = new JLabel("____________________________");
		lblUnderline.setBackground(new Color(255, 0, 0));
		lblUnderline.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnderline.setForeground(Color.RED);
		lblUnderline.setFont(new Font("Cambria", Font.BOLD, 30));
		lblUnderline.setBounds(402, 33, 329, 51);
		panel.add(lblUnderline);
		
		JLabel lblInstructions = new JLabel("Please sign-in or register ");
		lblInstructions.setForeground(new Color(255, 255, 255));
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		lblInstructions.setBounds(402, 65, 329, 43);
		panel.add(lblInstructions);
		
		JLabel lblInstructions2 = new JLabel("\nbelow and get cooking...");
		lblInstructions2.setForeground(new Color(255, 255, 255));
		lblInstructions2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		lblInstructions2.setBounds(402, 107, 329, 43);
		panel.add(lblInstructions2);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setToolTipText("Please enter your username");
		txtUsername.setText("Username");
		txtUsername.setBounds(462, 168, 207, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setToolTipText("Please enter your password");
		txtPassword.setBounds(462, 199, 207, 20);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSignin = new JButton("Sign-in");
		// Declaration of action listener on a sign-in button
		btnSignin.addActionListener(new ActionListener() {
			// Declaration of event handler for when action on the button is performed
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Creating MySQL database connection using java database connectivity driver
					Class.forName("com.mysql.jdbc.Driver");
					// Defining the connection
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password=");     
					// Declaration of a create statement
					Statement state = c.createStatement();
					
					// Declaration of query statement for the database
					String query = "SELECT username, password FROM users";
					// Declaration of result set, initialisation & execution of the statement
			        ResultSet rs = state.executeQuery(query);
			        
			        // Declaration of local variables for later use
			        String userName, userPass;
			        // Declaration of control variable
			        int flag = 1;
					
			        // Result set query result
					while(rs.next()){
						flag = 1;
						// Initialisation of the local variables with values returned from database
						userName = rs.getString("username");
						userPass = rs.getString("password");
			        	
						// Comparison of result set for user name with login input
			        	if(userName.equals(txtUsername.getText())){
			        		// Comparison of result set for user password with login input
			        		if(userPass.equals(txtPassword.getText())){
			        			// Create new instance of menu frame
			        			Menu menuFrame = new Menu();
			        			// Get the menu frame and set the location of the frame to the centre
			        			menuFrame.getMenuFrame().setLocationRelativeTo(null);
			        			// Set the menu frame to be visible
			        			menuFrame.getMenuFrame().setVisible(true);
			        			// Disposal of login frame
			        			getLoginFrame().dispose();
			        		}// End of if
			        	}// End of if
			        	else{
			        		// set control variable to 2 for when condition is else
		        			flag = 2;
		        		}// End of else
					}// End of while
					
					// Declaration of statement for when credentials are invalid
					if(flag == 2){
						// SHow message dialog and display message to inform user about the event
						JOptionPane.showMessageDialog(null,"Input of credentials is incorrect! ", "\nPlease try again.",JOptionPane.ERROR_MESSAGE,null);
						// Set Control variable back to initial value
						flag = 1;
					}// End of if
					
					// Closing all connections
					state.close();
					c.close();
				}// End of try
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}// end catch
				
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}// End of catch
			}// End of event handler
		});// End of action listener
		btnSignin.setBorder(null);
		btnSignin.setToolTipText("Sign-in if an existing user");
		btnSignin.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnSignin.setOpaque(false);
		btnSignin.setBounds(462, 230, 207, 23);
		panel.add(btnSignin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Create new instance of Register Frame
				Register register = new Register();
				// Get register frame and set its position to centre
				register.getRegisterFrame().setLocationRelativeTo(null);
				// Get register frame and set it to visible
				register.getRegisterFrame().setVisible(true);
				// Disposal of login frame 
				getLoginFrame().dispose();
			}// End of event handler
		});// End of action listener
		btnRegister.setBorder(null);
		btnRegister.setToolTipText("Register a new user");
		btnRegister.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnRegister.setOpaque(false);
		btnRegister.setBounds(462, 264, 207, 23);
		panel.add(btnRegister);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 750, 356);
		lblBackground.setIcon(new ImageIcon(Login.class.getResource("/ie/gmit/sw/resources/Recipe-It Login.png")));
		lblBackground.setFont(new Font("Cambria", Font.BOLD, 20));
		panel.add(lblBackground);
	}
	
	// Get login frame function to get instance of this current frame
	public JFrame getLoginFrame() {
		// Return login for instance
		return loginFrame;
	}// End of getLoginFrame
	
	// Set login frame function to set the instance of this current frame
	public void setLoginFrame(JFrame loginFrame) {
		// set the instance to private variable
		this.loginFrame = loginFrame;
	}// End of setLoginFrame
}// End of Login
