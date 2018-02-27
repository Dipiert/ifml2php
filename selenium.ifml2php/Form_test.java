package selenium.ifml2php;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Form_test {
	
	private static String lvlBaseDirController, yiiBaseDirController;	
	private static Yii yii;
	private static Laravel laravel;
	private static List<WebDriver> drivers;
	
	public Form_test() {
		String server = "localhost";
		String controller = "movie";
		drivers = new ArrayList<WebDriver>();
		yii = new Yii(server, controller);
		yiiBaseDirController = yii.getBaseDirController();
		laravel = new Laravel(server, controller);
		lvlBaseDirController = laravel.getBaseDirController();
	}
	
	@BeforeClass
	private void setUp() {		
		registerDrivers();
		loadDrivers();
	}
	
	private void loadFirefoxDriver() {
		drivers.add(new FirefoxDriver());
	}
	
	private void loadChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		drivers.add(new ChromeDriver(chromeOptions));
	}
	private void loadDrivers() {
		loadFirefoxDriver();
		loadChromeDriver();		
	}
	
	private void registerDrivers() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	}
	
	@AfterClass
	private static void tearDown() {
		for (WebDriver driver : drivers)
			driver.close();
	}
	
	private static void formsShouldHaveTextInputs(String baseDirController, Map<String, String[]> inputTexts){
		String name, query;
		String[] inputsTextsName;
		WebElement inputText;	
		for (WebDriver driver : drivers){
			for (Map.Entry<String, String[]> entry : inputTexts.entrySet()) {
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
	}
	
	private static void formsShouldHaveLabels(String baseDirController, Map<String, String[]> labelsPage) {
		String name, query;
		String[] labelsName;
		WebElement label;
		for (WebDriver driver : drivers){
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
	}

	private static void formsShouldHaveRadioButtons(String baseDirController, Map<String, String[]> radiosPage) {
		String name;
		String[] radioNames;
		WebElement radio;
		for(WebDriver driver : drivers) {
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

	@Test(enabled = true)
	public static void lvlFormsShouldHaveTextInputs() {
		formsShouldHaveTextInputs(lvlBaseDirController, laravel.getInputTextsPage());
	}
	
	@Test(enabled = true)
	public static void yiiFormsShouldHaveTextInputs() {
		formsShouldHaveTextInputs(yiiBaseDirController, yii.getInputTextsPage());
	}
	
	@Test(enabled = true)
	public static void yiiFormsShouldHaveLabels() {
		formsShouldHaveLabels(yiiBaseDirController, yii.getLabelsPage());
	}
	
	@Test(enabled = true)
	public static void lvlFormsShouldHaveLabels() {
		formsShouldHaveLabels(lvlBaseDirController, laravel.getLabelsPage());
	}
		
	@Test(enabled = true)
	public static void yiiFormsShouldHaveRadioButtons() {
		formsShouldHaveRadioButtons(yii.getBaseDirController(), yii.getRadiosPage());
	}
	
	@Test(enabled = true)
	public static void lvlFormsShouldHaveRadioButtons() {
		formsShouldHaveRadioButtons(laravel.getBaseDirController(), laravel.getRadiosPage());
	}
}
