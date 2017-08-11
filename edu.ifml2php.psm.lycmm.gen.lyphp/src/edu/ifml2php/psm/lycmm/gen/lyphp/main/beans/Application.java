package edu.ifml2php.psm.lycmm.gen.lyphp.main.beans;

import edu.ifml2php.psm.lycmm.gen.lyphp.services.FileReader;
import edu.ifml2php.psm.lycmm.gen.lyphp.services.LaravelInputPaths;

public class Application {
	//public String routes = "localhost/site1"; podríamos crearlos a la hora de crear los controladores.
   //public String AppType = "web"; lo vamos a descartar por ahora porque no queda comprendido dentro del caso de estudio

   public String locale = "es-ES";

   public static void main(String[] args) {
      Application app = new Application();
      app.getAppConfig();
   }
      
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getAppConfig() {
		return new FileReader().getFile(new LaravelInputPaths().getConfigApp());
	}
	
	public String getAppConfigLines(String keyword) {
      return new FileReader().getFile(new LaravelInputPaths().getConfigApp(), keyword);
   }
}
