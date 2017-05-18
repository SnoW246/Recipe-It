package ie.gmit.sw.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Register {
	// Declaration of variables
	private JFrame registerFrame;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtpasswordConfirmation;
	private JPanel panelCredentials;
	@SuppressWarnings("rawtypes")
	private JComboBox dropdownDays;
	@SuppressWarnings("rawtypes")
	private JComboBox dropdownMonths;
	@SuppressWarnings("rawtypes")
	private JComboBox dropdownYears;
	private String name;
	private String surname;
	private String day;
	private String month;
	private String year;
	private String date;
	public int selectedOption;
	
	// Launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Constructing new instance of 
					Register window = new Register();
					// Get new register frame and set its position to the centre
					window.getRegisterFrame().setLocationRelativeTo(null);
					// Set the visibility of the register frame instance to true
					window.getRegisterFrame().setVisible(true);
				}// End of try
				catch (Exception e) {
					e.printStackTrace();
				}// End of catch
			}// End of run
		});// End of Runnable
	}// End of main

	// Create the application.
	public Register() {
		// // Initialization of all components
		initialize();
	}// End of Register

	// Initialize the content of the frame.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setRegisterFrame(new JFrame());
		getRegisterFrame().setBounds(100, 100, 554, 401);
		getRegisterFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMain = new JPanel();
		getRegisterFrame().getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(null);
		
		JPanel panelPersonalDetails = new JPanel();
		panelPersonalDetails.setOpaque(false);
		panelPersonalDetails.setBounds(10, 11, 518, 340);
		panelMain.add(panelPersonalDetails);
		panelPersonalDetails.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(77, 136, 100, 18);
		panelPersonalDetails.add(lblName);
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblSurname = new JLabel("Surname :");
		lblSurname.setBounds(77, 165, 100, 18);
		panelPersonalDetails.add(lblSurname);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setHorizontalAlignment(SwingConstants.LEFT);
		lblSurname.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblDob = new JLabel("D.O.B. :");
		lblDob.setBounds(77, 224, 100, 18);
		panelPersonalDetails.add(lblDob);
		lblDob.setForeground(Color.WHITE);
		lblDob.setHorizontalAlignment(SwingConstants.LEFT);
		lblDob.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBounds(187, 135, 240, 21);
		panelPersonalDetails.add(txtName);
		txtName.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBorder(null);
		txtSurname.setBounds(187, 164, 240, 21);
		panelPersonalDetails.add(txtSurname);
		txtSurname.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtSurname.setColumns(10);
		
		dropdownDays = new JComboBox();
		dropdownDays.setBounds(187, 223, 66, 21);
		panelPersonalDetails.add(dropdownDays);
		dropdownDays.setFont(new Font("Cambria", Font.ITALIC, 12));
		// Initialization of dropdown menu for days of the month values
		dropdownDays.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06",
				"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", 
				"23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		dropdownMonths = new JComboBox();
		dropdownMonths.setBounds(263, 223, 66, 21);
		panelPersonalDetails.add(dropdownMonths);
		dropdownMonths.setFont(new Font("Cambria", Font.ITALIC, 12));
		// Initialization of dropdown menu for months of the year values
		dropdownMonths.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", 
				"07", "08", "09", "10", "11", "12"}));
		
		dropdownYears = new JComboBox();
		dropdownYears.setBounds(339, 223, 88, 21);
		panelPersonalDetails.add(dropdownYears);
		dropdownYears.setFont(new Font("Cambria", Font.ITALIC, 12));
		// Initialization of dropdown menu for year values
		dropdownYears.setModel(new DefaultComboBoxModel(new String[] {"", "2017", "2016", "2015", "2014", "2013",
				"2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", 
				"2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", 
				"1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", 
				"1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", 
				"1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", 
				"1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", 
				"1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", 
				"1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", 
				"1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", 
				"1904", "1903", "1902", "1901", "1900", "1899", "1898", "1897", "1896", "1895", "1894", "1893", 
				"1892", "1891", "1890", "1889", "1888", "1887", "1886", "1885", "1884", "1883", "1882", "1881", 
				"1880", "1879", "1878", "1877", "1876", "1875", "1874", "1873", "1872", "1871", "1870"}));
		
		JLabel lblStar1 = new JLabel("*");
		lblStar1.setBounds(437, 219, 9, 24);
		panelPersonalDetails.add(lblStar1);
		lblStar1.setForeground(new Color(255, 0, 0));
		lblStar1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblWelcome = new JLabel("Do you want to become a new member of Recipe-It application?");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(9, 11, 499, 22);
		panelPersonalDetails.add(lblWelcome);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblUnderline = new JLabel("_________________________________");
		lblUnderline.setBounds(9, 11, 499, 47);
		panelPersonalDetails.add(lblUnderline);
		lblUnderline.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnderline.setForeground(Color.RED);
		lblUnderline.setFont(new Font("Cambria", Font.BOLD, 40));
		lblUnderline.setBackground(Color.RED);
		
		JLabel lblInfo = new JLabel("Please enter the following details below to create a new account");
		lblInfo.setBounds(9, 61, 499, 20);
		panelPersonalDetails.add(lblInfo);
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNotice = new JLabel("Important note: Mandatory fields are indicated with red * symbol");
		lblNotice.setBounds(9, 92, 499, 20);
		panelPersonalDetails.add(lblNotice);
		lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotice.setForeground(new Color(255, 0, 0));
		lblNotice.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblDd = new JLabel("DD        /        MM        /       YYYY  ");
		lblDd.setHorizontalAlignment(SwingConstants.CENTER);
		lblDd.setForeground(Color.WHITE);
		lblDd.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblDd.setBounds(187, 194, 240, 18);
		panelPersonalDetails.add(lblDd);
		
		JButton btnNext = new JButton("Next");
		// Declaration of action listener on the next button
		btnNext.addActionListener(new ActionListener() {
			// Declaration of event handler for when action on the button is performed 
			public void actionPerformed(ActionEvent e) {
				// Set name taken from the text field
				setName(txtName.getText());
				// Set surname taken from the text field
				setSurname(txtSurname.getText());
				// Set day taken from the combo box
				setDay((String)dropdownDays.getSelectedItem());
				// Set month taken from the combo box
				setMonth((String)dropdownMonths.getSelectedItem());
				// Set year taken from the combo box
				setYear((String)dropdownYears.getSelectedItem());
				// Set date taking values saved from combo boxes
				// preparing valid date format for the database
				setDate(getDay(), getMonth(), getYear());
				// Set visibility of the current panel within 
				// the registration frame to false
				panelPersonalDetails.setVisible(false);
				// get instance of panel two with credentials
				getPanelCredentials();
				// set credentials panel to be visible
				panelCredentials.setVisible(true);
			}// End of event handler
		});// End of action listener
		btnNext.setBorder(null);
		btnNext.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnNext.setBounds(187, 255, 115, 23);
		panelPersonalDetails.add(btnNext);
		
		JButton btnReturn2 = new JButton("Return");
		// Declaration of action listener on the return button 
		btnReturn2.addActionListener(new ActionListener() {
			// Declaration of event handler for when action on a button is performed
			public void actionPerformed(ActionEvent arg0) {
				// Confirmation dialog box to get user to approve the action
				selectedOption = JOptionPane.showConfirmDialog(null,
						"Do you wish to return to Login Frame?\nCurrent data will be lost!", "Please select...",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				// Check for user selection, if yes selected then carry out the action
				if (selectedOption == JOptionPane.YES_OPTION) {
					// Create new instance of Register Frame
					Login login = new Login();
					// Get register frame and set its position to centre
					login.getLoginFrame().setLocationRelativeTo(null);
					// Get register frame and set it to visible
					login.getLoginFrame().setVisible(true);
					// Disposal of login frame 
					registerFrame.dispose();
				}// End of if
			}// End of event handler
		});// End of action listener
		btnReturn2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnReturn2.setBorder(null);
		btnReturn2.setBounds(312, 255, 115, 23);
		panelPersonalDetails.add(btnReturn2);
		
		JPanel panelCredentials = new JPanel();
		panelCredentials.setOpaque(false);
		panelCredentials.setVisible(false);
		panelCredentials.setBounds(10, 11, 518, 340);
		panelMain.add(panelCredentials);
		panelCredentials.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(23, 178, 134, 18);
		panelCredentials.add(lblUsername);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(23, 207, 134, 18);
		panelCredentials.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblConfirmation = new JLabel("Confirm password :");
		lblConfirmation.setBounds(23, 236, 134, 18);
		panelCredentials.add(lblConfirmation);
		lblConfirmation.setForeground(Color.WHITE);
		lblConfirmation.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmation.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBounds(167, 175, 188, 21);
		panelCredentials.add(txtUsername);
		txtUsername.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBorder(null);
		txtPassword.setBounds(167, 206, 188, 21);
		panelCredentials.add(txtPassword);
		txtPassword.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtPassword.setColumns(10);
		
		txtpasswordConfirmation = new JTextField();
		txtpasswordConfirmation.setBorder(null);
		txtpasswordConfirmation.setBounds(167, 235, 188, 21);
		panelCredentials.add(txtpasswordConfirmation);
		txtpasswordConfirmation.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtpasswordConfirmation.setColumns(10);
		
		JLabel lblStar4 = new JLabel("*");
		lblStar4.setBounds(365, 172, 9, 24);
		panelCredentials.add(lblStar4);
		lblStar4.setForeground(new Color(255, 0, 0));
		lblStar4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblStar5 = new JLabel("*");
		lblStar5.setBounds(365, 201, 9, 24);
		panelCredentials.add(lblStar5);
		lblStar5.setForeground(new Color(255, 0, 0));
		lblStar5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblStar6 = new JLabel("*");
		lblStar6.setBounds(365, 230, 9, 24);
		panelCredentials.add(lblStar6);
		lblStar6.setForeground(new Color(255, 0, 0));
		lblStar6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblNowPleaseSet = new JLabel("Set up your account credentials!");
		lblNowPleaseSet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNowPleaseSet.setForeground(Color.WHITE);
		lblNowPleaseSet.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 17));
		lblNowPleaseSet.setBounds(10, 11, 499, 22);
		panelCredentials.add(lblNowPleaseSet);
		
		JLabel label_1 = new JLabel("_________________________________");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Cambria", Font.BOLD, 40));
		label_1.setBackground(Color.RED);
		label_1.setBounds(10, 32, 499, 47);
		panelCredentials.add(label_1);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the following details below to create log-in details");
		lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterThe.setForeground(Color.WHITE);
		lblPleaseEnterThe.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		lblPleaseEnterThe.setBounds(10, 90, 499, 20);
		panelCredentials.add(lblPleaseEnterThe);
		
		JLabel label_3 = new JLabel("Important note: Mandatory fields are indicated with red * symbol");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		label_3.setBounds(10, 121, 499, 20);
		panelCredentials.add(label_3);
		
		JLabel lblAccountCredentialsWill = new JLabel("Account credentials will be used to log-in to the Recipe-It application");
		lblAccountCredentialsWill.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountCredentialsWill.setForeground(Color.WHITE);
		lblAccountCredentialsWill.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		lblAccountCredentialsWill.setBounds(10, 44, 499, 20);
		panelCredentials.add(lblAccountCredentialsWill);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBorder(null);
		// Declaration of action listener of a create button
		btnCreate.addActionListener(new ActionListener() {
			// Declaration of event handler for when action on the button is performed
			public void actionPerformed(ActionEvent e) {
				// Declaration of local variables
				String username = "";
				// Initialisation of a control variable
				int flag = 1;
				
				try{
					// Creating MySQL database connection using java database connectivity driver
					Class.forName("com.mysql.jdbc.Driver");
					// Defining the connection
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password=");     
					// Declaration of a create statement
					Statement state = c.createStatement();

					// Declaration of select query statement for the database
					String selectQuery = "SELECT username FROM users";
					// Declaration of result set, initialisation & execution of the statement
		            ResultSet rs = state.executeQuery(selectQuery);
					
		            // While condition to go through records returned in the result set from the database 
					while(rs.next()) {
						// Set the result set value to the local variable 
						username = rs.getString("username");
						// If statement condition to compare the value returned with the 
						// value taken from the user name text field
						if(username.equals(txtUsername.getText())){
							// When matched, set control variable to two
							flag = 2;
							// Print out in the system console the matched user name
							System.out.println(username+" = " + txtUsername.getText());
						}// End of if
	                }// End of while
		            
					// If statement condition for a case where no such user name was found in the database
					if(flag == 1){
						try {
							// Defining the connection
							Connection c2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password="); 
							// Declaration of a create statement
							Statement state2 = c2.createStatement();
							
							// Statement to compare if passwords have been matched, and if so carry out the query
							if (txtPassword.getText().equals(txtpasswordConfirmation.getText())) {
								// Declaration of insert query statement for the database to create a now user
								// with provided user credentials
								String insertQuery = "INSERT INTO users (username,password,name,surname,dob,recipeCount) VALUES ('"
										+ txtUsername.getText() + "', '" +  txtPassword.getText() + "', '" 
										+ getName() + "', '" + getSurname() + "', '" + getDate()+ "', 0)";

								//initialisation & execution of the statement
								state2.executeUpdate(insertQuery);
								// closure of all connections
								c2.close();
								state2.close();
								
								// Display information message dialog to inform 
								// that user has been created successfully
								selectedOption = JOptionPane.showConfirmDialog(null, "User successgully created...", 
				            			  "Success!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
								// Statement condition to close the frame after user has been informed
								if(selectedOption == JOptionPane.OK_OPTION){
									// Creating a new instance of login frame
									Login loginFrame = new Login();
									// Getting the instance of login frame and setting the position of it to the centre
									loginFrame.getLoginFrame().setLocationRelativeTo(null);
									// Setting the login frame to be visible
									loginFrame.getLoginFrame().setVisible(true);
									// Disposal of register frame
									registerFrame.dispose();
								}// End of if
				            }// End of if
				            
							// Else to show error message dialog to inform user that password confirmation failed
				            else {
				            	// Display error message dialog
				            	  JOptionPane.showMessageDialog(null, "Passwords do not match!\nPlease try again...", 
				            			  "Confirmation Failed!", JOptionPane.ERROR_MESSAGE);
				            }// End of else
						}// End of try
						
						catch(SQLException ex) {
							ex.printStackTrace();
						}// End of catch
					}// End of if
					
					// Else if the user name was found in the database
					else if(flag != 1){
						// Display warning message dialog informing user that user name 
						// already exist and therefore cannot be used again
						JOptionPane.showMessageDialog(null,
								"Sorry, but the username '" + username + "' already exist!\nPlease use different username.",
								"Invalid username", JOptionPane.WARNING_MESSAGE);
					}// End of else
					
					// Closure of all connections
					c.close();
					state.close();
				}// End of try
				
				catch(Exception ex){
					ex.printStackTrace();
				}// End of catch
			}// End of even handler
		});// End of action listener
		btnCreate.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnCreate.setBounds(167, 267, 89, 23);
		panelCredentials.add(btnCreate);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBorder(null);
		// Declaration of action listener on return button
		btnReturn.addActionListener(new ActionListener() {
			// Declaration of event handler for when the action on the button is performed
			public void actionPerformed(ActionEvent e) {
				// Declaration & initialization of a warning message dialog with select option on it
				// asking user if they wish to proceed
				selectedOption = JOptionPane.showConfirmDialog(null,
						"Do you wish to return to previous view?", "Please select...",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				// Statement condition to take action if YES was selected in the dialog
				if (selectedOption == JOptionPane.YES_OPTION) {
					// Set the visibility of the current panel to false
					panelCredentials.setVisible(false);
					// Set visibility of initial panel to true
					panelPersonalDetails.setVisible(true);
				}// End of if
			}// End of event handler
		});// End of action listener
		btnReturn.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnReturn.setBounds(266, 267, 89, 23);
		panelCredentials.add(btnReturn);
		
		this.setPanelCredentials(panelCredentials);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(Register.class.getResource("/ie/gmit/sw/resources/Recipe-It Register.jpg")));
		lblBackground.setBounds(0, 0, 538, 362);
		panelMain.add(lblBackground);
	}// End of Initialize
	
	// Declaration of get register frame function
	public JFrame getRegisterFrame() {
		// Return register frame instance
		return registerFrame;
	}// End of getRegisterFrame
	
	// Declaration of set register frame function
	public void setRegisterFrame(JFrame registerFrame) {
		// Set current frame to gathered frame instance
		this.registerFrame = registerFrame;
	}// End of setRegisterFrame
	
	// Declaration of get credentials panel function
	public JPanel getPanelCredentials() {
		// Return panel
		return panelCredentials;
	}// End of getPanelCredentials
	
	// Declaration of set credentials panel function
	public void setPanelCredentials(JPanel panel) {
		// Set current panel to gathered panel instance
		this.panelCredentials = panel;
	}// End of setPanelCredentials
	
	// Declaration of get name function
	public String getName(){
		// Return name
		return name;
	}// End of getName
	
	// Declaration of set name function
	public void setName(String userName){
		// Setting name to users name
		name = "" + userName;
	}// End of setName
	
	// Declaration of get surname function
	public String getSurname(){
		// Return surname
		return surname;
	}// End of getSurname
	
	// Declaration of set surname function
	public void setSurname(String userSurname){
		// Setting surname to users surname
		surname = "" + userSurname;
	}// End of setSurname
	
	// Declaration of get day function
	public String getDay(){
		// Return day
		return day;
	}// End of getDay
	
	// Declaration of set day function
	public void setDay(String selectedDay){
		// Setting day to user defined day
		day = selectedDay;
	}// End of setDay
	
	// Declaration of get month function
	public String getMonth(){
		// Return month
		return month;
	}// End of getMonth
	
	// Declaration of set month function
	public void setMonth(String selectedMonth){
		// Setting month to user defined month
		month = selectedMonth;
	}// End of setMonth
	
	// Declaration of get year function
	public String getYear(){
		// Return year
		return year;
	}// End of getYear
	
	// Declaration of set year function
	public void setYear(String selectedYear){
		// Setting of year to year selected by user
		year = selectedYear;
	}// End of setYear
	
	// Declaration of get date function
	public String getDate() {
		return date;
	}// End of getDate
	
	// Declaration of set date function
	public void setDate(String day, String month, String year) {
		// Setting current date to date combination selected by user
		this.date = year + "-" + month + "-" + day;
	}// End of setDate
}// End of Register
