package services;

public class Yii2InputPaths extends Yii2Paths{
	String configAppPath = "/yii2.0.12/config/web.php"; //ESto hay que hacerlo depender del BASE_DIR de Laravel
	//String routesPath = "/yii2.0.12/routes/web.php";
   
	public String getConfigAppPath() {
      return configAppPath;
   }

   public void setConfigAppPath(String configApp) {
      this.configAppPath = configApp;
   }

   /*public String getRoutesPath() {	   	
	    return routesPath;
   }*/

   /*public void setRoutesPath(String routes) {
	this.routesPath = routes;
   }*/
	
}
