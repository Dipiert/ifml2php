package selenium.ifml2php;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Page_test {
	
	private static FirefoxDriver driver;
	private static String yiiBaseDirController, lvlBaseDirController;
	private static String server, controller;	
	private static String[] yiiPagesWithImages, lvlPagesWithImages;
	private static Map<String, String[]> lvlAnchorsLinks;
	private static Map<String, String[]> yiiAnchorsLinks;
	private static Map<String, String> yiiPagesWithForms;
    private static Map<String, String> lvlPagesWithForms;
    private static Map<String, String> yiiPagesTitles;
    private static Map<String, String> lvlPagesTitles;    
    private static String addFormMovie, updateFormMovie, deleteFormMovie, mainMenuMovie;
    private static String _addFormMovie, _updateFormMovie, _deleteFormMovie, _mainMenuMovie;
    private static String view_main_menu_movie, view_add_form_movie, view_update_form_movie, view_delete_form_movie;
    
    public Page_test() {    	
		getStrings();
		makeURLs();
		getAnchorsLinks();
		getPagesWithImages();
		getPagesWithForms();
		getPagesTitles();
    }
    
	@BeforeClass
	private static void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dam/Descargas/eclipse/luna/geckodriver");
		driver = new FirefoxDriver();
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
	    view_main_menu_movie = "view-main-menu-movie";
	    view_add_form_movie = "view-add-form-movie";
	    view_update_form_movie = "view-update-form-movie";
	    view_delete_form_movie = "view-delete-form-movie";
	    server = "localhost";
	    controller = "movie";
	}
	
	private static void getPagesTitles() {
		lvlPagesTitles = new HashMap<String, String>();
		yiiPagesTitles = new HashMap<String, String>();		
		lvlPagesTitles.put(_addFormMovie, _addFormMovie);
		lvlPagesTitles.put(_updateFormMovie, _updateFormMovie);
		lvlPagesTitles.put(_deleteFormMovie, _deleteFormMovie);		
		yiiPagesTitles.put(view_add_form_movie, _addFormMovie);
		yiiPagesTitles.put(view_update_form_movie, _updateFormMovie);
		yiiPagesTitles.put(view_delete_form_movie, _deleteFormMovie);
		
	}

	private static void getAnchorsLinks() {
		lvlAnchorsLinks = new HashMap<String, String[]>();
		yiiAnchorsLinks = new HashMap<String, String[]>();
		
		String[] anchorsMainMenu = {addFormMovie, updateFormMovie, deleteFormMovie};
		String[] anchorsAddForm = {mainMenuMovie , updateFormMovie, deleteFormMovie};
		String[] anchorsUpdateForm = {mainMenuMovie , addFormMovie, deleteFormMovie};
		String[] anchorsDeleteForm = {mainMenuMovie , addFormMovie, updateFormMovie};		
		String[] lvlTitles = {_mainMenuMovie,_addFormMovie,_updateFormMovie,_deleteFormMovie};
		String[] yiiTitles = {view_main_menu_movie, view_add_form_movie, view_update_form_movie, view_delete_form_movie};
		
		String[][] anchors = {anchorsMainMenu, anchorsAddForm, anchorsUpdateForm, anchorsDeleteForm};
		for(int i = 0; i < lvlTitles.length; i++)		
			lvlAnchorsLinks.put(lvlTitles[i], anchors[i]);
		for(int i = 0; i < yiiTitles.length; i++)		
			yiiAnchorsLinks.put(yiiTitles[i], anchors[i]);
	}
	
	private static void getPagesWithForms() {
		lvlPagesWithForms = new HashMap<String, String>();
		yiiPagesWithForms = new HashMap<String, String>();		
		lvlPagesWithForms.put(_addFormMovie, _addFormMovie);
		lvlPagesWithForms.put(_updateFormMovie, _updateFormMovie);
		lvlPagesWithForms.put(_deleteFormMovie, _deleteFormMovie);
		yiiPagesWithForms.put(view_add_form_movie, _addFormMovie);
		yiiPagesWithForms.put(view_update_form_movie, _updateFormMovie);
		yiiPagesWithForms.put(view_delete_form_movie, _deleteFormMovie);
	}
	
	private static void getPagesWithImages() {
		lvlPagesWithImages = new String[]{_mainMenuMovie};
		yiiPagesWithImages = new String[]{view_main_menu_movie};
	}
	
	private static void makeURLs() {
		makeYii2URL();
		makeLaravelURL();
	}
	
	private static void makeYii2URL() {
		String project = "yii2.0.12";
		String appHome = "web/index.php?r=";
		yiiBaseDirController = "http://" + server + "/"
									  + project + "/" 
									  + appHome
									  + controller + "/";
	}
	
	private static void makeLaravelURL() {
		String project = "laravel5.4.15";
		String appHome = "public";
		lvlBaseDirController = "http://" + server + "/"
									  + project + "/" 
									  + appHome + "/"
									  + controller + "/";	
	}

	private static void pagesShouldHaveCorrectTitle(String baseDirController, Map<String, String> pagesTitles) {
		String page, title;
		WebElement frm;
		for (Map.Entry<String, String> entry : pagesTitles.entrySet()) {
			page = entry.getKey();
			title = entry.getValue();
			driver.get(baseDirController + page);
			Assert.assertEquals(driver.getTitle(),title);
		}
	}	

	private static void pagesShouldHaveFormsWithSubmit(String baseDirController, Map<String, String> pagesWithForms) {
		String title, formName, query;
		List<WebElement> allFormChildElements;
		String submit = null;
		for (Map.Entry<String, String> entry : pagesWithForms.entrySet()) {
			title = entry.getKey();
			formName = entry.getValue();
			driver.get(baseDirController + title);
			query = "//form[contains(@name, " + formName + ")]";
			allFormChildElements =  driver.findElements(By.xpath(query));
			AssertJUnit.assertNotNull(allFormChildElements);
			for(WebElement item : allFormChildElements)
				if(item.getTagName().equals("input") && item.getAttribute("type").equals("submit"))
					AssertJUnit.assertNotNull(item);			
		}
	}
	
	private static void pagesShouldHaveAnchors(String baseDirController, Map<String, String[]> anchorsLinks) {
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
	
	private static void pagesShouldDisplayImages(String baseDirController, String[] pagesWithImages) {
		String query;
		for(String pageWithImage : pagesWithImages) {
			driver.get(baseDirController + pageWithImage);	
			query = "//img[contains(@alt,'logo')]";
			WebElement img = driver.findElement(By.xpath(query));
			AssertJUnit.assertNotNull(img);	
		}		
	}	
	
	@Test(enabled = true)
	public static void lvlPagesShouldHaveCorrectTitle() {
		pagesShouldHaveCorrectTitle(lvlBaseDirController, lvlPagesTitles);
	}
	
	@Test(enabled = true)
	public static void yiiPagesShouldHaveCorrectTitle() {
		pagesShouldHaveCorrectTitle(yiiBaseDirController, yiiPagesTitles);
	}

	@Test(enabled = true)
	public static void lvlPagesShouldHaveFormsWithSubmit() {
		pagesShouldHaveFormsWithSubmit(lvlBaseDirController, lvlPagesWithForms);
	}
	
	@Test(enabled = true)
	public static void yiiPagesShouldHaveFormsWithSubmit() {
		pagesShouldHaveFormsWithSubmit(yiiBaseDirController, yiiPagesWithForms);
	}
	
	@Test(enabled = true)
	public static void lvlPagesShouldHaveAnchors() {
		pagesShouldHaveAnchors(lvlBaseDirController, lvlAnchorsLinks);
	}
	
	@Test(enabled = true)
	public static void yiiPagesShouldHaveAnchors() {
		pagesShouldHaveAnchors(yiiBaseDirController, yiiAnchorsLinks);
	}
	
	@Test(enabled = true)
	public static void lvlPagesShouldDisplayImages() {
		pagesShouldDisplayImages(lvlBaseDirController, lvlPagesWithImages);
	}
	
	@Test(enabled = true)
	public static void yiiPagesShouldDisplayImages() {
		pagesShouldDisplayImages(yiiBaseDirController, yiiPagesWithImages);
	}
}
