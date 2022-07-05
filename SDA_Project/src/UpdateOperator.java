import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateOperator {

	JFrame frmUpdateOperator;
	JComboBox FirstName,LastName,UserName,Password,Salary;
	String UN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateOperator window = new UpdateOperator();
					window.frmUpdateOperator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateOperator() {
		initialize();		
	}
	
	public UpdateOperator(String s) {
		initialize();
		GetInfo(s);
		setUserName(s);
		
	}
	
	void setUserName(String s) {
		this.UN = s;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateOperator = new JFrame();
		frmUpdateOperator.setTitle("Update Operator");
		frmUpdateOperator.setBounds(100, 100, 690, 477);
		frmUpdateOperator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateOperator.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
					String fn=FirstName.getSelectedItem().toString();
					String ln=LastName.getSelectedItem().toString();
					String un=UserName.getSelectedItem().toString();
					String p=Password.getSelectedItem().toString();
					String s=Salary.getSelectedItem().toString();
					if(!fn.equals("")&&!ln.equals("")&&!un.equals("")&&!p.equals("")&&!s.equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						String query= "update registration set firstName='"+fn+"',lastName='"+ln+"',UserName='"+un+"',Password='"+p+"',salary='"+s+"' where UserName ='"+UN+"' ";            
						
						stmt.executeUpdate(query);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null,"Info Saved");
						
						
						
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteOperator obj = new DeleteOperator();
				frmUpdateOperator.setVisible(false);
				obj.frmDeleteOperator.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 11, 119, 39);
		frmUpdateOperator.getContentPane().add(btnNewButton_1);
		btnNewButton.setBounds(302, 372, 109, 39);
		frmUpdateOperator.getContentPane().add(btnNewButton);
		
		Password = new JComboBox();
		Password.setEditable(true);
		Password.setBounds(287, 234, 165, 39);
		frmUpdateOperator.getContentPane().add(Password);
		
		UserName = new JComboBox();
		UserName.setEditable(true);
		UserName.setBounds(287, 174, 165, 39);
		frmUpdateOperator.getContentPane().add(UserName);
		
		LastName = new JComboBox();
		LastName.setEditable(true);
		LastName.setBounds(287, 105, 165, 39);
		frmUpdateOperator.getContentPane().add(LastName);
		
		FirstName = new JComboBox();
		FirstName.setEditable(true);
		FirstName.setBounds(287, 44, 165, 39);
		frmUpdateOperator.getContentPane().add(FirstName);
		
		JLabel lblNewLabel_5 = new JLabel("Salary:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(140, 294, 111, 48);
		frmUpdateOperator.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(140, 231, 101, 38);
		frmUpdateOperator.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(140, 171, 111, 38);
		frmUpdateOperator.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(139, 102, 124, 38);
		frmUpdateOperator.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(139, 41, 124, 39);
		frmUpdateOperator.getContentPane().add(lblNewLabel_1);
		
		Salary = new JComboBox();
		Salary.setEditable(true);
		Salary.setBounds(287, 302, 165, 38);
		frmUpdateOperator.getContentPane().add(Salary);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 674, 438);
		frmUpdateOperator.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(187, 117, 198, 53);
		frmUpdateOperator.getContentPane().add(label);
	}
	
	void GetInfo(String st) {
		try {
			Connection con=DBconnection.MySqlConnection();
			String query="SELECT * FROM registration WHERE status > 0 and userName = '"+st+"'";
			Statement stmt=con.createStatement();
			String firstName,lastName,userName,password,salary;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				firstName=rs.getString(1);
				lastName=rs.getString(2);
				userName=rs.getString(3);
				password=rs.getString(4);
				salary=rs.getString(5);
				
				FirstName.addItem(firstName);
				LastName.addItem(lastName);
				UserName.addItem(userName);
				Password.addItem(password);
				Salary.addItem(salary);
			}
			stmt.close();
			con.close();
			
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Error.\n"+ex.getLocalizedMessage());
		}
	}
}
