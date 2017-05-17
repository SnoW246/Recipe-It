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
import javax.swing.JPasswordField;

public class Login {

	private JFrame loginFrame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					login.getLoginFrame().setLocationRelativeTo(null);
					login.getLoginFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		txtPassword = new JPasswordField();
		txtPassword.setText("***********");
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setToolTipText("Please enter your password");
		txtPassword.setBounds(462, 199, 207, 20);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSignin = new JButton("Sign-in");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Setting up connection to the database
					// Create MySQL database connection
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password=");     
					Statement state = c.createStatement();
					
					// Declaration of query statement for the database
					String query = "SELECT username, password from user_credentials";
					// Declaration of result set & initialisation of the statement
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
			        		if(userPass.equals(txtPassword.getPassword())){
			        			// Create new instance of menu frame
			        			Menu menu = new Menu();
			        			// Set the location of the frame to centre
			        			menu.getMenuFrame().setLocationRelativeTo(null);
			        			// Set the frame to be visible
			        			menu.getMenuFrame().setVisible(true);
			        			// Disposal of login frame
			        			getLoginFrame().dispose();
			        		}// End of if
			        	}// End of if
			        	else{
		        			flag = 2;
		        		}// End of else
					}// End of while
					
					if(flag == 2){
						JOptionPane.showMessageDialog(null,"Input of credentials is incorrect! ", "\nPlease try again.",JOptionPane.ERROR_MESSAGE,null);
						flag = 1;
					}// End of if
					
					// Closing all connections
					state.close();
					c.close();
				}// End of try
				
				catch(SQLException ex) {
					ex.printStackTrace();
				} // end catch
				
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

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(JFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
}
