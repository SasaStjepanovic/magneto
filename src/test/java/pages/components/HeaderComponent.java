package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='page-header']//*[contains(text(), 'Sign In')]")
    WebElement signInButton;

    @FindBy(xpath = "//header[@class='page-header']//*[contains(text(), 'Create an Account')]")
    WebElement createAccountButton;

    public void loginButton(){
        clickElement(signInButton, "signIn button is pressed");
    }

    public void createAccountButton(){
        clickElement(createAccountButton, "create account button is pressed");
    }
}
