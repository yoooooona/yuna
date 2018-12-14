package action;

import javax.servlet.http.HttpServletRequest;

import dao.GoodsDAO;
import vo.GoodsVO;

public class ModifyAction implements Action {
	
	private String path;
	
	public ModifyAction(String path) {
		super();
		this.path=path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//goods_modify_pro.jsp
		
		String code=req.getParameter("code");
		int price=Integer.parseInt(req.getParameter("price"));
		
		GoodsDAO dao=new GoodsDAO();
		GoodsVO vo=new GoodsVO();
		vo.setCode(code);
		vo.setPrice(price);
		int result=dao.goods_modify(vo);
		
		if(result==0)
			path="error/error.jsp";
		
		return new ActionForward(true, path);
	}

}
