package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchResultsPage {
    private final WebDriver driver ;
    private final By nextPageEle=By.cssSelector("a[aria-label=\"Page 2\"]");
    private final By lastPageEle=By.cssSelector("a[aria-label=\"Page 3\"]");
    private final By resultsofpageele= By.cssSelector("div[class=\"tptt\"]");
    private WebDriverWait wait;
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void nextPageClick(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(nextPageEle));
        driver.findElement(nextPageEle).click();
    }
    public void lastPageClick(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(lastPageEle));
        driver.findElement(lastPageEle).click();
    }
    public int countResultsofpage() {
        return driver.findElements(resultsofpageele).size();
    }
}
