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


public class UpdateUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtPayRatehr;
	private JButton btnFNComit;
	private JButton btnUNComit;
	private JButton btnLNComit;
	private JButton btnPassComit;
	private JButton btnRateComit;
	private JButton btnDesComit;
	private JLabel lblEnterUsernameOf;
	private JTextField usernameField;
	
	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser frame = new UpdateUser();
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
	public UpdateUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(12, 137, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(229, 137, 130, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(268, 230, 161, 29);
		contentPane.add(btnCancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"E", "M", "A"}));
		comboBox.setBounds(246, 190, 76, 27);
		contentPane.add(comboBox);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(246, 175, 76, 16);
		contentPane.add(lblDesignation);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setBounds(229, 99, 130, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(12, 99, 130, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtPayRatehr = new JTextField();
		txtPayRatehr.setText("Pay Rate ($/hr)");
		txtPayRatehr.setBounds(12, 189, 130, 26);
		contentPane.add(txtPayRatehr);
		txtPayRatehr.setColumns(10);
		
		btnFNComit = new JButton("Edit");
		btnFNComit.setBounds(154, 99, 63, 29);
		contentPane.add(btnFNComit);
		btnFNComit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.setFirst(txtFirstName.getText(), usernameField.getText()); 
				btnFNComit.setText("Done");
				btnCancel.setText("Done");
			}
		});
		
		btnUNComit = new JButton("Edit");
		btnUNComit.setBounds(154, 137, 63, 29);
		contentPane.add(btnUNComit);
		btnUNComit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.setUsername(txtUsername.getText(), usernameField.getText()); 
				usernameField.setText(txtUsername.getText());
				btnUNComit.setText("Done");
				btnCancel.setText("Done");
			}
		});
		
		btnLNComit = new JButton("Edit");
		btnLNComit.setBounds(371, 96, 63, 29);
		contentPane.add(btnLNComit);
		btnLNComit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.setLast(txtLastName.getText(), usernameField.getText()); 
				btnLNComit.setText("Done");
				btnCancel.setText("Done");
			}
		});
		
		btnPassComit = new JButton("Edit");
		btnPassComit.setBounds(371, 137, 63, 29);
		contentPane.add(btnPassComit);
		btnPassComit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.setPassword(txtPassword.getText(), usernameField.getText());
				btnPassComit.setText("Done");
				btnCancel.setText("Done");
			} 
		});
		
		btnRateComit = new JButton("Edit");
		btnRateComit.setBounds(154, 189, 63, 29);
		contentPane.add(btnRateComit);
		btnRateComit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.setRate(Double.parseDouble(txtPayRatehr.getText()), usernameField.getText());
				btnRateComit.setText("Done");
				btnCancel.setText("Done");
			}
		});
		
		btnDesComit = new JButton("Edit");
		btnDesComit.setBounds(371, 189, 63, 29);
		contentPane.add(btnDesComit);
		btnDesComit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.setDesignation(comboBox.getSelectedItem().toString(), usernameField.getText()); 
				btnDesComit.setText("Done");
				btnCancel.setText("Done");
			}
		});
		
		JLabel lblUpdateField = new JLabel("Update Field");
		lblUpdateField.setBounds(12, 71, 88, 16);
		contentPane.add(lblUpdateField);
		
		JLabel label = new JLabel("Update Field");
		label.setBounds(229, 71, 88, 16);
		contentPane.add(label);
		
		JLabel lblComit = new JLabel("Comit");
		lblComit.setBounds(164, 71, 61, 16);
		contentPane.add(lblComit);
		
		JLabel label_1 = new JLabel("Comit");
		label_1.setBounds(383, 68, 61, 16);
		contentPane.add(label_1);
		
		lblEnterUsernameOf = new JLabel("Enter Username of the Employee to update");
		lblEnterUsernameOf.setBounds(89, 6, 271, 26);
		contentPane.add(lblEnterUsernameOf);
		
		usernameField = new JTextField();
		usernameField.setBounds(109, 33, 232, 26);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				dispose();
			}
		});
			
	}
}
