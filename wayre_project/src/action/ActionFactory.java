package action;

public class ActionFactory {
	private static ActionFactory baf;
	private ActionFactory() {}
	public static ActionFactory getInstance() {
		if(baf==null)
			baf = new ActionFactory();
		return baf;
		
	}
	
	Action action = null;
	public Action action(String cmd) {
		if(cmd.equals("/login.do"))
		{
			action=new LoginAction("user/login.jsp");
		}	
		else if(cmd.equals("/signup.do"))
		{
			action=new SignUpAction("user/signUp.jsp");
		}	
		
		else if (cmd.equals("/checkIdEmail.do"))
		{
			action=new CheckIdEmailAction("user/checkIdEmail.jsp");
		}
		
		return action;
	}
}
