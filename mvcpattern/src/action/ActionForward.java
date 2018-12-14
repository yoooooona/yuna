package action;

public class ActionForward {
	//sendRedirect로 이동할 것인지  forward로 이동할 것인지 결정
	private String path; //실제 경로
	private boolean redirect; //redirect여부
	
	public ActionForward(String path, boolean redirect) {
		super();
		this.path=path;
		this.redirect=redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	

}
