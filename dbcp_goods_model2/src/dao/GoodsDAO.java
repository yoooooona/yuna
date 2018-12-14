package dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import vo.GoodsVO;

import java.sql.PreparedStatement;

public class GoodsDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	public Connection getConnection() {		
		try {
		/*	Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/javadb?useSSL=true";
			return DriverManager.getConnection(url,"root","12345");*/
				Context ctx=new InitialContext();
				DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
				return ds.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
	}	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close(Connection con, PreparedStatement pstmt) {
		try {			
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int goods_insert(GoodsVO vo) {
		int result=0;
		
		try {
			con=getConnection();
			String sql="insert into goodsinfo values(?,?,?,?)";		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			result=pstmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}		
		return result;
	}
	public int goods_modify(GoodsVO vo) {
		int result=0;
		try {
			con=getConnection();
			String sql="update goodsinfo set price=? where code=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getCode());
			result=pstmt.executeUpdate();	
		}catch(SQLException e) {			
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}		
		return result;
	}
	public int goods_delete(String code) {
		int result=0;
		try {
			con=getConnection();
			String sql="delete from goodsinfo where code=?";
			PreparedStatement pstmt=con.prepareStatement(sql);	
			pstmt.setString(1, code);
			result=pstmt.executeUpdate();		
		}catch(SQLException e) {			
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}	
		return result;
	}
	public ArrayList<GoodsVO> selectAll() {
		ArrayList<GoodsVO> list=new ArrayList<>();
		try {
			con=getConnection();
			String sql="select * from goodsinfo";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO vo=new GoodsVO();
				vo.setCode(rs.getString(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				list.add(vo);
			}
		}catch(SQLException e) {			
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return list;
	}
	
	public ArrayList<GoodsVO> goods_search(String criteria, String searchword){
		ArrayList<GoodsVO> list=new ArrayList<>();
		try{
			con=getConnection();
		String sql="select * from goodsinfo where "+criteria+"=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, searchword);
		rs=pstmt.executeQuery();
		System.out.println("pstmt : "+pstmt);
		while(rs.next()) {
			GoodsVO vo=new GoodsVO();
			vo.setCode(rs.getString(1));
			vo.setTitle(rs.getString(2));
			vo.setWriter(rs.getString(3));
			vo.setPrice(rs.getInt(4));
			list.add(vo);
		}
	}catch(SQLException e) {			
		e.printStackTrace();
	}finally {
		close(con,pstmt,rs);
	}
	return list;

	}
}


















