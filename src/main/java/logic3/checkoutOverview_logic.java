package logic3;

import driver.driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages2.checkoutOverview_page;
import pages2.checkout_page;

public class checkoutOverview_logic {


    driver Driver = null;
    checkoutOverview_page checkoutOverviewP = null;

    public checkoutOverview_logic(driver driver) {

        this.Driver = driver;
        checkoutOverviewP = new checkoutOverview_page(Driver);

    }

    public void checkTotals()
    {
        checkoutOverviewP.getSubprice();

    }
    public String gettotalamount()
    {
        return    checkoutOverviewP.getTotalPrice();

    }

}
