package selenium.ifml2php;

import java.util.HashMap;
import java.util.Map;

public class Laravel extends Framework {
	
	public Laravel(String server, String controller) {
		super(server, controller);
	}
	
	@Override
	protected void makeViewsNames() {
		addFormMovie = "AddFormMovie";
		updateFormMovie = "UpdateFormMovie";
		deleteFormMovie = "DeleteFormMovie";
		mainMenuMovie = "MainMenuMovie";
	}
	
	@Override
	protected void makeBaseDirController(String server, String controller) {
		String project = "laravel5.4.15";
		String appHome = "public";
		baseDirController = "http://" + server + "/"
									  + project + "/" 
									  + appHome + "/"
									  + controller + "/";
	}
	
}
