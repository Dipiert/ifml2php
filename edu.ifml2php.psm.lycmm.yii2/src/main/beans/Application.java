package main.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import services.FileReader;
import services.Yii2InputPaths;

public class Application {
	//Hace falta una clase de Paths? Cada path pertenece a un "concern" y quiza pueda asignarse en la clase correspondiente.
	//Lo vamos a hacer así porque en caso de que sea ncesario cambiar las rutas por un cambio de versión de Laravel podemos decir que usamos el principio de responsasbilidad simple
	
   //public String AppType = "web"; lo vamos a descartar por ahora porque no queda comprendido dentro del caso de estudio

   public String locale = "es-ES";
   private FileReader fr = new FileReader();
   private Yii2InputPaths lip = new Yii2InputPaths();
   private String defaultAppName;
   
   public String getDefaultAppName(String framework) {
	   switch(framework) {
	      case "Laravel": 
	    	  return "App";
	      case "Yii2":
	    	  return "My Application";
	      case "CI":
	    	  return "";
	      default:
	    	  return "";
	   }
   }
   
	public String getAppConfigLines(String keyword) {
      return fr.getFile(lip.getConfigAppPath(), keyword);
    }
	
	public boolean isSet(String attribute) {
		Matcher m = Pattern.compile("'" + attribute + "' =>" ).matcher(getAppConfig());		
		return m.matches();
	}
	
	public String getAppConfig() {
		return fr.getFile(lip.getBaseDir() + lip.getConfigAppPath());
	}
	
	/*public String getRoutes(){
		return fr.getFile(lip.getBaseDir() + lip.getRoutesPath());
	}*/
		 
	public String getLocale() {
		return locale;
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}	
}
