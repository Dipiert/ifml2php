package acceleo.ifml2OurMM;

public class LaravelInputPaths extends LaravelPaths{
	String configApp = "/var/www/html/learning/config/app.php"; //ESto hay que hacerlo depender del BASE_DIR de Laravel
		
   public String getConfigApp() {
      return configApp;
   }

   public void setConfigApp(String configApp) {
      this.configApp = configApp;
   }
	
	
	
}
