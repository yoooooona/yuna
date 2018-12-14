package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class animalServlet
 */
@WebServlet("/animalServlet")
public class AnimalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//여러개의 값을 가져올 경우 getParameterValues 하나의 값을 가져올 때  getParameter
		String animal[]=req.getParameterValues("animal");
		String dinner=req.getParameter("dinner");
		//출력
		res.setContentType("text/html/;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.print("<html><head><title>애완동물</title></head>");
		out.print("<body><h3>애완 동물 : ");
		for(String s:animal)
			out.printf("%s" ,s);
		out.print("</h3><h3>저녁 식사 : ");
		out.printf("%s", dinner);
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
