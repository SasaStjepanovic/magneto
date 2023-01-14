package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='page-header']//*[contains(text(), 'Sign In')]")
    WebElement signInButton;

    public void login(){
    clickElement(signInButton, "signIn button is pressed");
    }
}
