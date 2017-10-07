package services;

public class Yii2OutputPaths extends Yii2Paths{
   String modelsHome = super.getYii2Version()  + "models/";
   String viewsHome =  super.getYii2Version() + "views/";
   String controllersHome = super.getYii2Version()  + "controllers/";
   String welcomeView = super.getYii2Version()  + "views/layouts/main.php";
   String stylesheetsPath = super.getYii2Version() + "web/css/";
   
   public String getYii2Version() {
      return yii2Version ;
   }
   public void setYii2Version(String yii2Version ) {
      this.yii2Version  = yii2Version ;
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
   public String getStylesheetsHome() {
	  return this.stylesheetsPath;
   }
   public void setStyleSheetsHome(String stylesheetPath) {
	  this.stylesheetsPath = stylesheetPath;
   }
   
   
   
}
