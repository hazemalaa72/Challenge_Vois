package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class SearchResultsPage {
    private final WebDriver driver ;
    private final By nextPageElement=By.cssSelector("a[aria-label=\"Page 2\"]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public Nextpage nextPageClick(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(nextPageElement));
        driver.findElement(nextPageElement).click();
        return new Nextpage(driver);
    }


}
