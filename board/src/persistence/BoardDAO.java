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

import com.mysql.jdbc.SQLError;

import domain.BoardVO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private Connection getConnection() {
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
			return ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	private void close(Connection con,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private void close(Connection con,PreparedStatement pstmt) {
		try {			
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//게시판 전체 목록 가져오기
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		
		String sql="select bno,title,name,re_lev,readcount,regdate"
				+ " from board order by re_ref desc, re_seq asc";
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));	
				vo.setRe_lev(rs.getInt("re_lev"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRegdate(rs.getDate("regdate"));
				list.add(vo);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return list;
	}//전체 게시판 리스트
	
	public int insertArticle(BoardVO vo) {
		int result=0;
		int bno=0;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			//글번호 알아내기
			pstmt=con.prepareStatement("select max(bno) from board");
			rs=pstmt.executeQuery();
			if(rs.next())
				bno=rs.getInt(1)+1;
			else
				bno=1;
			
			//새로운 글 삽입
			String sql="insert into board"+"(bno,name,password,title,content,"
			+"file,re_ref,re_lev,re_seq) values(?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getPassword());
			pstmt.setString(4,vo.getTitle());
			pstmt.setString(5,vo.getContent());
			pstmt.setString(6,vo.getFile());
			pstmt.setInt(7,bno);
			pstmt.setInt(8,0);
			pstmt.setInt(9,0);
			result=pstmt.executeUpdate();
			if(result>0)
				con.commit();
		}catch(SQLException e) {
			try {
				con.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			close(con,pstmt,rs);
		}
		return result;
	}//insertArticle 종료
	
	public BoardVO getRow(int bno) {
		BoardVO vo=null;
		
		con=getConnection();
		//re_ref,re_seq,re_lev :  답변글 작성할 때 필요
		//bno : 삭제, 수정
		String sql="select bno,name,title,content,file,re_ref,re_seq,re_lev from board where bno=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setFile(rs.getString(5));
				vo.setRe_ref(rs.getInt(6));
				vo.setRe_seq(rs.getInt(7));
				vo.setRe_lev(rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return vo;
	}
	//조회수 업데이트
	public int hitUpdate(int bno) {
		int result=0;
		
		String sql="update board set readcount=readcount+1 where bno=?";
		try {
			con=getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			result=pstmt.executeUpdate();
			if(result>0)
				con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}
		return result;
	} 
	public int pwdCheck(int bno, String password) {
		int result=0;
		
		try {
			con=getConnection();
			String sql="select * from board where bno=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next())
				result=1;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return result;
	}//bno와 password 일치여부
	public int delete_row(int bno) {
		int result=0;
		
		try {
			con=getConnection();
			con.setAutoCommit(false);
			String sql="delete from board where bno=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			result=pstmt.executeUpdate();
			if(result>0)
				con.commit();
		}catch(SQLException e) {
			try{
				con.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return result;
}
	public int updateRow(BoardVO vo) {
		int result=0;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			String sql=null;
			if(vo.getFile()!=null) {
				sql="update board set content=?, title=?, file=? where bno=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,vo.getContent());
				pstmt.setString(2,vo.getTitle());
				pstmt.setString(3,vo.getFile());
				pstmt.setInt(4,vo.getBno());
			}else {
				sql="update board set content=?, title=? where bno=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,vo.getContent());
				pstmt.setString(2,vo.getTitle());
				pstmt.setInt(3,vo.getBno());
			}
			result=pstmt.executeUpdate();
			if(result>0)
				con.commit();
		}catch(SQLException e) {
			try {
				con.rollback();
			}catch(SQLException e1 ) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			close(con,pstmt);
		}
		return result;
	}
	public int replyRow(BoardVO vo) {
		int result=0;
		int bno=0;
		try {
			con=getConnection();
			con.setAutoCommit(false);
			//글번호 가져오기
			String sql="select max(bno) from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				bno=rs.getInt(1)+1;
			else
				bno=1;
			
			//원본글에 달린 기존 댓글 정보 수정
			sql="update board set re_ref=re_seq+1";
			sql+=" where re_ref=? and re_seq>?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,vo.getRe_ref());
			pstmt.setInt(2,vo.getRe_seq());
			result=pstmt.executeUpdate();
			
			//댓글 입력하기
			int re_seq=vo.getRe_seq()+1;
			int re_lev=vo.getRe_lev()+1;
			int re_ref=vo.getRe_ref();
			
			sql="insert into board"+"(bno,name,password,title,content,"
					+" file,re_ref,re_lev,re_seq) values(?,?,?,?,?,?,?,?,?)";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, bno);
					pstmt.setString(2,vo.getName());
					pstmt.setString(3,vo.getPassword());
					pstmt.setString(4,vo.getTitle());
					pstmt.setString(5,vo.getContent());
					pstmt.setString(6,vo.getFile());
					pstmt.setInt(7,re_ref); //원본글과 같은 번호
					pstmt.setInt(8,re_lev);
					pstmt.setInt(9,re_seq);
					
					result=pstmt.executeUpdate();
					if(result>0)
						con.commit();
		}catch(SQLException e) {
			try {
				con.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		
		return result;
	}
	//페이지 나누기가 적용된 게시물 리스트 가져오기
	public ArrayList<BoardVO> getlist(int page, int limit){
		//넘어온 페이지에 의해 몇번째 레코드부터 보여줄 것인지 결정
		int start=(page-1)*10;
		
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		
		String sql="select bno, title,name, re_lev,readcount, regdate"
				+" from board order by re_ref desc, re_seq asc limit ?,?";
		
		try {
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2,limit);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRe_lev(rs.getInt(4));
				vo.setReadcount(rs.getInt(5));
				vo.setRegdate(rs.getDate(6));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return list;
	}
	//전체 목록 수 구하기
	public int totalRows() {
		int totalRows=0;
		
		try {
			con=getConnection();
			String sql="select count(*) from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				totalRows=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return totalRows;
	}
	//검색어와 검색조건에 맞는 전체 게시물 수
	public int totalRows(String criteria, String keyword) {
		int totalRows=0;
		
		try {
			con=getConnection();
			String sql="select count(*) from board where ";
			sql+=criteria+" like ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next())
				totalRows=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return totalRows;
	}
	//페이지 나누기가 적용된 게시물 리스트 가져오기
		public ArrayList<BoardVO> getSearchlist(int page, int limit, String criteria, String keyword){
			//넘어온 페이지에 의해 몇번째 레코드부터 보여줄 것인지 결정
			int start=(page-1)*10;
			
			ArrayList<BoardVO> list=new ArrayList<BoardVO>();
			
			String sql="select bno, title,name, re_lev,readcount, regdate"
					+" from board where " 
					+criteria+" like ? "
					+" order by re_ref desc, re_seq asc limit ?,?";
			try {
				con=getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,"%"+keyword+"%");
				pstmt.setInt(2,start);
				pstmt.setInt(3,limit);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					BoardVO vo=new BoardVO();
					vo.setBno(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setRe_lev(rs.getInt(4));
					vo.setReadcount(rs.getInt(5));
					vo.setRegdate(rs.getDate(6));
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(con,pstmt,rs);
			}
			return list;
		}
}

















