import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;


public class ReportHandler {
   private static ExtentReports extent;
   private static ExtentTest test;


    // initialize all objects relevant for new report
    public void InitializeReport(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("c:\\QA Course\\Project2\\report.html");
        // attach reporter
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
        // name the test and add description
    test = extent.createTest("Buyme Test","Automation test for https://wwww.buyme.co.il");


    extent.setSystemInfo("PC", "Win11");
extent.setSystemInfo("Tester","Gilad");

test.log(Status.INFO, "Initialiaze extent report");

    }
    // wrapper method for capturing screenshot
    public void CreateScreenShot(WebDriver driver) throws IOException {

        String timeNow = String.valueOf(System.currentTimeMillis());
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("c:\\QA course\\Project2"+ timeNow,driver)).build());


    }
    // inner method for taking screen shot
    private static String takeScreenShot(String ImagesPath, WebDriver driver){

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");

        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e){
            System.out.println(e.getMessage());

        }return ImagesPath + ".png";
    }

    // wrapper function for writing log entry with relevant status
    public void Log(Status  entryStatus,String logEntry){
        test.log(entryStatus,logEntry);
    }
    // method for finalizing the report
    public void FinalizeExtentReport(){
        // build and flush report
        extent.flush();
    }
}
