
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	static String connnectionName = "com.mysql.jdbc.Driver";

	static Connection MySqlConnection() {
		Connection con = null ;
		try {
			
			 String dbName= "carparking"; 
			 String userName= "root"; 
			 String password= ""; 
			 String connectionString= "jdbc:mysql://localhost:3306/"+ dbName;
			 
			con = DriverManager.getConnection(connectionString,userName, password);
		}

	catch(Exception ex){
		System.out.println("Database/Server Conncetion Error"+ex.toString());
	}
	return con;
	}
}
