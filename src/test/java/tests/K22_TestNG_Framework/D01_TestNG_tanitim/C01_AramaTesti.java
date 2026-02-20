package tests.K22_TestNG_Framework.D01_TestNG_tanitim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_AramaTesti {

    @Test
    public void test01() throws InterruptedException {
        //bir test class oluştur ilgil ayarları yap
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://wwww.testotomasyonu.com adresine git
        driver.get("https://www.testotomasyonu.com");

        //urun arama kutusunu locate et
        WebElement searchBox = driver.findElement(By.id("global-search"));

        //arama kutusuna shoe yaz
        searchBox.sendKeys("shoe");

        //arama islemini yapabilmek icin ENTER tusuna bas
        searchBox.submit();

        Thread.sleep(2000);
        driver.quit();
    }
}
