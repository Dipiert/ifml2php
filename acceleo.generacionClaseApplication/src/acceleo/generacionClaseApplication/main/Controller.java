package acceleo.generacionClaseApplication.main;

public class Controller {
	private boolean isHookeable;

	public Controller(boolean isHookeable){
		this.isHookeable = isHookeable;
	}
	
	public boolean isHookeable() {
		return isHookeable;
	}

	public void setHookeable(boolean isHookeable) {
		this.isHookeable = isHookeable;
	}
	
	
	
}
