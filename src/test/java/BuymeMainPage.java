import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
// class representing main page
public class BuymeMainPage extends BuymeBase {

    // construct main page with external driver
    public BuymeMainPage(WebDriver _driver) {
        driver = _driver;
    }


    //RegClick module clicks on register button and selects register.
    public void ClickRegistration(){
        WebElement Regbtn = driver.findElement(By.partialLinkText(Constant.REGISTRATION));
        ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_CLICK,Regbtn);


           }
           public void ClickRegistration2(){
               WebElement Regselect = driver.findElement(By.className("text-link"));
               ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_CLICK,Regselect);

           }

    //ChoseGift selects from each drop down
    public void ChooseGift()
    {
        SetSearchProperties(Constant.PRICE, Constant.XPATHCONVERTOR_1);
        SetSearchProperties(Constant.AREA, Constant.XPATHCONVERTOR_2);
        SetSearchProperties(Constant.CATEGORY, Constant.XPATHCONVERTOR_3);

        driver.findElement(By.cssSelector("a[href*='"+ Constant.SEARCHGIFT + "']")).click();
    }
    //Assert WebPage checking the current URL if it equal to expected url
  public void AssertWebPage() throws ParserConfigurationException, IOException , SAXException{
        String currentURL;
        String expectedURL;
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://buyme.co.il/search?budget=3&category=359&region=12";
      Assert.assertEquals(currentURL, expectedURL);
    }


}
