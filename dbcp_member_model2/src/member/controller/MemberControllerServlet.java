package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.Action;
import member.action.ActionForward;
import member.action.MemberActionFactory;

/**
 * Servlet implementation class MemberControllerServlet
 */
@WebServlet("*.do")
public class MemberControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//request 한글처리
		req.setCharacterEncoding("utf-8");
		
		//url 잘라내기
		String requestURI=req.getRequestURI(); // /context명/~~.do
		String contextPath=req.getContextPath(); // /context명
		String cmd=requestURI.substring(contextPath.length()); //   /~.do
				
		//MemberActionFactory 객체 생성
		MemberActionFactory maf=MemberActionFactory.getInstance();
		//action메소드 호출
		Action action=maf.action(cmd);
		
		//넘겨받은 Action 일 시키기
		//일이 끝난 후 이동할 경로 및 이동 방법 리턴 받음
		ActionForward af=action.execute(req);
				
		//이동하기
		if(af.isRedirect()) {
			res.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd=req.getRequestDispatcher(af.getPath());
			rd.forward(req, res);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}











