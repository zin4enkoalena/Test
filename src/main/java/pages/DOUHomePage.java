package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Alona on 29/06/2017.
 */
public class DOUHomePage extends BasePage {
    public void open() {
        driver.get(baseUrl);
    }

    public void goFirstLink() {
        driver.findElement(By.cssSelector("ul.l-articles > li > a.link")).click();
    }

    public String getFirstLinkTitle () {
        return driver.findElement(By.cssSelector("ul.l-articles > li > a.link")).getText();
    }

    public List<WebElement> getEventList() {
        return driver.findElements(By.className("adv-event-block"));
    }

}
