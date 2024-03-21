import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search {
    WebDriver driver;
    //Constructor
    public Search(WebDriver driver) {
        this.driver = driver;


    }
// count results in page
    public List<WebElement> countResultsEle() {

        return driver.findElements(By.cssSelector("div[class=\"tptt\"]"));

    }
    // locate page 2 element
    public By nextPageEle() {

        return (By.cssSelector("a[aria-label=\"Page 2\"]"));

    }
    // locate page 3 element
    public By lastPageEle() {

        return (By.cssSelector("a[aria-label=\"Page 3\"]"));

    }
}
