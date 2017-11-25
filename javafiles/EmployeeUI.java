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


public class EmployeeUI extends JFrame {

	private JPanel contentPane;


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
	}
}	