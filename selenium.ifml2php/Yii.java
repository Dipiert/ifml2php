package selenium.ifml2php;

import java.util.HashMap;
import java.util.Map;

public class Yii {

	private static Map<String, String[]> labelsPage, inputTextsPage, radiosPage;
	private static String view_add_form_movie, view_update_form_movie, view_delete_form_movie;
	private static String baseDirController;
	private static Form form;
	private static Label label;
	
	public Yii(String server, String controller) {		
		form = new Form();
		label = new Label();
		makeBaseDirController(server, controller);		
		getStrings();
		makeLabelsPage();	
		makeInputTexts();
		makeRadiosPage();
	}
	
	private void makeLabelsPage() {
		labelsPage = new HashMap<String, String[]>();
		labelsPage.put(view_add_form_movie, form.getLabelsAddForm());
		labelsPage.put(view_update_form_movie, form.getLabelsUpdateForm());
		labelsPage.put(view_delete_form_movie, form.getLabelsDeleteForm());		
	}
	
	private void makeRadiosPage() {
		radiosPage = new HashMap<String, String[]>();
		String[][] radios = {form.getRadiosAddForm(), form.getRadiosUpdateForm()};
		String[] viewNames = {view_add_form_movie, view_update_form_movie};
		for(int i = 0; i < viewNames.length; i++) {
			radiosPage.put(viewNames[i], radios[i]);
		}
	}
	
	private void makeInputTexts() {
		inputTextsPage = new HashMap<String, String[]>();
		String year = label.getYear();
		String title = label.getTitle();
		String[] inputTextsAddForm = {year, title};		
		String[] inputTextsUpdateForm = {year, title};
		String[] inputTextsDeleteForm = {title};		
		String[][] inputs = {inputTextsAddForm, inputTextsUpdateForm, inputTextsDeleteForm};
		String[] viewNames = {view_add_form_movie, view_update_form_movie, view_delete_form_movie};
		for(int i = 0; i < viewNames.length; i++) {		
			inputTextsPage.put(viewNames[i], inputs[i]);
		}
	}
	
	public Map<String, String[]> getInputTexts() {
		return inputTextsPage;
	}
	
	public Map<String, String[]> getLabelsPage() {
		return labelsPage;
	}
	
	public Map<String, String[]> getRadiosPage() {
		return radiosPage;
	}
	
	
	public void getStrings() {
		view_add_form_movie = "view-add-form-movie";
		view_update_form_movie = "view-update-form-movie";
		view_delete_form_movie = "view-delete-form-movie";
	}
	
	public static void makeBaseDirController(String server, String controller) {
		String project = "yii2.0.12";
		String appHome = "web/index.php?r=";
		baseDirController = "http://" + server + "/"
									  + project + "/" 
									  + appHome
									  + controller + "/";
	}
	
	public String getBaseDirController() {
		return baseDirController;
	}
}
