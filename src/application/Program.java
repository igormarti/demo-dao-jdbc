package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DBException;

public class Program {

	
	public static void main(String[] args) {
		
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/yyyy");
		
		try {
			
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller"
					+"(Name, Email, BirthDate, BaseSalary, DepartmentId)"
				    +"VALUES(?, ?, ?, ?, ?)"
					, PreparedStatement.RETURN_GENERATED_KEYS
					);
			st.setString(1, "Igor Mart");
			st.setString(2, "igor@test.com");
			st.setDate(3, new Date(sdf.parse("03/10/1996").getTime()));
			st.setDouble(4, 3000.00);
			st.setInt(5, 4);
			
			int rows = st.executeUpdate();
			
			if(rows > 0) {
				
				rs = st.getGeneratedKeys();
				
				while(rs.next()) {
					System.out.println("done! id= "+ rs.getInt(1));
				}
				
			} else {
				System.out.println("No rows affectds!!!");
			}
			
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
		
	}
	
}
