package edu.ifml2php.psm.lycmm.gen.laravel.main.beans;

public class PackageFramework {
	String name = "Laravel";
	String version = "5.4.15";
	//Es necesaria la relación c/ Application?
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getFQN() {
		return this.getClass().getCanonicalName();
	}
}

