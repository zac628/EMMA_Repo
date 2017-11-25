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

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AdminUI extends JFrame {
	
	private JPanel contentPane;
	
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminUI() {
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
				//shit
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
		
		JButton btnAdminTools = new JButton("Admin Tools");
		btnAdminTools.setBounds(1036, 152, 200, 200);
		contentPane.add(btnAdminTools);
		
		btnAdminTools.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//shit
			}
		});
		
		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.setBounds(1036, 504, 200, 200);
		contentPane.add(btnUpdateClient);
		
		btnWorkorders.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				//shit
				
			}
		});
		
	}
}
