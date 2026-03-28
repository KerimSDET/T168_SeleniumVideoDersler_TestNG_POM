package tests.K26_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class C03_RaporluAlisverisTesti extends TestBaseRapor {

    @Test(groups = "E2E")
    public void AlisverisTesti() {
        extentTest = extentReports.createTest("ALışveriş Testi", "Kullanici seçtiği ürünün sepete eklendiğin test eder");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2- belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("Belirlenmiş ürünü arar");

        //3- Listelenen sonuclardan ilkini tiklayin
        testOtomasyonuPage.foundElementsList.get(0).click();
        extentTest.info("Listelenen ürünlerin ilkini tıklar");

        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String ilkUrunIsmi = testOtomasyonuPage.firstItemNameTextElement.getText();
        testOtomasyonuPage.addToCartButton.click();
        extentTest.info("Sepete ekle linkine tıklar");

        //5- your cart linkine tiklayin
        testOtomasyonuPage.yourCartButton.click();
        extentTest.info("Your cart linkine tıklar");

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testOtomasyonuPage.productTitleInCart.getText();

        Assert.assertEquals(sepettekiUrunIsmi, ilkUrunIsmi);
        extentTest.pass("Kullanici kaydettiği ürün ile spettiki ürün isminin aynı olduğunu test eder");

        //7- sayfayi kapatin
        extentTest.info("Sayfayı kapatır");

    }
}

