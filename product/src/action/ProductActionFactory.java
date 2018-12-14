package action;

public class ProductActionFactory {
	
	private static ProductActionFactory paf;
	private ProductActionFactory() {}
	
	public static ProductActionFactory getInstance() {
		if(paf==null)
			paf=new ProductActionFactory();
		return paf;
	}
	Action action=null;
	public Action action(String cmd) {
		if(cmd.equals("/insert.do")) {
			action=new InsertAction("selectAll.do");
		}else if(cmd.equals("/selectAll.do")) {
			action=new SelectAllAction("views/selectAll.jsp");
		}else if(cmd.equals("/select.do")) {  //하나만 가져오기
			action=new SelectOneAction("views/select1.jsp");
		}else if(cmd.equals("/delete.do")) {
			action=new DeleteAction("selectAll.do");
		}
		return action;
	}
}
