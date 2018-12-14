package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.ProductActionFactory;

/**
 * Servlet implementation class ProductControlServlet
 */
@WebServlet({ "/ProductControlServlet", "*.do" })
public class ProductControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//한글 처리
		req.setCharacterEncoding("utf-8");
		//url 분리
		String requestURI=req.getRequestURI(); 
		String contextPath=req.getContextPath(); 
		String cmd=requestURI.substring(contextPath.length());
		// 액션 생성
		ProductActionFactory paf=ProductActionFactory.getInstance();
		//action메소드 호출
		Action action=paf.action(cmd);
		ActionForward af= null;
		try {
			af=action.execute(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//액션 일 시키기
		
		//이동
		if(af.isRedirect()) {
			res.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd=req.getRequestDispatcher(af.getPath());
			rd.forward(req,res);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
