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

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String requestURI=req.getRequestURI();
		String contextURI=req.getContextPath();
		String cmd=requestURI.substring(contextURI.length());
		
		//사용자의 명령에 따라 Action을 생성해주는 객체에 일 시키기
		MemberActionFactory maf=MemberActionFactory.getInstance();
		Action action=maf.action(cmd);
		
		ActionForward af=action.execute(req, res);
		
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
