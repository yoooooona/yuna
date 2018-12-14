package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import domain.ProductVO;
import persistence.ProductDAO;

public class SelectAllAction implements Action {
	
	private String path;

	public SelectAllAction(String path) {
		super();
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//전체 product 리스트 가져오기
		ProductDAO dao=new ProductDAO();
    	ArrayList<ProductVO> list=dao.selectAll();
		//request에 담기
		if(!list.isEmpty()) {
			req.setAttribute("list",list);
		}
		return new ActionForward(path, false);
	}

}
