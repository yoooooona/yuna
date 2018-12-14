package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cart.html에서 넘긴 값 가져오기
		String car=request.getParameter("car");
		
		//session객체 생성 후에 cart.html에서 넘긴 값 담기
		HttpSession session=request.getSession();
		//페이지에서 계속 상품을 담을 수 있도록 ArrayList 사용
		//기존에 담아높은 ArrayList가 있는지 확인해야 함
		ArrayList<String> list=null;
		
		if(session.getAttribute("car_list") != null)
			list=(ArrayList<String>) session.getAttribute("car_list");
		
		else
			list=new ArrayList<String>();
		
		list.add(car);
		session.setAttribute("car_list",list);
		//session.setAttribute("car",car);
		
		//CartBasket페이지로 이동할 수 있는 링크 제공
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<html><head><title>장바구니</title></head>");
		out.print("<body>");
		out.print("<h3>Product추가</h3>");
		out.print("<a href='CartBasket'>장바구니 담기</a>");
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
