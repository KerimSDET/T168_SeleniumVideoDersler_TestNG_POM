package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C01_PageClassKullanimi {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin


    @Test (priority=1)
    public void homePageTest(){
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        String expUrlInc = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expUrlInc));

    }

    @Test (dependsOnMethods = "homePageTest")
    public void phoneSearchTest(){
        //phone icin arama yap
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys("phone"+ Keys.ENTER);

        //urun bulundugnu test et
        int actFoundProducts = testOtomasyonuPage.foundElementsList.size();

        Assert.assertTrue(actFoundProducts > 0);

    }

    @Test (dependsOnMethods = "phoneSearchTest")
    public void firstItemTextTest(){

        //ilk urunu tikla
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.foundElementsList.get(0).click();


        //urun isminde cs olmadan phone oldugunu test et

        String expProductNameText = "phone";
        String actProductName = testOtomasyonuPage.firstItemNameTextElement.getText().toLowerCase();

        Assert.assertTrue(actProductName.contains(expProductNameText));

        Driver.quitDriver();
    }
}
