package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	//DB 접속을 담당하는 메소드
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/javadb?useSSL=false";
			con=DriverManager.getConnection(url, "root", "12345");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//자원해제
	private void dbClose(Connection con,PreparedStatement pstmt) {
		try {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		private void dbClose(Connection con,PreparedStatement pstmt,ResultSet rs) {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	//사용자 입력 -Insert 담당
	public int user_insert(String name, String birthday, String addr) {
		con=getConnection();
		String sql="insert into userTBL(name,birthday,address)";
				sql+="value(?,?,?)";
				int result=0;
				try{
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, birthday);
					pstmt.setString(3, addr);
					result=pstmt.executeUpdate();
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					dbClose(con, pstmt);
				}
				return result;
	}
	//사용자 조회 -select
	public UserVO getUser(int no) {
		con=getConnection();
		String sql="select * from userTBL where no=?";
		UserVO vo=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new UserVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setBirthday(rs.getString(3));
				vo.setAddress(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose(con,pstmt,rs);
		}
		return vo;
	}
	
	//사용자 전체 조회 -select
	public ArrayList<UserVO> getUsers(){
		con=getConnection();
		String sql="select * from userTBL";
		ArrayList<UserVO> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				UserVO vo=new UserVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setBirthday(rs.getString(3));
				vo.setAddress(rs.getString(4));
				list.add(vo);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose(con,pstmt,rs);
		}
		return list;
	}
	
	//사용자 수정 -update
	public int user_update(int no, String addr) {
		con=getConnection();
		String sql="update userTBL set address=? where no=?";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setInt(2, no);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose(con,pstmt);
		}
		return result;
	}
	//사용자 삭제 -delete
	public int user_delete(int name1) {
		con=getConnection();
		String sql="delete from userTBL where no=?";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, name1);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose(con,pstmt);
		}
		return result;
	}

}
