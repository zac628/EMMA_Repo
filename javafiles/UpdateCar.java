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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class UpdateCar extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtCarModel;
	private JTextField txtCarColor;
	private JTextField txtPlate;
	static String currentEmail;
	ResultSet cars = null;
	ResultSet info = null;
	private String plate = "";

	/**
	 * Launch the application.
	 */
	public static void go(String email) {
		currentEmail = email;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCar frame = new UpdateCar();
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
	public UpdateCar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEmail = new JTextField(currentEmail);
		txtEmail.setBounds(25, 33, 179, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Client Email");
		lblNewLabel_3.setBounds(25, 16, 95, 16);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"}));
		comboYear.setToolTipText("");
		comboYear.setBounds(277, 103, 96, 27);
		contentPane.add(comboYear);
		
		JLabel lblNewLabel_5 = new JLabel("Car Year");
		lblNewLabel_5.setBounds(277, 85, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboMake = new JComboBox();
		comboMake.setModel(new DefaultComboBoxModel(new String[] {"Acura", "Alfa Romeo", "AMC", "Ariel", "Aston Martin", "Audi", "Austin Healey", "Bentley", "BMW", "Bugatti", "Buick", "Cadillac", "Callaway", "Caterham", "Cheverlot", "Chrysler", "Daewoo", "Datsun", "Dodge", "Ferrari", "Fiat", "Ford ", "Genesis", "Geo", "GMC", "Honda", "Hummer", "Hyundai", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", "Lamborghini", "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati", "Maybach", "Mazda", "Mclaren ", "Mercedes", "Mercurt", "Mini", "Mitisubishi", "Nissian", "Noble", "Oldsmobile", "Plymouth", "Pontiac", "Porsche", "Proton ", "Ram", "Rolls Royce", "Saab", "Saleen", "Saturn ", "Scion", "Shelby", "Smart", "Suburu", "Suzuki", "Telsa", "Toyota", "VW", "Volvo", ""}));
		comboMake.setBounds(25, 103, 98, 27);
		contentPane.add(comboMake);
		
		
		/*comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				try{
					cars = Car.getClientCars(currentEmail);
					info = Car.getCarInfo(currentEmail, cars.getString(comboBox.getSelectedItem().toString()));
					comboBox.setSelectedItem(info.getString("MAKE"));
					txtCarModel.setText(info.getString("MODEL"));
					CarYearcomboBox.setSelectedItem(info.getString("YEAR"));
					txtCarColor.setText(info.getString("COLOR"));
					txtPlate.setText(info.getString("PLATE"));
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
				
			}
		});*/
	
		
		JLabel lblNewLabel_6 = new JLabel("Car Make ");
		lblNewLabel_6.setBounds(25, 88, 62, 16);
		contentPane.add(lblNewLabel_6);
		
		txtCarModel = new JTextField();
		txtCarModel.setBounds(135, 102, 115, 26);
		contentPane.add(txtCarModel);
		txtCarModel.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Car Model");
		lblNewLabel_7.setBounds(135, 88, 72, 16);
		contentPane.add(lblNewLabel_7);
		
		txtCarColor = new JTextField();
		txtCarColor.setBounds(245, 172, 128, 26);
		contentPane.add(txtCarColor);
		txtCarColor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Car Color ");
		lblNewLabel_8.setBounds(245, 154, 71, 16);
		contentPane.add(lblNewLabel_8);
		
		JButton btnCompleteForm = new JButton("Complete");
		btnCompleteForm.setBounds(285, 233, 117, 29);
		contentPane.add(btnCompleteForm);
		
		txtPlate = new JTextField();
		txtPlate.setBounds(25, 172, 179, 26);
		contentPane.add(txtPlate);
		txtPlate.setColumns(10);
		
		JLabel lblPlateNumber = new JLabel("Plate Number");
		lblPlateNumber.setBounds(25, 154, 84, 16);
		contentPane.add(lblPlateNumber);
		
		JComboBox comboCar = new JComboBox();
		comboCar.setModel(new DefaultComboBoxModel(new String[] {"CAR1", "CAR2", "CAR3", "CAR4", "CAR5"}));
		comboCar.setBounds(277, 34, 96, 27);
		contentPane.add(comboCar);
		
		JLabel lblCar = new JLabel("Car");
		lblCar.setBounds(287, 16, 61, 16);
		contentPane.add(lblCar);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(231, 33, 56, 29);
		contentPane.add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] cars = (Car.getClientCars(currentEmail));
				String num ="";
				if(comboCar.getSelectedItem().toString().equals("CAR1"))
					num = cars[0];
				else if(comboCar.getSelectedItem().toString().equals("CAR2"))
					num = cars[1];
				else if(comboCar.getSelectedItem().toString().equals("CAR3"))
					num = cars[2];
				else if(comboCar.getSelectedItem().toString().equals("CAR4"))
					num = cars[3];
				else if(comboCar.getSelectedItem().toString().equals("CAR5"))
					num = cars[4];
				
				String[] info = Car.getCarInfo(currentEmail, num);
				txtPlate.setText(info[0]);
				plate = info[0];
				comboYear.setSelectedItem(info[1]);
				comboMake.setSelectedItem(info[2]);
				txtCarModel.setText(info[3]);
				txtCarColor.setText(info[4]);
			}
			
		});
		
		btnCompleteForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				Car.setPlate(txtPlate.getText(), plate);
				ClientOperations.setCar1(currentEmail, txtPlate.getText());
				Car.setYear(comboYear.getSelectedItem().toString(), txtPlate.getText());
				Car.setMake(comboMake.getSelectedItem().toString(),txtPlate.getText());
				Car.setModel(txtCarModel.getText(), txtPlate.getText());
				Car.setColor(txtCarColor.getText(), txtPlate.getText());
			}
		});
			
	}
}
