package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import persistence.BoardDAO;

public class BoardhitUpdateAction implements Action {
	
	private String path;
	
	public BoardhitUpdateAction(String path) {
		super();
		this.path=path;
	}
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//qna_board_list.jsp에서 넘긴 값 가져오기
		int bno=Integer.parseInt(req.getParameter("bno"));
		//페이지 나누기 때문에 추가
		int page=Integer.parseInt(req.getParameter("page"));
		//검색 때문에 추가
		String criteria=req.getParameter("criteria");
		//한글 깨짐
		String keyword=URLEncoder.encode(req.getParameter("keyword"), "utf-8");
		//bno에 해당하는 내용 db에서 가져온 후
		BoardDAO dao=new BoardDAO();
		
		//조회수 업데이트
		int result=dao.hitUpdate(bno);
		//조회수 업데이트 성공 후 view.do
		if(result==0)//에러메시지
			path=""; 
		else {
			if(criteria.isEmpty())
				path+="?bno="+bno+"&page="+page;
			else
				path+="?bno="+bno+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
		
		return new ActionForward(path, true); //setAttribute를 하면 false
	}

}
