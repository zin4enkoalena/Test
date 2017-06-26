import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alona on 03/06/2017.
 */


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\zin4e\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://dou.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testJ() throws Exception {
        driver.get(baseUrl + "/");
        //driver.findElement(By.cssSelector("#fp-articles_recent > li > a.link")).click();
        driver.findElement(By.cssSelector("ul.l-articles > li > a.link")).click();
        //driver.wait();
        System.out.println(driver.findElement(By.cssSelector("ul.l-articles > li > a.link")).getText());

    }

    @Test
    public void testCheckDouEvents() throws Exception {
        driver.get(baseUrl + "lenta/articles/dou-projector-dict-uk/");
        List<WebElement> element = driver.findElements(By.className("adv-event-block"));
        assertEquals(10, element.size());
    }

    @Test
    public void testCheckDouNames() throws Exception {
        driver.get(baseUrl + "lenta/articles/dou-projector-dict-uk/");
        List<WebElement> element = driver.findElements(By.className("adv-event-block"));
        for (WebElement item : element) {
            System.out.println(item.findElement(By.className("date")).getText());
        }
    }

    @Test
    public void testCheckNewNames() throws Exception {
        String eventDate;
        List<String> expectedDates = new ArrayList<String>();
        expectedDates.add("29 июня");
        expectedDates.add("14 июля");


        driver.get(baseUrl + "lenta/articles/dou-projector-dict-uk/");
        List<WebElement> element = driver.findElements(By.className("adv-event-block"));
        for (WebElement item : element)
        {
            for (int i = 0; i < expectedDates.size(); i++) {
                eventDate = item.findElement(By.className("date")).getText();
                if (eventDate.contains(expectedDates.get(i))) {
                    System.out.println(eventDate);
                }
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
