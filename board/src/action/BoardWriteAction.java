package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import persistence.BoardDAO;


public class BoardWriteAction implements Action {

	private String path;
	
	public BoardWriteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		//요청이 들어오면 uploadFileUtils에 req를 넘겨서
		//일반 폼 필드 값과 파일에 들어온 값을 분리한 후 다시 돌려받는다
		UploadFileUtils utils=new UploadFileUtils();
		// HashMap <키, 값>
		HashMap<String, String> dataMap=utils.uploadFile(req);
		
		BoardVO vo=new BoardVO();
		vo.setName(dataMap.get("name"));
		vo.setPassword(dataMap.get("password"));
		vo.setTitle(dataMap.get("title"));
		vo.setContent(dataMap.get("content"));
		if(dataMap.get("file")!=null)
			vo.setFile(dataMap.get("file"));
		
		
		//db insert 작업
		BoardDAO dao=new BoardDAO();
		int result=dao.insertArticle(vo);
		//insert 작업 결과에 따라 페이지 이동
		if(result==0)//insert 실패시
		path="";
		return new ActionForward(path, true);
	}

}
