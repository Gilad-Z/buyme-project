import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    private static WebDriver driver;

    private static ReportHandler reports = new ReportHandler();


    @BeforeClass
 public static void browser() throws ParserConfigurationException, IOException,SAXException {
   String browser = XMLHandler.getData(Constant.BROWSER_KEY);
   String url = XMLHandler.getData(Constant.URL);

    if (browser.equals("chrome"))
    {
      System.setProperty("webdriver.chrome.driver", "c:\\QA course\\chromedriver.exe");
      ChromeOptions x = new ChromeOptions();
      x.addArguments("--headless");
      driver = new ChromeDriver(x);
      driver.get(url);
       } else if (browser.equals("firefox"))
  {
      System.setProperty("webdriver.gecko.driver", "c:\\QA course\\geckodriver.exe");
      driver = new FirefoxDriver();
      driver.get(url);
  }
    else {
        throw new IOException("Enter correct browser name");

    }
    reports.InitializeReport();

    }


    @Test
    public void Test01() throws InterruptedException  ,IOException{

        BuymeMainPage mainPage = new BuymeMainPage(driver);
        Thread.sleep(300);
        mainPage.ClickRegistration();
        Thread.sleep(300);
        mainPage.ClickRegistration2();

      reports.CreateScreenShot(driver);
      reports.Log(Status.PASS, "Entering registration screen");

        BuymeRegistration registrationPage = new BuymeRegistration(driver);
        registrationPage.FillRegistrationForm();
        Thread.sleep(350);
        registrationPage.clickX();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Finished filling in registration information");

    }


    @Test
    public void Test02() throws InterruptedException, IOException
    {
        BuymeMainPage mainPage = new BuymeMainPage(driver);
        Thread.sleep(350);
        mainPage.ChooseGift();


        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Finished choosing gift");


    }

    @Test
    public void Test03() throws InterruptedException, IOException,ParserConfigurationException,SAXException
    {
        BuymeMainPage mainPage = new BuymeMainPage(driver);
        mainPage.AssertWebPage();
        Thread.sleep(300);

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Assertion of web address finished");

        BuymeGiftSelection giftSelection = new BuymeGiftSelection(driver);
        giftSelection.ChooseBusiness();
        Thread.sleep(350);
        giftSelection.EnterPrice();

        reports.CreateScreenShot(driver);
        reports.Log(Status.PASS, "Finished selecting gift");
    }

    @Test
    public void Test04() throws InterruptedException, IOException {


        BuymeSendPresent sendPresent = new BuymeSendPresent(driver);
        sendPresent.InformationScreen();
        Thread.sleep(300);
        reports.CreateScreenShot(driver);


        sendPresent.EventSelection();
        Thread.sleep(500);
        reports.CreateScreenShot(driver);

        sendPresent.Blessing();
        reports.CreateScreenShot(driver);
        Thread.sleep(500);

        reports.CreateScreenShot(driver);

        sendPresent.UploadImage();

        reports.CreateScreenShot(driver);

        sendPresent.SubmitBTN();


        sendPresent.FinalScreen();


        reports.Log(Status.PASS, "Finished selecting gift properties");
    }


    @AfterClass
    public static void Finalize()
    {
        reports.Log(Status.PASS, "Quitting browser after test");
        driver.quit();
        reports.FinalizeExtentReport();
}



}
