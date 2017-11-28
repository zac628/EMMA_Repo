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


public class SpecialOrder extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrice;
	private JTextField txtOdr;
	private JTextField txtPart;

	/**
	 * Launch the application.
	 */
	public static void go() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecialOrder frame = new SpecialOrder();
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
	public SpecialOrder() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 289, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(69, 133, 115, 26);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price of Part");
		lblPrice.setBounds(73, 119, 115, 16);
		contentPane.add(lblPrice);
		
		txtOdr = new JTextField();
		txtOdr.setBounds(253, 133, 128, 26);
		contentPane.add(txtOdr);
		txtOdr.setColumns(10);
		
		JLabel lblOdr = new JLabel("How Many?");
		lblOdr.setBounds(261, 119, 115, 16);
		contentPane.add(lblOdr);
		
		JButton btnCompleteForm = new JButton("Complete");
		btnCompleteForm.setBounds(311, 233, 117, 29);
		contentPane.add(btnCompleteForm);
		
		txtPart = new JTextField();
		txtPart.setBounds(114, 51, 220, 26);
		contentPane.add(txtPart);
		txtPart.setColumns(10);
		
		JLabel lblPart = new JLabel("Part Name");
		lblPart.setBounds(183, 34, 84, 16);
		contentPane.add(lblPart);
		
		btnCompleteForm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				String sql = "INSERT INTO Inventory(PART, PRICE, QUANTITY, ODR) VALUES(?,?,?,?)";
		        try (Connection conn = DriverManager.getConnection(DBTools.url);
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            	pstmt.setString(1, txtPart.getText());
		            	pstmt.setDouble(2, Double.parseDouble(txtPrice.getText()));
		            	pstmt.setInt(3, 0);
		            	pstmt.setInt(4,Integer.parseInt(txtOdr.getText()));
		            pstmt.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		        JOptionPane.showMessageDialog(null, "Succesfully added "+Integer.parseInt(txtOdr.getText())+"of "+txtPart.getText()+ " to orders");
		        dispose();
			}
		});
			
	}
}
