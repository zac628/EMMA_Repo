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
import java.sql.ResultSet;
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
import javax.swing.JTable;

public class SaleUI extends JFrame {

	private JPanel contentPane;
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	Date previous = new Date();
	private JTextField textFieldOrderNumber;
	private JTextField textFieldLaborHours;
	private JButton btnCancel;
	private JButton btnPay;
	private JLabel lblSolutionDescription;
	private JLabel lblPartsUsed;
	private JLabel lblNotes;
	private JEditorPane editorPaneNotes;
	private JLabel lblPartName;
	private JLabel lblQuantity;
	private JTextField textFieldP1;
	private JTextField Q1;
	private JTextField textFieldP2;
	private JTextField textFieldQ2;
	private JTextField textFieldP3;
	private JTextField textFieldQ3;
	private JTextField textFieldP4;
	private JTextField textFieldQ4;
	private JTextField textFieldP5;
	private JTextField textFieldQ5;
	private JLabel lblX;
	private JLabel x2;
	private JLabel x3;
	private JLabel x4;
	private JLabel x5;

	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleUI frame = new SaleUI();
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
	public SaleUI() {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1, 1, 1450, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWorkOrderNumber = new JLabel("Work Order Number");
		lblWorkOrderNumber.setFont(new Font("Arial", Font.PLAIN, 24));
		lblWorkOrderNumber.setBounds(15, 16, 228, 42);
		contentPane.add(lblWorkOrderNumber);
		
		textFieldOrderNumber = new JTextField();
		textFieldOrderNumber.setFont(new Font("Monospaced", Font.PLAIN, 24));
		textFieldOrderNumber.setBounds(15, 67, 228, 42);
		contentPane.add(textFieldOrderNumber);
		textFieldOrderNumber.setColumns(10);
		
		JLabel lblLaborHours = new JLabel("Labor Hours");
		lblLaborHours.setFont(new Font("Arial", Font.PLAIN, 24));
		lblLaborHours.setBounds(15, 125, 228, 42);
		contentPane.add(lblLaborHours);
		
		textFieldLaborHours = new JTextField();
		textFieldLaborHours.setFont(new Font("Monospaced", Font.PLAIN, 24));
		textFieldLaborHours.setBounds(15, 183, 228, 42);
		contentPane.add(textFieldLaborHours);
		textFieldLaborHours.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(356, 679, 179, 49);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent done){
				dispose();
			}
		});
		
		lblSolutionDescription = new JLabel("Solution Description");
		lblSolutionDescription.setFont(new Font("Arial", Font.PLAIN, 24));
		lblSolutionDescription.setBounds(328, 16, 235, 42);
		contentPane.add(lblSolutionDescription);
		
		JEditorPane editorPaneDescription = new JEditorPane();
		editorPaneDescription.setFont(new Font("Monospaced", Font.PLAIN, 16));
		editorPaneDescription.setBounds(328, 67, 368, 298);
		contentPane.add(editorPaneDescription);
		
		lblPartsUsed = new JLabel("Parts Used");
		lblPartsUsed.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPartsUsed.setBounds(785, 16, 235, 42);
		contentPane.add(lblPartsUsed);
		
		lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNotes.setBounds(15, 342, 69, 20);
		contentPane.add(lblNotes);
		
		editorPaneNotes = new JEditorPane();
		editorPaneNotes.setFont(new Font("Monospaced", Font.PLAIN, 16));
		editorPaneNotes.setBounds(15, 388, 681, 235);
		contentPane.add(editorPaneNotes);
		
		lblPartName = new JLabel("Part Name");
		lblPartName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPartName.setBounds(785, 67, 114, 20);
		contentPane.add(lblPartName);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Arial", Font.PLAIN, 18));
		lblQuantity.setBounds(1124, 67, 69, 20);
		contentPane.add(lblQuantity);
		
		textFieldP1 = new JTextField();
		textFieldP1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldP1.setBounds(785, 95, 270, 31);
		contentPane.add(textFieldP1);
		textFieldP1.setColumns(10);
		
		Q1 = new JTextField();
		Q1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		Q1.setColumns(10);
		Q1.setBounds(1124, 95, 69, 31);
		contentPane.add(Q1);
		
		textFieldP2 = new JTextField();
		textFieldP2.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldP2.setColumns(10);
		textFieldP2.setBounds(785, 142, 270, 31);
		contentPane.add(textFieldP2);
		
		textFieldQ2 = new JTextField();
		textFieldQ2.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldQ2.setColumns(10);
		textFieldQ2.setBounds(1124, 142, 69, 31);
		contentPane.add(textFieldQ2);
		
		textFieldP3 = new JTextField();
		textFieldP3.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldP3.setColumns(10);
		textFieldP3.setBounds(785, 190, 270, 31);
		contentPane.add(textFieldP3);
		
		textFieldQ3 = new JTextField();
		textFieldQ3.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldQ3.setColumns(10);
		textFieldQ3.setBounds(1124, 193, 69, 31);
		contentPane.add(textFieldQ3);
		
		textFieldP4 = new JTextField();
		textFieldP4.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldP4.setColumns(10);
		textFieldP4.setBounds(785, 237, 270, 31);
		contentPane.add(textFieldP4);
		
		textFieldQ4 = new JTextField();
		textFieldQ4.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldQ4.setColumns(10);
		textFieldQ4.setBounds(1124, 240, 69, 31);
		contentPane.add(textFieldQ4);
		
		textFieldP5 = new JTextField();
		textFieldP5.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldP5.setColumns(10);
		textFieldP5.setBounds(785, 284, 270, 31);
		contentPane.add(textFieldP5);
		
		textFieldQ5 = new JTextField();
		textFieldQ5.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textFieldQ5.setColumns(10);
		textFieldQ5.setBounds(1124, 287, 69, 31);
		contentPane.add(textFieldQ5);
		
		lblX = new JLabel("x");
		lblX.setBounds(1081, 101, 69, 20);
		contentPane.add(lblX);
		
		x2 = new JLabel("x");
		x2.setBounds(1081, 148, 69, 20);
		contentPane.add(x2);
		
		x3 = new JLabel("x");
		x3.setBounds(1081, 196, 69, 20);
		contentPane.add(x3);
		
		x4 = new JLabel("x");
		x4.setBounds(1081, 243, 69, 20);
		contentPane.add(x4);
		
		x5 = new JLabel("x");
		x5.setBounds(1081, 290, 69, 20);
		contentPane.add(x5);
		
		btnPay = new JButton("Pay");
		btnPay.setBounds(891, 679, 179, 49);
		contentPane.add(btnPay);
		btnPay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent done){
				int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(btnPay, "Are you sure?","Warning",dialogButton);
				
				
				if(dialogResult == JOptionPane.YES_OPTION){
					double labor = Double.parseDouble(textFieldLaborHours.getText());
					int on = Integer.parseInt(textFieldOrderNumber.getText());
					String prevNotes = new String();
					
					double price = labor * 30;
					
					String sql2 = "SELECT NOTES FROM WorkOrders WHERE NUMBER =?";
					try(Connection conn = DriverManager.getConnection(DBTools.url);
							PreparedStatement pstmt = conn.prepareStatement(sql2)){
						pstmt.setInt(1, on);
						ResultSet rs = pstmt.executeQuery();
						
						prevNotes = rs.getString("NOTES");
					}catch(SQLException e){
						System.out.println(e.getMessage());
					}
					
					String sql = "UPDATE WorkOrders SET SDESCRIPTION =?, LABOR =?, CDATE =?, NOTES =? WHERE NUMBER =?";
					try (Connection conn = DriverManager.getConnection(DBTools.url);
		        			PreparedStatement pstmt = conn.prepareStatement(sql)){
		        		pstmt.setString(1, editorPaneDescription.getText());
		        		pstmt.setDouble(2, labor);
		        		pstmt.setString(3, df.format(previous));
		        		pstmt.setString(4, prevNotes + "\n" + editorPaneNotes.getText());
		        		pstmt.setInt(5, on);
		        		pstmt.executeUpdate();
		        	} catch(SQLException e){
		        		System.out.println(e.getMessage());
		        	}
					
					if(textFieldP1.getText() != null){
						int q1 = Integer.parseInt(Q1.getText());
						String sql3 = "SELECT PRICE FROM Inventory WHERE NAME =?";
						try(Connection conn = DriverManager.getConnection(DBTools.url);
								PreparedStatement pstmt = conn.prepareStatement(sql3)){
							pstmt.setString(1, textFieldP1.getText());
							ResultSet rs = pstmt.executeQuery();
							
							price += rs.getDouble("Price") * q1;
						}catch(SQLException e){
							System.out.println(e.getMessage());
						}
					}
					
					if(textFieldP2.getText() != null){
						int q2 = Integer.parseInt(textFieldQ2.getText());
						String sql4 = "SELECT PRICE FROM Inventory WHERE NAME =?";
						try(Connection conn = DriverManager.getConnection(DBTools.url);
								PreparedStatement pstmt = conn.prepareStatement(sql4)){
							pstmt.setString(1, textFieldP2.getText());
							ResultSet rs = pstmt.executeQuery();
							
							price += rs.getDouble("Price") * q2;
						}catch(SQLException e){
							System.out.println(e.getMessage());
						}
					}
					
					if(textFieldP3.getText() != null){
						int q3 = Integer.parseInt(textFieldQ3.getText());
						String sql5 = "SELECT PRICE FROM Inventory WHERE NAME =?";
						try(Connection conn = DriverManager.getConnection(DBTools.url);
								PreparedStatement pstmt = conn.prepareStatement(sql5)){
							pstmt.setString(1, textFieldP3.getText());
							ResultSet rs = pstmt.executeQuery();
							
							price += rs.getDouble("Price") * q3;
						}catch(SQLException e){
							System.out.println(e.getMessage());
						}
					}
					
					if(textFieldP4.getText() != null){
						int q4 = Integer.parseInt(textFieldQ4.getText());
						String sql6 = "SELECT PRICE FROM Inventory WHERE NAME =?";
						try(Connection conn = DriverManager.getConnection(DBTools.url);
								PreparedStatement pstmt = conn.prepareStatement(sql6)){
							pstmt.setString(1, textFieldP4.getText());
							ResultSet rs = pstmt.executeQuery();
							
							price += rs.getDouble("Price") * q4;
						}catch(SQLException e){
							System.out.println(e.getMessage());
						}
					}
					
					if(textFieldP5.getText() != null){
						int q5 = Integer.parseInt(textFieldQ5.getText());
						String sql7 = "SELECT PRICE FROM Inventory WHERE NAME =?";
						try(Connection conn = DriverManager.getConnection(DBTools.url);
								PreparedStatement pstmt = conn.prepareStatement(sql7)){
							pstmt.setString(1, textFieldP5.getText());
							ResultSet rs = pstmt.executeQuery();
							
							price += rs.getDouble("Price") * q5;
						}catch(SQLException e){
							System.out.println(e.getMessage());
						}
					}
					
					String sql8 = "INSERT INTO Sales(WO,PAID) VALUES(?,?)";
			        try (Connection conn = DriverManager.getConnection(DBTools.url);
			                PreparedStatement pstmt = conn.prepareStatement(sql8)) {
			            pstmt.setInt(1, on);
			            pstmt.setDouble(2, price);
			            pstmt.executeUpdate();
			        } catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
				}
			}
		});
		
		
	}
}	