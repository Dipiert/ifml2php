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

    private static Map<String, String[]> lvlLabelsPage, yiiLabelsPage;
    private static Map<String, String[]> lvlInputTextsPage, yiiInputTextsPage;
    private static Map<String, String[]> lvlRadiosPage, yiiRadiosPage;
    
    private static String year, title, _addFormMovie, _updateFormMovie, _deleteFormMovie;
    private static String view_add_form_movie, view_update_form_movie, view_delete_form_movie;
    private static String G, PG, PG13, R, isSaga, audience;
    private static String lvlBaseDirController, yiiBaseDirController, server, controller;
    
    public Form_test() {
        getStrings();       
        makeURLs();
        getInputTextsPage();
        getLabelsPage();
        getRadiosPage();
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

    private static void makeURLs() {
        makeLaravelURL();
        makeYii2URL();
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
        
    private static void getRadiosPage() {       
        lvlRadiosPage = new HashMap<String, String[]>();
        yiiRadiosPage = new HashMap<String, String[]>();        
        String[] radiosAddForm = {audience};
        String[] radiosUpdateForm = {audience};
        String[][] radios = {radiosAddForm, radiosUpdateForm};
        String[] lvlNames = {_addFormMovie, _updateFormMovie};
        String[] yiiNames = {view_add_form_movie, view_update_form_movie};
        for(int i = 0; i < lvlNames.length; i++) {
            lvlRadiosPage.put(lvlNames[i], radios[i]);
        }
        for(int i = 0; i < yiiNames.length; i++) {
            yiiRadiosPage.put(yiiNames[i], radios[i]);
        }
    }
    
    private static void getInputTextsPage() {
        lvlInputTextsPage = new HashMap<String, String[]>();
        yiiInputTextsPage = new HashMap<String, String[]>();
        
        String[] inputTextsAddForm = {year, title};     
        String[] inputTextsUpdateForm = {year, title};
        String[] inputTextsDeleteForm = {title};
        
        String[][] inputs = {inputTextsAddForm, inputTextsUpdateForm, inputTextsDeleteForm};
        String[] lvlNames = {_addFormMovie, _updateFormMovie, _deleteFormMovie};
        String[] yiiNames = {view_add_form_movie, view_update_form_movie, view_delete_form_movie};
        
        for(int i = 0; i < lvlNames.length; i++) {      
            lvlInputTextsPage.put(lvlNames[i], inputs[i]);
        }
        
        for(int i = 0; i < yiiNames.length; i++) {      
            yiiInputTextsPage.put(yiiNames[i], inputs[i]);
        }
    }
    
    private static void getLabelsPage() {
        yiiLabelsPage = new HashMap<String, String[]>();
        lvlLabelsPage = new HashMap<String, String[]>();
        
        String[] labelsAddForm = {year, title, G, PG, PG13, R, isSaga};
        String[] labelsUpdateForm = {year, title, G, PG, PG13, R, isSaga};
        String[] labelsDeleteForm = {title};
        lvlLabelsPage.put(_addFormMovie, labelsAddForm);
        lvlLabelsPage.put(_updateFormMovie, labelsUpdateForm);
        lvlLabelsPage.put(_deleteFormMovie, labelsDeleteForm);
        yiiLabelsPage.put(view_add_form_movie, labelsAddForm);
        yiiLabelsPage.put(view_update_form_movie, labelsUpdateForm);
        yiiLabelsPage.put(view_delete_form_movie, labelsDeleteForm);
        
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
        server = "localhost";
        controller = "movie";
        view_add_form_movie = "view-add-form-movie";
        view_update_form_movie = "view-update-form-movie";
        view_delete_form_movie = "view-delete-form-movie";
    }
    
    private static void formsShouldHaveInputs(String baseDirController, Map<String, String[]> inputTexts){
        String name, query;
        String[] inputsTextsName;
        WebElement inputText;   
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
    
    private static void formsShouldHaveLabels(String baseDirController, Map<String, String[]> labelsPage) {
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

    private static void formsShouldHaveRadioButtons(String baseDirController, Map<String, String[]> radiosPage) {
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

    @Test(enabled = true)
    public static void laravelFormsShouldHaveInputs() {
        formsShouldHaveInputs(lvlBaseDirController, lvlInputTextsPage);
    }
    
    @Test(enabled = true)
    public static void yiiFormsShouldHaveInputs() {
        formsShouldHaveInputs(yiiBaseDirController, yiiInputTextsPage);
    }
    
    @Test(enabled = true)
    public static void yiiFormsShouldHaveLabels() {
        formsShouldHaveLabels(yiiBaseDirController, yiiLabelsPage);
    }
    
    @Test(enabled = true)
    public static void lvlFormsShouldHaveLabels() {
        formsShouldHaveLabels(lvlBaseDirController, lvlLabelsPage);
    }
        
    @Test(enabled = true)
    public static void yiiFormsShouldHaveRadioButtons() {
        formsShouldHaveLabels(yiiBaseDirController, yiiRadiosPage);
    }
    
    @Test(enabled = true)
    public static void lvlFormsShouldHaveRadioButtons() {
        formsShouldHaveLabels(lvlBaseDirController, lvlRadiosPage);
    }
}
