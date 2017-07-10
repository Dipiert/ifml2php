package acceleo.generacionClaseApplication.main;

public class Application {
	private String routes = "localhost/site1";
	private String locale = "es-ES";
	private String AppType = "web";
	
	public String getRoutes() {
		return routes;
	}
	public void setRoutes(String routes) {
		this.routes = routes;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getAppType() {
		return AppType;
	}
	public void setAppType(String appType) {
		AppType = appType;
	}
	
	
}
