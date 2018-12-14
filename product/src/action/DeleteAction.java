package action;

import javax.servlet.http.HttpServletRequest;

import persistence.ProductDAO;

public class DeleteAction implements Action {

	private String path;
	
	public DeleteAction(String path) {
		super();
		this.path=path;
	}
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		
		int prcode=Integer.parseInt(req.getParameter("prcode"));
	
		ProductDAO dao=new ProductDAO();
		int result=dao.product_delete(prcode);
		
		if(result==0)
			path="error/error.jsp";
		return new ActionForward(path, true);
	}

}
