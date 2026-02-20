package tests.K22_TestNG_Framework.D03_DriverClassKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_BasicDriverClassKullanimi {

    @Test
    public void TestNG_Framework_DriverClassKullanimi() {

        Driver.getDriver().get("https://www.wisequarter.com");

        Driver.getDriver().get("https://www.youtube.com");

        //testotomasyonu sayfasina git
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //arama kutusunu locate et
        WebElement searchBox = Driver.getDriver().findElement(By.id("global-search"));

        // phone icin arama yapin

        searchBox.sendKeys("phone"+ Keys.ENTER);

        //sayfayi kapatin

        ReusableMethods.bekle(2);
        Driver.quitDriver();


    }
}
