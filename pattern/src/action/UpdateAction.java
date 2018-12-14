package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction {
	//update.do로 들어오는 요청 처리
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String age=req.getParameter("age");
		System.out.println("나이 : "+age);
	}
}
