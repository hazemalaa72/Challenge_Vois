package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LastPage {
    private WebDriver driver;
    private final By resultsofpageele= By.cssSelector("div[class=\"tptt\"]");
    public LastPage(WebDriver driver){
        this.driver=driver;
    }
    public int countResultsofpage() {
        return driver.findElements(resultsofpageele).size();
    }
}
