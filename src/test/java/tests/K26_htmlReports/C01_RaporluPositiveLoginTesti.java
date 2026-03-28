package tests.K26_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {

    @Test
    public void C01_PositiveLoginTesti() {

        extentTest = extentReports.createTest("pozitif login testi",
                "Kullanici gecerli bilgilerle sisteme giris yapabilmeli");


        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        // 2- account linkine basina
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Account Linkine Basar");

        // 3- Kullanici email'i olarak wise@gmail.com girin
        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecerliMail"));
        extentTest.info("Email kutusuna gecerli email yazar");


        // 4- Kullanici sifresi olarak 12345 girin
        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Password kutusuna gecerli sifreyi girer");


        // 5- Login butonuna basarak login olun
        testOtomasyonuPage.loginButton.click();
        extentTest.info("Login butonuna basarak login olur");


        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButton.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");



        // 7- logout olun
        testOtomasyonuPage.logoutButton.click();
        extentTest.info("Logout butonuna basarak sistemden çıkış yapar.");


        // 8- sayfayi kapatin
        extentTest.info("Sayfayi kapatir");



    }

}
