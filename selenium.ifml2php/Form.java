package selenium.ifml2php;

public class Form {
	String year, title, G, PG, PG13, R, isSaga, audience;
	String[] labelsAddForm, labelsUpdateForm, labelsDeleteForm;
	String[] radiosAddForm, radiosUpdateForm;
	
	public Form() {
		getStrings();
		makeLabels();
		makeRadios();
	}
	
	private void makeLabels() {
		labelsAddForm = new String[]{year, title, G, PG, PG13, R, isSaga};
		labelsUpdateForm = new String[]{year, title, G, PG, PG13, R, isSaga};
		labelsDeleteForm = new String[]{title};
	}
	
	private void makeRadios() {
		radiosAddForm = new String[]{audience};
		radiosUpdateForm = new String[]{audience};
	}
	
	public void getStrings() {
		year = "year";
		title = "title";
		G = "G";
		PG = "PG";
		PG13 = "PG13";
		R = "R";
		isSaga = "IsSaga";
		audience = "audience";
	}
	
	public String[] getLabelsAddForm() {
		return labelsAddForm;
	}
	
	public String[] getLabelsUpdateForm() {
		return labelsUpdateForm;
	}
	
	public String[] getLabelsDeleteForm() {
		return labelsDeleteForm;
	}
	
	public String[] getRadiosAddForm() {
		return radiosAddForm;
	}
	
	public String[] getRadiosUpdateForm() {
		return radiosUpdateForm;
	}
	
	
}
