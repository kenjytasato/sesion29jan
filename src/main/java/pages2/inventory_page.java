package pages2;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class inventory_page {

    public driver Driver = null;
    public WebDriver driver = null;

    @FindBy(xpath="//*[@id='inventory_container']/div/div[1]/div[3]/button")
                   //*[@id="inventory_container"]/div/div[3]/div[3]/button
    WebElement elementBtn;

    @FindBy(id="shopping_cart_container")
    WebElement shoppongCar;

    @FindBy(xpath="//*[@id='cart_contents_container']/div/div[2]/a[2]")
    WebElement checkoutBtn;



    public inventory_page(driver driver) {

        this.Driver = driver;
        PageFactory.initElements(this.Driver.returnDriver(), this);
    }

    public void addElement() {
        Driver.customWait_clickable(elementBtn);
        elementBtn.click();
    }

    public void goToShoppingCar() {

        Driver.customWait_clickable(shoppongCar);
        shoppongCar.click();
    }

    public void precheckout() {

        Driver.customWait_clickable(checkoutBtn);
        checkoutBtn.click();
    }


}
