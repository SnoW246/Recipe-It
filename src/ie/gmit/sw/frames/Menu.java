package ie.gmit.sw.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JEditorPane;

public class Menu {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 601, 391);
		frame.getContentPane().add(tabbedPane);
		
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
		btnSearch.setBounds(232, 67, 89, 23);
		panelSearch.add(btnSearch);
		
		JPanel panelCreate = new JPanel();
		tabbedPane.addTab("Create", null, panelCreate, null);
		panelCreate.setLayout(null);
		
		JLabel label = new JLabel("Please select from the following:");
		label.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 11, 223, 14);
		panelCreate.add(label);
		
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
		label_3.setBounds(10, 86, 100, 14);
		panelCreate.add(label_3);
		
		JLabel lblStep = new JLabel("Step :");
		lblStep.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		lblStep.setBounds(10, 111, 100, 14);
		panelCreate.add(lblStep);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboBox.setEditable(true);
		comboBox.setBounds(120, 33, 162, 20);
		panelCreate.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Cambria", Font.ITALIC, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(120, 58, 452, 20);
		panelCreate.add(textField_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Amount", "1/2", "1/3", "2/3", "1/4", "3/4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(120, 83, 75, 20);
		panelCreate.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Measures", "Centigrams (cg)", "Centiliters (cl)", "Centimeters (cm)", "Cubic Centimeter (cc)", "Cup (237 ml)", "Decigrams (dg)", "Deciliters (dl)", "Decimeters (dm)", "Dekagrams (dag)", "Drams (dr)", "Feet (ft)", "Fluid Ounces (oz)", "Gills (gi)", "Grains (gr)", "Grams (g)", "Hectograms (hg)", "Inches (in)", "Kilogram (kg)", "Liter (l)", "Meter (m)", "Milligrams (mg)", "Milliliters (ml)", "Millimeters (mm)", "Pints (pi)", "Pounds (lb)", "Quarts (qt)", "Teaspoons (tsp)", "Tablespoon (tbsp)"}));
		comboBox_2.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboBox_2.setBounds(205, 83, 128, 20);
		panelCreate.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Ingredients"}));
		comboBox_3.setFont(new Font("Cambria", Font.ITALIC, 12));
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(343, 83, 162, 20);
		panelCreate.add(comboBox_3);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Cambria", Font.ITALIC, 12));
		editorPane.setBounds(120, 111, 452, 97);
		panelCreate.add(editorPane);
		
		JButton button = new JButton("Add");
		button.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		button.setBounds(515, 82, 57, 23);
		panelCreate.add(button);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Cambria", Font.ITALIC, 12));
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(292, 33, 280, 20);
		panelCreate.add(textField_2);
		
		JButton button_1 = new JButton("Create");
		button_1.setBounds(10, 273, 100, 23);
		panelCreate.add(button_1);
		
		JButton button_2 = new JButton("Reset");
		button_2.setBounds(10, 307, 100, 23);
		panelCreate.add(button_2);
		
		JPanel panelLibrary = new JPanel();
		tabbedPane.addTab("My Library", null, panelLibrary, null);
		panelLibrary.setLayout(null);
		
		JPanel panelProfile = new JPanel();
		tabbedPane.addTab("Profile", null, panelProfile, null);
		panelProfile.setLayout(null);
	}
}
