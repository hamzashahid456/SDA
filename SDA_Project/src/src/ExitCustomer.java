

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ExitCustomer {

	JFrame frmExitCustomer;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExitCustomer window = new ExitCustomer();
					window.frmExitCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExitCustomer() {
		initialize();
		GetInfo();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExitCustomer = new JFrame();
		frmExitCustomer.setTitle("Exit Customer");
		frmExitCustomer.setBounds(100, 100, 668, 384);
		frmExitCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExitCustomer.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Exit Customer");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String customer = comboBox.getSelectedItem().toString();
					if(!customer.equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						String floor="select floor from customer where customerID='"+customer+"'";
						
						ResultSet rs = stmt.executeQuery(floor);
						
						String Floor = null;
						while(rs.next()) {
							Floor=rs.getString(1);
						}
						String query2 = null;
						if(Floor.equals("Basement")) {
							query2 = "update building set basementSlots = (select basementSlots from building)-1;";
						}
						else if(Floor.equals("Ground Floor")) {
							query2 = "update building set groundFloorSlots = (select groundFloorSlots from building)-1;";
						}
						else if(Floor.equals("1st Floor")) {
							query2 = "update building set firstFloorSlots = (select firstFloorSlots from building)-1;";
						}
						
						String query="update customer set status = b'0' where customerID = '"+customer+"'" ;			
						
						
						stmt.executeUpdate(query);
						stmt.executeUpdate(query2);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null,"Customer exited");
						
						
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Select Customer ID");
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
				OperatorMainMenu men = new OperatorMainMenu();
				frmExitCustomer.setVisible(false);
				men.frmOperatorMainMenu.setVisible(true);
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setBounds(247, 104, 183, 53);
		frmExitCustomer.getContentPane().add(comboBox);
		btnNewButton_1.setBounds(22, 28, 120, 39);
		frmExitCustomer.getContentPane().add(btnNewButton_1);
		btnNewButton.setBounds(190, 215, 265, 53);
		frmExitCustomer.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(88, 104, 163, 53);
		frmExitCustomer.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 652, 345);
		frmExitCustomer.getContentPane().add(lblNewLabel);
	}
	
	void GetInfo() {
		try {
			Connection con=DBconnection.MySqlConnection();
			String query="SELECT customerID FROM customer where status > 0";
			Statement stmt=con.createStatement();
			String vehiclenum;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				vehiclenum=rs.getString(1);
				
				comboBox.addItem(vehiclenum);
			}
			stmt.close();
			con.close();
			
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Error.\n"+ex.getLocalizedMessage());
		}
	}
	

}