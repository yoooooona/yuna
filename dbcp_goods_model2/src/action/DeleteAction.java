package action;

import javax.servlet.http.HttpServletRequest;

import dao.GoodsDAO;

public class DeleteAction implements Action {

	private String path;

	public DeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		// goods_delete_pro.jsp
		String code = req.getParameter("code");

		GoodsDAO dao = new GoodsDAO();
		int result = dao.goods_delete(code);

		if (result == 0)
			path = "error/error.jsp";
		return new ActionForward(true, path);
	}

}
