import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ejercicio1_resol {

public static void main(String[] args)
{
    String localizadorXpath = "/html/body/header/div/form/input"; //xpath relativo
    String localizadorName="as_word";

    String mercadolibreLogo = "/html/body/header/div/a[2]";
    String dummy ="";

    String listStart1 = "//*[@id='root-app']/div/div/section/ol/li[";
    String listEnd = "]/div/div/div[2]/div[2]/div[1]/div/div/div/span[1]/span[2]" ;
    String productEnd ="/div/div/div[2]/div[1]/a/h2";

int a = 0;


    String wikilinkPath = "";
    WebElement inputBusqueda = null;
    WebDriver driver = null;
    WebDriverManager.chromedriver().version("87.0.4280.88").setup();
    driver = new ChromeDriver();



     //abrimos el browser
    driver.get("https://www.mercadolibre.com.pe/");


    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mercadolibreLogo)));

    //utilizamos distintas formas de llamar al webdriver
    inputBusqueda = driver.findElement(By.xpath(localizadorXpath));
   // inputBusqueda = driver.findElement(By.name(localizadorName));

    inputBusqueda.sendKeys("mackbook");

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    inputBusqueda.sendKeys(Keys.ENTER);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    for (int i = 1; i < 3; ++i) {
        System.out.println("entrando");
        float i1 = Float.parseFloat(driver.findElement(By.xpath(listStart1 + i + listEnd)).getText()) ;
        float i2 = Float.parseFloat(driver.findElement(By.xpath(listStart1 + i+1 + listEnd)).getText()) ;

        if (i1>i2)
        {
            a=i+1;
        }
        else
        {
            a=i;
        }
    }

       System.out.println(driver.findElement(By.xpath(listStart1 + a + listEnd)).getText());
    driver.findElement(By.xpath( "//*[@id='root-app']/div/div/section/ol/li[" +a+ "]/div/div/div[2]/div[1]/a/h2")).click();





    driver.get("https://www.mercadolibre.com.pe/");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mercadolibreLogo)));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dummy)));
    System.out.println("termino el test");
    driver.close();

}


//*[@id="root-app"]/div/div/section/ol/li[X]





}


