package tests.K23_testNG_Assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v142.css.model.Value;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C03_SoftAssert {

    @Test
    public void test02(){


        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));


        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        String expectedUrl = ConfigReader.getProperty("zeroUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUrl, expectedUrl, "URLs don't match");

        // 3. Sign in butonuna basin
        ZeroPage  zeroPage = new ZeroPage();
        zeroPage.anaSayfaSignInButton.click();

        // 4. Login kutusuna “username” yazin
        zeroPage.loginKutusu.sendKeys("username");

        // 5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");

        // 6. Sign in tusuna basin
        zeroPage.loginPageSignInButton.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2); //bu aşamada zayıf şifre uyarısı gelmekte manuel tamam dersek geçiyor

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroPage.settingsMenu.isDisplayed(), "Settings menu is not displayed");

        // 9. Online banking menusunu tiklayin
        zeroPage.onlineBankingMenu.click();


        //10. Pay Bills sayfasina gidin
        zeroPage.payBills.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseForeignCurrency.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroPage.currencyDdm.isEnabled(), "Currency ddm is not enabled");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select  = new Select(zeroPage.currencyDdm);
        select.selectByValue("EUR");


        //14. "Eurozone (euro)" secildigini dogrulayin
        String actualSelectedCurrency = select.getFirstSelectedOption().getText();

        //softAssert.assertEquals(actualSelectedCurrency, "Eurozone (euro)", "Currencies are not equal");

        softAssert.assertTrue(actualSelectedCurrency.contains("Eurozone (euro)")); //bi öncekinde  de pass aldık

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        List<WebElement> ddmList = select.getOptions();
        softAssert.assertTrue(ddmList.size() == 16, "Currency ddm list is not 16 ");


        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        //bu benim çözümüm

        List<String> ddmValues = new ArrayList<>();
        for (WebElement ddmEach : ddmList) {
            ddmValues.add(ddmEach.getText());
        }
        softAssert.assertTrue(ddmValues.contains("Canada (dollar)"));

        //Bu da Ahmet hocanın çözümü:
        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin

//        List<String > optionYazilariList = ReusableMethods.stringListeDondur(dropdownElementleriList);
//
//        String expectedOption = "Canada (dollar)";
//
//        softAssert.assertTrue(optionYazilariList.contains(expectedOption),"dropdown Canada dolari icermiyor");






        softAssert.assertAll();

        //17. Sayfayi kapatin
        Driver.quitDriver();
    }

}
