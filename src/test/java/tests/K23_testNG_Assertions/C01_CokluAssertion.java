package tests.K23_testNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_CokluAssertion {

    @Test
    public void CokluAssertion(){


        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in testotomasyonu icerdigini test edin
        String urlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(urlIcerik),"url verilen icerige sahip degil");


        // 2- nutella icin arama yapip
        TestOtomasyonuPage  testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys("nutella"+ Keys.ENTER);


        // urun bulunamadigini test edin
//        int actualFoundProductSize = testOtomasyonuPage.foundElementsList.size();
//
//        Assert.assertEquals(actualFoundProductSize,0);
        //bu testi yapmak için liste ürün eklemek için bekliyor

        //Assert.assertEquals(actualBulunanUrunSayisi,0);
        // actual bulunan urun sayisi icin List kullanirsak
        // driver, list'e eklenecek WebElement bulmak icin
        // implicitly wait suresince bekleyecektir

        String actualAramaSonucYazi = testOtomasyonuPage.productSearchResult.getText();

        Assert.assertEquals(actualAramaSonucYazi,ConfigReader.getProperty("toBulunamadiYazisi"));

        //Bu testte süre yarı yarıya azaldı





        // 3- belirlenen arama kelimesi icin arama yapip
        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);

        // urun bulunabildigini test edin
        actualAramaSonucYazi = testOtomasyonuPage.productSearchResult.getText();
        Assert.assertNotEquals(actualAramaSonucYazi,ConfigReader.getProperty("toBulunamadiYazisi"));

        // 4- ilk urunu tiklayip
        testOtomasyonuPage.foundElementsList.get(0).click();

        // urun isminde case sensitive olmadan aranacak kelime bulundugunu test edin
        String expectedIsimIcerik = ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsim = testOtomasyonuPage.firstItemNameTextElement.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsim.contains(expectedIsimIcerik));


        // 5- sayfayi kapatin
                Driver.quitDriver();

    }

}
