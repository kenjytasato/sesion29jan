package pages2;

import driver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class windowsSesion3_page {
    //solo debemos considerar los comportamientos basicos de cada elemento de la pagina
    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath = "//*[@id='txtUsername']")
    WebElement user;

    @FindBy(xpath = "//*[@id='txtPassword']")
    WebElement password;

    @FindBy(xpath = "//*[@id='btnLogin']")
    WebElement loginbtn;

    @FindBy(id = "help")
    WebElement helpbtn;

    @FindBy(xpath = "//*[@id='help']/ul/li[1]/a/span")
    WebElement helpbtnOp1;

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/p")
    WebElement newWindowText;

    public windowsSesion3_page(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }


    public WebElement user() {
        return user;
    }


    public WebElement password() {
        return password;
    }


    public WebElement loginbtn() {
        return loginbtn;
    }


    public WebElement helpbtn() {
        return helpbtn;
    }


    public WebElement helpbtnOp1() {
        return helpbtnOp1;
    }


    public WebElement newWindowText() {
        return newWindowText;
    }


}
