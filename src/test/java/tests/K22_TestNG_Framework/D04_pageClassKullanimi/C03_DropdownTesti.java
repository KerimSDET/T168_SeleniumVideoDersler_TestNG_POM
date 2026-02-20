package tests.K22_TestNG_Framework.D04_pageClassKullanimi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C03_DropdownTesti {

    @Test
    public void dropdowntesti(){

        //● https://testotomasyonu.com/form adresine gidin.
        Driver.getDriver().get("https://testotomasyonu.com/form");

        TestOtomasyonuPage  testOtomasyonuPage = new TestOtomasyonuPage();

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        Select selectGun = new Select(testOtomasyonuPage.getKayitFormGun);

        selectGun.selectByIndex(5);

        //3. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testOtomasyonuPage.getKayitFromAy);

        selectAy.selectByValue("nisan"); //Nisan yazdığımda hata verdi cunku value nisan Text Nisan Dikkat!!

        //4. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testOtomasyonuPage.getKayitFromYil);
        selectYil.selectByVisibleText("1990");

        //5. Secilen değerleri konsolda yazdirin

        System.out.println("Secilen Gun : "+selectGun.getFirstSelectedOption().getText());
        System.out.println("Secilen Ay : "+selectAy.getFirstSelectedOption().getText());
        System.out.println("Secilen Yil : "+selectYil.getFirstSelectedOption().getText());

        //6. Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> ayDropdownMenuList = selectAy.getOptions();
        System.out.println(ReusableMethods.stringListeDondur(ayDropdownMenuList));

        //7. listedeki opsiyonlarda Mart degeri oldugunu test edin


        Assert.assertTrue(ReusableMethods.stringListeDondur(ayDropdownMenuList).contains("Mart"));

        //8. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(13,ayDropdownMenuList.size());



        Driver.quitDriver();


    }

}
