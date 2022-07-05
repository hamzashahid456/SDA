import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MemberEntry {

	JFrame frame;
	JComboBox memberID,floor;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberEntry window = new MemberEntry();
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
	public MemberEntry() {
		initialize();
		GetInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		memberID = new JComboBox();
		memberID.setBounds(248, 88, 182, 49);
		frame.getContentPane().add(memberID);
		
		JLabel lblNewLabel = new JLabel("Member ID:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel.setBounds(89, 89, 133, 41);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Enter Member");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String member=memberID.getSelectedItem().toString();
					String Floor=floor.getSelectedItem().toString();
					if(!member.equals("")&& !Floor.equals("-") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						if(Floor.equals("Basement")) {
							String base = "select basementSlots from building";
							String ba=null;
							ResultSet b = stmt.executeQuery(base);
							while(b.next()) {
								ba=b.getString(1);
							}
							int basementSlots = Integer.parseInt(ba);
							if(basementSlots <= 0 ) {
								JOptionPane.showMessageDialog(null,"No space in Basement");
							}
							else {
								
								String query2 = "update building set basementSlots = (select basementSlots from building)-1;";
								
						
								stmt.executeUpdate(query2);
								stmt.close();
								con.close();
								JOptionPane.showMessageDialog(null,"Slot Allocated");
							}
						}
						
						else if(Floor.equals("Ground Floor")) {
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
								String query2 = "update building set groundFloorSlots = (select groundFloorSlots from building)-1;";
								
								stmt.executeUpdate(query2);
								stmt.close();
								con.close();
								JOptionPane.showMessageDialog(null,"Slot Allocated");
							}
						}
						
						else if(Floor.equals("1st Floor")) {
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
								
								String query2 = "update building set firstFloorSlots = (select firstFloorSlots from building)-1;";
					
								stmt.executeUpdate(query2);
								stmt.close();
								con.close();
								JOptionPane.showMessageDialog(null,"Slot Allocated");
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
		btnNewButton.setBounds(270, 263, 133, 49);
		frame.getContentPane().add(btnNewButton);
		
		floor = new JComboBox();
		floor.setModel(new DefaultComboBoxModel(new String[] {"-", "Basement", "Ground Floor", "1st Floor"}));
		floor.setBounds(248, 160, 182, 41);
		frame.getContentPane().add(floor);
		
		lblNewLabel_1 = new JLabel("Floor:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(97, 157, 125, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberOrNot obj = new MemberOrNot();
				obj.frmMemberOrNot.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(35, 23, 112, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Show Free slots");
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setBounds(520, 59, 133, 49);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(459, 138, 272, 183);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel_2.setBounds(0, 0, 776, 375);
		frame.getContentPane().add(lblNewLabel_2);
	}
	
	void GetInfo() {
		try {
			Connection con=DBconnection.MySqlConnection();
			String query="SELECT memberID FROM membership ";
			Statement stmt=con.createStatement();
			String memID;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				memID=rs.getString(1);
				
				memberID.addItem(memID);
				
			}
			stmt.close();
			con.close();
			
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Error.\n"+ex.getLocalizedMessage());
		}
	}
}

