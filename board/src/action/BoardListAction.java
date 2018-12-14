package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import domain.PageVO;
import persistence.BoardDAO;

public class BoardListAction implements Action {
	private String path;	
	
	public BoardListAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//board 전체 리스트를 받은 후 
		//리스트를 request 객체에 담는다
		BoardDAO dao=new BoardDAO();
		
		//페이지 나누기 기능 추가
		//1. 현재 페이지 결정
		int page=1;
		
		if(req.getParameter("page")!=null)
			page=Integer.parseInt(req.getParameter("page"));
		
		// 2. 한 페이지당 출력될 게시글 목록 수 결정
		int limit=10;
		
		// 3. 전체 목록 구하기
		int totalRows=dao.totalRows();
		// 4. 전체 목록 수에 따른 총 페이지 수 구하기
		int totalPage=(int)((double)totalRows/limit+0.95);
		// 5 . 현재 화면의 시작 페이지 수 구하기
		int startPage=(((int)((double)page/10+0.9))-1)*10+1;
		// 6. 현재 화면의 마지막 페이지 수 구하기
		int endPage=startPage+9;
		// 7. 보여줄 목록이 작은 경우 현재 화면에 보여지는 나열된 페이지 번호가 
		// totalPage를 넘지 않도록 설정하기
		if(endPage>totalPage)
			endPage=totalPage;
		// 8. qna_board_list.jsp에서 하단에 위치할 페이지 나누기에 사용할 정보 담기
		PageVO info=new PageVO();
		info.setPage(page);
		info.setEndPage(endPage);
		info.setStartPage(startPage);
		info.setTotalPage(totalPage);
		// 9. page에 의한 목록 가져오기
		ArrayList<BoardVO> list=dao.getlist(page, limit);
	
		if(!list.isEmpty()) {
			req.setAttribute("list", list);
			req.setAttribute("info",info);
	}
		return new ActionForward(path, false);
	}
}




















