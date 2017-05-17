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

public class Register {

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
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.getRegisterFrame().setLocationRelativeTo(null);
					window.getRegisterFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setRegisterFrame(new JFrame());
		getRegisterFrame().setBounds(100, 100, 554, 401);
		getRegisterFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMain = new JPanel();
		getRegisterFrame().getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(null);
		
		JPanel panelPersonalDetails = new JPanel();
		panelPersonalDetails.setBounds(10, 11, 518, 340);
		panelMain.add(panelPersonalDetails);
		panelPersonalDetails.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(77, 136, 100, 18);
		panelPersonalDetails.add(lblName);
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblSurname = new JLabel("Surname :");
		lblSurname.setBounds(77, 165, 100, 18);
		panelPersonalDetails.add(lblSurname);
		lblSurname.setForeground(new Color(0, 0, 0));
		lblSurname.setHorizontalAlignment(SwingConstants.LEFT);
		lblSurname.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblDob = new JLabel("D.O.B. :");
		lblDob.setBounds(77, 224, 100, 18);
		panelPersonalDetails.add(lblDob);
		lblDob.setForeground(new Color(0, 0, 0));
		lblDob.setHorizontalAlignment(SwingConstants.LEFT);
		lblDob.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		txtName = new JTextField();
		txtName.setBounds(187, 135, 240, 21);
		panelPersonalDetails.add(txtName);
		txtName.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(187, 164, 240, 21);
		panelPersonalDetails.add(txtSurname);
		txtSurname.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtSurname.setColumns(10);
		
