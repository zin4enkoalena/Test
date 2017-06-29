package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.DOUHomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Alona on 29/06/2017.
 */
public class TestPages {

    private DOUHomePage basePage;

    @Before
    public void setUp() throws Exception {
        basePage = new DOUHomePage();
        basePage.BasePage();
    }

    @After
    public void tearDown() throws Exception {
        basePage.tearDown();
    }

    @Test
    public void openHomePage() {
        basePage.open();
    }

    @Test
    public void openFirstURLandPrintTitle() throws Exception {
        basePage.open();
        basePage.goFirstLink();
        System.out.println(basePage.getFirstLinkTitle());
    }

    @Test
    public void printEventList() {
        basePage.open();
        basePage.goFirstLink();
        List<WebElement> list = basePage.getEventList();
        for (WebElement item : list) {
            System.out.println(item.findElement(By.className("date")).getText());
        }
    }

    @Test
    public void printEventListForSpecificDates() {
        List<String> expectedDates = new ArrayList<String>();
        expectedDates.add("3 июля");
        expectedDates.add("14 июля");

        basePage.open();
        basePage.goFirstLink();
        List<WebElement> list = basePage.getEventList();
        for (WebElement item : list) {
            for (int i = 0; i < expectedDates.size(); i++) {
                String eventDate = item.findElement(By.className("date")).getText();
                if (eventDate.contains(expectedDates.get(i))) {
                    System.out.println(eventDate);
                }
            }
        }
    }
}
