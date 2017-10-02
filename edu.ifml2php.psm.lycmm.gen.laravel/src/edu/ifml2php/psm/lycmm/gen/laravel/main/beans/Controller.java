package edu.ifml2php.psm.lycmm.gen.laravel.main.beans;

public class Controller {
	private boolean isHookeable;

	public Controller() {
	   //Las clase Java que proveen servicios a Acceleo deben tener un contructor vacio.
	}
	
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
