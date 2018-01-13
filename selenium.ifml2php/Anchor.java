package selenium.ifml2php;

public class Anchor {
	private String[] mainMenuAnchors, addFormAnchors, updateFormAnchors, deleteFormAnchors;
	private String addFormMovie, updateFormMovie, deleteFormMovie, mainMenuMovie;
	private View view;
	
	public Anchor() {
		//view = new View();
		addFormMovie = "Add Form Movie";
		updateFormMovie = "Update Form Movie";
		deleteFormMovie = "Delete Form Movie";
		mainMenuMovie = "Main Menu Movie";
		mainMenuAnchors = new String[]{addFormMovie, updateFormMovie, deleteFormMovie};
		addFormAnchors = new String[]{mainMenuMovie , updateFormMovie, deleteFormMovie};
		updateFormAnchors = new String[]{mainMenuMovie , addFormMovie, deleteFormMovie};
		deleteFormAnchors = new String[]{mainMenuMovie , addFormMovie, updateFormMovie};
	}

	public String[] getMainMenuAnchors() {
		return mainMenuAnchors;
	}

	public String[] getAddFormAnchors() {
		return addFormAnchors;
	}

	public String[] getUpdateFormAnchors() {
		return updateFormAnchors;
	}

	public String[] getDeleteFormAnchors() {
		return deleteFormAnchors;
	}

	public String getAddFormMovie() {
		return addFormMovie;
	}

	public String getUpdateFormMovie() {
		return updateFormMovie;
	}

	public String getDeleteFormMovie() {
		return deleteFormMovie;
	}

	public String getMainMenuMovie() {
		return mainMenuMovie;
	}

	public View getView() {
		return view;
	}
		
}
