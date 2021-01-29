package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class driver {

    public Properties p=null;
    public Properties p1=null;
    public Properties p2=null;
    public WebDriver driver;
    public FileReader reader=null;
    public WebDriver returnDriver()
    {
        return driver;
    }

    public static void setupClass()
    {
        WebDriverManager.chromedriver().version("88.0.4324.96").setup();

      // WebDriverManager.chromedriver().setup();
    }
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public driver()
    {
        setupClass();
        setupTest();
        /*
        initiateLocators();
        initiateReport();
        initiateVariables();
*/

        PageFactory.initElements(this.driver, this);
    }
    public void initiateVariables()
    {
        try{
            String prop_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"env/variables.properties";
            FileReader readeri =new FileReader(prop_path);
            reader = readeri;
            p = new Properties();
            p.load(reader);
        }
        catch(Exception e)
        {
            System.out.println("el archivo de variables del sitio no se cargo de manera adecuada");
            e.printStackTrace();
        }
    }
    public void initiateReport()
    {
        try{
            String prop_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"env/reportConfig.properties";
            FileReader readeri =new FileReader(prop_path);
            reader = readeri;
            p1 = new Properties();
            p1.load(reader);
        }
        catch(Exception e)
        {
            System.out.println("el archivo de reporte no se inicializo de manera adecuada");
            e.printStackTrace();
        }
    }
    public void initiateLocators()
    {
        try{
            String prop_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"env/locators.properties";
            FileReader readeri =new FileReader(prop_path);
            reader = readeri;
            p2 = new Properties();
            p2.load(reader);
        }
        catch(Exception e)
        {
            System.out.println("el archivo de locators no se inicializo de manera adecuada");
            e.printStackTrace();
        }
    }


    public void explicitWait(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
           //   wait.until(ExpectedConditions.elementToBeClickable(element));
              wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void customWait_xpath (By minedupath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(presenceOfElementLocated(minedupath));
    }
    public void customWait_clickable (WebElement minedupath)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(elementToBeClickable(minedupath));
    }



    public void send_keys(By mineduElement, String mineduInput)
    { driver.findElement(mineduElement).sendKeys(mineduInput);

    }
    public void goto_url(String url_address) throws InterruptedException {
        driver.get(url_address);
        Thread.sleep(6000);
    }



    public void click (By mineduPath)
    {
        driver.findElement(mineduPath).click();
           }

           public String windowParent()
           {
               String winHandleBefore = driver.getWindowHandle();

               return winHandleBefore;
           }


           public void switchWindows(String winHandle)
    {
        // Store the current window handle

// Perform the click operation that opens new window
// Switch to new window opened
      //  for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
   //     }
// Perform the actions on new window
// Close the new window, if that window no more required
//   driver.close();
// Switch back to original browser (first window)
    //    driver.switchTo().window(winHandleBefore);
    }
    public void switchToNewWindows() {
        // Store the current window handle

// Perform the click operation that opens new window
// Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            //     }
// Perform the actions on new window
// Close the new window, if that window no more required
//   driver.close();
// Switch back to original browser (first window)
            //    driver.switchTo().window(winHandleBefore);
        }
    }


    public void implicitwait() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //   Thread.sleep(4000);

    }
    public void implicitwait2() throws InterruptedException {


         Thread.sleep(8000);

    }




    public void submit(By form) {
    driver.findElement(form).submit();
    }

    public Properties return_Prop() {

        return p;
    }




    public boolean missingImageElement(WebElement ImageElement)
    {   Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageElement);
        return ImagePresent;
    }

    public boolean missingElement(WebElement Element)
    {   Boolean response = null;
        response = Element.isDisplayed() && Element.isEnabled();
        return response;
    }


    public  String takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("_yyyMMdd_hhmmss").format(System.currentTimeMillis());
        String img = "image"+timeStamp+".png";
        FileUtils.copyFile(scrFile,new File("Report//screenshots//"+img));
        return img;
    }
    public void scroll(int x)
    {
        ((JavascriptExecutor) driver).executeScript("scroll(0,"+x +")");

    }

}
