package selenium.ifml2php;

public class Yii extends Framework{

	public Yii(String server, String controller) {		
		super(server, controller);
	}

	@Override
	protected void makeViewsNames() {
		addFormMovie = "view-add-form-movie";
		updateFormMovie = "view-update-form-movie";
		deleteFormMovie = "view-delete-form-movie";
		mainMenuMovie = "view-main-menu-movie";
	}
	
	@Override
	protected void makeBaseDirController(String server, String controller) {
		String project = "yii2.0.12";
		String appHome = "web/index.php?r=";
		baseDirController = "http://" + server + "/"
									  + project + "/" 
									  + appHome
									  + controller + "/";
	}
		
}
