

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EditMembers {

	JFrame frmEditMembers;
	JComboBox name,cnic;
	String vehiclenum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMembers window = new EditMembers();
					window.frmEditMembers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditMembers() {
		initialize();
	}
	
	public EditMembers(String s) {
		initialize();
		GetInfo(s);
		setVal(s);
	}
	
	void setVal(String s) {
		this.vehiclenum = s;
	}

	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditMembers = new JFrame();
		frmEditMembers.setTitle("Edit Members");
		frmEditMembers.setBounds(100, 100, 697, 622);
		frmEditMembers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditMembers.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectMember obj = new SelectMember();
				obj.frmSelectMember.setVisible(true);
				frmEditMembers.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(23, 28, 89, 23);
		frmEditMembers.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("CNIC:");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(128, 201, 148, 44);
		frmEditMembers.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(128, 128, 140, 44);
		frmEditMembers.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fn=name.getSelectedItem().toString();
					String cn=cnic.getSelectedItem().toString();
					if(!fn.equals("")&&!cn.equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						int cnic = Integer.parseInt(cn);
						String query="update membership set name="
								+ "'"+fn+"' WHERE cnic='"+cn+"'" ;
						
						stmt.executeUpdate(query);
						
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null,"Member Updated");
						
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
		btnNewButton.setBounds(243, 296, 140, 36);
		frmEditMembers.getContentPane().add(btnNewButton);
		
		cnic = new JComboBox();
		cnic.setFont(new Font("Georgia", Font.PLAIN, 11));
		cnic.setEditable(true);
		cnic.setBounds(296, 204, 206, 44);
		frmEditMembers.getContentPane().add(cnic);
		
		name = new JComboBox();
		name.setFont(new Font("Georgia", Font.PLAIN, 11));
		name.setEditable(true);
		name.setBounds(296, 131, 206, 44);
		frmEditMembers.getContentPane().add(name);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, -11, 681, 583);
		frmEditMembers.getContentPane().add(lblNewLabel);
	}
	void GetInfo(String st) {
	
		try {
			Connection con=DBconnection.MySqlConnection();
			String query="SELECT name,cnic FROM membership WHERE cnic = '"+st+"'";
			Statement stmt=con.createStatement();
			String Name,Cnic;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Name=rs.getString(1);
				Cnic = rs.getString(2);
				
				name.addItem(Name);
				cnic.addItem(Cnic);
				
			}
			stmt.close();
			con.close();
			
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Error.\n"+ex.getLocalizedMessage());
		}
	}
}
