package member.action;

import javax.servlet.http.HttpServletRequest;

import member.dao.MemberDAO;
import member.vo.MemberVO;

public class JoinAction implements Action {
	private String path;
	
	public JoinAction(String path) {
		super();
		this.path = path; //view/loginForm.jsp
	}	
	@Override
	public ActionForward execute(HttpServletRequest req) {
		//joinProcess.jsp에서 작업했던 일
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		String confirm_password=req.getParameter("confirm_password");
		String name=req.getParameter("name");	
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		
		MemberDAO dao=new MemberDAO();	
		MemberVO vo=new MemberVO();
		//두개의 비밀번호가 일치하는지 확인하기 위해서
		vo.setPassword(password);	
		
		if(vo.password_equalTo(confirm_password)){		
			//비밀번호가 맞는다면 나머지 정보를 다 담는다
			vo.setUserid(userid);
			vo.setName(name);
			vo.setGender(gender);
			vo.setEmail(email);
		
	  		int result=dao.member_insert(vo);	
	  		
	  		//회원가입 성공 path=view/loginForm.jsp
	  		
	  		if(result==0) //회원가입실패
	  			path="view/joinForm.jsp";
		}else{
				path="";
		} 	
		return new ActionForward(true,path);
	}
}









