package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.GoodsDAO;
import vo.GoodsVO;

public class SearchAction implements Action {
	private String path;
	
	public SearchAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		
		//book_search.jsp에서 넘긴 값 가져오기
		String criteria=req.getParameter("criteria");
		String searchword=req.getParameter("searchword");
	    	//DAO good_search 메소드 호출
	    	GoodsDAO dao=new GoodsDAO();
	    	ArrayList<GoodsVO> list=dao.goods_search(criteria,searchword);
	    	
	    	if(!list.isEmpty()) {
				req.setAttribute("list",list);
			}
	       	
		return new ActionForward(false, path); //담았으면 false
	}

}
