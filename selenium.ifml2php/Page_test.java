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

public class Page_test {
	
	private static FirefoxDriver driver;
	private static String baseDirController;
	private static String[] pagesNames, pagesWithImages;
	private static Map<String, String[]> anchorsLinks, inputTextsPage;
    private static Map<String, String> pagesWithForms;
    private static Map<String, String> pagesTitles;
    private static String addFormMovie, updateFormMovie, deleteFormMovie, mainMenuMovie;
    private static String _addFormMovie, _updateFormMovie, _deleteFormMovie, _mainMenuMovie;
    
	@BeforeClass
	private static void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		driver = new FirefoxDriver();
		makeURL();
		getStrings();
		getPagesNames();		
		getAnchorsLinks();
		getPagesWithImages();
		getPagesWithForms();
		getPagesTitles();
	}
	
	@AfterClass
	private static void tearDown() {
		driver.close();
	}
	
	private static void getStrings() {
		addFormMovie = "Add Form Movie";		
	    updateFormMovie = "Update Form Movie";	    
	    deleteFormMovie = "Delete Form Movie";	    
	    mainMenuMovie = "Main Menu Movie";	    
	    _addFormMovie = addFormMovie.replaceAll("\\s+", "");
	    _updateFormMovie = updateFormMovie.replaceAll("\\s+", "");
	    _deleteFormMovie = deleteFormMovie.replaceAll("\\s+", "");
	    _mainMenuMovie = mainMenuMovie.replaceAll("\\s+", "");
	}
	
	private static void getPagesTitles() {
		pagesTitles = new HashMap<String, String>();
		pagesTitles.put(_addFormMovie, _addFormMovie);
		pagesTitles.put(_updateFormMovie, _updateFormMovie);
		pagesTitles.put(_deleteFormMovie, _deleteFormMovie);
	}

	private static void getPagesNames() {
		pagesNames = new String[]{_mainMenuMovie, _addFormMovie, _updateFormMovie, _deleteFormMovie};
	}
	
	private static void getAnchorsLinks() {
		anchorsLinks = new HashMap<String, String[]>();
		String[] anchorsMainMenu = {addFormMovie, updateFormMovie, deleteFormMovie};
		String[] anchorsAddForm = {mainMenuMovie , updateFormMovie, deleteFormMovie};
		String[] anchorsUpdateForm = {mainMenuMovie , addFormMovie, deleteFormMovie};
		String[] anchorsDeleteForm = {mainMenuMovie , addFormMovie, updateFormMovie};		
		String[] titles = {_mainMenuMovie,_addFormMovie,_updateFormMovie,_deleteFormMovie};
		String[][] anchors = {anchorsMainMenu, anchorsAddForm, anchorsUpdateForm, anchorsDeleteForm};
		for(int i = 0; i < titles.length; i++)		
			anchorsLinks.put(titles[i], anchors[i]);
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
		String server = "localhost";
		String project = "laravel5.4.15";
		String controller = "movie";
		baseDirController = "http://" + server + "/" + project + "/public/" + controller + "/";
	}
	
	@Test(enabled = true)	
	public static void pagesShouldHaveCorrectTitle() {
		String page, title;
		WebElement frm;
		for (Map.Entry<String, String> entry : pagesTitles.entrySet()) {
			page = entry.getKey();
			title = entry.getValue();
			driver.get(baseDirController + page);
			frm =  driver.findElement(By.xpath("//form[contains(@name, " + title + ")]"));
			AssertJUnit.assertNotNull(frm);	
		}
	}
	
	@Test(enabled = true)
	public static void pagesShouldHaveAnchors() {
		String title;
		String[] anchorLinks;
		WebElement anchor;
		for (Map.Entry<String, String[]> entry : anchorsLinks.entrySet()) {
			title = entry.getKey();
			driver.get(baseDirController + title);
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
			driver.get(baseDirController + pageWithImage);		
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
			driver.get(baseDirController + title);
			frm =  driver.findElement(By.xpath("//form[contains(@name, " + formName + ")]"));
			AssertJUnit.assertNotNull(frm);	
		}
	}	
}

