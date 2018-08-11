package com.design;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTabbedPane;

import com.core.AdminCustomerDlt;
import com.core.adminCheckingSSn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class AdminGUI {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public AdminGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 500, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHereIAm = new JLabel("JEEWAN BAKING MANAGEMENT SYSTEM");
		lblHereIAm.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblHereIAm.setBounds(95, 13, 569, 34);
		frame.getContentPane().add(lblHereIAm);
		
		JLabel lblHereIAm_1 = new JLabel("HERE I AM");
		lblHereIAm_1.setIcon(new ImageIcon(AdminGUI.class.getResource("/img/img.jpg")));
		lblHereIAm_1.setBounds(26, 52, 718, 60);
		frame.getContentPane().add(lblHereIAm_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminGUI.class.getResource("/img/admin.gif")));
		lblNewLabel.setBounds(496, 139, 249, 270);
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 125, 436, 315);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Admin", null, panel, null);
		panel.setLayout(null);
		
		JButton btnCheckCustomerAccount = new JButton("CHECK CUSTOMER ACCOUNT");
		btnCheckCustomerAccount.setBounds(12, 32, 352, 33);
		panel.add(btnCheckCustomerAccount);
		btnCheckCustomerAccount.setForeground(Color.BLACK);
		btnCheckCustomerAccount.addActionListener(new ActionListener()
				{
			       public void actionPerformed(ActionEvent e)
			       {
			    	   CustomerList obj = new CustomerList();
			    	  obj.frame.setVisible(true);
			    	  
			       }
			    	   
			       
				});
		btnCheckCustomerAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(12, 186, 112, 33);
		panel.add(btnExit);
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnViewSsn = new JButton("view SSN");
		btnViewSsn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList obj = new CustomerList();
				obj.frame.setVisible(true);
			}
		});
		btnViewSsn.setBounds(214, 78, 161, 33);
		panel.add(btnViewSsn);
		btnViewSsn.setForeground(Color.BLACK);
		btnViewSsn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnSsnGiven = new JButton("Give SSN");
		btnSsnGiven.setBounds(12, 78, 191, 33);
		panel.add(btnSsnGiven);
		btnSsnGiven.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSsnGiven.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try {
						String ssn = JOptionPane.showInputDialog(null,"Enter a SSN Number for customer");
						 
						 int number = Integer.parseInt(ssn);
						adminCheckingSSn obj = new adminCheckingSSn();
						if(obj.ssnChecking(number) == true)
						{
							JOptionPane.showMessageDialog(null, "USED ANOTHER SSN NUMBER");
						} else {
							obj.insertSSn(number);
							JOptionPane.showMessageDialog(null, "INSERTED!!!!!!!!!!!!");
						}
				
				}catch(NumberFormatException EX)
				{
					JOptionPane.showMessageDialog(null, "NOTHING ENTER FOR SOCIAL NUMBER");
				}
				}
				});
		btnSsnGiven.setForeground(SystemColor.desktop);
		
		JButton btnDeleteAccount = new JButton("DELETE ACCOUNT");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String ssn = JOptionPane.showInputDialog(null, "Enter SSN to Delete Record","DELETING",JOptionPane.INFORMATION_MESSAGE);
				int number = Integer.parseInt(ssn);
				AdminCustomerDlt obj = new AdminCustomerDlt();
				obj.cdlt(number);
				}catch(NumberFormatException EX)
				{
				}
			}
		});
		btnDeleteAccount.setBounds(12, 124, 229, 33);
		panel.add(btnDeleteAccount);
		btnDeleteAccount.setForeground(Color.BLACK);
		btnDeleteAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Admin Account Create", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(23, 23, 137, 35);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(23, 100, 137, 35);
		panel_1.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(62, 58, 292, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(62, 136, 298, 41);
		panel_1.add(passwordField);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCreate.setBounds(23, 202, 166, 46);
		btnCreate.addActionListener(new ActionListener()
				{
			       public void actionPerformed(ActionEvent e)
			       {
			    	   String name = textField.getText();
			    	   @SuppressWarnings("deprecation")
					String pw = passwordField.getText();
			    	   adminCheckingSSn obj = new adminCheckingSSn();
			    	   obj.AdminAccount(name, pw);
			    	   textField.setText(" ");
			    	   passwordField.setText("");
			       }
				});
		panel_1.add(btnCreate);
		
		
		
		
	}
}
