package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	private String path;
	
	public LogoutAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) {
		//세션 해제
		HttpSession session=req.getSession(false);
		if(session!=null)
			session.invalidate();
		return new ActionForward(true,path);
	}

}












