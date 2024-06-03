package pages;

import dev.failsafe.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SearchResultsPage {

    private WebDriver driver;
    private By nextPageEle=By.cssSelector("a[aria-label=\"Page 2\"]");
    private By lastPageEle=By.cssSelector("a[aria-label=\"Page 3\"]");
    private By resultsofpageele= By.cssSelector("div[class=\"tptt\"]");
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void nextPageClick(){
        driver.findElement(nextPageEle).click();

    }
    public void lastPageClick(){
        driver.findElement(lastPageEle).click();

    }
    public int countResultsofpage() {
        return driver.findElements(resultsofpageele).size();
    }
}
