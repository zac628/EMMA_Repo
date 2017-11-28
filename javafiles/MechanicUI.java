import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

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

public class MechanicUI extends JFrame {
	
	private JPanel contentPane;
	DateFormat df = new SimpleDateFormat("HH:mm");
	Date previous = new Date();
	
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MechanicUI frame = new MechanicUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MechanicUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1,1,1450,880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWorkorders = new JButton("Workorders");
		btnWorkorders.setBounds(212, 152, 200, 200);
		contentPane.add(btnWorkorders);
		
		btnWorkorders.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//shit
				
			}
		});
		
		JButton btnSale = new JButton("Sale");
		btnSale.setBounds(624, 152, 200, 200);
		contentPane.add(btnSale);
		
		btnSale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//shit
				
			}
		});
		
		JButton btnNewWorkorder = new JButton("New Workorder");
		btnNewWorkorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewWorkOrderUI.go();
			}
		});
		btnNewWorkorder.setBounds(212, 504, 200, 200);
		contentPane.add(btnNewWorkorder);
		
		
		
		JButton btnNewClient = new JButton("New Client");
		btnNewClient.setBounds(624, 504, 200, 200);
		contentPane.add(btnNewClient);
		
		btnNewClient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				ContactForm.go();
				
			}
		});
		
		JButton btnPunch = new JButton("Record Time Stamp");
		btnPunch.setBounds(1036, 152, 200, 200);
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
		
		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.setBounds(1036, 504, 200, 200);
		contentPane.add(btnUpdateClient);
		btnUpdateClient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				UpdateClient.go();
				
			}
		});
		
		btnWorkorders.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				ListWorkorders.go();
				
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
