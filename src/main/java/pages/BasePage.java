package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Alona on 29/06/2017.
 */
public class BasePage {
    public static final String baseUrl = "https://dou.ua/";
    WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();

    public void BasePage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\zin4e\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver = driver;
    }

    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}
