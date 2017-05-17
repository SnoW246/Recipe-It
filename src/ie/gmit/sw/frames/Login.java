package ie.gmit.sw.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Login {

	private JFrame frmRecipeit;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmRecipeit.setVisible(true);
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
		frmRecipeit = new JFrame();
		frmRecipeit.setTitle("Recipe-It");
		frmRecipeit.setForeground(Color.WHITE);
		frmRecipeit.setFont(new Font("Cambria", Font.BOLD, 14));
		frmRecipeit.setBounds(100, 100, 762, 391);
		frmRecipeit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmRecipeit.getContentPane().add(panel, BorderLayout.CENTER);
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
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Password");
		txtPassword.setToolTipText("Please enter your password");
		txtPassword.setBounds(462, 199, 207, 20);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSignin = new JButton("Sign-in");
		btnSignin.setBorder(null);
		btnSignin.setToolTipText("Sign-in if an existing user");
		btnSignin.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnSignin.setOpaque(false);
		btnSignin.setBounds(462, 230, 207, 23);
		panel.add(btnSignin);
		
		JButton btnRegister = new JButton("Register");
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
}
