package acceleo.ifml2OurMM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import acceleo.ifml2OurMM.FileReader;
import acceleo.ifml2OurMM.LaravelPaths;


public class Application {
	public String routes = "localhost/site1";
	public String locale = "es-ES";
	public String AppType = "web";
	
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
	
	public static void main(String[] args){
		Application app = new Application();
		app.getAppConfig();
	}
	
	public String getAppConfig(){
		return new FileReader().getFile(new LaravelPaths().getConfigApp());
	}	
}
