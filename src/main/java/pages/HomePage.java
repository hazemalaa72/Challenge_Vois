package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class HomePage  {
    private WebDriver driver;
    private By searchelement=By.id("sb_form_q");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
public void setSeachWord(String seachWord){
    driver.findElement(searchelement).sendKeys(seachWord);
}
public SearchResultsPage searchelementclick(){
        driver.findElement(searchelement).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}