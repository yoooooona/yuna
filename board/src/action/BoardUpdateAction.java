package action;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;


public class BoardUpdateAction implements Action {
	
	private String path;
	
	
	public BoardUpdateAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		UploadFileUtils utils=new UploadFileUtils();
		HashMap<String ,String> dataMap=utils.uploadFile(req);
	
		
		int bno=Integer.parseInt(dataMap.get("bno"));
		String password=dataMap.get("password");
		String title=dataMap.get("title");
		String content=dataMap.get("content");
		String file=dataMap.get("file");
		
		int page=Integer.parseInt(dataMap.get("page"));
		
		//검색 때문에 추가
		String criteria=dataMap.get("criteria");
		String keyword=URLEncoder.encode(dataMap.get("keyword"),"utf-8");
	
		//db 비밀번호 확인 작업
		BoardDAO dao=new BoardDAO();
		int result=dao.pwdCheck(bno, password);
		if(result==0) 
			return new ActionForward("error.jsp",true);
			
		//비밀번호가 맞다면 수정 작업 시작
		BoardVO vo=null;
		if(file!=null) {
			vo=new BoardVO();
			vo.setBno(bno);
			vo.setPassword(password);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setFile(file);
		}else {
			vo=new BoardVO();
			vo.setBno(bno);
			vo.setPassword(password);
			vo.setTitle(title);
			vo.setContent(content);
		}
		result=dao.updateRow(vo);
		
		if(result==0)
			path="error.jsp";
		else {
			
			if(criteria.isEmpty())
			path+="?bno="+bno+"&page="+page;
			else
				path+="?bno="+bno+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
		return new ActionForward(path, true);
	}

}
