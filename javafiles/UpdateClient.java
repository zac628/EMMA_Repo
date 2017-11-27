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


public class UpdateClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField emailField;

	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClient frame = new UpdateClient();
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
	public UpdateClient() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("");
		txtFirstName.setBounds(11, 66, 179, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name*");
		lblNewLabel.setBounds(11, 56, 179, 16);
		contentPane.add(lblNewLabel);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(289, 72, 179, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name*");
		lblNewLabel_1.setBounds(289, 56, 84, 16);
		contentPane.add(lblNewLabel_1);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(11, 112, 179, 26);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number*");
		lblNewLabel_2.setBounds(11, 98, 179, 16);
		contentPane.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(289, 114, 179, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(288, 98, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(11, 158, 457, 26);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(11, 142, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(439, 256, 117, 29);
		contentPane.add(btnCancel);
		
		JButton btnFNC = new JButton("Commit");
		btnFNC.setBounds(201, 72, 77, 29);
		contentPane.add(btnFNC);
		btnFNC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientOperations.setFirst(emailField.getText(), txtFirstName.getText());
				btnCancel.setText("Done"); 
			}
		});
		
		JButton btnLNC = new JButton("Commit");
		btnLNC.setBounds(479, 72, 77, 29);
		contentPane.add(btnLNC);
		btnLNC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientOperations.setLast(emailField.getText(), txtLastName.getText());
				btnCancel.setText("Done"); 
			}
		});
		
		JButton btnPhoneC = new JButton("Commit");
		btnPhoneC.setBounds(201, 114, 77, 29);
		contentPane.add(btnPhoneC);
		btnPhoneC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientOperations.setNumber(emailField.getText(), txtPhoneNumber.getText());
				btnCancel.setText("Done"); 
			}
		});
		
		JButton btnEmailC = new JButton("Commit");
		btnEmailC.setBounds(479, 114, 77, 29);
		contentPane.add(btnEmailC);
		btnEmailC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientOperations.setEmail(emailField.getText(), txtEmail.getText());
				emailField.setText(txtEmail.getText());
				btnCancel.setText("Done"); 
			}
		});
		
		JButton btnAddress = new JButton("Commit");
		btnAddress.setBounds(479, 158, 77, 29);
		contentPane.add(btnAddress);
		btnAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientOperations.setAddress(emailField.getText(), txtAddress.getText());
				btnCancel.setText("Done"); 
			}
		});
		
		emailField = new JTextField();
		emailField.setBounds(145, 26, 258, 26);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblEnterEmailOf = new JLabel("Enter Email of the Client to update");
		lblEnterEmailOf.setBounds(163, 8, 224, 16);
		contentPane.add(lblEnterEmailOf);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(54, 215, 117, 29);
		contentPane.add(btnAddCar);
		btnAddCar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				AddCar.go(emailField.getText());
			}
		});
		
		JButton btnEditCar = new JButton("Edit Car");
		btnEditCar.setBounds(225, 215, 117, 29);
		contentPane.add(btnEditCar);
		btnEditCar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				UpdateCar.go(emailField.getText());
			}
		});
		
		JButton btnRemoveCar = new JButton("Remove Car");
		btnRemoveCar.setBounds(396, 215, 117, 29);
		contentPane.add(btnRemoveCar);
		btnRemoveCar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				RemoveCar.go(emailField.getText());
			}
		});
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				dispose();
			}
		});
	}
}
