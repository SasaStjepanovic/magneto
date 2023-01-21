package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='box box-information']//div")
    WebElement accountInformation;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(xpath = "//div[@id='email-error']")
    WebElement emailMessage;

    @FindBy(xpath = "//*[contains(text(),'The account sign-in was incorrect')]")
    WebElement bothMessage1;

    @FindBy(xpath = "//*[contains(text(),'Incorrect CAPTCHA')]")
    WebElement bothMessage2;

    @FindBy(xpath = "//input[@name='login[password]']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id='pass-error']")
    WebElement passwordMessage;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//button//span")
    WebElement signInButton;

    public void signInButton(){
    clickElement(signInButton, "signIn button is pressed");
    }

    public void login(String password, String email){
        typeText(emailField, email,"email is entered");
        typeText(passwordField, password,"password is entered");
        signInButton();
    }
    public void verifyLoginInformation(String firstName, String lastName, String email) throws InterruptedException {
        comparePartOfText(accountInformation, firstName);
        comparePartOfText(accountInformation, lastName);
        comparePartOfText(accountInformation, email);
    }

    public void verifyInvalidLoginMessages(String field, String expectedText, String expectedText2) throws Exception {
        switch (field.toUpperCase()) {
            case "EMAIL": {
                compareText(emailMessage, expectedText);
            }
            break;
            case "PASSWORD": {
                compareText(passwordMessage, expectedText);
            }
            break;
            case "BOTH": {

                try {
                    compareText(bothMessage1, expectedText);
                } catch (Exception e) {
                    compareText(bothMessage2, expectedText2);
                }
            }
            break;
            default:
                throw new Exception("No such field: " + field);

        }
    }
}
