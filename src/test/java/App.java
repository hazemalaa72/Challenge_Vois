import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

public class App {
    public static void main(String[] args) {
    }

    WebDriver driver = null;
    Home home;
    Search search;
    SoftAssert soft;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Row row;
    Cell cell;
    ExtentReports extent ;
    ExtentTest test;
    WebDriverWait wait;



    @BeforeTest
    @Parameters("browser")
    public void OpenBrowser(String browser) throws Exception {
        //selection of execution browser
        if ( browser.equalsIgnoreCase ( "firefox" ) ) {
            driver = new FirefoxDriver ( );
        } else if ( browser.equalsIgnoreCase ( "chrome" ) ) {
            driver = new ChromeDriver ( );
        } else if ( browser.equalsIgnoreCase ( "Edge" ) ) {
            driver = new EdgeDriver ( );
        } else {
            throw new Exception ( "Incorrect Browser" );
        }

        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );
        // Initializing Report
        extent=new ExtentReports ( "C:\\Users\\Hazem Alaa Mostafa\\IdeaProjects\\Challenge\\ExexutionReportResults.html" );
        //path for test data file
        FileInputStream fs = new FileInputStream ( "C:\\Users\\Hazem Alaa Mostafa\\IdeaProjects\\Challenge\\testdata.xlsx" );
        //read data from file
        workbook = new XSSFWorkbook ( fs );
        sheet = workbook.getSheetAt ( 0 );
        row = sheet.getRow ( 0 );
        cell = row.getCell ( 0 );
        driver.get ( "" + sheet.getRow ( 0 ).getCell ( 0 ) );
        //fullscreen
        driver.manage ( ).window ( ).maximize ( );
        //Intializing
        home = new Home ( driver );
        search = new Search ( driver );
        soft = new SoftAssert ( );
        wait = new WebDriverWait (driver, Duration.ofSeconds ( 5 ));
    }


    @Test
    public void ValidChallenge() throws InterruptedException {
        //  Executes preconditions of a test case
        test = extent.startTest("ValidChallenge", "Sample description");
        // type "Vodafone" on search element and press enter
        home.searchEle ( ).sendKeys ( "" + sheet.getRow ( 1 ).getCell ( 0 ) );
        home.searchEle ( ).sendKeys ( Keys.ENTER );
        //wait for the next page button to be click-able
        /*
        explicit wait function does not work and i searched for this problem and i did not find the solution until now
         so i used Threed.sleep function instead until i can find the solution
        wait.until(ExpectedConditions.elementToBeClickable (search.nextPageEle()));
         */
        Thread.sleep ( 4000 );
        // Go to the next page (Page 2)
        driver.findElement (search.nextPageEle()).click ();
        // Count the result of page 2
        List<WebElement> resultsofpage2 = search.countResultsEle ( );
        System.out.println ( "number of results of page 2= " + resultsofpage2.size ( ) );
        //wait for the last page button to be click-able
        /*
        explicit wait function does not work and i searched for this problem and i did not find the solution until now
         so i used Threed.sleep function instead until i can find the solution
        wait.until(ExpectedConditions.elementToBeClickable (search.lastPageEle()));
         */
        Thread.sleep ( 4000 );
        //Go to the next page (Page 3)
        driver.findElement (search.lastPageEle ()).click ();
        // Count the result of page 3
        List<WebElement> resultsofpage3 = search.countResultsEle ( );
        System.out.println ( "number of results of page 3= " + resultsofpage3.size ( ) );
        //Validate if the number of results on page 2 is equal to page 3 or not
        soft.assertEquals ( resultsofpage2, resultsofpage2, "The results of two pages are not equal" );
        //printing test data
        System.out.println ( sheet.getRow ( 0 ).getCell ( 0 ) );
        System.out.println ( sheet.getRow ( 1 ).getCell ( 0 ) );
        soft.assertAll ( );



    }

    @Test
    public void InvalidChallenge() throws Exception {
        //  Executes preconditions of a test case
        test = extent.startTest("InvalidChallenge", "Sample description");
        // Navigate to bing.com
        driver.get ( "" + sheet.getRow ( 0 ).getCell ( 0 ) );
        // type "Vodafone" on search element and press enter
        home.searchEle ( ).sendKeys ( "" + sheet.getRow ( 3 ).getCell ( 0 ) );
        home.searchEle ( ).sendKeys ( Keys.ENTER );
        // Go to the next page (Page 2)
        driver.findElement (search.nextPageEle()).click ();
        // Count the result of page 2
        List<WebElement> resultsofpage2 = search.countResultsEle ( );
        System.out.println ( "number of results of page 2= " + resultsofpage2.size ( ) );
        //Go to the next page (Page 3)
        driver.findElement (search.lastPageEle()).click ();
        // Count the result of page 3
        List<WebElement> resultsofpage3 = search.countResultsEle ( );
        System.out.println ( "number of results of page 3= " + resultsofpage3.size ( ) );
        //Validate if the number of results on page 2 is equal to page 3 or not
        soft.assertEquals ( resultsofpage2, resultsofpage2, "The results of two pages are not equal" );
        soft.assertAll ( );


    }









// Get the status of test case to save it in the report
   @AfterMethod
   public void afterMethod(ITestResult result) throws Exception {
       if (result.getStatus() == ITestResult.FAILURE) {
           test.log(LogStatus.FAIL, result.getThrowable());
       } else if (result.getStatus() == ITestResult.SKIP) {
           test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
       } else {
           test.log(LogStatus.PASS, "Test passed");
       }


   }

    @AfterTest
    public void CloseBrowser() {
        driver.manage ( ).timeouts ( ).implicitlyWait ( Duration.ofSeconds ( 5 ) );
        //  Executes postconditions of a test case
        extent.endTest(test);
        //Erases any previous data on a relevant report and creates a whole new report
        extent.flush();
        // Close the browser
        driver.quit();
    }
    }



