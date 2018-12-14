package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import persistence.BoardDAO;

public class BoardDeleteAction implements Action {
	
	private String path;
	public BoardDeleteAction(String path) {
		super();
		this.path=path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//게시물 삭제후 리스트로 이동
		int bno=Integer.parseInt(req.getParameter("bno"));
		
		int page=Integer.parseInt(req.getParameter("page"));
		
		String criteria=req.getParameter("criteria");
		String keyword = null;
		if(req.getParameter("keyword") != null)
			 keyword=URLEncoder.encode(req.getParameter("keyword"),"utf-8");
		BoardDAO dao=new BoardDAO();
		int result=dao.delete_row(bno);
		
		if(result==0)
			path=""; //에러페이지
		else {
			//select.do가 잡혀있기때문에
			if(criteria == null)
				path+="?page="+page;
			else
				path="search.do?page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
		return new ActionForward(path, true);
	}

}
