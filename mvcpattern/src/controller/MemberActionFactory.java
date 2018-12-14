package controller;

import action.Action;
import action.InsertAction;

public class MemberActionFactory {
	//사용자의 명령에 따라서 각각의 action 생성
	private static MemberActionFactory maf;
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() { //sigleton패턴
		if(maf==null)
			maf=new MemberActionFactory();
		return maf;
	}
	
	Action action=null;
	public Action action(String cmd) {
		
		if(cmd.equals("/insert.do")) {
			action=new InsertAction();
		}
		return action;
	}

}
