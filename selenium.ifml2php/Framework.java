package selenium.ifml2php;

import java.util.HashMap;
import java.util.Map;

public abstract class Framework {
	protected Map<String, String[]> labelsPage, inputTextsPage, radiosPage, anchorsLinks;
	protected Map<String, String> pagesWithForms, pagesTitles;
	protected String addFormMovie;
	protected String updateFormMovie;
	protected String deleteFormMovie;
	protected String mainMenuMovie;
	protected String baseDirController;
	protected String[] pagesWithImages;
	protected Form form;
	protected Label label;
	protected View view;
	
	public Framework(String server, String controller) {
		form = new Form();
		label = new Label();
		view = new View();
		makeBaseDirController(server,controller);
		makeViewsNames();
		makePagesWithImages();
		makeLabelsPage();
		makeRadiosPage();
		makeInputTexts();
		makeAnchorsLink();
		makePagesWithForms();
		makePagesTitles();
	}	
	
	protected abstract void makeBaseDirController(String server, String controller);
	protected abstract void makeViewsNames();
	
	protected void makePagesWithImages() {
		pagesWithImages = new String[]{mainMenuMovie};
	}
	
	protected void makeLabelsPage() {
		labelsPage = new HashMap<String, String[]>();
		labelsPage.put(addFormMovie, form.getLabelsAddForm());
		labelsPage.put(updateFormMovie, form.getLabelsUpdateForm());
		labelsPage.put(deleteFormMovie, form.getLabelsDeleteForm());
	}
	
	protected void makeRadiosPage() {
		radiosPage = new HashMap<String, String[]>();
		String[][] radios = {form.getRadiosAddForm(), form.getRadiosUpdateForm()};
		String[] viewNames = {addFormMovie, updateFormMovie};
		for(int i = 0; i < viewNames.length; i++) {
			radiosPage.put(viewNames[i], radios[i]);
		}
	}
	
	protected void makeInputTexts() {
		inputTextsPage = new HashMap<String, String[]>();
		String year = label.getYear();
		String title = label.getTitle();
		String[] inputTextsAddForm = {year, title};		
		String[] inputTextsUpdateForm = {year, title};
		String[] inputTextsDeleteForm = {title};		
		String[][] inputs = {inputTextsAddForm, inputTextsUpdateForm, inputTextsDeleteForm};
		String[] viewNames = {addFormMovie, updateFormMovie, deleteFormMovie};
		for(int i = 0; i < viewNames.length; i++) {		
			inputTextsPage.put(viewNames[i], inputs[i]);
		}
	}
	
	protected void makeAnchorsLink() {
		anchorsLinks = new HashMap<String, String[]>();
		String[] titles = {mainMenuMovie, addFormMovie, updateFormMovie, deleteFormMovie};
		String[][] anchors = new Anchor().getAllAnchors();
		for(int i = 0; i < titles.length; i++)       
            anchorsLinks.put(titles[i], anchors[i]);
	}
	
	protected void makePagesWithForms() {
		pagesWithForms = new HashMap<String, String>();
		String addFormMovie = getAddFormMovie();
		String updateFormMovie = getUpdateFormMovie();
		String deleteFormMovie = getDeleteFormMovie();
		pagesWithForms.put(addFormMovie, addFormMovie);
        pagesWithForms.put(updateFormMovie, updateFormMovie);
        pagesWithForms.put(deleteFormMovie, deleteFormMovie);

	}
	
	protected void makePagesTitles() {
		pagesTitles = new HashMap<String, String>();
		pagesTitles.put(addFormMovie, view.getAddFormMovieSplit());
        pagesTitles.put(updateFormMovie, view.getUpdateFormMovieSplit());
        pagesTitles.put(deleteFormMovie, view.getDeleteFormMovieSplit());
	}

	public Map<String, String[]> getLabelsPage() {
		return labelsPage;
	}

	public Map<String, String[]> getInputTextsPage() {
		return inputTextsPage;
	}

	public Map<String, String[]> getRadiosPage() {
		return radiosPage;
	}

	public Map<String, String[]> getAnchorsLinks() {
		return anchorsLinks;
	}

	public Map<String, String> getPagesWithForms() {
		return pagesWithForms;
	}

	public Map<String, String> getPagesTitles() {
		return pagesTitles;
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

	public String getBaseDirController() {
		return baseDirController;
	}

	public String[] getPagesWithImages() {
		return pagesWithImages;
	}

	public Form getForm() {
		return form;
	}

	public Label getLabel() {
		return label;
	}
	
}
