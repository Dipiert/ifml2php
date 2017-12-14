package selenium.ifml2php;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Tests {
	private static FirefoxDriver driver;
	private static String URL;
	private static String[] pagesTitles, pagesWithImages;
	private static Map<String, String[]> anchorsLinks;
    private static Map<String, String> pagesWithForms;
    private static String addFormMovie, updateFormMovie, deleteFormMovie, mainMenuMovie;
    private static String _addFormMovie, _updateFormMovie, _deleteFormMovie, _mainMenuMovie;
    
	@BeforeClass
	private static void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		driver = new FirefoxDriver();
		makeURL();
		getStrings();
		getPagesTitles();		
		getAnchorsLinks();
		getPagesWithImages();
		getPagesWithForms();		
	}
	
	@AfterClass
	private static void tearDown() {
		driver.close();
	}
	
	private static void getStrings() {
		addFormMovie = "Add Form Movie";
		_addFormMovie = addFormMovie.replaceAll("\\s+", "");
	    updateFormMovie = "Update Form Movie";
	    _updateFormMovie = updateFormMovie.replaceAll("\\s+", "");
	    deleteFormMovie = "Delete Form Movie";
	    _deleteFormMovie = deleteFormMovie.replaceAll("\\s+", "");
	    mainMenuMovie = "Main Menu Movie";
	    _mainMenuMovie = mainMenuMovie.replaceAll("\\s+", "");
	}

	private static void getPagesTitles() {
		pagesTitles = new String[]{_mainMenuMovie, _addFormMovie, _updateFormMovie, _deleteFormMovie};
	}
	
	private static void getAnchorsLinks() {
		anchorsLinks = new HashMap<String, String[]>();
		String[] anchorsMainMenu = {addFormMovie, updateFormMovie, deleteFormMovie};
		String[] anchorsAddForm = {mainMenuMovie , updateFormMovie, deleteFormMovie};
		String[] anchorsUpdateForm = {mainMenuMovie , addFormMovie, deleteFormMovie};
		String[] anchorsDeleteForm = {mainMenuMovie , addFormMovie, updateFormMovie};		
		String[] titles = {_mainMenuMovie,_addFormMovie,_updateFormMovie,_deleteFormMovie};
		String[][] anchors = {anchorsMainMenu, anchorsAddForm, anchorsUpdateForm, anchorsDeleteForm};
		for(int i = 0; i < titles.length; i++) {		
			anchorsLinks.put(titles[i], anchors[i]);
		}
	}
	
	private static void getPagesWithForms() {
		pagesWithForms = new HashMap<String, String>();
		pagesWithForms.put(_addFormMovie, _addFormMovie);
		pagesWithForms.put(_updateFormMovie, _updateFormMovie);
		pagesWithForms.put(_deleteFormMovie, _deleteFormMovie);
	}
	
	private static void getPagesWithImages() {
		pagesWithImages = new String[]{_mainMenuMovie};
	}
	
	private static void makeURL() {
		String server= "localhost";
		String project = "laravel5.4.15";
		String controller = "movie";
		URL = "http://" + server + "/" + project + "/public/" + controller + "/";
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
		String title;
		String[] anchorLinks;
		WebElement anchor;
		for (Map.Entry<String, String[]> entry : anchorsLinks.entrySet()) {
			title = entry.getKey();
			driver.get(URL + title);
			anchorLinks = entry.getValue();			
			for(String anchorLink : anchorLinks) {
				anchor = driver.findElementByLinkText(anchorLink);
				AssertJUnit.assertNotNull(anchor);
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
	
	@Test(enabled = true)
	public static void pagesShouldHaveForms() {
		String title, formName;
		WebElement frm;
		for (Map.Entry<String, String> entry : pagesWithForms.entrySet()) {
			title = entry.getKey();
			formName = entry.getValue();
			driver.get(URL + title);
			frm =  driver.findElement(By.xpath("//form[contains(@name, " + formName + ")]"));
			AssertJUnit.assertNotNull(frm);	
		}
	}
}

