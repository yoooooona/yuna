package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction {
	//insert.do로 들어오는 요청 작업 처리
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String name=req.getParameter("name");
		System.out.println(name);
		//DAO연동
		
		//페이지 이동
	}
}
