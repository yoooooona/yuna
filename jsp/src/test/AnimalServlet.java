package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnimailSerlet
 */
@WebServlet("/AnimailSerlet")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String food=req.getParameter("food");
		/*HttpSession session=req.getSession();
		session.setAttribute("food",food);*/
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out =res.getWriter();
		out.print("<h3>좋아하는 동물은?</h3>");
		out.print("<form action='test/prefer.jsp' method='post'>");
		out.print("<input type='text' name='animal'>");
		out.print("&nbsp;&nbsp;");
		out.print("<input type='submit' value='확인'>");
		//hidden : 값숨기기 중요한 내용은 hidden에 담으면 안됌 소스보기 하면 뜨기 때문에
		out.print("<input type='hidden' name='food' value="+food+">");
		out.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
