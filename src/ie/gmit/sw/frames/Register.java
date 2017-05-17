package ie.gmit.sw.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Register {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtpasswordConfirmation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMain = new JPanel();
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
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
		
		JComboBox dropdownDays = new JComboBox();
		dropdownDays.setBounds(187, 223, 66, 21);
		panelPersonalDetails.add(dropdownDays);
		dropdownDays.setFont(new Font("Cambria", Font.ITALIC, 12));
		dropdownDays.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox dropdownMonths = new JComboBox();
		dropdownMonths.setBounds(263, 223, 66, 21);
		panelPersonalDetails.add(dropdownMonths);
		dropdownMonths.setFont(new Font("Cambria", Font.ITALIC, 12));
		dropdownMonths.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox dropdownYears = new JComboBox();
		dropdownYears.setBounds(339, 223, 88, 21);
		panelPersonalDetails.add(dropdownYears);
		dropdownYears.setFont(new Font("Cambria", Font.ITALIC, 12));
		dropdownYears.setModel(new DefaultComboBoxModel(new String[] {"", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900", "1899", "1898", "1897", "1896", "1895", "1894", "1893", "1892", "1891", "1890", "1889", "1888", "1887", "1886", "1885", "1884", "1883", "1882", "1881", "1880", "1879", "1878", "1877", "1876", "1875", "1874", "1873", "1872", "1871", "1870"}));
		
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
		btnNext.setBorder(null);
		btnNext.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnNext.setBounds(187, 255, 115, 23);
		panelPersonalDetails.add(btnNext);
		
		JButton btnReturn2 = new JButton("Return");
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
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(167, 206, 188, 21);
		panelCredentials.add(txtPassword);
		txtPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		txtPassword.setEchoChar('*');
		txtPassword.setColumns(10);
		
		txtpasswordConfirmation = new JPasswordField();
		txtpasswordConfirmation.setBounds(167, 235, 188, 21);
		panelCredentials.add(txtpasswordConfirmation);
		txtpasswordConfirmation.setEchoChar('*');
		txtpasswordConfirmation.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
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
		btnCreate.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnCreate.setBounds(167, 267, 89, 23);
		panelCredentials.add(btnCreate);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		btnReturn.setBounds(266, 267, 89, 23);
		panelCredentials.add(btnReturn);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 538, 362);
		panelMain.add(lblBackground);
	}
}
