package com.BMS.design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewAccount {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccount window = new NewAccount();
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
	public NewAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Jeewan World Bank");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel_1.setBounds(244, 0, 319, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabbedPane.setToolTipText("Account");
		tabbedPane.setBounds(233, 147, 555, 320);
		frame.getContentPane().add(tabbedPane);
		
		JPanel NeAcc = new JPanel();
		NeAcc.setToolTipText("");
		tabbedPane.addTab("New Account", null, NeAcc, null);
		NeAcc.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(22, 12, 120, 30);
		NeAcc.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(22, 40, 120, 30);
		NeAcc.add(lblPassword);
		
		JLabel lblSsn = new JLabel("SSN :");
		lblSsn.setBounds(22, 100, 101, 30);
		NeAcc.add(lblSsn);
		
		JLabel lblAddress = new JLabel(" Address :");
		lblAddress.setBounds(22, 124, 120, 30);
		NeAcc.add(lblAddress);
		
		JLabel lblFullName = new JLabel("full Name :");
		lblFullName.setBounds(22, 72, 120, 30);
		NeAcc.add(lblFullName);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(39, 178, 117, 25);
		NeAcc.add(btnCreate);
		
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login.main(null);
			}
		});
		btnUserLogin.setBounds(39, 228, 117, 25);
		NeAcc.add(btnUserLogin);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Adminlogin.main(null);
				
			}
		});
		btnAdminLogin.setBounds(191, 228, 141, 25);
		NeAcc.add(btnAdminLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("  ");
				textField_1.setText("  ");
				textField_2.setText("  ");
				textField_3.setText("   ");
				textField_4.setText("   ");
			}
		});
		btnReset.setBounds(191, 178, 117, 25);
		NeAcc.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/jeewan/eclipse-workspace/Practise/project/pw.png"));
		lblNewLabel.setBounds(326, 12, 208, 201);
		NeAcc.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(126, 18, 154, 19);
		NeAcc.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 72, 154, 19);
		NeAcc.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 40, 154, 19);
		NeAcc.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(126, 106, 154, 19);
		NeAcc.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(126, 130, 154, 19);
		NeAcc.add(textField_4);
		
		JPanel Resetpw = new JPanel();
		tabbedPane.addTab("Reset Password", null, Resetpw, null);
		Resetpw.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Show your password");
		lblNewLabel_2.setFont(new Font("DialogInput", Font.BOLD, 31));
		lblNewLabel_2.setBounds(79, 12, 403, 37);
		Resetpw.add(lblNewLabel_2);
		
		JLabel lblUserName_1 = new JLabel("User Name :");
		lblUserName_1.setBounds(37, 95, 131, 29);
		Resetpw.add(lblUserName_1);
		
		JLabel lblSsn_1 = new JLabel("SSN :");
		lblSsn_1.setBounds(37, 122, 131, 29);
		Resetpw.add(lblSsn_1);
		
		JButton btnShowPw = new JButton("Show pw");
		btnShowPw.setBounds(37, 163, 117, 25);
		Resetpw.add(btnShowPw);
		
		JButton btnUseLogin = new JButton("user login");
		btnUseLogin.setBounds(176, 163, 117, 25);
		Resetpw.add(btnUseLogin);
		
		JButton btnAdminLogin_1 = new JButton("Admin Login");
		btnAdminLogin_1.setBounds(37, 200, 131, 25);
		Resetpw.add(btnAdminLogin_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/home/jeewan/eclipse-workspace/Practise/project/pw.png"));
		lblNewLabel_3.setBounds(311, 49, 223, 203);
		Resetpw.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(137, 127, 156, 19);
		Resetpw.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(137, 100, 156, 19);
		Resetpw.add(textField_6);
		
		JLabel imgg1 = new JLabel("");
		imgg1.setIcon(new ImageIcon("/home/jeewan/eclipse-workspace/Practise/project/img.jpg"));
		imgg1.setBounds(34, 33, 715, 102);
		frame.getContentPane().add(imgg1);
		
		JLabel img1 = new JLabel("");
		img1.setIcon(new ImageIcon("/home/jeewan/eclipse-workspace/Practise/project/login.png"));
		img1.setBounds(19, 181, 196, 260);
		frame.getContentPane().add(img1);
	}
}
