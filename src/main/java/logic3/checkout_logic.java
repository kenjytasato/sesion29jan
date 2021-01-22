package logic3;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages2.checkout_page;
import pages2.landing_page;

public class checkout_logic {

    driver Driver = null;
    checkout_page checkoutP = null;

    public checkout_logic(driver driver) {

        this.Driver = driver;
        checkoutP = new checkout_page(Driver);
    }
    public void fillform(String name, String lname, String zip)
    {
        checkoutP.addFirsname(name);
        checkoutP.addLastName(lname);
        checkoutP.addZipCode(zip);

    }
    public void go()
    {
        checkoutP.continuego();
    }

}
