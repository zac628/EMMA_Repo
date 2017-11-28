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
	
	private JPanel contentPane;
	private JTable table;
	
	
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
			    		table.getColumnModel().getColumn(3).setMaxWidth(500);
			    		table.getColumnModel().getColumn(4).setMaxWidth(80);
			    		table.getColumnModel().setColumnMargin(10);
			    		table.setTableHeader(header);
			    		
			    		

			           
			        } 
				 catch (SQLException e) {
			            System.out.println(e.getMessage());
			        }
			}
		});
		
	}
}