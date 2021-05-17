package jdbcIntro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Statement sqlQuery = null;
		ResultSet rs = null;
		DbHelper dbHelper = new DbHelper();
		try {
			connection = dbHelper.getConnection();
			System.out.println("Baðlantý tamam");
			
			sqlQuery = connection.createStatement();
			String sql = "SELECT * FROM public.jobs ORDER BY job_id ASC";
			rs = sqlQuery.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("job_id");
				String jobTitle = rs.getString("job_title");
				double minSalary = rs.getDouble("min_salary");
				double maxSalary = rs.getDouble("max_salary");
				
				System.out.println("Id : " + id);
				System.out.println("Title  : " + jobTitle);
				System.out.println("Min Salary : " + minSalary);
				System.out.println("Max Salary : " + maxSalary);
			}
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			try {
				connection.close();
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		

		

	}

}
