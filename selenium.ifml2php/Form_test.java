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
	private static Map<String, String[]> inputTextsPage;
	private static String year, title;
	private static String baseDirController;
	
	public Form_test() {
		getStrings();
		makeURL();
		getInputTextsPage();
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

	private static void getInputTextsPage() {
		inputTextsPage = new HashMap<String, String[]>();
		String[] inputTextsAddForm = {year, title};
		String[] inputTextsUpdateForm = {year, title};
		String[] inputTextsDeleteForm = {title};
		String[][] inputs = {inputTextsAddForm, inputTextsUpdateForm, inputTextsDeleteForm};
		String[] titles = {"AddFormMovie", "UpdateFormMovie", "DeleteFormMovie"};
		for(int i = 0; i < titles.length; i++) {		
			inputTextsPage.put(titles[i], inputs[i]);
		}
	}
	
	private static void getStrings() {
		year = "year";
		title = "title";
	}
	
	@Test(enabled = true)
	public static void formsShouldHaveInputs(){
		String[] inputsTextsName;
		WebElement inputText;		
		for (Map.Entry<String, String[]> entry : inputTextsPage.entrySet()) {
			title = entry.getKey();
			driver.get(baseDirController + title);
			inputsTextsName = entry.getValue();
			for(String inputTextName : inputsTextsName) {
				inputText = driver.findElement(By.xpath("//input[contains(@name," + inputTextName + " )]"));				
				
				AssertJUnit.assertNotNull(inputText);
			}
		}
		
	}
	
	public static void formsShouldHaveLabels() {
		
	}
	
	public static void formsShouldHaveRadiosButtons() {
		
	}
	
	public static void formsShouldHaveSubmits() {
		
	}
}
