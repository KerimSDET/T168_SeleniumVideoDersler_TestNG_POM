package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

//    @FindBy (xpath = "(//span[.='Allow all cookies'])[3]")
//    public WebElement allowAllCookies;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement loginPassBox;

    @FindBy (xpath = "//*[@role='button']")
    public WebElement loginSubmitButton;




}
