import driver.driver;
import logic3.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class auxiliarTest_anotations {

    driver Driver = null;
    auxiliar_logic auxL =null;

    @BeforeClass
    public void setupEnv() {
        Driver = new driver();
       auxL = new auxiliar_logic(Driver);

    }

    @Test(priority = 1, testName = "sesion2")
    public void testcas1() throws InterruptedException {
        Driver.goto_url("https://www.saucedemo.com/");

    }

    @AfterClass
    public void teardown() {
        Driver.teardown();
    }


}


