package action;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import domain.BoardVO;
import persistence.BoardDAO;

public class BoardReplyAction implements Action {

	private String path;

	public BoardReplyAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req) throws Exception {
		// qna_board_reply.jsp에서 넘긴 값 가져오기
		UploadFileUtils utils = new UploadFileUtils();
		// HashMap <키, 값>
		HashMap<String, String> dataMap = utils.uploadFile(req);

		BoardVO vo = new BoardVO();
		vo.setName(dataMap.get("name"));
		vo.setPassword(dataMap.get("password"));
		vo.setTitle(dataMap.get("title"));
		vo.setContent(dataMap.get("content"));
		if (dataMap.get("file") != null)
			vo.setFile(dataMap.get("file"));
		// hidden 숨긴 값 가져오기
		if (dataMap.get("re_ref") != null) {
			vo.setRe_ref(Integer.parseInt(dataMap.get("re_ref")));
			vo.setRe_seq(Integer.parseInt(dataMap.get("re_seq")));
			vo.setRe_lev(Integer.parseInt(dataMap.get("re_lev")));
		}
		// 페이지 나누기 추가
		int page = Integer.parseInt(dataMap.get("page"));
		
		

		String criteria = dataMap.get("criteria");
		String keyword = URLEncoder.encode(dataMap.get("keyword"), "utf-8");
		
		// db
		BoardDAO dao = new BoardDAO();
		int result = dao.replyRow(vo);

		if (result == 0)
			path = "";
		else {
			if (criteria.isEmpty())
				path += "?page=" + page;
			else
				path = "search.do?page=" + page + "&criteria=" + criteria + "&keyword=" + keyword;
		}
		return new ActionForward(path, true);
	}

}
