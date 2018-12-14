package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import domain.PageVO;
import domain.SearchVO;
import persistence.BoardDAO;

public class BoardSearchAction implements Action {

	private String path;

	public BoardSearchAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		// qna_board_list.jsp에서 넘어오는 검색조건과 검색어 가져오기
		String criteria = req.getParameter("criteria");
		String keyword = req.getParameter("keyword");
		BoardDAO dao = new BoardDAO();
		// 검색조건과 검색어에 맞는 페이지 나누기
		int page = 1;

		if (req.getParameter("page") != null)
			page = Integer.parseInt(req.getParameter("page"));

		// 2. 한 페이지당 출력될 게시글 목록 수 결정
		int limit = 10;

		// 3. 검색어와 검색조선에 맞는 전체 목록 구하기
		int totalRows = dao.totalRows(criteria,keyword);
		// 4. 전체 목록 수에 따른 총 페이지 수 구하기
		int totalPage = (int) ((double) totalRows / limit + 0.95);
		// 5 . 현재 화면의 시작 페이지 수 구하기
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 6. 현재 화면의 마지막 페이지 수 구하기
		int endPage = startPage + 9;
		// 7. 보여줄 목록이 작은 경우 현재 화면에 보여지는 나열된 페이지 번호가
		// totalPage를 넘지 않도록 설정하기
		if (endPage > totalPage)
			endPage = totalPage;
		
		//리스트 페이지랑 달라지는 부분
		if(page>totalPage)
			page=1;
		
		// 8. qna_board_list.jsp에서 하단에 위치할 페이지 나누기에 사용할 정보 담기
		PageVO info = new PageVO();
		info.setPage(page);
		info.setEndPage(endPage);
		info.setStartPage(startPage);
		info.setTotalPage(totalPage);
		
		//검색어와 검색조건 담기
		SearchVO searchVO=new SearchVO();
		searchVO.setCriteria(criteria);
		searchVO.setKeyword(keyword);
		
		// 검색조건과 검색어에 맞는 리스트 뽑아내기
		ArrayList<BoardVO> search = dao.getSearchlist(page, limit, criteria, keyword);
		
		if(!search.isEmpty()) {
			req.setAttribute("list",search);
			req.setAttribute("info", info);
			req.setAttribute("search",searchVO);
		}
		// 검색 리스트 결과 담고 이동
		

		return new ActionForward(path, false);
	}

}
