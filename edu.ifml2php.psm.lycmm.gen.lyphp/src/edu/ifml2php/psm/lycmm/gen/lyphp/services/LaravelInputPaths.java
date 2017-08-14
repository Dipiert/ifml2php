package edu.ifml2php.psm.lycmm.gen.lyphp.services;

public class LaravelInputPaths extends LaravelPaths{
	String configAppPath = "/laravel5.4.15/config/app.php"; //ESto hay que hacerlo depender del BASE_DIR de Laravel
	String routesPath = "/laravel5.4.15/routes/web.php";
   
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
	
}
