

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OperatorMainMenu {
	JFrame frmOperatorMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorMainMenu window = new OperatorMainMenu();
					window.frmOperatorMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatorMainMenu() {
		initialize();
//		expMembership();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOperatorMainMenu = new JFrame();
		frmOperatorMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmOperatorMainMenu.setTitle("Operator Main Menu");
		frmOperatorMainMenu.setBounds(100, 100, 837, 492);
		frmOperatorMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOperatorMainMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register New Customer");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterCustomer obj=new EnterCustomer();
				obj.frmEnterCustomer.setVisible(true);
				frmOperatorMainMenu.setVisible(false);
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarParking obj=new CarParking();
				obj.frmLogInSystem.setVisible(true);
				frmOperatorMainMenu.setVisible(false);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Log out");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorLogin obj=new OperatorLogin();
				obj.frmAdminLoginSystem.setVisible(true);
				frmOperatorMainMenu.setVisible(false);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Exit Customer");
		btnNewButton_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitCustomer obj = new ExitCustomer();
				frmOperatorMainMenu.setVisible(false);
				obj.frmExitCustomer.setVisible(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Edit Membership");
		btnNewButton_4.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectMember obj = new SelectMember();
				obj.frmSelectMember.setVisible(true);
				frmOperatorMainMenu.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(160, 245, 210, 39);
		frmOperatorMainMenu.getContentPane().add(btnNewButton_4);
		btnNewButton_3.setBounds(494, 245, 210, 39);
		frmOperatorMainMenu.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Enter customer");
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberOrNot obj = new MemberOrNot();
				frmOperatorMainMenu.setVisible(false);
				obj.frmMemberOrNot.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(494, 173, 210, 39);
		frmOperatorMainMenu.getContentPane().add(btnNewButton_2);
		btnNewButton_1_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1_1.setBackground(Color.YELLOW);
		btnNewButton_1_1.setBounds(372, 396, 89, 23);
		frmOperatorMainMenu.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2_2 = new JButton("View Customers");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorViewCustomers obj = new OperatorViewCustomers();
				frmOperatorMainMenu.setVisible(false);
				obj.frmOperatorView.setVisible(true);
			}
		});
		btnNewButton_2_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2_2.setBounds(494, 321, 210, 39);
		frmOperatorMainMenu.getContentPane().add(btnNewButton_2_2);
		
		JButton btnNewButton_2_1 = new JButton("View Membership");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMember obj =new ViewMember();
				obj.frmViewMemebrship.setVisible(true);
				frmOperatorMainMenu.setVisible(false);
			}
		});
		btnNewButton_2_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2_1.setBounds(160, 321, 210, 39);
		frmOperatorMainMenu.getContentPane().add(btnNewButton_2_1);
		
		JButton newMemeber = new JButton("Register New Membership");
		newMemeber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterMemberOperator obj=new RegisterMemberOperator();
				obj.frmRegisterCustomer.setVisible(true);
				frmOperatorMainMenu.setVisible(false);
			}
		});
		newMemeber.setFont(new Font("Georgia", Font.PLAIN, 11));
		newMemeber.setBounds(160, 173, 210, 39);
		frmOperatorMainMenu.getContentPane().add(newMemeber);
		
		

		
		JLabel lblNewLabel_2 = new JLabel("WELCOME OPERATOR");
		lblNewLabel_2.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(235, 94, 354, 81);
		frmOperatorMainMenu.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Car Parking Portal");
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(204, 11, 407, 106);
		frmOperatorMainMenu.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Downloads\\imageedit_6_2710433596.jpg"));
		lblNewLabel.setBounds(0, 11, 821, 453);
		frmOperatorMainMenu.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(355, 405, 46, 14);
		frmOperatorMainMenu.getContentPane().add(label);
	}


void expMembership(){
	try {
		Connection con=DBconnection.MySqlConnection();
		
		
		String query="update membership set status = b'0' where startDate = endDate";
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);	

		
		stmt.close();
		con.close();
	}
	catch(Exception ex) {
		JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
	}
	
}
}
