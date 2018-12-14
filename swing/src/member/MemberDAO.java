package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.UserVO;

public class MemberDAO {
	// JDBC : �ڹ� �������α׷����� DB���� ���Ӱ� CRUD �۾��� ����

	private Connection con = null;
	// �������� ���� �����ϰ� ���߿� ������ �ش��ϴ� �� �Ҵ�
	private PreparedStatement pstmt = null;
	// select����� ��µ� ���
	private ResultSet rs = null;

	// �����۾�
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

	// �ڿ�����
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

	// ����
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

	// ����
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

	// ���ڵ� �ϳ� ��ȸ
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
   
	// ��ü ��ȸ
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

	// ����
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
