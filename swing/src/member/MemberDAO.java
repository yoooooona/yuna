package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.UserVO;

public class MemberDAO {
	// JDBC : 자바 응용프로그램에서 DB와의 접속과 CRUD 작업을 정의

	private Connection con = null;
	// 쿼리문을 먼저 수행하고 나중에 변수에 해당하는 값 할당
	private PreparedStatement pstmt = null;
	// select결과를 담는데 사용
	private ResultSet rs = null;

	// 연결작업
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javadb?useSSL=true";
			con = DriverManager.getConnection(url, "root", "12345");
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	// 자원해제
	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(Connection con, PreparedStatement pstmt) {
		try {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 삽입
	public int insert_member(String name, int age, String gender) {
		int result = 0;
		try {
			con = getConnection();
			String sql = "insert into memberTBL(name,age,gender)";
			sql += "values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, gender);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return result;
	}

	// 삭제
	public int delete_member(int idx) {
		int result = 0;

		try {
			con = getConnection();
			String sql = "delete from memberTBL wher idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return result;
	}

	// 레코드 하나 조회
	public MemberVO get_member(int idx) {
		MemberVO vo = null;
		con = getConnection();
		String sql = "select * from memberTBL where idx=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setIdx(idx);
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return vo;
	}
   
	// 전체 조회
	public ArrayList<MemberVO> get_members() {
		MemberVO vo = null;
		ArrayList<MemberVO> list = new ArrayList<>();
		con = getConnection();
		String sql = "select * from memberTBL";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setIdx(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	// 수정
	public int update_member(int idx, int age) {
		int result=0;
		
	try {
		con=getConnection();
		String sql = "update memberTBL set age=? where idx=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, age);
		pstmt.setInt(2, idx);
		result=pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close(con,pstmt);
	}
	return result;
	}
}
