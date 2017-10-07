package edu.ifml2php.psm.lycmm.gen.laravel.services;

public class LaravelOutputPaths extends LaravelPaths{
   String modelsHome = super.getLaravelVersion() + "app/";
   String viewsHome =  super.getLaravelVersion() + "resources/";
   String controllersHome = super.getLaravelVersion() + "/app/Http/Controllers/";
   String modelRequestsHome = super.getLaravelVersion() + "app/Http/Requests/";
   String welcomeView = super.getLaravelVersion() + "resources/views/welcome.blade.php";
   String stylesheetsPath = super.getLaravelVersion() + "public/css/";
   
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
