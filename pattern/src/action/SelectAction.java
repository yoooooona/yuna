package action;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import member.dao.MemberDAO;
import member.vo.MemberVO;


public class SelectAction {
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		//member 테이블 내용 가져오기 
		MemberDAO dao=new MemberDAO();
		
		ArrayList<MemberVO> list=dao.getList();
		req.setAttribute("list", list);
	}
}
