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


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	
	static String currentUser = "No User";
	private JPasswordField txtPassword;
	
	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(166, 147, 117, 29);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(160, 71, 124, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("Password");
		txtPassword.setBounds(160, 109, 124, 26);
		contentPane.add(txtPassword);
		
			
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				
				if(DBTools.testAll(txtUsername.getText(), txtPassword.getText()).equals("A")){
					//JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
					AdminUI.go();
					currentUser = txtUsername.getText();
					dispose();
				}else if(DBTools.testAll(txtUsername.getText(), txtPassword.getText()).equals("M")){
					MechanicUI.go();
					currentUser = txtUsername.getText();
					dispose();
				}
				else if(DBTools.testAll(txtUsername.getText(), txtPassword.getText()).equals("E")){
					EmployeeUI.go();
					currentUser = txtUsername.getText();
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Record Not Found");
				//DBTools.insert(un1.getText(), p1.getText());
				}
			
		});
			
	}
}
