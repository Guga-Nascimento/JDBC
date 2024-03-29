package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.DB;
import db.DbException;
public class Program {	
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM department");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("Name"));
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.resultSetStatement(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		}
	}
