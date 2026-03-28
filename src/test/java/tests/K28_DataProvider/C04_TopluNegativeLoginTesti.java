package tests.K28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_TopluNegativeLoginTesti {


    @DataProvider
    public static Object[][] TestDataProvideri() {
        String[][] kullanıciBilgileriArr = {
                {"anil@hotmail.com","13579"},
                {"ceren@gmail.com","24680"},
                {"cansu@yahoo.com","asdfgh"}
        };

        return kullanıciBilgileriArr;
    }

    // testotomasyonu anasayyafa gider
    // account linkine tıklar
    // aşağıda verilen email ve şifreleri sırayla yazar
    // login butonuna basar
    // login olup olmadığını test eder
    // anil@hotmail.com 13579, ceren@gmail.com 24680, cansu@yahoo.com asdfgh .


    // anil@hotmail.com 13579, ceren@gmail.com 24680, cansu@yahoo.com asdfgh .


    @Test (dataProvider = "TestDataProvideri")
    public void negatifLoginTesti (String verilenEmail, String verilenSifre){

        // testotomasyonu anasayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine tıklar
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        // aşağıda verilen email ve şifreleri sırayla yazar
        testOtomasyonuPage.loginSayfasiEmailKutusu.sendKeys(verilenEmail);
        testOtomasyonuPage.loginPasswordTextBox.sendKeys(verilenSifre);

        // login butonuna basar
        testOtomasyonuPage.loginSayfasiSubmitButonu.click();

        // login olup olmadığını test eder
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(testOtomasyonuPage.loginSayfasiEmailKutusu.isDisplayed());

        softAssert.assertAll();


    }


}
