package selenium.ifml2php;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Tests {
	static FirefoxDriver driver;
	static String URL;
	static String[] pagesTitles;
	static String[] anchorsLinks;
	static String[] pagesWithImages;
	
	@BeforeClass
	private static void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		driver = new FirefoxDriver();
		URL = makeURL();
		pagesTitles = new String[]{"MainMenuMovie", "AddFormMovie", "UpdateFormMovie", "DeleteFormMovie"};
		anchorsLinks = new String[]{"Main Menu Movie", "Add Form Movie", "Update Form Movie", "Delete Form Movie"};
		pagesWithImages = new String[]{"MainMenuMovie"};
	}
	
	@AfterClass
	private static void tearDown() {
		driver.close();
	}
	
	private static String makeURL() {
		String server= "localhost";
		String project = "laravel5.4.15";
		String controller = "movie";
		return "http://" + server + "/" + project + "/public/" + controller + "/";
	}
	
	@Test(enabled = true)	
	public static void pagesShouldHaveSameTitle() {
		for(String title : pagesTitles) {
			driver.get(URL + title);
			AssertJUnit.assertEquals(title, driver.getTitle());
		}		
	}
	
	@Test(enabled = true)
	public static void testAPageAnchors() {
		for(String anchorLink : anchorsLinks){
			for(String title : anchorsLinks){
				String _title = title.replaceAll("\\s+","");
				driver.get(URL + _title);
				if (! _title.equals(driver.getTitle())) {
					WebElement el = driver.findElementByLinkText(title);
					AssertJUnit.assertNotNull(el);
				}
			}	
		}				
	}
	
	@Test(enabled = true)
	public static void pagesShouldDisplayImages() {
		for(String pageWithImage : pagesWithImages) {
			driver.get(URL + pageWithImage);		
			WebElement img = driver.findElement(By.xpath("//img[contains(@alt,'logo')]"));
			AssertJUnit.assertNotNull(img);	
		}		
	}
}

