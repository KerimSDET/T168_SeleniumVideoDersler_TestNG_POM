package tests.K22_TestNG_Framework.D04_pageClassKullanimi;


import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_FacebookTesti {


    @Test
    public void FacebookTest(){

        //    https://www.facebook.com adresine git
        Driver.getDriver().get("https://www.facebook.com");

        // Cookies cikiyorsa kabul edin
        FacebookPage facebookPage = new FacebookPage();
        //facebookPage.allowAllCookies.click();


        // POM'a uygun olarak email, sifre kutularini ve giris yap butonunu locate et

        //Faker classini kullanarak email, sifre degerlerini yazdirip giris butonuna bas
        Faker  faker = new Faker();
        facebookPage.loginEmailBox.sendKeys(faker.internet().emailAddress());
        facebookPage.loginPassBox.sendKeys(faker.internet().password());
        facebookPage.loginSubmitButton.click();


        //basarili giris yapilmadigini test edin
        ReusableMethods.bekle(1);

        Assert.assertTrue(facebookPage.loginEmailBox.isDisplayed());

        Driver.quitDriver();

    }

}
