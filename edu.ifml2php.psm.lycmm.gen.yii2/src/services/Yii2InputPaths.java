package services;

public class Yii2InputPaths extends Yii2Paths{
	String configAppPath = "/yii2.0.12/config/web.php";
   
	public String getConfigAppPath() {
      return configAppPath;
   }

   public void setConfigAppPath(String configApp) {
      this.configAppPath = configApp;
   }
	
}
