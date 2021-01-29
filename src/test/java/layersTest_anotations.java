import driver.driver;
import logic3.Landing_logic;
import logic3.checkoutOverview_logic;
import logic3.checkout_logic;
import logic3.inventory_logic;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class layersTest_anotations {

    driver Driver = null;
    Landing_logic ldlc = null;
    inventory_logic invlc = null;
    checkout_logic checkLc = null;
    checkoutOverview_logic checkOvLc = null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver();
        ldlc = new Landing_logic(Driver);
        invlc = new inventory_logic(Driver);
        checkLc = new checkout_logic(Driver);
        checkOvLc = new checkoutOverview_logic(Driver);

    }

    @Test(priority = 1, testName = "caso 1")
    public void testcas1() throws InterruptedException {
        Driver.goto_url("https://www.saucedemo.com/");
        ldlc.login("standard_user", "secret_sauce");
        invlc.addElementToShoppingCar();
        invlc.checkShoppingCar();
        invlc.precheckout();
        checkLc.fillform("john", "doe", "123");
        checkLc.go();
        System.out.println(checkOvLc.gettotalamount());

    }

    @Test(priority = 3, testName = "caso 2")
    public void testcase2() throws InterruptedException {
        Driver.goto_url("https://www.saucedemo.com/");
        ldlc.login("standard_user", "secret_sauce");
        invlc.addElementToShoppingCar();
        invlc.checkShoppingCar();
        invlc.precheckout();
        checkLc.fillform("pepito", "torres", "123");
        checkLc.go();
        System.out.println(checkOvLc.gettotalamount());

    }

    @AfterClass
    public void teardown() {
        Driver.teardown();
    }


}


