package pages2;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutOverview_page {
    //solo debemos considerar los comportamientos basicos de cada elemento de la pagina
    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath="//*[@id='checkout_summary_container']/div/div[2]/div[5]")
    WebElement totalPrice;

    public checkoutOverview_page(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

public void getTitle()
{

}


    public void getSubprice() {
    }
    public String getTotalPrice() {
        String s= totalPrice.getText();
        s = s.substring(13);
        return s;
    }
}
