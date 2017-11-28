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
import javax.swing.JPasswordField;


public class AdminCheck extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	
	static String currentUser = "No User";
	private JPasswordField txtPassword;
	private JLabel lblAdminUsername;
	private JLabel lblAdminPassword;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCheck frame = new AdminCheck();
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
	public AdminCheck() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 289, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setBounds(166, 147, 117, 29);
		contentPane.add(btnContinue);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(160, 71, 124, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(160, 111, 124, 26);
		contentPane.add(txtPassword);
		
		lblAdminUsername = new JLabel("Admin Username");
		lblAdminUsername.setBounds(166, 52, 117, 16);
		contentPane.add(lblAdminUsername);
		
		lblAdminPassword = new JLabel("Admin Password");
		lblAdminPassword.setBounds(164, 96, 117, 16);
		contentPane.add(lblAdminPassword);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(166, 188, 117, 29);
		contentPane.add(btnCancel);
		
			
		btnContinue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(DBTools.testAll(txtUsername.getText(), txtPassword.getText()).equals("A")){
						SpecialOrder.go();
					dispose();
				}else{
					JOptionPane.showMessageDialog(btnContinue, "Invalid Credentials");
				}
			}
		});
			
	}
}
