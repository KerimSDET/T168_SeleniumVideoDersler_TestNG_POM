package tests.K22_TestNG_Framework.D06_DriverClassiDinamikYapma;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_AlisverisTesti {

    @Test (groups = "E2E")
    public void AlisverisTesti(){


        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testOtomasyonuPage.foundElementsList.get(0).click();

        //4- urun ismini kaydedin ve urunu sepete ekleyin
        String ilkUrunIsmi = testOtomasyonuPage.firstItemNameTextElement.getText();
        testOtomasyonuPage.addToCartButton.click();

        //5- your cart linkine tiklayin
        testOtomasyonuPage.yourCartButton.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testOtomasyonuPage.productTitleInCart.getText();

        Assert.assertEquals(sepettekiUrunIsmi, ilkUrunIsmi);

        //7- sayfayi kapatin

        Driver.getDriver();
    }
}
