package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetInfoServlet
 */
@WebServlet("/NetInfoServlet")
public class NetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.print("Server Name : "+req.getServerName()+"<br>");
		out.print("Server Port : "+req.getServerPort()+"<br>");
		out.print("Context path : "+req.getContextPath()+"<br>");
		out.print("Client Address :"+req.getRemoteAddr()+"<br>");
		out.print("Client Host : "+req.getRemoteHost()+"<br>");
		out.print("Request URI : "+req.getRequestURI()+"<br>");
		out.print("Servlet path : "+req.getServletPath()+"<br>");
		out.print("HTTP Method : "+req.getMethod());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
