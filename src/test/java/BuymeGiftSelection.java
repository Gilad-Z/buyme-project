import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuymeGiftSelection extends BuymeBase{

    public BuymeGiftSelection(WebDriver _driver)
    {
        driver = _driver;
    }

    //To select a gift
    public void ChooseBusiness()
    {
        driver.findElement(By.cssSelector("a[href*='" + Constant.GIFT_LINK + "']")).click();
    }
//price of the gift
    public void EnterPrice(){
        WebElement price = driver.findElement(By.id(Constant.PRICEFOX));
        price.click();
        price.sendKeys("400");

        WebElement Submit = driver.findElement(By.id("ember2085"));
        Submit.click();
    }
}
