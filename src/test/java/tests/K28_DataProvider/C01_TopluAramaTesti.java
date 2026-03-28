package tests.K28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_TopluAramaTesti {

    @Test
            public void topluAramaTesti () {

        //test otomasyon sayfasına gidin
        //verilen ürünlerin her biri için arama yaptırıp
        // arama sonucunda urun bulunabildigini test edin
        //
        // phone, java,  dress,  baby, nutella, samsung, iphone, shirt.

        List<String> aranacakUrunlerListesi = new ArrayList<>(Arrays.asList("phone", "java", "dress", "baby", "nutella", "samsung", "iphone", "shirt"));

        //test otomasyon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        //verilen ürünlerin her biri için arama yaptırıp
        for (String eachUrun : aranacakUrunlerListesi) {

            testOtomasyonuPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);

            String unexpectedSonucYazisi = ConfigReader.getProperty("toBulunamadiYazisi"); //0 Product Found yazisi
            String actualSonucYazisi = testOtomasyonuPage.aramaSonucElementi.getText();

            softAssert.assertNotEquals(actualSonucYazisi,unexpectedSonucYazisi, eachUrun +" için arama sonucu : " + actualSonucYazisi);
        }
        softAssert.assertAll();

        Driver.quitDriver();
        
        
        // arama sonucunda urun bulunabildigini test edin
    }

}
