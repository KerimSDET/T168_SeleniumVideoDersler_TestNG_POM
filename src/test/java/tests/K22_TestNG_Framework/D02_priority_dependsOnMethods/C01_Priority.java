package tests.K22_TestNG_Framework.D02_priority_dependsOnMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {

    //uc farkli test method'u olustur
    // testotomasyonu wisequarter ve bestbuy sitelerine git
    // url'nin testotomasyonu wisequarter ve bestbuy kelimerini icerdigini test et
    // ve windowlari kapat.

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test (priority = -1)
    public  void testotomasyonuTest() throws InterruptedException {

        driver.get("https://www.testotomasyonu.com");

        String expUrlIcerik = "testotomasyonu";
        String actUrlIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actUrlIcerik.contains(expUrlIcerik));
        Thread.sleep(1000);
    }

    @Test (priority = 12) //default 0
    public  void wisequarterTest() throws InterruptedException {
        driver.get("https://www.wisequarter.com");

        String expUrlIcerik = "wisequarter";
        String actUrlIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actUrlIcerik.contains(expUrlIcerik));
        Thread.sleep(1000);
    }

    @Test //(priority = 3)
    public  void bestBuyTest() throws InterruptedException {
        driver.get("https://www.bestbuy.com");

        String expUrlIcerik = "bestbuy";
        String actUrlIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actUrlIcerik.contains(expUrlIcerik));
        Thread.sleep(1000);
    }
}
