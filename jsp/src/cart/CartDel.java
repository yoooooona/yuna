package cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartDel
 */
@WebServlet("/CartDel")
public class CartDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 해제 시킨 후 
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.removeAttribute("car_list");
		
		//상품 선택 페이지로 가는 링크 제공
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<html><head><title>장바구니</title></head>");
		out.print("<body>");
		out.print("<h3>장바구니 비웠음</h3>");
		out.print("<a href='test/cart.html'>상품선택  페이지</a>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
