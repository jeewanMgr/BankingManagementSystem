package com.BMS.design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminlogin {

	JFrame frmAdminLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin window = new Adminlogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(500, 500, 800, 500);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(12, 22, 725, 21);
		frmAdminLogin.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAdminLogin = new JMenuItem("Admin login");
		mntmAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminLogin.dispose();
				Adminlogin.main(null);
			}
		});
		mnFile.add(mntmAdminLogin);
		
		JMenuItem mntmUserLogin = new JMenuItem("User Login");
		mntmUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminLogin.dispose();
				login.main(null);
			}
		});
		mnFile.add(mntmUserLogin);
			
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/jeewan/Desktop/project/img.jpg"));
		lblNewLabel.setBounds(22, 66, 725, 80);
		frmAdminLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Login");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(346, 187, 222, 21);
		frmAdminLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/home/jeewan/Desktop/project/admin.gif"));
		lblNewLabel_2.setBounds(12, 187, 263, 231);
		frmAdminLogin.getContentPane().add(lblNewLabel_2);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 17));
		lblUserName.setBounds(330, 238, 125, 29);
		frmAdminLogin.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(400, 269, 211, 29);
		frmAdminLogin.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(400, 319, 213, 29);
		frmAdminLogin.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPassword.setBounds(338, 295, 117, 21);
		frmAdminLogin.getContentPane().add(lblPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(346, 360, 117, 25);
		frmAdminLogin.getContentPane().add(btnLogIn);
		
		JButton btnRe = new JButton("ReSet");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnRe.setBounds(475, 360, 117, 25);
		frmAdminLogin.getContentPane().add(btnRe);
		
	}
}
