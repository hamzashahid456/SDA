

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterMemberOperator {

	public JFrame frmRegisterCustomer;
	private JTextField name;
	private JTextField cnic;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterMemberOperator window = new RegisterMemberOperator();
					window.frmRegisterCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterMemberOperator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisterCustomer = new JFrame();
		frmRegisterCustomer.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hp\\Downloads\\Sus Birds.png"));
		frmRegisterCustomer.setTitle("Registration ");
		frmRegisterCustomer.setBounds(100, 100, 787, 507);
		frmRegisterCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegisterCustomer.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!name.getText().equals("")&&!cnic.getText().equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						String query="insert into carparking.membership(name,cnic) values("
								+ "'"+name.getText()+"','"+cnic.getText()+"')" ;
						
						stmt.executeUpdate(query);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null,"Member Registered");			
					}
					else {
						JOptionPane.showMessageDialog(null,"Kindly fill all records");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
				}
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatorMainMenu obj= new OperatorMainMenu();
				obj.frmOperatorMainMenu.setVisible(true);
				frmRegisterCustomer.setVisible(false);
			}
		});
		btnNewButton_1_1.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(20, 21, 98, 23);
		frmRegisterCustomer.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1.setBounds(358, 277, 142, 39);
		frmRegisterCustomer.getContentPane().add(btnNewButton_1);
		
		cnic = new JTextField();
		cnic.setColumns(10);
		cnic.setBounds(337, 199, 193, 26);
		frmRegisterCustomer.getContentPane().add(cnic);
		
		name = new JTextField();
		name.setBounds(337, 150, 193, 26);
		frmRegisterCustomer.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("CNIC:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(195, 200, 107, 18);
		frmRegisterCustomer.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Name: ");
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(195, 151, 83, 18);
		frmRegisterCustomer.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Membership Registeration");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Leelawadee", Font.BOLD, 30));
		lblNewLabel_2.setBounds(171, 62, 421, 77);
		frmRegisterCustomer.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Car Parking Portal");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Bright", Font.BOLD, 40));
		lblNewLabel_1.setBounds(181, 0, 494, 102);
		frmRegisterCustomer.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 771, 502);
		frmRegisterCustomer.getContentPane().add(lblNewLabel);
	}
}
