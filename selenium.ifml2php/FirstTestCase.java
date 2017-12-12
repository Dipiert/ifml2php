package selenium.ifml2php;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCase {

	public static void main(String[] args) {	
		shouldHaveSameTitle();		
	}
	
	
	static private String makeURL() {
		String server= "localhost";
		String project = "laravel5.4.15";
		String controller = "movie";
		return "http://" + server + "/" + project + "/public/" + controller + "/";
	}
	
	@Test
	static public void shouldHaveSameTitle() {
		String URL = makeURL();	
		String[] titles = {"MainMenuMovie", "AddFormMovie", "UpdateFormMovie", "DeleteFormMovie"};
		for(String title : titles){
			testATitle(URL, title);
		}			
	}
	
	static private void testATitle(String URL, String title) {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(URL + title);
		Assert.assertEquals(title, driver.getTitle());
	}
	
}

