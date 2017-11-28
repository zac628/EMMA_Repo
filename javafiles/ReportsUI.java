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
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.text.*;

public class ReportsUI extends JFrame {

	private JPanel contentPane;
	DateFormat df = new SimpleDateFormat("MM-DD-YYYY");
	Date previous = new Date();

	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsUI frame = new ReportsUI();
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
	public ReportsUI() {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1, 1, 800, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalRevenue = new JLabel("Total Revenue: $" + formatter.format(Reports.getRevenue()));
		lblTotalRevenue.setFont(new Font("Arial", Font.PLAIN, 24));
		lblTotalRevenue.setBounds(15, 16, 208, 36);
		contentPane.add(lblTotalRevenue);
		
		JLabel lblLaborCost = new JLabel("Labor Cost: $" + formatter.format(Reports.getLaborCost()));
		lblLaborCost.setFont(new Font("Arial", Font.PLAIN, 24));
		lblLaborCost.setBounds(15, 68, 208, 36);
		contentPane.add(lblLaborCost);
		
		JLabel lblInventoryCost = new JLabel("Inventory Cost: $" + formatter.format(Reports.getInventoryCost()));
		lblInventoryCost.setFont(new Font("Arial", Font.PLAIN, 24));
		lblInventoryCost.setBounds(15, 120, 208, 36);
		contentPane.add(lblInventoryCost);
		
		JLabel lblTotalProfit = new JLabel("Total Profit: $" + formatter.format(Reports.getProfit()));
		lblTotalProfit.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTotalProfit.setBounds(15, 172, 239, 58);
		contentPane.add(lblTotalProfit);
		
		JButton btnFinalizePayPeriod = new JButton("Finalize Pay Period");
		btnFinalizePayPeriod.setFont(new Font("Arial", Font.PLAIN, 30));
		btnFinalizePayPeriod.setBounds(15, 246, 346, 67);
		contentPane.add(btnFinalizePayPeriod);
		btnFinalizePayPeriod.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent done){
				String sql = "UPDATE User SET HOURS =?";
				try (Connection conn = DriverManager.getConnection(DBTools.url);
	        			PreparedStatement pstmt = conn.prepareStatement(sql)){
	        		pstmt.setDouble(1, 0.0);
	        		pstmt.executeUpdate();
	        	} catch(SQLException e){
	        		System.out.println(e.getMessage());
	        	}
				
				//Print Screen Contents
				JOptionPane.showMessageDialog(null, "Pay Period Finalized");
				dispose();
			}
		});
	}
}
	