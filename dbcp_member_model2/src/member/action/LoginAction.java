package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.vo.MemberVO;

public class LoginAction implements Action {

	private String path;
	
	public LoginAction(String path) {
		this.path=path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req) {
		//loginForm.jsp에서 넘긴 값 가져오기

		//DAO isLogin() 호출해서 있는 사용자라면 로그인 해주기
		//로그인이 되거나, 안되거나 모두 loginForm.jsp로 이동시킨다.
		//로그인이 되면 ~~님 반갑습니다.  로그아웃   이런 형태로 나오게 만들고
		//로그인이 되지 않으면 다시 로그인폼을 띄우도록 한다.

		String userid=req.getParameter("userid");
		String current_password=req.getParameter("current_password");
		
		MemberDAO dao=new MemberDAO();	
		MemberVO vo=dao.isLogin(userid, current_password);	
	  		
	  	if(vo!=null){
	  		HttpSession session=req.getSession();
	  		session.setAttribute("vo",vo); 		
	  	}	  	
		return new ActionForward(true,path);
	}

}











