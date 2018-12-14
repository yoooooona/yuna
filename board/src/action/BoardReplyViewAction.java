package action;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;

public class BoardReplyViewAction implements Action {
	
	private String path;
	
	public BoardReplyViewAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//bno 가지고 오기
		int bno=Integer.parseInt(req.getParameter("bno"));
		int page=Integer.parseInt(req.getParameter("page"));
		
		
		SearchVO search=new SearchVO();
		search.setCriteria(req.getParameter("criteria"));
		search.setKeyword(req.getParameter("keyword"));
		//bno에 해당하는 내용 가져오기
		BoardVO vo=new BoardDAO().getRow(bno);
		
		//내용을 담고 페이지 이동
		if(vo!=null && search.getCriteria()==null) {
			req.setAttribute("vo", vo);
		}else {
			req.setAttribute("vo",vo);
			req.setAttribute("search",search);
		}
		
		path+="?page="+page;
			
		return new ActionForward(path,false);
	}

}
