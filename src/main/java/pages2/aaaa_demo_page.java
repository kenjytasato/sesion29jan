package pages2;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aaaa_demo_page {
    //solo debemos considerar los comportamientos basicos de cada elemento de la pagina
    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath="")
    WebElement createArticle;

    public aaaa_demo_page(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

public void getTitle()
{

}





}
