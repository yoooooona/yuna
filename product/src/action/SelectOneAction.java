package action;

import javax.servlet.http.HttpServletRequest;

import domain.ProductVO;
import persistence.ProductDAO;

public class SelectOneAction implements Action {

	private String path;
	
	public SelectOneAction(String path) {
			super();
			this.path = path;
		}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		
		int prcode=Integer.parseInt(req.getParameter("prcode"));
		
		ProductDAO dao=new ProductDAO();
		ProductVO vo=dao.get_product(prcode);
		
		if(vo!=null)
			req.setAttribute("vo", vo);
		return new ActionForward(path, false);
	}

}
