package edu.ifml2php.psm.lycmm.gen.lyphp.services;

public class LaravelInputPaths extends LaravelPaths{
	String configApp = "/var/www/html/laravel5.4.15/config/app.php"; //ESto hay que hacerlo depender del BASE_DIR de Laravel
	String routesPath = "/var/www/html/laravel5.4.15/routes/web.php";
   
	public String getConfigApp() {
      return configApp;
   }

   public void setConfigApp(String configApp) {
      this.configApp = configApp;
   }

   public String getRoutesPath() {
	    return routesPath;
   }

   public void setRoutesPath(String routes) {
	this.routesPath = routes;
   }
	
}