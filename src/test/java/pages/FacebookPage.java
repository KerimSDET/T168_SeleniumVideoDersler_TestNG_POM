package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "(//span[.='Allow all cookies'])[3]")
    public WebElement allowAllCookies;

    @FindBy (xpath = "//*[@id='email']")
    public WebElement loginEmailBox;

    @FindBy (xpath = "//*[@id='pass']")
    public WebElement loginPassBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginSubmitButton;
}
