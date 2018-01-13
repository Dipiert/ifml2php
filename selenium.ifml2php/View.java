package selenium.ifml2php;

public class View {
	String addFormMovieSplit, updateFormMovieSplit, deleteFormMovieSplit, mainMenuMovieSplit;
	Anchor anchor;
	
	public View() {
		anchor = new Anchor();
        addFormMovieSplit =  anchor.getAddFormMovie().replaceAll("\\s","");
        updateFormMovieSplit = anchor.getUpdateFormMovie().replaceAll("\\s", "");
        deleteFormMovieSplit = anchor.getDeleteFormMovie().replaceAll("\\s", "");
        mainMenuMovieSplit = anchor.getMainMenuMovie().replaceAll("\\s", "");
	}

	public String getAddFormMovieSplit() {
		return addFormMovieSplit;
	}

	public String getUpdateFormMovieSplit() {
		return updateFormMovieSplit;
	}

	public String getDeleteFormMovieSplit() {
		return deleteFormMovieSplit;
	}

	public String getMainMenuMovieSplit() {
		return mainMenuMovieSplit;
	}

}
