package action;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;

public class BoardModifyAction implements Action {

	private String path;

	public BoardModifyAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		// bno 가져오기
		int bno = Integer.parseInt(req.getParameter("bno"));
		// 페이지 나누기 때문에 추가
		int page = Integer.parseInt(req.getParameter("page"));
		// 검색 때문에 추가
		String criteria = req.getParameter("criteria");
		String keyword = req.getParameter("keyword");
		SearchVO search = new SearchVO();
		search.setCriteria(criteria);
		search.setKeyword(keyword);
		// bno에 해당하는 게시물 가져오기

		BoardVO vo = new BoardDAO().getRow(bno);

		// 내용 담고 페이지 이동 ->
		if (vo != null && search.getCriteria() == null) {
			req.setAttribute("vo", vo);		
		}else {
			req.setAttribute("search",search);
			req.setAttribute("vo",vo);
		}
		path+="?page="+page;
		return new ActionForward(path, false);
	}

}
