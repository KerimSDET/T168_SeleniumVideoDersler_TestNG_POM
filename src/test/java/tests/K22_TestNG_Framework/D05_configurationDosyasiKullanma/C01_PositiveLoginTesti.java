package tests.K22_TestNG_Framework.D05_configurationDosyasiKullanma;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PositiveLoginTesti {

    @Test
    public void C01_PositiveLoginTesti() {


        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

       // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        // 3- Kullanici email'i olarak wise@gmail.com girin
        testOtomasyonuPage.emailTextBox.sendKeys(ConfigReader.getProperty("toGecerliMail"));


        // 4- Kullanici sifresi olarak 12345 girin
        testOtomasyonuPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("toGecerliPassword"));


        // 5- Login butonuna basarak login olun
        testOtomasyonuPage.loginButton.click();


        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutButton.isDisplayed());



        // 7- logout olun
        testOtomasyonuPage.logoutButton.click();


        // 8- sayfayi kapatin

        Driver.quitDriver();



    }
}
