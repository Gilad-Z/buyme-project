import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuymeRegistration extends BuymeBase{

    // construct object with external driver
    public BuymeRegistration(WebDriver _driver){
        driver = _driver;
    }


    //FillRegistration Form to enter mail and password and first name
    public void FillRegistrationForm(){

        // parse configurable values from XML
        String firstNameFromXml= "";
        String mailFromXml = "";
        String passwordFromXml = "";

        try {
            firstNameFromXml = XMLHandler.getData(Constant.FIRST_NAME_XML);
            mailFromXml = XMLHandler.getData(Constant.EMAIL_XML);
            passwordFromXml = XMLHandler.getData(Constant.PASSWORD_XML);

        }
        catch (Exception ex){

            System.out.println("Exeption getting value from xml");
        }


        // fill registration fields
        FillRegFormByXpath(Constant.FIRST_NAME, firstNameFromXml);
        FillRegFormByXpath(Constant.EMAIL,mailFromXml);
        FillRegFormByXpath(Constant.PASSWORD, passwordFromXml);
        FillRegFormByXpath(Constant.PASSWORDCONFIRM, passwordFromXml);

        // agree to site terms
       WebElement agreeCheckbox = driver.findElement(By.className(Constant.AGREEBOX)) ;
        ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_CLICK, agreeCheckbox);
        // submit button for registration
        WebElement submitBox = driver.findElement(By.id(Constant.SUBMIT));
        ((JavascriptExecutor) driver).executeScript(Constant.JAVASCRIPT_CLICK, submitBox);

    }

// exit the registration form for program keep running
    public void clickX() throws InterruptedException{
        WebElement x = driver.findElement(By.xpath("//*[@id=\"times\"]"));
        x.click();
        Thread.sleep(250);
    }

    // helper function to simplify element search
    private void FillRegFormByXpath(String tagName, String fill){
        String xpathExpression =  "//input[@placeholder='"+ tagName + "']";
        WebElement fillElement = driver.findElement(By.xpath(xpathExpression));
        fillElement.sendKeys(fill);
    }
}
