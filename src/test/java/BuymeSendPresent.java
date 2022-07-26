import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

// represent page in which user sends present
public class BuymeSendPresent extends BuymeBase {

    // construct object with external driver

    public BuymeSendPresent(WebDriver _driver)
    {
        driver = _driver;
    }

    //select event
    public void  EventSelection() throws InterruptedException{
        SetSearchProperties(Constant.WHICHEVENT,Constant.XPATHCONVERTOR);
             Thread.sleep(500);


    }


// last screen of the project
   public void  FinalScreen() throws InterruptedException {

Thread.sleep(500);
       List<WebElement> ClickMail = driver.findElements(By.className("method-icon"));


       WebElement mailBtnn = ClickMail.get(1);
        mailBtnn.click();

        WebElement mailToPresent = driver.findElement(By.id(Constant.MAIL_TO_GIFT_CSS));
        mailToPresent.sendKeys(Constant.MAIL_TO_GIFT);


       WebElement Sender = driver.findElement(By.id("ember1767"));
       Sender.click();
       Sender.clear();
       Sender.sendKeys(Constant.SENDER_NAME);


      WebElement submitBtn = driver.findElement(By.id("ember1772"));
       ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_SCROLL, submitBtn);
       submitBtn.click();



        List<WebElement> submitBtns = driver.findElements(By.cssSelector(Constant.SUBMIT));
        WebElement saveMail = submitBtns.get(0);
        saveMail.click();
        Thread.sleep(1000);

        WebElement pay = submitBtns.get(1);
        pay.click();

    }
    //To insert a blessing
    public void Blessing()
    {
        WebElement blessing = driver.findElement(By.cssSelector(Constant.BLESSING_FIELD));
        blessing.click();
        blessing.clear();
        blessing.sendKeys(Constant.BLESSING_INSERT);
    }

    // to upload image in relevant element

   public void SubmitBTN() throws InterruptedException{
       WebElement submitBtns = driver.findElement(By.id(Constant.CONTINUE));
       ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_SCROLL, submitBtns);
       Thread.sleep(500);
        submitBtns.click();

   }
    // to upload image in relevant element
    public void UploadImage()
    {
        WebElement imageBtn = driver.findElement(By.id(Constant.UPLOAD_PIC));
        ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_SCROLL, imageBtn);
        //  imageBtn.click();
        imageBtn.sendKeys(Constant.PIC_PATH);
    }

    //To who the gift is
    public void InformationScreen()
    {
        WebElement forSomeoneElse = driver.findElement(By.className(Constant.FOR_SOMEONE));
        forSomeoneElse.click();

        List<WebElement> nameField = driver.findElements(By.cssSelector(Constant.RECEIVER_FIELD));
        WebElement name = nameField.get(0);
        name.click();

        name.sendKeys(Constant.RECEIVER_NAME);

    }
}



