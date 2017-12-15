package selenium.ifml2php;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Form_test {
	
	private static FirefoxDriver driver;
	private static Map<String, String[]> inputTextsPage, labelsPage, radiosPage;
	private static String year, title, _addFormMovie, _updateFormMovie, _deleteFormMovie, G;
	private static String PG, PG13, R, isSaga, audience;
	private static String baseDirController;
	
	public Form_test() {
		getStrings();
		makeURL();
		getInputTextsPage();
		getLabelsPage();
		getRadiosPage();
		getSubmitsForm();
	}
	
	@BeforeClass
	private void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	private static void tearDown() {
		driver.close();
	}
	
	private static void makeURL() {
		String server = "localhost";
		String project = "laravel5.4.15";
		String controller = "movie";
		baseDirController = "http://" + server + "/" + project + "/public/" + controller + "/";
	}

	private static void getSubmitsForm() {

	}
	
	private static void getRadiosPage() {
		radiosPage = new HashMap<String, String[]>();
		String[] radiosAddForm = {audience};
		String[] radiosUpdateForm = {audience};
		String[][] radios = {radiosAddForm, radiosUpdateForm};
		String[] names = {_addFormMovie, _updateFormMovie};
		for(int i = 0; i < names.length; i++) {
			radiosPage.put(names[i], radios[i]);
		}
	}
	
	private static void getInputTextsPage() {
		inputTextsPage = new HashMap<String, String[]>();
		String[] inputTextsAddForm = {year, title};
		String[] inputTextsUpdateForm = {year, title};
		String[] inputTextsDeleteForm = {title};
		String[][] inputs = {inputTextsAddForm, inputTextsUpdateForm, inputTextsDeleteForm};
		String[] names = {_addFormMovie, _updateFormMovie, _deleteFormMovie};
		for(int i = 0; i < names.length; i++) {		
			inputTextsPage.put(names[i], inputs[i]);
		}
	}
	
	private static void getLabelsPage() {
		labelsPage = new HashMap<String, String[]>();
		String[] labelsAddForm = {year, title, G, PG, PG13, R, isSaga};
		String[] labelsUpdateForm = {year, title, G, PG, PG13, R, isSaga};
		String[] labelsDeleteForm = {title};
		labelsPage.put(_addFormMovie, labelsAddForm);
		labelsPage.put(_updateFormMovie, labelsUpdateForm);
		labelsPage.put(_deleteFormMovie, labelsDeleteForm);
	}
	private static void getStrings() {
		audience = "audience";
		year = "year";
		title = "title";
		G = "G";
		PG = "PG";
		PG13 = "PG13";
		R = "R";
		isSaga = "IsSaga";
		_addFormMovie = "AddFormMovie";
		_updateFormMovie = "UpdateFormMovie";
		_deleteFormMovie = "DeleteFormMovie";		
	}
	
	@Test(enabled = true)
	public static void formsShouldHaveInputs(){
		String name, query;
		String[] inputsTextsName;
		WebElement inputText;	
		for (Map.Entry<String, String[]> entry : inputTextsPage.entrySet()) {
			name = entry.getKey();
			driver.get(baseDirController + name);
			inputsTextsName = entry.getValue();
			for(String inputTextName : inputsTextsName) {
				query = "//input[contains(@name," + inputTextName + ")]";
				inputText = driver.findElement(By.xpath(query));				
				AssertJUnit.assertNotNull(inputText);
				AssertJUnit.assertNotNull(inputText.getAttribute("type").equals("text"));				
			}
		}		
	}
	
	@Test(enabled = true)
	public static void formsShouldHaveLabels() {
		String name, query;
		String[] labelsName;
		WebElement label;
		for (Map.Entry<String, String[]> entry : labelsPage.entrySet()) {
			name = entry.getKey();
			driver.get(baseDirController + name);
			labelsName = entry.getValue();
			for (String labelName : labelsName) {
				query = "//label[contains(@for," + labelName + " )]";
				label = driver.findElement(By.xpath(query));
				AssertJUnit.assertNotNull(label);
			}
		}
	}
	
	@Test(enabled = true)
	public static void formsShouldHaveRadioButtons() {
		String name;
		String[] radioNames;
		WebElement radio;
		for (Map.Entry<String, String[]> entry : radiosPage.entrySet()) {
			name = entry.getKey();
			driver.get(baseDirController + name);
			radioNames = entry.getValue();
			for(String radioName : radioNames) {
				radio = driver.findElement(By.xpath("//input[contains(@name," + radioName + ")]"));
				AssertJUnit.assertNotNull(radio);
				AssertJUnit.assertNotNull(radio.getAttribute("type").equals("radio"));
			}
		}
	}
}
