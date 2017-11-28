import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ListWorkorders extends JFrame {
	
	private static JPanel contentPane;
	private static JTable table;
	
	
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListWorkorders frame = new ListWorkorders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListWorkorders() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1,1,1450,880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGetList = new JButton("Get Work Orders");
		btnGetList.setBounds(1265, 19, 156, 29);
		contentPane.add(btnGetList);
		
		btnGetList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				showTable();
			}
		});
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = JOptionPane.showInputDialog("Enter Username");
				int row  = table.getSelectedRow();
				int woid = Integer.parseInt(table.getValueAt(row, 0).toString());
				
				String[] orderSlots = Mechanic.getOrders(un);
		        String wo = "x";
		        for(int i = 0; i < 5; i++){
		        	if(orderSlots[i] == null){
		        		wo = "WO" + (i + 1);
		        		break;
		        	}
		        }
		        String sql;
		        if(wo != "x"){
					sql = "UPDATE Mechanic SET " + wo + "  = ?" + "WHERE USERNAME = ?";
		        }else{
		        	Mechanic.shiftOrders(un);
		        	sql = "UPDATE Mechanic SET WO1 = ?" + "WHERE USERNAME = ?";
		        }try (Connection conn = DriverManager.getConnection(DBTools.url);
	        			PreparedStatement pstmt = conn.prepareStatement(sql)){
	        		pstmt.setInt(1, woid);
	        		pstmt.setString(2, un);
	        		pstmt.executeUpdate();
	        	} catch(SQLException e1){
	        		System.out.println(e1.getMessage());
	        	}
		        
		        String sql2 = "UPDATE WorkOrders SET STATUS = ? WHERE NUMBER= ?";
		        try (Connection conn = DriverManager.getConnection(DBTools.url);
	        			PreparedStatement pstmt = conn.prepareStatement(sql2)){
	        		pstmt.setString(1, Employee.getFName(un)+" "+Employee.getLName(un));
	        		pstmt.setInt(2, woid);
	        		pstmt.executeUpdate();
	        	} catch(SQLException e1){
	        		System.out.println(e1.getMessage());
	        	}
		        JOptionPane.showMessageDialog(null, "WorkOrder "+woid+" Assigned to "+un);
		        dispose();
			}
		});
		btnAssign.setBounds(1304, 818, 117, 29);
		contentPane.add(btnAssign);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(42, 6, 43, 29);
		contentPane.add(btnBack);
		
		JLabel lblWo = new JLabel("WO#");
		lblWo.setBounds(122, 24, 35, 16);
		contentPane.add(lblWo);
		
		JLabel lblLicense = new JLabel("Plate #");
		lblLicense.setBounds(162, 24, 53, 16);
		contentPane.add(lblLicense);
		
		JLabel lblProblemDescription = new JLabel("Problem Description");
		lblProblemDescription.setBounds(242, 24, 217, 16);
		contentPane.add(lblProblemDescription);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(742, 24, 53, 16);
		contentPane.add(lblNotes);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(1222, 24, 43, 16);
		contentPane.add(lblStatus);
		
	}
	public static void showTable(){
		DefaultListModel model = new DefaultListModel();
		String sql = "SELECT NUMBER,PLATE,PDESCRIPTION,NOTES,STATUS FROM WorkOrders";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
	                Statement stmt = conn.createStatement()) {
	            ResultSet rs = stmt.executeQuery(sql);
	            String cn[] = {"WO#","Plate","Problem Description","Notes", "Status"};
	            DefaultTableModel tModel = new DefaultTableModel(cn,4);
	            JTableHeader header = new JTableHeader();
	            table = new JTable(WorkOrder.buildTableModel(rs));
	    		table.setBounds(117, 46, 1216, 766);
	    		contentPane.add(table);
	    		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    		table.getColumnModel().getColumn(0).setMaxWidth(40);
	    		table.getColumnModel().getColumn(1).setMaxWidth(80);
	    		table.getColumnModel().getColumn(2).setMaxWidth(500);
	    		table.getColumnModel().getColumn(3).setMaxWidth(480);
	    		table.getColumnModel().getColumn(4).setMaxWidth(100);
	    		table.getColumnModel().setColumnMargin(10);
	    		table.setTableHeader(header);
	    		table.setGridColor(Color.BLACK);
	    		
	    		

	           
	        } 
		 catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
}