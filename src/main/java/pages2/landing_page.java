package pages2;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landing_page {

    public driver Driver = null;
    public WebDriver driver = null;


    @FindBy(xpath = "//*[@id='user-name']")
    WebElement user1;

    @FindBy(xpath = "//*[@id='password']")
    WebElement pass1;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginBtn;

    public landing_page(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public void setUsername(String user) throws InterruptedException {
        Driver.implicitwait();
        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(user1).click().sendKeys(user).perform();
      //  builder.moveToElement(user1).click().sendKeys(user).build().perform();


    }

    public void setPassword(String password) throws InterruptedException {
        Driver.implicitwait();
        Actions builder = new Actions(Driver.returnDriver());
        builder.moveToElement(pass1).click().sendKeys(password).build().perform();


    }

    public void login() {
        Driver.customWait_clickable(loginBtn);
        loginBtn.click();

    }



}
