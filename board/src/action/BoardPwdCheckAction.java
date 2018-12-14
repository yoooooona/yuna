package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;



import persistence.BoardDAO;

public class BoardPwdCheckAction implements Action {
	
	private String path;
	
	public BoardPwdCheckAction(String path) {
		super();
		this.path=path;
	}
	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//비밀번호와 bno를 가져온 후
		String password=req.getParameter("password");
		int bno=Integer.parseInt(req.getParameter("bno"));
		
		String criteria=req.getParameter("criteria");
		String keyword=URLEncoder.encode(req.getParameter("keyword"),"utf-8");
		//페이지 나누기 때문에 추가
		int page=Integer.parseInt(req.getParameter("page"));
		//db 확인 일치하면
		BoardDAO dao=new BoardDAO();
		int result=dao.pwdCheck(bno, password);
		//삭제하는 액션으로 이동
		if(result==0)
			path="error/error.jsp"; //에러페이지로 이동
		else {
			if(criteria.isEmpty())
				path+="?bno="+bno+"&page="+page;
			else
				path+="?bno="+bno+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
	
		return new ActionForward(path,true);
	}

}
