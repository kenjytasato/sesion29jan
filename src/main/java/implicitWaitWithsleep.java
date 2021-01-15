import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class implicitWaitWithsleep {

public static void main(String[] args)
{
    String localizadorXpath = "/html/body/header/div/form/input"; //xpath relativo
    String localizadorName="as_word";

    String wikilinkPath = "";
    WebElement inputBusqueda = null;
    WebDriver driver = null;
    WebDriverManager.chromedriver().version("87.0.4280.88").setup();
    driver = new ChromeDriver();



    //abrimos el browser
    driver.get("https://www.mercadolibre.com.pe/");

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }



    //utilizamos distintas formas de llamar al webdriver
    inputBusqueda = driver.findElement(By.xpath(localizadorXpath));
   // inputBusqueda = driver.findElement(By.name(localizadorName));

    inputBusqueda.sendKeys("wikipedia");

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    inputBusqueda.sendKeys(Keys.ENTER);
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    driver.get("https://www.mercadolibre.com.pe/");
    System.out.println("termino el test");
    driver.close();

}


}
