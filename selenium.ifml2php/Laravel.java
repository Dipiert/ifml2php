package selenium.ifml2php;

import java.util.HashMap;
import java.util.Map;

public class Laravel {
	private static Map<String, String[]> labelsPage, inputTextsPage, radiosPage;
	private static String addFormMovie, updateFormMovie, deleteFormMovie;
	private static String baseDirController;
	private static Form form;
	private static Label label;
	
	public Laravel(String server, String controller) {
		form = new Form();
		label = new Label();
		makeBaseDirController(server,controller);
		getStrings();
		makeLabelsPage();
		makeRadiosPage();
		makeInputTexts();
	}
	
	private void getStrings() {
		addFormMovie = "AddFormMovie";
		updateFormMovie = "UpdateFormMovie";
		deleteFormMovie = "DeleteFormMovie";
	}
	
	private void makeBaseDirController(String server, String controller) {
		String project = "laravel5.4.15";
		String appHome = "public";
		baseDirController = "http://" + server + "/"
									  + project + "/" 
									  + appHome + "/"
									  + controller + "/";
	}
	
	public String getBaseDirController() {
		return baseDirController;
	}
	
	private void makeLabelsPage() {
		labelsPage = new HashMap<String, String[]>();
		labelsPage.put(addFormMovie, form.getLabelsAddForm());
		labelsPage.put(updateFormMovie, form.getLabelsUpdateForm());
		labelsPage.put(deleteFormMovie, form.getLabelsDeleteForm());
	}

	public Map<String, String[]> getLabelsPage() {
		return labelsPage;
	}
	
	private void makeRadiosPage() {
		radiosPage = new HashMap<String, String[]>();
		String[][] radios = {form.getRadiosAddForm(), form.getRadiosUpdateForm()};
		String[] viewNames = {addFormMovie, updateFormMovie};
		for(int i = 0; i < viewNames.length; i++) {
			radiosPage.put(viewNames[i], radios[i]);
		}
	}
	
	public Map<String, String[]> getRadiosPage() {
		return radiosPage;
	}
	
	private void makeInputTexts() {
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
	
	public Map<String, String[]> getInputTexts() {
		return inputTextsPage;
	}
}
