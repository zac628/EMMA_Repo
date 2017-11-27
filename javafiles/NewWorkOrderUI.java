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


public class NewWorkOrderUI extends JFrame {

	private JPanel contentPane;
	DateFormat df = new SimpleDateFormat("MM-DD-YYYY");
	Date previous = new Date();
	private JTextField plateField;

	/**
	 * Launch the application.
	 */
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewWorkOrderUI frame = new NewWorkOrderUI();
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
	public NewWorkOrderUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1, 1, 800, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLicensePlate = new JLabel("License Plate");
		lblLicensePlate.setFont(new Font("Arial", Font.PLAIN, 24));
		lblLicensePlate.setBounds(15, 16, 278, 38);
		contentPane.add(lblLicensePlate);
		
		JLabel lblProblemDescription = new JLabel("Problem Description");
		lblProblemDescription.setFont(new Font("Arial", Font.PLAIN, 24));
		lblProblemDescription.setBounds(15, 136, 227, 29);
		contentPane.add(lblProblemDescription);
		
		plateField = new JTextField();
		plateField.setFont(new Font("Monospaced", Font.PLAIN, 26));
		plateField.setBounds(15, 56, 176, 47);
		contentPane.add(plateField);
		plateField.setColumns(10);
		
		JEditorPane pDescription = new JEditorPane();
		pDescription.setFont(new Font("Monospaced", Font.PLAIN, 20));
		pDescription.setBounds(15, 181, 278, 247);
		contentPane.add(pDescription);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNotes.setBounds(339, 16, 90, 38);
		contentPane.add(lblNotes);
		
		JEditorPane notesField = new JEditorPane();
		notesField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		notesField.setBounds(339, 56, 424, 372);
		contentPane.add(notesField);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(146, 444, 176, 49);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent cancel){
				dispose();
			}
		});
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(468, 444, 162, 49);
		contentPane.add(btnDone);
		btnDone.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent done){
				int id = WorkOrder.getID();
				 String sql = "INSERT INTO WorkOrders(PLATE, PDESCRIPTION, NOTES, NUMBER, STATUS, EDATE) VALUES(?,?,?,?,?,?)";
				        try (Connection conn = DriverManager.getConnection(DBTools.url);
				                PreparedStatement pstmt = conn.prepareStatement(sql)) {
				            pstmt.setString(1, plateField.getText());
				            pstmt.setString(2, pDescription.getText());
				            pstmt.setString(3, notesField.getText());
				            pstmt.setInt(4, id);
				            pstmt.setString(5, "Open");
				            pstmt.setString(1, df.format(previous));
				            pstmt.executeUpdate();
				        } catch (SQLException e) {
				            System.out.println(e.getMessage());
				        }
				        
				        String[] orderSlots = WorkOrder.getOrders(plateField.getText());
				        String wo = "x";
				        for(int i = 0; i < 5; i++){
				        	if(orderSlots[i] == null){
				        		wo = "WO" + (i + 1);
				        		break;
				        	}
				        }
				        
				        String sql2 = new String();
				        if(wo != "x"){
				        	Car.shiftOrders(plateField.getText());
				        	sql2 = "UPDATE Car SET WO1 = ?" + "WHERE PLATE = ?";

				        }else{
				        	sql2 = "UPDATE Car SET" + wo + "  = ?" + "WHERE PLATE = ?";
				        }
			        	try (Connection conn = DriverManager.getConnection(DBTools.url);
			        			PreparedStatement pstmt = conn.prepareStatement(sql2)){
			        		pstmt.setInt(1, id);
			        		pstmt.setString(2, plateField.getText());
			        		pstmt.executeUpdate();
			        	} catch(SQLException e){
			        		System.out.println(e.getMessage());
			        	}
			        
							
			        
			   JOptionPane.showMessageDialog(null, "New Work Order Created");
		       dispose(); 
		}
	});	
	}
}