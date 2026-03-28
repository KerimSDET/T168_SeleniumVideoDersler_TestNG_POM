package tests.K26_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNegativeLoginTesti extends TestBaseRapor {

    TestOtomasyonuPage testOtomasyonuPage;

    @Test (priority = 1)
    public void gecersizPasswordTesti() {

        extentTest = extentReports.createTest("Geçersiz Password Testi", "Kullanici Geçersiz Password Geçerli Email ile Giriş Yapamamalı");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotoasyonu anasayfaya gider");

        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Account linkine tıklar");

        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("Email kutusuna gecerli emaili yazar");

        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna geçersiz şifre yazar");

        testOtomasyonuPage.loginButton.click();
        extentTest.info("Login butonuna basar, login olmayı dener");

        Assert.assertTrue(testOtomasyonuPage.loginButton.isDisplayed());
        extentTest.pass("Başarılı olarak giriş yapamadığını test eder");

    }

    @Test (priority = 2)
    public void gecersizEmailTesti() {
        extentTest = extentReports.createTest("Geçersiz Email Testi", "Kullanici Geçerli Password Geçersiz Email ile Giriş Yapamamalı");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotoasyonu anasayfaya gider");

        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Account linkine tıklar");

        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("Email kutusuna gecersiz emaili yazar");

        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna geçerli şifre yazar");

        testOtomasyonuPage.loginButton.click();
        extentTest.info("Login butonuna basar, login olmayı dener");

        Assert.assertTrue(testOtomasyonuPage.loginButton.isDisplayed());
        extentTest.pass("Başarılı olarak giriş yapamadığını test eder");

    }

    @Test (priority = 3)
    public void gecersizEmailGecersizPasswordTesti() {
        extentTest = extentReports.createTest("Geçersiz Email & Password Testi", "Kullanıcı hatalı bilgilerle giriş yapamamalı");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotoasyonu anasayfaya gider");

        testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Account linkine tıklar");

        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecersizMail"));
        extentTest.info("Email kutusuna gecersiz emaili yazar");

        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Password kutusuna geçersiz şifre yazar");

        testOtomasyonuPage.loginButton.click();
        extentTest.info("Login butonuna basar, login olmayı dener");

        Assert.assertTrue(testOtomasyonuPage.loginButton.isDisplayed());
        extentTest.pass("Başarılı olarak giriş yapamadığını test eder");

    }


}

