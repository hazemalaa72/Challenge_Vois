package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchResultsPage;
import testdata.JsonDataReader;
import java.io.IOException;
import java.time.Duration;
public class Basetests extends JsonDataReader {
    protected   WebDriver driver =null;
    protected HomePage home;
    protected String [] data=null;
    protected SearchResultsPage search;
    protected SoftAssert soft;
    @BeforeClass
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\test\\IdeaProjects\\Challenge_Vois\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage ( ).timeouts ( ).implicitlyWait (Duration.ofSeconds ( 5 ) );
        driver.get ( "https://www.bing.com" );
        driver.manage ( ).window ( ).maximize ( );
        search = new SearchResultsPage( driver );
        home = new HomePage( driver );
        soft = new SoftAssert ( );
    }
    @AfterClass
    public  void tearDown() throws IOException {
        driver.quit();
    }
}
  /*@BeforeTest
    //@Parameters("browser")
    public void OpenBrowser() throws Exception {
        /*
        if ( browser.equalsIgnoreCase ( "firefox" ) ) {
            driver = new FirefoxDriver ( );
        } else if ( browser.equalsIgnoreCase ( "chrome" ) ) {
            driver = new ChromeDriver ( );
        } else if ( browser.equalsIgnoreCase ( "Edge" ) ) {
            driver = new EdgeDriver ( );
        } else {
            throw new Exception ( "Incorrect Browser" );
        }

         */
// Get the status of test case to save it in the report
    /*
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

     */
