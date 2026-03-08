package tests.K22_TestNG_Framework.D05_configurationDosyasiKullanma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DinamikNegativeLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin

    TestOtomasyonuPage testOtomasyonuPage;

    @Test
    public void gecersizPasswordTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        testOtomasyonuPage.loginButton.click();
        Assert.assertTrue(testOtomasyonuPage.loginButton.isDisplayed());
        Driver.quitDriver();
    }
    @Test
    public void gecersizEmailTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        testOtomasyonuPage.loginButton.click();
        Assert.assertTrue(testOtomasyonuPage.loginButton.isDisplayed());
        Driver.quitDriver();
    }

    @Test (groups = {"E2E","smoke","regression"})
    public void gecersizEmailGecersizPasswordTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        testOtomasyonuPage.loginButton.click();
        Assert.assertTrue(testOtomasyonuPage.loginButton.isDisplayed());
        Driver.quitDriver();

    }



}
