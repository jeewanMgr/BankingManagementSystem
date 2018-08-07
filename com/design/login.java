package com.design;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JPanel;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import com.core.vlogin;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class login {
	
	private JFrame frmLoginIn;
	private JPasswordField passwordField;
	private TextField jtxtUn;
	private String uname;
	private String pass;
	
	public String getUsername()
	{
		uname = jtxtUn.getText();
		return uname;
	}
	@SuppressWarnings("deprecation")
	public String getpw()
	{
		pass=passwordField.getText();
		return pass;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLoginIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();   
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginIn = new JFrame();
		frmLoginIn.setBackground(new Color(204, 255, 255));
		frmLoginIn.setAlwaysOnTop(true);
		frmLoginIn.setTitle("User Login In");
		frmLoginIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginIn.setBounds(500, 500, 800, 500);
		frmLoginIn.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(297, 192, 491, 296);
		frmLoginIn.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label lblUsrername = new Label("User Name:");
		lblUsrername.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUsrername.setAlignment(Label.CENTER);
		lblUsrername.setBounds(47, 91, 111, 21);
		panel.add(lblUsrername);
		
		 jtxtUn = new TextField();
		jtxtUn.setBounds(91, 118, 287, 24);
		panel.add(jtxtUn);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPassword.setBounds(47, 148, 111, 21);
		panel.add(lblPassword);
		
		
		
		JLabel lblUserLoinTo = new JLabel("User Loin to BMS");
		lblUserLoinTo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUserLoinTo.setBounds(63, 24, 315, 25);
		panel.add(lblUserLoinTo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 61, 417, 7);
		panel.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 169, 297, 25);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jeewan\\eclipse-workspace\\MBS\\src\\img\\img.jpg"));
		lblNewLabel_1.setBounds(25, 71, 751, 88);
		frmLoginIn.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jeewan\\eclipse-workspace\\MBS\\src\\img\\banking2.jpg"));
		lblNewLabel.setBounds(27, 192, 265, 261);
		frmLoginIn.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(12, 22, 725, 21);
		frmLoginIn.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAdminLogin = new JMenuItem("Admin login");
		mntmAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Adminlogin admin = new Adminlogin();
				frmLoginIn.dispose();
				Adminlogin admin = new Adminlogin();
				admin.getFrmAdminLogin().setVisible(true);
			}
		});
		mnFile.add(mntmAdminLogin);
		
		JMenuItem mntmUserLogin = new JMenuItem("User Login");
		mntmUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	dispose();
				//login user = new login();
			//	Adminlogin admin = new Adminlogin();
				frmLoginIn.dispose();
				login.main(null);
				//user.frmLoginIn.setVisible(true);
				
			}
		});
		mnFile.add(mntmUserLogin);
		
		
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo1) {
				
				
				vlogin obj = new vlogin(getUsername(),getpw());
				
				boolean chk=obj.checking();
				if(chk==true)
				{
					frmLoginIn.dispose();
					//dataPlaying data = new dataPlaying(getUsername(),getpw());
				    Account z = new Account(getUsername(),getpw());	
				    z.setBname(getUsername());
				    z.setBpw(getpw());
				    z.frmWelcome.setVisible(true);
				}else
				{
					frmLoginIn.dispose();
					JOptionPane.showMessageDialog(null, "UserName or Password incorrect");
					frmLoginIn.setVisible(true);
				}  				
				
			}
			
			public String getUsername()
			{
				uname = jtxtUn.getText();
				return uname;
			}
			@SuppressWarnings("deprecation")
			public String getpw()
			{
				pass=passwordField.getText();
				return pass;
			}
			
		});
		btnLogIn.setBounds(47, 218, 117, 25);
		panel.add(btnLogIn);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtUn.setText("  ");
				passwordField.setText(null);
			//	.setText("  ");
				
			}
		});
		btnReset.setBounds(188, 218, 117, 25);
		panel.add(btnReset);
		
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnCreateAccount = new JMenu(" Account");
		menuBar.add(mnCreateAccount);
		
		JMenuItem mntmNewAccount = new JMenuItem("New Account");
		mntmNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginIn.dispose();
				NewAccount obj = new NewAccount();
				obj.getFrame().setVisible(true);
				
			}
		});
		mnCreateAccount.add(mntmNewAccount);
		
		JMenuItem mntmResetPassword = new JMenuItem("Reset Password");
		mntmResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginIn.dispose();
				NewAccount obj = new NewAccount();
				obj.getFrame().setVisible(true);
			}
		});	
	}
}
