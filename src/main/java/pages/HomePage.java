package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage  {
    private WebDriver driver;
    private By searchele=By.id("sb_form_q");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

public void setSeachWord(String seachWord){
    driver.findElement(searchele).sendKeys(seachWord);
    driver.findElement(searchele).sendKeys(Keys.ENTER);

}

}
