package selenium.ifml2php;

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
    private static Yii yii;
    private static Laravel laravel;
    
    public Page_test() {    
    	String server = "localhost";
		String controller = "movie";
    	yii = new Yii(server, controller);
        laravel = new Laravel(server, controller);
    	yiiBaseDirController = yii.getBaseDirController();
		lvlBaseDirController = laravel.getBaseDirController();
    }
    
    @BeforeClass
    private static void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new FirefoxDriver();
    }
    
    @AfterClass
    private static void tearDown() {
        driver.close();
    }
       
    private static void pagesShouldHaveCorrectTitle(String baseDirController, Map<String, String> pagesTitles) {
        String page, title;
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
        pagesShouldHaveCorrectTitle(lvlBaseDirController, laravel.getPagesTitles());
    }
    
    @Test(enabled = true)
    public static void yiiPagesShouldHaveCorrectTitle() {
        pagesShouldHaveCorrectTitle(yiiBaseDirController, yii.getPagesTitles());
    }

    @Test(enabled = true)
    public static void lvlPagesShouldHaveFormsWithSubmit() {
        pagesShouldHaveFormsWithSubmit(lvlBaseDirController, laravel.getPagesWithForms());
    }
    
    @Test(enabled = true)
    public static void yiiPagesShouldHaveFormsWithSubmit() {
        pagesShouldHaveFormsWithSubmit(yiiBaseDirController, yii.getPagesWithForms());
    }
    
    @Test(enabled = true)
    public static void lvlPagesShouldHaveAnchors() {
        pagesShouldHaveAnchors(lvlBaseDirController, laravel.getAnchorsLinks());
    }
    
    @Test(enabled = true)
    public static void yiiPagesShouldHaveAnchors() {
        pagesShouldHaveAnchors(yiiBaseDirController, yii.getAnchorsLinks());
    }
    
    @Test(enabled = true)
    public static void lvlPagesShouldDisplayImages() {
        pagesShouldDisplayImages(lvlBaseDirController, laravel.getPagesWithImages());
    }
    
    @Test(enabled = true)
    public static void yiiPagesShouldDisplayImages() {
    	pagesShouldDisplayImages(yiiBaseDirController, yii.getPagesWithImages());
    }
}
