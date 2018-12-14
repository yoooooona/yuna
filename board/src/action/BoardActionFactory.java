package action;

public class BoardActionFactory {
	private static BoardActionFactory baf;
	private BoardActionFactory() {}
	public static BoardActionFactory getInstance() {
		if(baf==null)
			baf=new BoardActionFactory();
		return baf;
	}
	
	Action action=null;
	public Action action(String cmd) {
		if(cmd.equals("/select.do")) {
			action=new BoardListAction("views/qna_board_list.jsp");
		}else if(cmd.equals("/insert.do")) { //리스트로 이동
			action=new BoardWriteAction("select.do");
		}else if(cmd.equals("/view.do")) {
			action=new BoardViewAction("views/qna_board_view.jsp");
		}else if(cmd.equals("/hitUpdate.do")) {
			action=new BoardhitUpdateAction("view.do");
		}else if(cmd.equals("/pwdCheck.do")) {
			action=new BoardPwdCheckAction("delete.do");  //delete.do
		}else if(cmd.equals("/delete.do")) {
			action=new BoardDeleteAction("select.do"); //끝나고 리스트 페이지 보여주기
		}else if(cmd.equals("/modify.do")) {
			action=new BoardModifyAction("views/qna_board_modify.jsp");
		}else if(cmd.equals("/update.do")) {
			action=new BoardUpdateAction("view.do");
		}else if(cmd.equals("/replyView.do")) {
			action=new BoardReplyViewAction("views/qna_board_reply.jsp");
		}else if(cmd.equals("/reply.do")) {
			action=new BoardReplyAction("select.do");
		}else if(cmd.equals("/search.do")) {
			action=new BoardSearchAction("views/qna_board_list.jsp");
		}
		
		
		
		return action;
	}
}
