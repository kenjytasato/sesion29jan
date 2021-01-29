package driver;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class manageWindowsdriver {

   WebDriver Driver = null;
   String Parent = "";
    Set<String> allwindows =null;
    public manageWindowsdriver(WebDriver driver)
    {
        Driver=driver;
    }

    public void storeParent()
    {
        Parent = Driver.getWindowHandle();



    }

    public void StoreAllWindows()
    {
        allwindows = Driver.getWindowHandles();
    }
    public void switchwindow() {

        for (String winHandle : Driver.getWindowHandles()) {

           System.out.println(winHandle);
                        Driver.switchTo().window(winHandle);

        }
    }
public void switchnexwindow()
{
    System.out.println("Count of windows:"+allwindows.size());

    //Get current handle or default handle
    String currentWindowHandle = allwindows.iterator().next();
    System.out.println("currentWindow Handle"+currentWindowHandle);

    //Remove first/default Handle
    allwindows.remove(allwindows.iterator().next());

    //get the last Window Handle
    String lastHandle = allwindows.iterator().next();
    System.out.println("last window handle"+lastHandle);

    //switch to second/last window, because we know there are only two windows 1-parent window 2-other window(ad window)
    Driver.switchTo().window(lastHandle);


}


}



