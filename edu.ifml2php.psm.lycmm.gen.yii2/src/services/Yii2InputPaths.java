package services;

public class Yii2InputPaths extends Yii2Paths{
	String configAppPath = super.getYii2Version() + "config/web.php";
   
	public String getConfigAppPath() {
      return configAppPath;
   }

   public void setConfigAppPath(String configApp) {
      this.configAppPath = configApp;
   }
	
   public String getFQN() {
	   return this.getClass().getCanonicalName();
   }
}
