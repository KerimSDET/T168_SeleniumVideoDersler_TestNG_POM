package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

    public TestOtomasyonuPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@*='prod-img']")
    public List<WebElement> foundElementsList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement firstItemNameTextElement;

    @FindBy(xpath = ("(//select[@class='form-control'])[1]"))
    public WebElement getKayitFormGun;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement getKayitFromAy;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement getKayitFromYil;

    @FindBy(xpath = "(//div/span/img)[1]")
    public WebElement accountLink;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement loginPasswordTextBox;

    @FindBy(xpath = "//*[@id='submitlogin']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//span[.='Your Cart'])[1]")
    public WebElement yourCartButton;

    @FindBy(xpath = "//a[@class='product-title text-center']")
    public WebElement productTitleInCart;

    @FindBy(xpath = "//*[@*='product-count-text']")
    public WebElement productSearchResult;

    @FindBy(id = "global-search")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//*[@*='prod-img']")
    public List<WebElement> bulunanUrunElementleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement ilkUrunSayfasindakiIsimElementi;

    @FindBy(xpath = "(//span[.='Account'])[1]")
    public WebElement accountLinki;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement loginSayfasiEmailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement loginSayfasiPasswordKutusu;

    @FindBy(id = "submitlogin")
    public WebElement loginSayfasiSubmitButonu;

    @FindBy(xpath = "//span[.='Logout']")
    public WebElement logoutButonu;

    @FindBy(xpath = "//button[@class='add-to-cart']")
    public WebElement addToCartButonu;

    @FindBy(xpath = "(//span[.='Your Cart'])[1]")
    public WebElement yourCartElementi;

    @FindBy(xpath = "//*[@*='product-title text-center']")
    public WebElement sepettekiUrunIsimElementi;

    @FindBy(xpath = "//*[@*='product-count-text']")
    public WebElement aramaSonucElementi;


}