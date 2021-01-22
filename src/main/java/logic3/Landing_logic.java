package logic3;

import driver.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages2.landing_page;

public class Landing_logic {

    driver Driver = null;
    landing_page lp = null;


    public Landing_logic(driver driver) {
        this.Driver = driver;
        lp = new landing_page(Driver);


    }

    public void login(String user, String pass)
    {

        lp.setUsername(user);
        lp.setPassword(pass);
        lp.login();

    }



}
