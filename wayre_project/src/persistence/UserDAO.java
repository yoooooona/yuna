package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource ds;
	private ResultSet rs;

	private Connection getConnection() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
			return ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int checkIdEmail(String user_id, String user_email) {
		con = getConnection();
		
		String sql = "SELECT user_id FROM userTBL WHERE user_id = ? or user_email = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) return 1;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		
		return 0;
	}
	
	public int signUp(String user_id, String user_pw, String user_email) {
		con = getConnection();
		
		String sql = "INSERT INTO userTBL values(?,?,?,'')";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			pstmt.setString(3, user_email);
			
			return pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		
		return 0;
	}
	
	public int login(String user_id, String user_pw) {
		con = getConnection();
		
		String sql = "SELECT * FROM userTBL WHERE user_id = ? and user_pw = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				return 1;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		
		return 0;
	}
}
