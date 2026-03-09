package tests.K22_TestNG_Framework.D03_DriverClassKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_DriverClassKullanimi {

    // uc farkli test methodu olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'nin bu kelimeleri icerdisigi test edin
    // ve windowlari kapatin



    @Test
    public void testotomasyonuTest() {
        Driver.getDriver().get("http://www.testotomasyonu.com");

        String expUrlInc = "testotomasyonu";
        String actUrlInc = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actUrlInc.contains(expUrlInc));
        Driver.quitDriver();
    }

    @Test
    public void wisequarterTest() {

        Driver.getDriver().get("http://www.wisequarter.com");

        String expUrlInc = "wisequarter";
        String actUrlInc = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actUrlInc.contains(expUrlInc));
        Driver.quitDriver();

    }

    @Test
    public void bestbuyTest() {

        Driver.getDriver().get("http://www.bestbuy.com");

        String expUrlInc = "bestbuy";
        String actUrlInc = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actUrlInc.contains(expUrlInc));
        Driver.quitDriver();

    }


}
