package services;

public class Yii2OutputPaths extends Yii2Paths{
   String yii2Version = "yii2.0.12/";
   String modelsHome = yii2Version  + "models/";
   String viewsHome =  yii2Version  + "views/";
   String controllersHome = yii2Version  + "controllers/";
   String welcomeView = yii2Version  + "views/layouts/main.php";
   String stylesheetsPath = yii2Version + "web/css/";
   
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
