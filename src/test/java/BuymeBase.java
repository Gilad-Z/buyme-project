import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;


public abstract class BuymeBase {
    // these members will be common to all sub classes (actual pages in website)
    protected WebDriver driver;


    // SetSearchProperties selecting search parameters from the drop down
    // common to two separate classes - so it's implemented here in base class
    protected void SetSearchProperties(String searchElement, String classToOptions){
        WebElement element = driver.findElement(By.id(searchElement));
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2));
        element.click();


        WebElement options = driver.findElement(By.xpath(classToOptions));
        options.click();
    }

}
