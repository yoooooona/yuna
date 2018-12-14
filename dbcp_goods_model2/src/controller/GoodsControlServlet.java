package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.GoodsActionFactory;


/**
 * Servlet implementation class GoodsControlServlet
 */
@WebServlet({ "/GoodsControlServlet", "*.do" })
public class GoodsControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//한글 처리
		req.setCharacterEncoding("utf-8");
		//URI 분리
		String requestURI=req.getRequestURI(); 
		String contextPath=req.getContextPath(); 
		String cmd=requestURI.substring(contextPath.length()); 
		//액션 생성
		GoodsActionFactory gaf=GoodsActionFactory.getInstance();
		Action action=gaf.action(cmd);
		//액션 일 시키기
		ActionForward af=null;
		try {
			af=action.execute(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//경로 이동
		if(af.isRedirect()) {
			res.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd=req.getRequestDispatcher(af.getPath());
			rd.forward(req,res);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
