package member.action;

public class MemberActionFactory {
	private static MemberActionFactory maf;
	private MemberActionFactory() {}
	
	public static MemberActionFactory getInstance() {
		if(maf==null)
			maf=new MemberActionFactory();
		return maf;
	}	
	
	Action action=null;
	public Action action(String cmd) {
		//cmd에 따라 액션 생성하기
		if(cmd.equals("/login.do")) {
			//액션을 생성하면서 일이 끝난 후 이동할 경로까지 세팅
			action=new LoginAction("view/loginForm.jsp");
		}else if(cmd.equals("/logout.do")) {
			action=new LogoutAction("view/loginForm.jsp");
		}else if(cmd.equals("/join.do")) {
			action=new JoinAction("view/loginForm.jsp");
		}		
		return action;
	}
}














