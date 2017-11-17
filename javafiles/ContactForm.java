

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ContactForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtCarModel;
	private JTextField txtCarColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactForm frame = new ContactForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("");
		txtFirstName.setBounds(20, 52, 179, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name*");
		lblNewLabel.setBounds(20, 36, 84, 16);
		contentPane.add(lblNewLabel);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(224, 52, 179, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name*");
		lblNewLabel_1.setBounds(224, 36, 84, 16);
		contentPane.add(lblNewLabel_1);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(20, 107, 143, 26);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number*");
		lblNewLabel_2.setBounds(20, 90, 98, 16);
		contentPane.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(193, 107, 179, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(193, 90, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(20, 162, 211, 26);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(20, 145, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JComboBox CarYearcomboBox = new JComboBox();
		CarYearcomboBox.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		CarYearcomboBox.setToolTipText("");
		CarYearcomboBox.setBounds(250, 163, 96, 27);
		contentPane.add(CarYearcomboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Car Year");
		lblNewLabel_5.setBounds(250, 145, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acura", "Alfa Romeo", "AMC", "Ariel", "Aston Martin", "Audi", "Austin Healey", "Bentley", "BMW", "Bugatti", "Buick", "Cadillac", "Callaway", "Caterham", "Cheverlot", "Chrysler", "Daewoo", "Datsun", "Dodge", "Ferrari", "Fiat", "Ford ", "Genesis", "Geo", "GMC", "Honda", "Hummer", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati", "Maybach", "Mazda", "Mclaren ", "Mercedes", "Mercurt", "Mini", "Mitisubishi", "Nissian", "Noble", "Oldsmobile", "Plymouth", "Pontiac", "Porsche", "Proton ", "Ram", "Rolls Royce", "Saab", "Saleen", "Saturn ", "Scion", "Shelby", "Smart", "Suburu", "Suzuki", "Telsa", "Toyota", "VW", "Volvo", ""}));
		comboBox.setBounds(20, 215, 98, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Car Make ");
		lblNewLabel_6.setBounds(20, 200, 62, 16);
		contentPane.add(lblNewLabel_6);
		
		txtCarModel = new JTextField();
		txtCarModel.setBounds(130, 214, 115, 26);
		contentPane.add(txtCarModel);
		txtCarModel.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Car Model");
		lblNewLabel_7.setBounds(130, 200, 72, 16);
		contentPane.add(lblNewLabel_7);
		
		txtCarColor = new JTextField();
		txtCarColor.setBounds(275, 214, 128, 26);
		contentPane.add(txtCarColor);
		txtCarColor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Car Color ");
		lblNewLabel_8.setBounds(275, 200, 71, 16);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCompleteFrom = new JButton("Complete");
		btnCompleteFrom.setBounds(327, 244, 117, 29);
		contentPane.add(btnCompleteFrom);
	}
}
