

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DeleteOperator {

	JFrame frmDeleteOperator;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteOperator window = new DeleteOperator();
					window.frmDeleteOperator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteOperator() {
		initialize();
		GetInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteOperator = new JFrame();
		frmDeleteOperator.setTitle("Delete Operator");
		frmDeleteOperator.setBounds(100, 100, 689, 415);
		frmDeleteOperator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteOperator.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String userName = comboBox.getSelectedItem().toString();
					if(!userName.equals("") ) {
						Connection con=DBconnection.MySqlConnection();
						Statement stmt = con.createStatement();
						
						String query="update registration set status = b'0' where UserName = "
								+ "'"+userName+"'" ;
						
						stmt.executeUpdate(query);
						stmt.close();
						con.close();
						JOptionPane.showMessageDialog(null,"Operator Deleted");
						
						
						
					}
					else {
						JOptionPane.showMessageDialog(null,"Select Username");
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
				MainMenu men = new MainMenu();
				frmDeleteOperator.setVisible(false);
				men.frmMainMenu.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String un=comboBox.getSelectedItem().toString();
					
					Connection con=DBconnection.MySqlConnection();
					Statement stmt = con.createStatement();
					
					String query2="select status from registration where username='"+un+"'";
					
					String s1=null;
					ResultSet rs=stmt.executeQuery(query2);
					while(rs.next()) {
						s1=rs.getString(1);
					}
					
						UpdateOperator obj = new UpdateOperator(comboBox.getSelectedItem().toString());
						frmDeleteOperator.setVisible(false);
						obj.frmUpdateOperator.setVisible(true);
					
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error.\n"+ex.getLocalizedMessage());
				}
				
				
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Georgia", Font.PLAIN, 11));
		comboBox.setBounds(307, 134, 205, 42);
		frmDeleteOperator.getContentPane().add(comboBox);
		btnNewButton_2.setBounds(435, 212, 134, 47);
		frmDeleteOperator.getContentPane().add(btnNewButton_2);
		btnNewButton_1.setBounds(27, 28, 100, 30);
		frmDeleteOperator.getContentPane().add(btnNewButton_1);
		btnNewButton.setBounds(269, 214, 124, 42);
		frmDeleteOperator.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Operator Username:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(92, 125, 205, 54);
		frmDeleteOperator.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Desktop\\Smp.jpg"));
		lblNewLabel.setBounds(0, 0, 673, 376);
		frmDeleteOperator.getContentPane().add(lblNewLabel);
	}
	
	void GetInfo() {
		try {
			Connection con=DBconnection.MySqlConnection();
			String query="SELECT userName FROM registration where status > 0";
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
