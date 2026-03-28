package tests.K28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;


public class C02_DataProviderIleTopluAramaTesti {


    @DataProvider
    public static Object[][] aranacakUrunProvideri() {

        String[][] aranacakUrunlerListesi = {
                {"phone"},
                {"java"},
                {"dress"},
                {"baby"},
                {"nutella"},
                {"samsung"},
                {"iphone"},
                {"shirt"}
        };
        return aranacakUrunlerListesi;
    }

@Test(dataProvider = "aranacakUrunProvideri")
public void provideIleTopluAramaTesti(String aranacakUrun) {

    //test otomasyon sayfasına gidin
    //verilen ürünlerin her biri için arama yaptırıp
    // arama sonucunda urun bulunabildigini test edin
    //
    // phone, java,  dress,  baby, nutella, samsung, iphone, shirt.

    //test otomasyon sayfasına gidin
    Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

    SoftAssert softAssert = new SoftAssert();

    //verilen ürünlerin her biri için arama yaptırıp
    testOtomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

    String unexpectedSonucYazisi = ConfigReader.getProperty("toBulunamadiYazisi"); //0 Product Found yazisi
    String actualSonucYazisi = testOtomasyonuPage.aramaSonucElementi.getText();

    softAssert.assertNotEquals(actualSonucYazisi, unexpectedSonucYazisi, aranacakUrun + " için arama sonucu : " + actualSonucYazisi);

    softAssert.assertAll();

    Driver.quitDriver();

}
}

