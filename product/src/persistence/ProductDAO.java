package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.ProductVO;

public class ProductDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public Connection getConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
			return ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private void close(Connection con, PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public int product_insert(ProductVO vo) {
		//prname,price,manufacture 를 입력
		int result=0;
		String sql="insert into product(prname,price,manufacture) values";
		sql+="(?,?,?)";
		try {
			con=getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getPrname());
			pstmt.setInt(2,vo.getPrice());
			pstmt.setString(3,vo.getManufacture());
			result=pstmt.executeUpdate();
			if(result>0)
				con.commit();
		}catch(SQLException e) {
			try {
				con.rollback();
			}catch(SQLException e1) {
				e.printStackTrace();
			}
			
		}finally {
		close(con,pstmt);
		}
		
		return result;
	}

	public int product_update(int prcode, int price) {
		// price만 변경 가능
		int result = 0;
		String sql = "update product set price=? where prcode=?";
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, prcode);
			result = pstmt.executeUpdate();
			if (result > 0)
				con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return result;

	}

	public int product_delete(int prcode) {
		// prcode가 일치하는 경우 삭제
		int result = 0;
		String sql = "delete from product where prcode=?";
		try {
			con = getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			result = pstmt.executeUpdate();
			if (result > 0)
				con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return result;

	}

	public ArrayList<ProductVO> selectAll() {
		// 전체 상품 가져오기
		ArrayList<ProductVO> list = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select * from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setPrcode(rs.getInt(1));
				vo.setPrname(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setManufacture(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}


	public ProductVO get_product(int prcode) {
		// 특정 상품 가져오기
		ProductVO vo=null;
		try {
			con = getConnection();
			String sql = "select * from product where prcode = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ProductVO();
				vo.setPrcode(rs.getInt(1));
				vo.setPrname(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setManufacture(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return vo;
	}
}
