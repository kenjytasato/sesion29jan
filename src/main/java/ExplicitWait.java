import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

public static void main(String[] args)
{
    String localizadorXpath = "/html/body/header/div/form/input"; //xpath relativo
    String localizadorName="as_word";

    String mercadolibreLogo = "/html/body/header/div/a[2]";
    String dummy ="";

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

    inputBusqueda.sendKeys("wikipedia");

    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    inputBusqueda.sendKeys(Keys.ENTER);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.get("https://www.mercadolibre.com.pe/");
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mercadolibreLogo)));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dummy)));
    System.out.println("termino el test");
    driver.close();

}


}
