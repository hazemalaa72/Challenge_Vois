package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class Nextpage {
    private WebDriver driver;
    private final By lastPageEle=By.cssSelector("a[aria-label=\"Page 3\"]");
    public Nextpage(WebDriver driver){
        this.driver=driver;
    }
    public LastPage lastPageClick(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(lastPageEle));
        driver.findElement(lastPageEle).click();
        return new LastPage(driver);
    }
}
