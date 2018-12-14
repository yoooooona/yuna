package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.GoodsDAO;
import vo.GoodsVO;

public class SelectAction implements Action {
	
	
	private String path;
	
	public SelectAction(String path) { //book_select_result.jsp
		this.path=path;
	}
	
	
	
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//goodsinfo 에 있는 전체내용 가져오기
		GoodsDAO dao=new GoodsDAO();
    	ArrayList<GoodsVO> list=dao.selectAll();
		//전체 리스트 내용을 담고 페이지 이동
		if(!list.isEmpty()) {
			req.setAttribute("list",list);
		}
		return new ActionForward(false,path); //req를 심을 때는 false
	}

}
