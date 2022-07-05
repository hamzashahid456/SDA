package logInGUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {
		try {
			Connection con=DBConnection.MySqlConnection();
			if(!con.isClosed()) {
				System.out.println("Get All Record ");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from login");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+
							" "+rs.getString(3)+" "+rs.getString(4));
				}
				stmt.close();
				System.out.println("Update Record ");
				stmt=con.createStatement();
				stmt.executeUpdate("update Login set UserName='ali',Password="+"'ali',Status=b'1'where ID=1");
				stmt.close();
				con.close();
				System.out.println("Update Record Succesfully");
			}
		}
	catch(Exception ex) {
		System.out.println(""+ex.toString());
	}
	}
}
