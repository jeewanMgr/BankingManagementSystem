package com.design;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.core.AdminCustomerDlt;
import com.core.checkingInsert;
import net.proteanit.sql.DbUtils;
import java.awt.Window;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class CustomerList {

	public JFrame frame;
	private JTable table;
	
	 checkingInsert obj = new checkingInsert();
		Connection conn = obj.getconnection();
		Statement stmt;
		 PreparedStatement prs =null;
		 private JTable ssnumber;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerList window = new CustomerList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerList() {
		initialize();
		alldataAcc();
		 ssnShow();
		 updatessn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 500, 800, 500);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		/*
		if(!(frame.isActive()))
		{
			AdminGUI obj = new AdminGUI();
			obj.frame.setVisible(true);
		}*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(12, 56, 714, 150);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		table.setToolTipText("");
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel());
		/*	new Object[][] {
			},
			new String[] {
				"UserName", "PassWord", "FullName", "Social Security Number", "Address"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});*/
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(12, 346, 174, 37);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(589, 219, 174, 235);
		frame.getContentPane().add(scrollPane_1);
		
		ssnumber = new JTable();
		scrollPane_1.setViewportView(ssnumber);
		
		JButton btnDltSsn = new JButton("Dlt SSN");
		btnDltSsn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String number = JOptionPane.showInputDialog(null,"enter a ssn number");
				int ssn = Integer.parseInt(number);
				AdminCustomerDlt ne = new AdminCustomerDlt();
				ne.ssndlt(ssn);
				updatessn();}catch (NumberFormatException ex) {
					
				}
				
			}
		});
		btnDltSsn.setBounds(12, 271, 174, 43);
		frame.getContentPane().add(btnDltSsn);
		
		JLabel lblJeewanBankingManagement = new JLabel("Jeewan Banking Management System");
		lblJeewanBankingManagement.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblJeewanBankingManagement.setBounds(169, 13, 418, 30);
		frame.getContentPane().add(lblJeewanBankingManagement);
		
		JButton btnNewButton_1 = new JButton("Refrace");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.setVisible(true);
				ssnShow();
				//updatessn();
				alldataAcc();
			}
		});
		btnNewButton_1.setBounds(224, 271, 183, 43);
		frame.getContentPane().add(btnNewButton_1);
	}

	public Window getFrame1() {
		// TODO Auto-generated method stub
		return null;
	}
	public void alldataAcc()
	  {
		 
		  try {
			  String alldata ="select * from newaccount";
			   prs = conn.prepareStatement(alldata);
			   ResultSet result = prs.executeQuery();
			   table.setModel(DbUtils.resultSetToTableModel(result));
			  
		  } catch(Exception e)
		  {
			  
		  }
		 
		  
	  }
	public void ssnShow()
	{
		try {
			String allssn = "select * from ssn";
			prs = conn.prepareStatement(allssn);
			 ResultSet result = prs.executeQuery();
			 ssnumber.setModel(DbUtils.resultSetToTableModel(result));
		}catch(Exception e)
		{
			
		}
		
		
	}
	
	public void updatessn()
	{
		try {
			stmt = conn.createStatement();
		String updatessn = "update ssn";
		stmt.executeUpdate(updatessn);
		 table.updateUI();
		}catch(Exception e)
		{
			
		}
		
	}
}
