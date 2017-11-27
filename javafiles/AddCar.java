import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class AddCar extends JFrame {

	private JPanel contentPane;
	private JTextField txtCarModel;
	private JTextField txtCarColor;
	private JTextField txtPlate;
	private JTextField emailField;
	static String currentEmail;

	/**
	 * Launch the application.
	 */
	public static void go(String email) {
		currentEmail = email;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCar frame = new AddCar();
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
	public AddCar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox CarYearcomboBox = new JComboBox();
		CarYearcomboBox.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		CarYearcomboBox.setToolTipText("");
		CarYearcomboBox.setBounds(54, 141, 96, 27);
		contentPane.add(CarYearcomboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Car Year");
		lblNewLabel_5.setBounds(54, 123, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acura", "Alfa Romeo", "AMC", "Ariel", "Aston Martin", "Audi", "Austin Healey", "Bentley", "BMW", "Bugatti", "Buick", "Cadillac", "Callaway", "Caterham", "Cheverlot", "Chrysler", "Daewoo", "Datsun", "Dodge", "Ferrari", "Fiat", "Ford ", "Genesis", "Geo", "GMC", "Honda", "Hummer", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati", "Maybach", "Mazda", "Mclaren ", "Mercedes", "Mercurt", "Mini", "Mitisubishi", "Nissian", "Noble", "Oldsmobile", "Plymouth", "Pontiac", "Porsche", "Proton ", "Ram", "Rolls Royce", "Saab", "Saleen", "Saturn ", "Scion", "Shelby", "Smart", "Suburu", "Suzuki", "Telsa", "Toyota", "VW", "Volvo", ""}));
		comboBox.setBounds(52, 86, 98, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Car Make ");
		lblNewLabel_6.setBounds(52, 71, 62, 16);
		contentPane.add(lblNewLabel_6);
		
		txtCarModel = new JTextField();
		txtCarModel.setBounds(162, 85, 115, 26);
		contentPane.add(txtCarModel);
		txtCarModel.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Car Model");
		lblNewLabel_7.setBounds(162, 71, 72, 16);
		contentPane.add(lblNewLabel_7);
		
		txtCarColor = new JTextField();
		txtCarColor.setBounds(162, 142, 128, 26);
		contentPane.add(txtCarColor);
		txtCarColor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Car Color ");
		lblNewLabel_8.setBounds(162, 128, 71, 16);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCompleteForm = new JButton("Complete");
		btnCompleteForm.setBounds(311, 233, 117, 29);
		contentPane.add(btnCompleteForm);
		
		txtPlate = new JTextField();
		txtPlate.setBounds(52, 198, 179, 26);
		contentPane.add(txtPlate);
		txtPlate.setColumns(10);
		
		JLabel lblPlateNumber = new JLabel("Plate Number");
		lblPlateNumber.setBounds(52, 180, 84, 16);
		contentPane.add(lblPlateNumber);
		
		emailField = new JTextField(currentEmail);
		emailField.setBounds(115, 17, 220, 26);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Client Email");
		lblEmail.setBounds(183, 6, 84, 16);
		contentPane.add(lblEmail);
		
		btnCompleteForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				String car = "x";
				String[] cars = (Car.getClientCars(currentEmail));
				for(int i=1; i<5;i++){
					String temp = cars[i];
					if(temp == null){
						car = "CAR"+(i+1);
						break;
					}
					
				}
				
				if(!car.equals("x")){
				String sql = "UPDATE Client SET "+car+" = ? WHERE EMAIL = ?";
				try (Connection conn = DriverManager.getConnection(DBTools.url);
			                PreparedStatement pstmt = conn.prepareStatement(sql)) {
			            pstmt.setString(1, txtPlate.getText());
			            pstmt.setString(2, currentEmail); 
			            pstmt.executeUpdate();
			  
			        } 
				 catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
				 String sql2 = "INSERT INTO Car(PLATE,YEAR,MAKE,MODEL,COLOR) VALUES(?,?,?,?,?)";
				 try (Connection conn = DriverManager.getConnection(DBTools.url);
			                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
					 	pstmt.setString(1,txtPlate.getText());
			            pstmt.setString(2, CarYearcomboBox.getSelectedItem().toString());
			            pstmt.setString(3, txtCarModel.getText());
			            pstmt.setString(4, comboBox.getSelectedItem().toString());
			            pstmt.setString(5, txtCarColor.getText());
			            pstmt.executeUpdate();
			  
			        } 
				 catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
				 JOptionPane.showMessageDialog(null, "Success");
				}else{
					 JOptionPane.showMessageDialog(null, "Too many cars");
				}
				dispose();
			}
		});
			
	}
}
