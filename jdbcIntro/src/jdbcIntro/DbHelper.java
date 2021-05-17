package jdbcIntro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	
	private  String url = "jdbc:postgresql://localhost:5432/HumanResources";
	private  String user = "postgres";
	private  String password = "12345";
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	public void showErrorMessage(SQLException exception) {
		System.out.println("Error : " + exception.getMessage());
		System.out.println("Hata Kodu : " + exception.getErrorCode());
	}
}
