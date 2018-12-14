package action;

public class ActionForward {
	private boolean redirect;
	private String path;
	
	
	public ActionForward() {
		super();
	}
	public ActionForward(boolean redirect, String path) {
		super();
		this.redirect = redirect;
		this.path = path;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
