package com.design;
import com.core.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Account {

	JFrame frmWelcome;
	JLabel lblUname;
	//JPasswordField passwordField;
	String bname;
	String bpw;
	int ssn;
	
	/**
	 * Create the application.
	 */
	public Account() {
		initialize();
	}
	
	public Account(String name,String pw) {
		initialize();
		
		this.bname = name;
		lblUname.setText(bname);
		this.bpw = pw;
	}

	
	 
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBpw() {
		return bpw;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome ");
		frmWelcome.setBounds(500, 500, 800, 500);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome" );
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblWelcome.setBounds(152, 30, 181, 35);
		frmWelcome.getContentPane().add(lblWelcome);
		
	    lblUname = new JLabel(" ");
		lblUname.setFont(new Font("Tahoma", Font.BOLD, 32));
		//lblUname.setText(uname);
		lblUname.setBounds(328, 30, 280, 35);
		frmWelcome.getContentPane().add(lblUname);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 71, 746, 10);	
		frmWelcome.getContentPane().add(separator);
		
		JButton btnwithdraw = new JButton("Withdraw");
		btnwithdraw.setBackground(SystemColor.activeCaption);
		btnwithdraw.setForeground(SystemColor.desktop);
		btnwithdraw.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnwithdraw.setBounds(22, 160, 241, 65);
		btnwithdraw.addActionListener(new ActionListener()
				{
			       public void actionPerformed(ActionEvent e)
			       {
			    	   String money = JOptionPane.showInputDialog(null, "Enter your Amount: ");
			    	   float amount =Float.parseFloat(money);
			    	  jAccount obj = new jAccount();
			    	  obj.amountgetting(getBname(),getBpw(),amount);
			       }
				}
				);
		frmWelcome.getContentPane().add(btnwithdraw);
		
		JButton btnDeposite1 = new JButton("Deposite");
		btnDeposite1.setBackground(SystemColor.activeCaption);
		btnDeposite1.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDeposite1.setBounds(22, 257, 241, 65);
		btnDeposite1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String amount = JOptionPane.showInputDialog(null, "Amount diposite");
				float money = Float.parseFloat(amount);
				jAccount one = new jAccount();
				one.deposite(money, getBname(), getBpw());
			}
		});
		frmWelcome.getContentPane().add(btnDeposite1);
		
		JButton btnBalanceInquery = new JButton("Balance Inquery");
		btnBalanceInquery.setBackground(SystemColor.activeCaption);
		btnBalanceInquery.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBalanceInquery.setBounds(275, 160, 290, 65);
		btnBalanceInquery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			  JOptionPane.showMessageDialog(null, "YOu have: "+
					  dataPlaying.ssnanother(getBname(),getBpw())+"$");
			  
			}
				
		});
		frmWelcome.getContentPane().add(btnBalanceInquery);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(SystemColor.activeCaption);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnExit.setBounds(22, 347, 241, 65);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmWelcome.getContentPane().add(btnExit);
		
		JLabel lblA = new JLabel("a");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setIcon(new ImageIcon("C:\\Users\\jeewan\\eclipse-workspace\\MBS\\src\\img\\admin.gif"));
		lblA.setBounds(583, 180, 175, 233);
		frmWelcome.getContentPane().add(lblA);
		
		JLabel lblL = new JLabel("l");
		lblL.setIcon(new ImageIcon("C:\\Users\\jeewan\\eclipse-workspace\\MBS\\src\\img\\img.jpg"));
		lblL.setBounds(22, 78, 736, 70);
		frmWelcome.getContentPane().add(lblL);
	}
}
