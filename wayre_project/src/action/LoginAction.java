package action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import persistence.UserDAO;

public class LoginAction implements Action{

	private String path;
	
	
	public LoginAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		// TODO Auto-generated method stub
		
		String user_id = req.getParameter("id");
		String user_pw = req.getParameter("pw");
		int result = 0;
		
		UserDAO dao = new UserDAO();
		result = dao.login(user_id, user_pw);
		
		req.setAttribute("result", result);
		return new ActionForward(path, false);
	}
}
