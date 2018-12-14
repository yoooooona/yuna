package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.DeleteAction;
import action.InsertAction;
import action.SelectAction;
import action.UpdateAction;
import member.vo.MemberVO;

/**
 * Servlet implementation class Frontcontroller
 */
@WebServlet("*.do") //*.do로 보내주기만 하면 응답을 받겠다는 의미
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//http://localhost:8080/pattern/update.do 와 같은 주소에서
		//update.do만 잘라내기
		String requestURI=req.getRequestURI();
		String contextPath=req.getContextPath();
		String cmd=requestURI.substring(contextPath.length());
		
		/*PrintWriter out=res.getWriter();
		res.setContentType("text/html;charset=utf=8");
		out.print("requestURI : "+requestURI+"<br>");
		out.print("contextPath : "+contextPath+"<br>");
		out.print("cmd : "+cmd);*/
		
		if(cmd.equals("/insert.do")){
			InsertAction action=new InsertAction();
			action.execute(req, res);
			//request.html로 이동
			res.sendRedirect("view/request.html");
		}else if(cmd.equals("/update.do")) {
			UpdateAction action=new UpdateAction();
			action.execute(req, res);
			res.sendRedirect("view/request.html");
		}else if(cmd.equals("/delete.do")) {
			DeleteAction action=new DeleteAction();
		}else { ///select.do
			SelectAction action=new SelectAction();
			action.execute(req, res);
			RequestDispatcher rd=req.getRequestDispatcher("view/select.jsp");
			rd.forward(req, res);
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
