package acceleo.ifml2OurMM;

public class LaravelOutputPaths extends LaravelPaths{
   String laravelVersion = "laravel5.4.15/";
   String modelsHome = laravelVersion + "app/";
   String viewsHome =  laravelVersion + "resources/";
   String controllersHome = laravelVersion + "/app/Http/Controllers/";
   
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
   
   
   
}
