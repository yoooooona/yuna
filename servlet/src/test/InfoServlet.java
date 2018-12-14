package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//method가 post라면 가져오는 데이터에 대한 인코딩 작업 필요
		req.setCharacterEncoding("utf-8");
		
		//사용자가 보낸 데이터 가져오기
		String name=req.getParameter("name");
		String addr=req.getParameter("addr");
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.print("<html><head><title>인적사항</title></head>");
		out.print("<body><h3>이름 : "+name);
		out.print("</h3><h3>주소 : "+addr);
		out.print("</h3></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
