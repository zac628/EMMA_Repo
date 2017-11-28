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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Inventory extends JFrame {
	
	private static JPanel contentPane;
	private static JTable table;
	private static DecimalFormat df = new DecimalFormat("#0.00");
	
	public static void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inventory() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1,1,1450,880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnGetList = new JButton("Show Inventory");
		btnGetList.setBounds(1081, 19, 156, 29);
		contentPane.add(btnGetList);
		
		btnGetList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				showTable();
			}
		});
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(42, 6, 43, 29);
		contentPane.add(btnBack);
		
		JLabel lblPartName = new JLabel("Part Name");
		lblPartName.setBounds(122, 24, 69, 16);
		contentPane.add(lblPartName);
		
		JLabel lblQt = new JLabel("Qt.");
		lblQt.setBounds(722, 24, 26, 16);
		contentPane.add(lblQt);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(522, 24, 37, 16);
		contentPane.add(lblPrice);
		
		JLabel lblOrder = new JLabel("Amount On Order");
		lblOrder.setBounds(802, 24, 123, 16);
		contentPane.add(lblOrder);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(1081, 119, 156, 117);
		contentPane.add(btnStock);
		btnStock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				String x = null; 
				int row = 0;
				int q = 0;
				int n = 0;
				String sql = "SELECT PRICE, QUANTITY, ODR FROM Inventory WHERE PART = ?";
				try (Connection conn = DriverManager.getConnection(DBTools.url);
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
					row = table.getSelectedRow();
					x = table.getValueAt(row, 0).toString();
					pstmt.setString(1, x);
					ResultSet rs = pstmt.executeQuery();
					q = rs.getInt("QUANTITY");
					n = rs.getInt("ODR");
				} catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
				String sql2 = "UPDATE Inventory SET QUANTITY = ?, ODR = ? WHERE PART = ?";
				try (Connection conn = DriverManager.getConnection(DBTools.url);
		                PreparedStatement pstmt = conn.prepareStatement(sql)) {
					pstmt.setInt(1, (q+n));
					pstmt.setInt(2, 0);
					pstmt.setString(3, x);
					pstmt.executeUpdate();
				} catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
			}
		});
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(1081, 362, 156, 117);
		contentPane.add(btnOrder);
		btnOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				
			}
		});
		
		JButton btnSpecialOrder = new JButton("Special Order");
		btnSpecialOrder.setBounds(1081, 605, 156, 117);
		contentPane.add(btnSpecialOrder);
		btnSpecialOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				
			}
		});
		
		
	}
	
	public static DefaultTableModel BuildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        	if(columnIndex == 1)
	        		vector.add(rs.getObject(columnIndex));
	        	else if(columnIndex == 2){
	        		vector.add(df.format(rs.getDouble(columnIndex)));
	        	}else{
	        		vector.add(rs.getInt(columnIndex));
	        	}
	        		
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	public static void showTable(){
		String sql = "SELECT * FROM Inventory";
		try (Connection conn = DriverManager.getConnection(DBTools.url);
	                Statement stmt = conn.createStatement()) {
	            ResultSet rs = stmt.executeQuery(sql);
	            String cn[] = {"Part","Price","Quantity","Odr"};
	            DefaultTableModel tModel = new DefaultTableModel(cn,3);
	            JTableHeader header = new JTableHeader();
	            table = new JTable(BuildTableModel(rs));
	    		table.setBounds(117, 46, 800, 766);
	    		contentPane.add(table);
	    		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    		table.getColumnModel().getColumn(1).setMaxWidth(200);
	    		table.getColumnModel().getColumn(0).setMaxWidth(400);
	    		table.getColumnModel().getColumn(2).setMaxWidth(80);
	    		table.getColumnModel().getColumn(3).setMaxWidth(120);
	    		table.getColumnModel().setColumnMargin(10);
	    		table.setTableHeader(header);
	    		table.setGridColor(Color.black);
	    		
	    		

	           
	        } 
		 catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
}