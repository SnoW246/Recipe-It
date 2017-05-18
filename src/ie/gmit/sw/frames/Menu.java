package ie.gmit.sw.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Menu {
	// Declaration of variables
	private JFrame menuFrame;
	private JTextField txtRecipeName;
	private JTextField txtSearch;
	private String id;
	private String cuisine;
	private String name;
	private String amount;
	private String measure;
	private String ingredient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.getMenuFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		setMenuFrame(new JFrame());
		getMenuFrame().setBounds(100, 100, 638, 450);
		getMenuFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMenuFrame().getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 601, 391);
		getMenuFrame().getContentPane().add(tabbedPane);
		
		JPanel panelSearch = new JPanel();
		tabbedPane.addTab("Search", null, panelSearch, null);
		panelSearch.setLayout(null);
		
		JLabel label_5 = new JLabel("Search for recipes :");
		label_5.setBounds(10, 11, 576, 14);
		panelSearch.add(label_5);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(10, 36, 576, 20);
		panelSearch.add(txtSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 67, 576, 23);
		panelSearch.add(btnSearch);
		
		JList list = new JList();
		list.setBounds(10, 101, 576, 217);
		panelSearch.add(list);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(10, 329, 576, 23);
		panelSearch.add(btnView);
		
		JPanel panelCreate = new JPanel();
		tabbedPane.addTab("Create", null, panelCreate, null);
		panelCreate.setLayout(null);
		
		JLabel lblToCreateA = new JLabel("To create a recipe, please select and fill in the following :");
		lblToCreateA.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		lblToCreateA.setBounds(10, 11, 576, 14);
		panelCreate.add(lblToCreateA);
		
		JLabel label_1 = new JLabel("Type of Cuisine :");
		label_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(10, 36, 100, 14);
		panelCreate.add(label_1);
		
		JLabel label_2 = new JLabel("Recipe name :");
		label_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(10, 61, 100, 14);
		panelCreate.add(label_2);
		
		JLabel label_3 = new JLabel("Ingredients :");
		label_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(10, 141, 100, 14);
		panelCreate.add(label_3);
		
		JLabel lblStep = new JLabel("Step :");
		lblStep.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		lblStep.setBounds(10, 199, 100, 14);
		panelCreate.add(lblStep);
		
		JComboBox comboCuisine = new JComboBox();
		comboCuisine.setModel(new DefaultComboBoxModel(new String[] {"", "American", "Breakfast", "Burgers", "Cafe", "Chinese", "International", "Desert", "Egyptian", "Frozen Yogurt", "Healthy Food", "Indian", "Italian", "Japanese", "Lebanese", "Mexican", "Pizzas", "Sandwiches", "Seafood", "Thai", "Turkish", "Pakistani", "Iranian", "Vegetarian", "Arabic", "Asian", "Other"}));
		comboCuisine.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboCuisine.setEditable(true);
		comboCuisine.setBounds(120, 33, 466, 20);
		panelCreate.add(comboCuisine);
		
		txtRecipeName = new JTextField();
		txtRecipeName.setFont(new Font("Cambria", Font.ITALIC, 12));
		txtRecipeName.setColumns(10);
		txtRecipeName.setBounds(120, 58, 466, 20);
		panelCreate.add(txtRecipeName);
		
		JComboBox comboAmount = new JComboBox();
		comboAmount.setModel(new DefaultComboBoxModel(new String[] {"", "1/2", "1/3", "2/3", "1/4", 
				"3/4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboAmount.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboAmount.setEditable(true);
		comboAmount.setBounds(120, 138, 75, 20);
		panelCreate.add(comboAmount);
		
		JComboBox comboMeasure = new JComboBox();
		comboMeasure.setModel(new DefaultComboBoxModel(new String[] {"", "Centigrams (cg)", 
				"Centiliters (cl)", "Centimeters (cm)", "Cubic Centimeter (cc)", "Cup (237 ml)", 
				"Decigrams (dg)", "Deciliters (dl)", "Decimeters (dm)", "Dekagrams (dag)", "Drams (dr)", 
				"Feet (ft)", "Fluid Ounces (oz)", "Gills (gi)", "Grains (gr)", "Grams (g)", 
				"Hectograms (hg)", "Inches (in)", "Kilogram (kg)", "Liter (l)", "Meter (m)", "Milligrams (mg)", 
				"Milliliters (ml)", "Millimeters (mm)", "Pints (pi)", "Pounds (lb)", "Quarts (qt)", 
				"Teaspoons (tsp)", "Tablespoon (tbsp)"}));
		comboMeasure.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboMeasure.setBounds(205, 138, 128, 20);
		panelCreate.add(comboMeasure);
		
		JComboBox comboIngredient = new JComboBox();
		comboIngredient.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboIngredient.setEditable(true);
		comboIngredient.setBounds(343, 138, 243, 20);
		panelCreate.add(comboIngredient);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Cambria", Font.ITALIC, 12));
		editorPane.setBounds(120, 199, 466, 97);
		panelCreate.add(editorPane);
		
		JButton btnAddIngredient = new JButton("Add Ingredient");
		// Declaration of action listener
		btnAddIngredient.addActionListener(new ActionListener() {
			// Declaration of event handler for when action on the button is performed
			public void actionPerformed(ActionEvent e) {
				
				//amount = (String) comboAmount.getSelectedItem();
				//measure = (String) comboMeasure.getSelectedItem();
				//ingredient = (String) comboIngredient.getSelectedItem();
				
			}// End of event handler
		});// End of action listener
		btnAddIngredient.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnAddIngredient.setBounds(120, 169, 466, 23);
		panelCreate.add(btnAddIngredient);
		
		JButton button_1 = new JButton("Create");
		button_1.setBounds(10, 329, 100, 23);
		panelCreate.add(button_1);
		
		JButton button_2 = new JButton("Reset");
		button_2.setBounds(10, 295, 100, 23);
		panelCreate.add(button_2);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		lblAmount.setBounds(120, 120, 75, 14);
		panelCreate.add(lblAmount);
		
		JLabel lblMeasures = new JLabel("Measures :");
		lblMeasures.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeasures.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		lblMeasures.setBounds(205, 120, 128, 14);
		panelCreate.add(lblMeasures);
		
		JLabel lblIngredients = new JLabel("Ingredients :");
		lblIngredients.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredients.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		lblIngredients.setBounds(343, 120, 243, 14);
		panelCreate.add(lblIngredients);
		
		JButton btnAddStep = new JButton("Add Above Step");
		btnAddStep.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnAddStep.setBounds(120, 307, 466, 23);
		panelCreate.add(btnAddStep);
		
		JButton btnStartRecipe = new JButton("Create & Start Recipe");
		// Declaration of action listener
		btnStartRecipe.addActionListener(new ActionListener() {
			// Declaration of event handler for when action on a button is performed
			public void actionPerformed(ActionEvent e) {
				// Declaration of local variables
				String recipeID, recipeName, recipeCuisine, recipeUserID = "";
				// Initialisation of a control variable
				int flag = 1;
				
				cuisine = (String) comboCuisine.getSelectedItem();
				name = txtRecipeName.getName();
				
				try{
					// Creating MySQL database connection using java database connectivity driver
					//Class.forName("com.mysql.jdbc.Driver");
					// Defining the connection
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeit?" + "user=root&password=");     
					// Declaration of a create statement
					Statement state = c.createStatement();
					
					// Declaration of select query statement for the database
					String selectQuery = "SELECT recipeID,name,cuisine,userID FROM recipes";
					// Declaration of result set, initialisation & execution of the statement
		            ResultSet rs = state.executeQuery(selectQuery);
		            
		            // While condition to go through records returned in the result set from the database 
					while(rs.next()) {
						// Set the result set value to the local variable 
						recipeID = rs.getString("recipeID");
						recipeName = rs.getString("name");
						recipeCuisine = rs.getString("cuisine");
						recipeUserID = rs.getString("userID");
						// If statement condition to compare the value returned with the 
						// value taken from the user name text field
						if(recipeName.equals(name) && recipeUserID.equals(getId())){
							// When matched, set control variable to two
							flag = 2;
						}// End of if
	                }// End of while
		            
					//if(flag == 1){
					/*String insertQuery = "INSERT INTO recipes (name,cuisine,userID) VALUES ('"
							+ name + "', '" +  cuisine + "', '" + getId() + "')";
		            String updateQuery = "UPDATE users SET recipeCount= +1 WHERE userID='" + getId() + "'";
					*/
					//}
		            
		            
		            
				}// End of try
				
				catch (SQLException ex){
					ex.printStackTrace();
				}// End of catch
				
				
				
				
			}// End of event handler
		});// End of action listener
		btnStartRecipe.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnStartRecipe.setBounds(120, 89, 466, 23);
		panelCreate.add(btnStartRecipe);
		
		JPanel panelLibrary = new JPanel();
		tabbedPane.addTab("My Library", null, panelLibrary, null);
		panelLibrary.setLayout(null);
		
		JPanel panelProfile = new JPanel();
		tabbedPane.addTab("Profile", null, panelProfile, null);
		panelProfile.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 281, 341);
		panelProfile.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserId = new JLabel("USER ID : ");
		lblUserId.setBounds(10, 11, 261, 14);
		panel.add(lblUserId);
		lblUserId.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 36, 90, 14);
		panel.add(lblName);
		lblName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblSurname = new JLabel("Surname : ");
		lblSurname.setBounds(10, 61, 90, 14);
		panel.add(lblSurname);
		lblSurname.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(10, 86, 90, 14);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(10, 111, 90, 14);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblRecipeCount = new JLabel("Recipe Count : ");
		lblRecipeCount.setBounds(10, 136, 90, 14);
		panel.add(lblRecipeCount);
		lblRecipeCount.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblPrivilages = new JLabel("Privilages : ");
		lblPrivilages.setBounds(10, 161, 90, 14);
		panel.add(lblPrivilages);
		lblPrivilages.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		
		textField = new JTextField();
		textField.setBounds(110, 34, 161, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 59, 161, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 84, 161, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 109, 161, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 134, 161, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(110, 159, 161, 20);
		panel.add(textField_5);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(10, 186, 89, 23);
		panel.add(btnEdit);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(110, 186, 89, 23);
		panel.add(btnSave);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(305, 11, 281, 341);
		panelProfile.add(panel_1);
		panel_1.setLayout(null);
	}

	public JFrame getMenuFrame() {
		return menuFrame;
	}

	public void setMenuFrame(JFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
