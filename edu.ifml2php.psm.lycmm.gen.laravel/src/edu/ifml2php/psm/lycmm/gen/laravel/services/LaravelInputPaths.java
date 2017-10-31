package edu.ifml2php.psm.lycmm.gen.laravel.services;

public class LaravelInputPaths extends LaravelPaths{
	String configAppPath =  super.getLaravelVersion() + "config/app.php"; 
	String routesPath = super.getLaravelVersion() + "routes/web.php";

	public String getConfigAppPath() {
		return configAppPath;
	}

	public void setConfigAppPath(String configApp) {
		this.configAppPath = configApp;
	}

	public String getRoutesPath() {	   	
		return routesPath;
	}

	public void setRoutesPath(String routes) {
		this.routesPath = routes;
	}
	
	public String getFQN() {
		return this.getClass().getCanonicalName();
	}
}
