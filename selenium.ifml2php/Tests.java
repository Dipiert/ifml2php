package selenium.ifml2php;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class FirstTestCase {
	static FirefoxDriver driver;

	@BeforeClass
	private static void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@AfterClass
	private static void tearDown() {
		driver.close();
	}
	
	@Test(enabled = true)
	public static void pagesShouldHaveSameTitle() {
		String URL = makeURL();	
		String[] titles = {"MainMenuMovie", "AddFormMovie", "UpdateFormMovie", "DeleteFormMovie"};
		for(String title : titles){
			testATitle(URL, title);
		}			
	}
	
	private static String makeURL() {
		String server= "localhost";
		String project = "laravel5.4.15";
		String controller = "movie";
		return "http://" + server + "/" + project + "/public/" + controller + "/";
	}
		
	private static void testATitle(String URL, String title) {
		driver.get(URL + title);
		AssertJUnit.assertEquals(title, driver.getTitle());
	}
	
	@Test(enabled = true)
	public static void pagesShouldHaveAllAnchors() {
		String URL = makeURL();
		String[] titles = {"Main Menu Movie", "Add Form Movie", "Update Form Movie", "Delete Form Movie"};
		for(String title : titles){
			testAPageAnchors(URL, titles);
		}	
	}
	
	private static void testAPageAnchors(String URL, String[] titles) {
		for(String title : titles){
			String _title = title.replaceAll("\\s+","");
			driver.get(URL + _title);
			if (! _title.equals(driver.getTitle())) {
				WebElement el = driver.findElementByLinkText(title);
				AssertJUnit.assertNotNull(el);
			}
		}		
	}
	
}

