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


public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtPayRatehr;
	
	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
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
	public CreateUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(30, 88, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(192, 88, 130, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnCreateUser = new JButton("Create Employee");
		btnCreateUser.setBounds(268, 230, 161, 29);
		contentPane.add(btnCreateUser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"E", "M", "A"}));
		comboBox.setBounds(246, 141, 76, 27);
		contentPane.add(comboBox);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(246, 126, 76, 16);
		contentPane.add(lblDesignation);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setBounds(192, 50, 130, 26);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(30, 50, 130, 26);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtPayRatehr = new JTextField();
		txtPayRatehr.setText("Pay Rate ($/hr)");
		txtPayRatehr.setBounds(30, 140, 130, 26);
		contentPane.add(txtPayRatehr);
		txtPayRatehr.setColumns(10);
		
		btnCreateUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				DBTools.insert(txtUsername.getText(),txtPassword.getText(),comboBox.getSelectedItem().toString(),txtFirstName.getText(),txtLastName.getText(),Double.parseDouble(txtPayRatehr.getText()));
				JOptionPane.showMessageDialog(null, "New User Created");
			}
		});
			
	}
}
