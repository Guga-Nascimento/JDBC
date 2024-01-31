package application;
/*atualizando Dados*/

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

import db.DB;
import db.DbException;
public class Program {	
	public static void main(String[] args) {
	
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			conn.createStatement();
			st = conn.createStatement();
			int rows1 =	st.executeUpdate("UPDATE seller SET BaseSalary = 5090 "
							+ "WHERE departmentId = 1 ");
			int x = 1;
			if(x > 2) {
				throw new SQLException("Fake error!!!!");
			}
			int rows2 =	st.executeUpdate("UPDATE seller SET BaseSalary = 7090 "
					+ "WHERE departmentId = 2 ");
			conn.commit();
		}
		
	catch(SQLException e) {
		try {
			conn.rollback();
			throw new DbException("Transation rolled back! Caused by: "+ e.getMessage());
		}
		catch(SQLException e1) {
			throw new DbException("ERROR " + e1.getMessage());
		}
		
	}
	finally {
		DB.closeStatement(st);
		DB.closeConnection();
	}
		}
	}

