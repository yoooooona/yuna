package action;

import javax.servlet.http.HttpServletRequest;


import domain.ProductVO;
import persistence.ProductDAO;


public class InsertAction implements Action {
	
	private String path; //selectAll.do
	
	public InsertAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//insert.html에서 넘긴 값 가져오기
		String prname=req.getParameter("prname");
		int price=Integer.parseInt(req.getParameter("price"));
		String manufacture=req.getParameter("manufacture");
	
		//데이터베이스에 입력
		ProductDAO dao=new ProductDAO();
		ProductVO vo=new ProductVO();
		vo.setPrname(prname);
		vo.setPrice(price);
		vo.setManufacture(manufacture);	
		int result=dao.product_insert(vo);
		
		//result가 0이면 error 페이지 띄우기
		if(result==0) //insert실패
			path="error/error.jsp";
		
		return new ActionForward(path, true);
	}

}
