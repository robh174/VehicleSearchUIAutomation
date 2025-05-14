package utilities;

import com.Base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver driver;

    // this sets a utility driver from the base class
    // that we can use to carry out our utility methods or other utility classes
    public static void setUtilityDriver(){
        driver = BasePage.driver;
    }

}
