package edu.ifml2php.psm.lycmm.gen.laravel.services;

public class LaravelPaths {
   String baseDir = "/var/www/html/";
   String laravelVersion = "laravel5.4.15/";

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
