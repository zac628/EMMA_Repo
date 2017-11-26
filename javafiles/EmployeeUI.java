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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class EmployeeUI extends JFrame {

	private JPanel contentPane;
	DateFormat df = new SimpleDateFormat("HH:mm");
	Date previous = new Date();

	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUI frame = new EmployeeUI();
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
	public EmployeeUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1, 1, 1450, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreateNewWork = new JButton("Create New Work Order");
		btnCreateNewWork.setBounds(184, 212, 469, 93);
		contentPane.add(btnCreateNewWork);	
		btnCreateNewWork.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent work){
				NewWorkOrderUI.go();
			}
		});
		
		JButton btnCreateNewClient = new JButton("Create New Client");
		btnCreateNewClient.setBounds(184, 518, 469, 93);
		contentPane.add(btnCreateNewClient);
		btnCreateNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent client) {
				ContactForm.go();
			}
		});
		
		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.setBounds(837, 212, 406, 93);
		contentPane.add(btnUpdateClient);
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent update) {
			}
		});
		
		JButton btnSale = new JButton("Sale");
		btnSale.setBounds(837, 518, 406, 93);
		contentPane.add(btnSale);
		
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent sale) {
			}
		});
		
		JButton btnPunch = new JButton("Record Time Stamp");
		btnPunch.setBounds(522, 382, 406, 93);
		contentPane.add(btnPunch);
		
		btnPunch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(btnPunch, "Record Time Stamp?\nPrevious Punch: "+Employee.getPunch(Login.currentUser)+" hours ago","Warning",dialogButton);
				
				
				if(dialogResult == JOptionPane.YES_OPTION){
					Date dateobj = new Date();
					previous = dateobj;
					String[] d = df.format(dateobj).split(":");
					
					if(Employee.getPunch(Login.currentUser) == null || Employee.getPunch(Login.currentUser) == 0.0){
						Employee.setPunch((Double.parseDouble(d[0])+(Double.parseDouble(d[1])/60)), Login.currentUser);
					}
					else{
						System.out.println("Punch found: "+Employee.getPunch(Login.currentUser)); 
						Double temp = ((Double.parseDouble(d[0])+(Double.parseDouble(d[1])/60)) - Employee.getPunch(Login.currentUser));
						Double tempHours = Employee.getHours(Login.currentUser);
						Employee.setHours((tempHours+temp), Login.currentUser); 
						Employee.setPunch(0.0,Login.currentUser);
					}
				}
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(1300, 30, 117, 29);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login.go();
				
			}
		});
		
	}
}	