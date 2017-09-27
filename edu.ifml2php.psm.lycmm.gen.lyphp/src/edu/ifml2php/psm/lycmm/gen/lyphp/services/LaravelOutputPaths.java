package edu.ifml2php.psm.lycmm.gen.lyphp.services;

public class LaravelOutputPaths extends LaravelPaths{
   String laravelVersion = "laravel5.4.15/";
   String modelsHome = laravelVersion + "app/";
   String viewsHome =  laravelVersion + "resources/";
   String controllersHome = laravelVersion + "/app/Http/Controllers/";
   String modelRequestsHome = laravelVersion + "app/Http/Requests/";
   String welcomeView = laravelVersion + "resources/views/welcome.blade.php";
   String stylesheetsPath = laravelVersion + "public/css/";
   
   public String getLaravelVersion() {
      return laravelVersion;
   }
   public void setLaravelVersion(String laravelVersion) {
      this.laravelVersion = laravelVersion;
   }
   public String getModelsHome() {
      return modelsHome;
   }
   public void setModelsHome(String modelsHome) {
      this.modelsHome = modelsHome;
   }
   public String getViewsHome() {
      return viewsHome;
   }
   public void setViewsHome(String viewsHome) {
      this.viewsHome = viewsHome;
   }
   public String getControllersHome() {
      return controllersHome;
   }
   public void setControllersHome(String controllersHome) {
      this.controllersHome = controllersHome;
   }
   public String getWelcomeView() {
	  return welcomeView;
   }
   public void setWelcomeView(String welcomeView) {
	  this.welcomeView = welcomeView;
   }
   public String getModelRequestsHome() {
      return modelRequestsHome;
   }
   public void setModelRequestsHome(String modelRequestsHome) {
      this.modelRequestsHome = modelRequestsHome;
   }
   public String getStylesheetsHome() {
	      return this.stylesheetsPath;
   }
   public void setStyleSheetsHome(String stylesheetPath) {
	      this.stylesheetsPath = stylesheetPath;
   }
   
}
