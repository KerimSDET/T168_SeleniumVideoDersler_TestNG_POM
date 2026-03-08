package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C04_PositiveLoginTesti {

    @Test (groups = "E2E")
    public void c04_PositiveLoginTesti() {

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        // 3- Kullanici email'i olarak wise@gmail.com girin
        testOtomasyonuPage.emailTextBox.sendKeys("wise@gmail.com");


        // 4- Kullanici sifresi olarak 12345 girin
        testOtomasyonuPage.loginPasswordTextBox.sendKeys("12345");

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
