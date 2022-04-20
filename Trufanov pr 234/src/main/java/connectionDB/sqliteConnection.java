package connectionDB;

import java.sql.*;

public class sqliteConnection {	
	Connection conn = null;
	String url = "jdbc:sqlite:D:/D/Учёба/3 курс/3 курс 2 семестр (6)/СТИП/eclipse projects/Trufanov pr 234/src/main/database/UserData.db";
	
	public Connection dbConnector() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("0");
			return null;
		}
	}
}
