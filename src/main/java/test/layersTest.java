package test;

import driver.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import logic3.Landing_logic;
import logic3.checkoutOverview_logic;
import logic3.checkout_logic;
import logic3.inventory_logic;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages2.landing_page;

import java.util.concurrent.TimeUnit;

public class layersTest {

public static void main(String[] args) throws InterruptedException {


    driver Driver = new driver();
    Driver.goto_url("https://www.saucedemo.com/");


    Landing_logic ldlc = new Landing_logic(Driver);
    System.out.println("login");
    ldlc.login("standard_user","secret_sauce");
        System.out.println("fin login");

    inventory_logic invlc = new inventory_logic(Driver);
    invlc.addElementToShoppingCar();
    invlc.checkShoppingCar();
    invlc.precheckout();

    checkout_logic checkLc = new checkout_logic(Driver);
    checkLc.fillform("john", "doe","123");
    checkLc.go();

checkoutOverview_logic checkOvLc = new checkoutOverview_logic(Driver);
System.out.println( checkOvLc.gettotalamount() );

   Driver.teardown();
}








}


