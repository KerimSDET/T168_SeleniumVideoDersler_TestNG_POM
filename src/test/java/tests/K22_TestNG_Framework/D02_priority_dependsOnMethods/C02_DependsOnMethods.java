package tests.K22_TestNG_Framework.D02_priority_dependsOnMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C02_DependsOnMethods {

    //3 farkli test methodu olusturup asagidaki gorevleri yapin
    //1-testotomasyonu ana sayfaya gidin urlin testotomasyonu icerdigini test edin
    //2-phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
    //3-ilk urunu tiklayip acilan urun sayfasindaki isimde case sensitive olmadan phone bulundugunu test edin


    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    //3 farkli test methodu olusturup asagidaki gorevleri yapin
    //1-testotomasyonu ana sayfaya gidin urlin testotomasyonu icerdigini test edin
    //2-phone icin arama yapip, arama sonucunda urun bulunabildigini test edin
    //3-ilk urunu tiklayip acilan urun sayfasindaki isimde case sensitive olmadan phone bulundugunu test edin


    @Test (priority = 1)
    public void anasayfaTesti(){

        driver.get("https:www.testotomasyonu.com");

        String expUrlIcerik = "testotomasyonu";
        String ActUrlIcerik = driver.getCurrentUrl();

        Assert.assertTrue(ActUrlIcerik.contains(expUrlIcerik));
    }

    @Test (priority = 2, dependsOnMethods = "anasayfaTesti")
    public void searchBoxTest (){

        WebElement searchBox = driver.findElement(By.id("global-search"));

        searchBox.sendKeys("phone"+ Keys.ENTER);

        List<WebElement> foundedElements = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualSize = foundedElements.size();

        Assert.assertTrue(actualSize > 0);

    }

    @Test (priority = 3,dependsOnMethods = "searchBoxTest")
    public void firstFoundElementTest(){

        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]")).click();

        String expItemInclude = "phone";

        String actItemInclude = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText().toLowerCase();

        Assert.assertTrue(actItemInclude.contains(expItemInclude));

    }


}
