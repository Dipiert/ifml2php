package edu.ifml2php.psm.lycmm.gen.laravel.services;

import org.apache.commons.lang3.SystemUtils;

public class LaravelPaths {
   String baseDir = SystemUtils.IS_OS_LINUX ? 
		   					"/var/www/html/" : 
		   					"C:/xampp/htdocs/";
   
   String laravelVersion = "laravel/";

   public String getBaseDir() {
      return baseDir;
   }

   public void setBaseDir(String baseDir) {
      this.baseDir = baseDir;
   }

   public String getLaravelVersion() {
	  return laravelVersion;
	}

	public void setLaravelVersion(String laravelVersion) {
	  this.laravelVersion = laravelVersion;
	}   
}
