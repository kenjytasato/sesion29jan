package pages2;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class checkout_page {
    //solo debemos considerar los comportamientos basicos de cada elemento de la pagina
    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath="//*[@id='first-name']")
    WebElement firstname;
    @FindBy(xpath="//*[@id='last-name']")
    WebElement lastname;
    @FindBy(xpath="//*[@id='postal-code']")
    WebElement zipcode;
    @FindBy(xpath="//*[@id='checkout_info_container']/div/form/div[2]/input")
    WebElement continueBtn;

    public checkout_page(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

public void addFirsname(String FirstName)
{
    Driver.customWait_clickable(firstname);
    firstname.sendKeys(FirstName);

}
    public void addLastName(String Lastname)
    {
        Driver.customWait_clickable(lastname);
        lastname.sendKeys(Lastname);

    }
    public void addZipCode(String zip)
    {
        Driver.customWait_clickable(zipcode);
        zipcode.sendKeys(zip);
    }

    public void continuego()
    {
        Driver.customWait_clickable(continueBtn);
        continueBtn.click();

    }

}
