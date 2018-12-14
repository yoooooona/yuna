package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;

public class BoardViewAction implements Action {

	private String path;

	public BoardViewAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		// qna_board_list.jsp에서 넘긴 값 가져오기
		int bno = Integer.parseInt(req.getParameter("bno"));
		// 페이지 나누기 때문에 추가
		int page = Integer.parseInt(req.getParameter("page"));
		
		String criteria=req.getParameter("criteria");
 
		String keyword=req.getParameter("keyword");
		
		SearchVO search=new SearchVO();
		search.setCriteria(req.getParameter("criteria"));
		search.setKeyword(req.getParameter("keyword"));
		
		
		// bno에 해당하는 내용 db에서 가져온 후
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getRow(bno);
		// 내용을 담고 qna_board_view.jsp로 이동
		if (vo != null && search.getCriteria()==null) {
			req.setAttribute("vo", vo);
		}else {
			req.setAttribute("vo",vo);
			req.setAttribute("search",search);
		}
		path += "?page=" + page;
		return new ActionForward(path, false);
	}

}
