package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import member.vo.MemberVO;

public class MemberDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public Connection getConnection() {		
		DataSource ds;
		try {
			Context ctx=new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
			return ds.getConnection();
		} catch (NamingException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}	
	public void close(Connection con,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void close(Connection con,PreparedStatement pstmt) {
		try {			
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public MemberVO isLogin(String userid,String current_password) {
		MemberVO vo=null;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			if(con!=null) {	
				pstmt=con.prepareStatement("select userid, name "
						+ "from member where userid=? and password=?");
				pstmt.setString(1, userid);
				pstmt.setString(2, current_password);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					vo=new MemberVO();
					vo.setUserid(rs.getString(1));
					vo.setName(rs.getString(2));
				}
				con.commit();
			}
		}catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			e1.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}		
		return vo;
	}
	
	public int member_insert(MemberVO member) {		
		int result=0;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			//if(con!=null) {	
			pstmt=con.prepareStatement("insert into member values(?,?,?,?,?)");				
			pstmt.setString(1,member.getUserid());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getGender());
			pstmt.setString(5,member.getEmail());
			result=pstmt.executeUpdate();	
			con.commit();
			//}
		} catch (SQLException e1) {	
			try {
				con.rollback();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			e1.printStackTrace();
		}finally {
			close(con,pstmt);
		}
		return result;
	}
	
	public ArrayList<MemberVO> getList(){
		ArrayList<MemberVO> list=new ArrayList<>();
		
		con=getConnection();
		String sql="select * from member";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo=new MemberVO();
				vo.setUserid(rs.getString(1));
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getString(4));
				vo.setEmail(rs.getString(5));
				list.add(vo);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return list;
	}


}











