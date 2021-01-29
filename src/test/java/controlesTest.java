import driver.driver;
import driver.manageWindowsdriver;
import logic3.Landing_logic;
import logic3.checkoutOverview_logic;
import logic3.checkout_logic;
import logic3.inventory_logic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages2.windowsSesion3_page;

public class controlesTest {

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

    @Test(priority = 1, testName = "Actions")
    public void acciones() throws InterruptedException {
        Driver.goto_url("https://www.saucedemo.com/");
        ldlc.login("standard_user", "secret_sauce");
        invlc.addElementToShoppingCar();
        invlc.checkShoppingCar();
        invlc.precheckout();
        checkLc.fillform("john", "doe", "123");
        checkLc.go();
        System.out.println(checkOvLc.gettotalamount());

    }

    @Test(priority = 2, testName = "Windows")
    public void ventanas() throws InterruptedException {
        Driver.goto_url("https://ultimateqa.com/dummy-automation-websites/#Telerik_Multi_Language_Demo_Site");

        String aux = Driver.windowParent();
        Driver.implicitwait2();
        Driver.scroll(800);
        windowsSesion3_page wp = new windowsSesion3_page(Driver);
        Driver.implicitwait2();
        Driver.scroll(800);
        WebElement link = Driver.returnDriver().findElement(By.xpath("//*[@id='post-9600']/div[2]/ul[1]/li[1]/strong/a"));
        link.click();
        Driver.switchWindows(aux);
        String a = wp.newWindowText().getText();
        System.out.println(a);


    }

    @Test(priority = 3, testName = "Assert")
    public void verificacion() throws InterruptedException {
        Driver.goto_url("https://ultimateqa.com/dummy-automation-websites/#Telerik_Multi_Language_Demo_Site");
        String aux = Driver.windowParent();

        manageWindowsdriver mwd = new manageWindowsdriver(Driver.returnDriver());

        Driver.implicitwait2();
        Driver.scroll(800);
        String ActualTitle = Driver.returnDriver().getTitle();
        windowsSesion3_page wp = new windowsSesion3_page(Driver);

        WebElement link = Driver.returnDriver().findElement(By.xpath("//*[@id='post-9600']/div[2]/ul[1]/li[1]/strong/a"));
        Driver.implicitwait2();
        Driver.scroll(400);
        link.click();

        mwd.StoreAllWindows();
        mwd.switchnexwindow();

        String ExpectedTitle = Driver.returnDriver().getTitle();

        Driver.implicitwait2();

        Assert.assertEquals(ExpectedTitle, ActualTitle);
        System.out.println(ExpectedTitle + "    " + ActualTitle);

        Driver.switchWindows(aux);

        String a = wp.newWindowText().getText();
        System.out.println(a);
    }

    @Test(priority = 4, testName = "dropdown/combobox")
    public void comboboxIndex() throws InterruptedException {
        Driver.goto_url("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = Driver.returnDriver().findElement(By.id("dropdown"));   //*[@id="dropdown"]
        Select opciones = new Select(dropdown);
        System.out.println("por indice");
        opciones.selectByIndex(1);
        Driver.implicitwait();

    }

    @Test(priority = 5, testName = "dropdown/combobox")
    public void comboboxText() throws InterruptedException {
        Driver.goto_url("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = Driver.returnDriver().findElement(By.id("dropdown"));   //*[@id="dropdown"]
        Select opciones = new Select(dropdown);
        System.out.println("por texto");
        opciones.selectByVisibleText("Option 2");
        WebElement a = Driver.returnDriver().findElement(By.id("asdasddasdasaddsfgadafsdf"));
        Driver.explicitWait(a);

    }

    @Test(priority = 6, testName = "dropdown/combobox")
    public void combobox3rd() throws InterruptedException {
        Driver.goto_url("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = Driver.returnDriver().findElement(By.id("dropdown"));   //*[@id="dropdown"]
        dropdown.click();
        WebElement op1 = Driver.returnDriver().findElement(By.xpath("//*[@id='dropdown']/option[1]"));
        WebElement op2 = Driver.returnDriver().findElement(By.xpath("//*[@id='dropdown']/option[2]"));
        Driver.explicitWait(op1);
        op2.click();
        WebElement a = Driver.returnDriver().findElement(By.id("asdasddasdasaddsfgadafsdf"));
        Driver.explicitWait(a);
        Driver.explicitWait(a);

    }

    @Test(priority = 7, testName = "modal")
    public void modal() throws InterruptedException {
        Driver.goto_url("http://the-internet.herokuapp.com/entry_ad");
        WebElement aux = Driver.returnDriver().findElement(By.xpath("//*[@id='modal']/div[2]/div[1]/h3"));

        Driver.explicitWait(aux);

        WebElement dropdown = Driver.returnDriver().findElement(By.xpath("//*[@id='modal']/div[2]/div[3]/p"));   //*[@id="dropdown"]
        dropdown.click();

        WebElement a = Driver.returnDriver().findElement(By.id("asdasddasdasaddsfgadafsdf"));
        Driver.explicitWait(a);
        Driver.explicitWait(a);

    }


    @AfterClass
    public void teardown() {
        Driver.teardown();
    }


}


