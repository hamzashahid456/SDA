import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EnterCustomer {

	JFrame frmEnterCustomer;
	private JTextField vehicleType;
	private JTable table;
	JComboBox comboBox;
	JComboBox comboBox_1;
	private JTextField vehicleNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterCustomer window = new EnterCustomer();
					window.frmEnterCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnterCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnterCustomer = new JFrame();
		frmEnterCustomer.setTitle("Enter Customer");
		frmEnterCustomer.setBounds(100, 100, 731, 514);
		frmEnterCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_2 = new JButton("Add Customer");
		btnNewButton_2.setBackground(Color.YELLOW);
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2.setBounds(156, 407, 197, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!vehicleNumber.getText().equals("")&&!vehicleType.getText().equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						String price=comboBox.getSelectedItem().toString();
						String floor=comboBox_1.getSelectedItem().toString();
						
						if(price.equals("-")) {
							JOptionPane.showMessageDialog(null,"Select Price");
						}
						
						if(floor.equals("Basement")) {
							String base = "select basementSlots from building";
							ResultSet b = stmt.executeQuery(base);
							while(b.next()) {
								base=b.getString(1);
							}
							int basementSlots = Integer.parseInt(base);
							if(basementSlots <= 0 ) {
								JOptionPane.showMessageDialog(null,"No space in Basement");
							}
							else {
								String query="insert into carparking.customer(vehicleNumber,vehicleType,floor,price,status) values("
										+ "'"+vehicleNumber.getText()+"','"+vehicleType.getText()+"','"+floor+"','"+price+"',b'1')" ;
								
								String query2 = "update building set basementSlots = (select basementSlots from building)-1;";
								
								stmt.executeUpdate(query);
								stmt.executeUpdate(query2);
								stmt.close();
								con.close();
								JOptionPane.showMessageDialog(null,"Customer Entered");
							}
						}
						
						else if(floor.equals("Ground Floor")) {
							String ground = "select groundFloorSlots from building";
							ResultSet g = stmt.executeQuery(ground);
							while(g.next()) {
								ground=g.getString(1);
							}
							int groundSlots = Integer.parseInt(ground);
							if(groundSlots <= 0 ) {
								JOptionPane.showMessageDialog(null,"No space on Ground Floor");
							}
							else {
								String query="insert into carparking.customer(vehicleNumber,vehicleType,floor,price,status) values("
										+ "'"+vehicleNumber.getText()+"','"+vehicleType.getText()+"','"+floor+"','"+price+"',b'1')" ;
								String query2 = "update building set groundFloorSlots = (select groundFloorSlots from building)-1;";
								
								stmt.executeUpdate(query);
								stmt.executeUpdate(query2);
								stmt.close();
								con.close();
								JOptionPane.showMessageDialog(null,"Customer Entered");
							}
						}
						
						else if(floor.equals("1st Floor")) {
							String first = "select firstFloorSlots from building";
							ResultSet f = stmt.executeQuery(first);
							while(f.next()) {
								first=f.getString(1);
							}
							int firstFloorSlots = Integer.parseInt(first);
							if(firstFloorSlots <= 0 ) {
								JOptionPane.showMessageDialog(null,"No space on 1st Floor");
							}
							else {
								String query="insert into carparking.customer(vehicleNumber,vehicleType,floor,price,status) values("
										+ "'"+vehicleNumber.getText()+"','"+vehicleType.getText()+"','"+floor+"','"+price+"',b'1')" ;
								String query2 = "update building set firstFloorSlots = (select firstFloorSlots from building)-1;";
								
								stmt.executeUpdate(query);
								stmt.executeUpdate(query2);
								stmt.close();
								con.close();
								JOptionPane.showMessageDialog(null,"Customer Entered");
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"select floor");
							stmt.close();
							con.close();
						}					
						
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Record Missing");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
				}
			}
		});
		frmEnterCustomer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Vehicle Number:");
		lblNewLabel_5.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(10, 146, 156, 41);
		frmEnterCustomer.getContentPane().add(lblNewLabel_5);
		
		vehicleNumber = new JTextField();
		vehicleNumber.setBounds(177, 153, 155, 34);
		frmEnterCustomer.getContentPane().add(vehicleNumber);
		vehicleNumber.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-", "Basement", "Ground Floor", "1st Floor"}));
		comboBox_1.setBounds(177, 270, 155, 34);
		frmEnterCustomer.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Price:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 325, 123, 34);
		frmEnterCustomer.getContentPane().add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Georgia", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "20", "30", "50"}));
		comboBox.setBounds(177, 328, 155, 34);
		frmEnterCustomer.getContentPane().add(comboBox);
		frmEnterCustomer.getContentPane().add(btnNewButton_2);
		
		vehicleType = new JTextField();
		vehicleType.setBounds(177, 211, 155, 34);
		frmEnterCustomer.getContentPane().add(vehicleType);
		vehicleType.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Floor: ");
		lblNewLabel_3.setBounds(10, 265, 108, 38);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 20));
		frmEnterCustomer.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Vehicle Type:");
		lblNewLabel_2.setBounds(10, 205, 123, 41);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 20));
		frmEnterCustomer.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Show Free Slots");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.setBounds(500, 92, 146, 41);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con=DBconnection.MySqlConnection();
					
					
					String query="select firstFloorSlots, groundfloorSlots, basementSlots from building";
					
					PreparedStatement stmt = con.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));		
					
					stmt.close();
					con.close();
					
					
					
				}
				catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Error In "+ex.toString());
				}
			}
		});
		frmEnterCustomer.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(21, 25, 108, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberOrNot men = new MemberOrNot();
				frmEnterCustomer.setVisible(false);
				men.frmMemberOrNot.setVisible(true);
			}
		});
		frmEnterCustomer.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(369, 144, 319, 53);
		frmEnterCustomer.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 715, 482);
		frmEnterCustomer.getContentPane().add(lblNewLabel);
	}
	
}
