import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    WebDriver driver;
//Constructor
    public Home(WebDriver driver) {
        this.driver = driver;


    }
//locate for search element
    public WebElement searchEle() {

        return driver.findElement(By.id("sb_form_q"));

    }
}
