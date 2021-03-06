package action;

import javax.servlet.http.HttpServletRequest;

import dao.GoodsDAO;
import vo.GoodsVO;

public class InsertAction implements Action {

	private String path;
	
	
	public InsertAction(String path) {
		super();
		this.path=path;
	}


	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//goods_insert_pro.jsp에서 했던 작업 
		String code=req.getParameter("code");
		String title=req.getParameter("title");
		String writer=req.getParameter("writer");
		int price=Integer.parseInt(req.getParameter("price"));
		
		GoodsDAO dao=new GoodsDAO();
		GoodsVO vo=new GoodsVO();
		vo.setCode(code);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setPrice(price);	
		int result=dao.goods_insert(vo);
		
		if(result==0)
			path="error/error.jsp";
		
		return new ActionForward(true, path);
	}

}
