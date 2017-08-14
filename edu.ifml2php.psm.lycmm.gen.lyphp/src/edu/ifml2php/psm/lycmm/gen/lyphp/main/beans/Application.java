package edu.ifml2php.psm.lycmm.gen.lyphp.main.beans;

import edu.ifml2php.psm.lycmm.gen.lyphp.services.FileReader;
import edu.ifml2php.psm.lycmm.gen.lyphp.services.LaravelInputPaths;

public class Application {
	//Hace falta una clase de Paths? Cada path pertenece a un "concern" y quiza pueda asignarse en la clase correspondiente.
	//Lo vamos a hacer así porque en caso de que sea ncesario cambiar las rutas por un cambio de versión de Laravel podemos decir que usamos el principio de responsasbilidad simple
	
   //public String AppType = "web"; lo vamos a descartar por ahora porque no queda comprendido dentro del caso de estudio

   public String locale = "es-ES";
   private FileReader fr = new FileReader();
   private LaravelInputPaths lip = new LaravelInputPaths();

	public String getAppConfigLines(String keyword) {
      return fr.getFile(lip.getConfigAppPath(), keyword);
    }
	
	public String getAppConfig() {
		return fr.getFile(lip.getBaseDir() + lip.getConfigAppPath());
	}
	
	public String getRoutes(){
		return fr.getFile(lip.getBaseDir() + lip.getRoutesPath());
	}
		 
	public String getLocale() {
		return locale;
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
