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
 * Servlet implementation class CartBasket
 */
@WebServlet("/CartBasket")
public class CartBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session에 저장된 값을 출력하기
		HttpSession session=request.getSession();
		//session 얻어오는 방법
		// request.getSession() :  request랑 관련있는 session이 있으면 돌려줌(세션이 없으면 무조건 새로 생성)
		//request.getSession(true) : " (세션이 없는 경우 true이면 생성
		//request.getSession()			false이면 생성 안함)	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<html><head><title>장바구니</title></head>");
		out.print("<body>");
		out.print("<h3>장바구니 리스트 상품 :");
//		if(session!=null) {
//			ArrayList<String> list=(ArrayList<String>)session.getAttribute("car_list");
//			for(String s : list)
//				out.print(s+",");
//		}
//		
		out.print(session.getAttribute("car_list"));
		//상품선택 페이지와 장바구니 비우기 링크 제공
		out.print("<a href='test/cart.html'>상품선택 페이지</a>");
		out.print("<a href='CartDel'>장바구니 비우기</a>");
		out.print("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
