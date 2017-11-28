import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminTools extends JFrame {
	
	private JPanel contentPane;
	
	
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTools frame = new AdminTools();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminTools() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1,1,1450,880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreateEmployee = new JButton("Create Employee/User");
		btnCreateEmployee.setBounds(184, 212, 469, 93);
		contentPane.add(btnCreateEmployee);	
		btnCreateEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent work){
				CreateUser.go();
			}
		});
		
		JButton btnUpdateEmployee = new JButton("Update Emplyoee/User");
		btnUpdateEmployee.setBounds(184, 518, 469, 93);
		contentPane.add(btnUpdateEmployee);
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent client) {
				UpdateUser.go();
			}
		});
		
		JButton btnReports = new JButton("Reports");
		btnReports.setBounds(837, 212, 406, 93);
		contentPane.add(btnReports);
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent update) {
				ReportsUI.go();
			}
		});
		
		JButton btnSale = new JButton("Sale");
		btnSale.setBounds(837, 518, 406, 93);
		contentPane.add(btnSale);
		
		JButton btnBack = new JButton("<");
		btnBack.setBounds(51, 36, 44, 29);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminUI.go();
			}
		});
		
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent sale) {
				//shit
			}
		});
	}
}
	