		dropdownDays = new JComboBox();
		dropdownDays.setBounds(187, 223, 66, 21);
		panelPersonalDetails.add(dropdownDays);
		dropdownDays.setFont(new Font("Cambria", Font.ITALIC, 12));
		dropdownDays.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06",
				"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", 
				"23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		dropdownMonths = new JComboBox();
		dropdownMonths.setBounds(263, 223, 66, 21);
		panelPersonalDetails.add(dropdownMonths);
		dropdownMonths.setFont(new Font("Cambria", Font.ITALIC, 12));
		dropdownMonths.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", 
				"07", "08", "09", "10", "11", "12"}));
		
		dropdownYears = new JComboBox();
		dropdownYears.setBounds(339, 223, 88, 21);
		panelPersonalDetails.add(dropdownYears);
		dropdownYears.setFont(new Font("Cambria", Font.ITALIC, 12));
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
		lblWelcome.setForeground(Color.BLACK);
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
		lblInfo.setForeground(new Color(0, 0, 0));
		lblInfo.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblNotice = new JLabel("Important note: Mandatory fields are indicated with red * symbol");
		lblNotice.setBounds(9, 92, 499, 20);
		panelPersonalDetails.add(lblNotice);
		lblNotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotice.setForeground(new Color(255, 0, 0));
		lblNotice.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblDd = new JLabel("DD        /        MM        /       YYYY  ");
		lblDd.setHorizontalAlignment(SwingConstants.CENTER);
		lblDd.setForeground(Color.BLACK);
		lblDd.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblDd.setBounds(187, 194, 240, 18);
		panelPersonalDetails.add(lblDd);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setName(txtName.getText());
				setSurname(txtSurname.getText());
				setDay((String)dropdownDays.getSelectedItem());
				setMonth((String)dropdownMonths.getSelectedItem());
				setYear((String)dropdownYears.getSelectedItem());
				setDate(getDay(), getMonth(), getYear());
				
				panelPersonalDetails.setVisible(false);
				getPanelCredentials();
				panelCredentials.setVisible(true);
			}// End of event handler
		});// End of action listener
		btnNext.setBorder(null);
		btnNext.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnNext.setBounds(187, 255, 115, 23);
		panelPersonalDetails.add(btnNext);
		
		JButton btnReturn2 = new JButton("Return");
		btnReturn2.addActionListener(new ActionListener() {
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
		panelCredentials.setVisible(false);
		panelCredentials.setBounds(10, 11, 518, 340);
		panelMain.add(panelCredentials);
		panelCredentials.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(23, 178, 134, 18);
		panelCredentials.add(lblUsername);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(23, 207, 134, 18);
		panelCredentials.add(lblPassword);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblConfirmation = new JLabel("Confirm password :");
		lblConfirmation.setBounds(23, 236, 134, 18);
		panelCredentials.add(lblConfirmation);
		lblConfirmation.setForeground(new Color(0, 0, 0));
		lblConfirmation.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmation.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(167, 175, 188, 21);
		panelCredentials.add(txtUsername);
		txtUsername.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(167, 206, 188, 21);
		panelCredentials.add(txtPassword);
		txtPassword.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtPassword.setColumns(10);
		
		txtpasswordConfirmation = new JTextField();
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
		lblNowPleaseSet.setForeground(Color.BLACK);
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
		lblPleaseEnterThe.setForeground(Color.BLACK);
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
		lblAccountCredentialsWill.setForeground(Color.BLACK);
		lblAccountCredentialsWill.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		lblAccountCredentialsWill.setBounds(10, 44, 499, 20);
		panelCredentials.add(lblAccountCredentialsWill);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = "";
				int flag = 1;
				
				try{
					// Setting up connection to the database
					// Create MySQL database connection
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password=");     
					Statement state = c.createStatement();


					// Query String
					String selectQuery = "SELECT username FROM users";
					// Execute the statement
		            ResultSet rs = state.executeQuery(selectQuery);
					
					while(rs.next()) {
						username = rs.getString("username");
						if(username.equals(txtUsername.getText())){
							flag = 2;
							System.out.println(username+" = " + txtUsername.getText());
						}// End of if
	                }// End of while
		            
					if(flag == 1){
						try {
							// Setting up connection
							Connection c2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password="); 
							Statement state2 = c2.createStatement();
							
							if (txtPassword.getText().equals(txtpasswordConfirmation.getText())) {
								// Formatting the query 
								String insertQuery = "INSERT INTO users (username,password,name,surname,dob,recipeCount) VALUES ('"
										+ txtUsername.getText() + "', '" +  txtPassword.getText() + "', '" 
										+ getName() + "', '" + getSurname() + "', '" + getDate()+ "', 0)";

								// Executing statement
								state2.executeUpdate(insertQuery);
								c2.close();
								state2.close();
								
								//
								registerFrame.dispose();
								//
								Login login = new Login();
								//
								login.getLoginFrame().setLocationRelativeTo(null);
								//
								login.getLoginFrame().setVisible(true);
				            }// End of if
				            
				            else {
				            	  JOptionPane.showMessageDialog(null, "Passwords do not match!\nPlease try again...", 
				            			  "Confirmation Failed!", JOptionPane.ERROR_MESSAGE);
				            }// End of else

						}// End of try
						catch(SQLException ex) {
							ex.printStackTrace();
						}// End of catch
					}// End of if
					else if(flag != 1){
						JOptionPane.showMessageDialog(null,
								"Sorry, but the username '" + username + "' already exist!\nPlease use different username.",
								"Invalid username", JOptionPane.WARNING_MESSAGE);
					}// End of else
					
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
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedOption = JOptionPane.showConfirmDialog(null,
						"Do you wish to return to previous view?", "Please select...",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (selectedOption == JOptionPane.YES_OPTION) {
					panelCredentials.setVisible(false);
					panelPersonalDetails.setVisible(true);
				}// End of if
			}// End of event handler
		});// End of action listener
		btnReturn.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnReturn.setBounds(266, 267, 89, 23);
		panelCredentials.add(btnReturn);
		
		this.setPanelCredentials(panelCredentials);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 538, 362);
		panelMain.add(lblBackground);
	}

	public JFrame getRegisterFrame() {
		return registerFrame;
	}

	public void setRegisterFrame(JFrame registerFrame) {
		this.registerFrame = registerFrame;
	}
	
	public JPanel getPanelCredentials() {
		return panelCredentials;
	}

	public void setPanelCredentials(JPanel panel) {
		this.panelCredentials = panel;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String userName){
		name = "" + userName;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String userSurname){
		surname = "" + userSurname;
	}
	
	public String getDay(){
		return day;
	}
	
	public void setDay(String selectedDay){
		day = selectedDay;
	}
	
	public String getMonth(){
		return month;
	}
	
	public void setMonth(String selectedMonth){
		month = selectedMonth;
	}
	
	public String getYear(){
		return year;
	}
	
	public void setYear(String selectedYear){
		year = selectedYear;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String day, String month, String year) {
		this.date = year + "-" + month + "-" + day;
	}
}
