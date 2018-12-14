package action;

public class GoodsActionFactory {
	private static GoodsActionFactory gaf;
	private GoodsActionFactory() {}
	public static GoodsActionFactory getInstance() {
		if(gaf==null)
			gaf=new GoodsActionFactory();
		return gaf;
	}
	Action action=null;
	public Action action(String cmd) {
		if(cmd.equals("/select.do")) {
			action=new SelectAction("book_select_result.jsp"); //어디 페이지로 돌아갈 것인지
		}else if(cmd.equals("/insert.do")) {
			action=new InsertAction("select.do");
		}else if(cmd.equals("/delete.do")) {
			action=new DeleteAction("select.do");
		}else if(cmd.equals("/modify.do")) {
			action=new ModifyAction("select.do");
		}else 
			action=new SearchAction("select.do");
		return action;
	}

}
