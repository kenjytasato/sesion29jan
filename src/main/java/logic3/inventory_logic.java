package logic3;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages2.inventory_page;
import pages2.landing_page;

public class inventory_logic {

    driver Driver = null;
    inventory_page ip = null;

    public inventory_logic(driver driver) {
        this.Driver = driver;
        ip = new inventory_page(Driver);
    }

    public void addElementToShoppingCar() {

        ip.addElement();
    }

    public void checkShoppingCar() {
        ip.goToShoppingCar();
    }

    public void precheckout() {
        ip.precheckout();
    }
}
