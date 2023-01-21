package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@title='Create an Account']")
    WebElement createAccountButton;

    @FindBy(css = "#firstname")
    WebElement firstNameField;

    @FindBy(css = "#lastname")
    WebElement lastNameField;

    @FindBy(css = "#email_address")
    WebElement emailField;

    @FindBy(css = "input#password")
    WebElement passwordField;

    @FindBy(css = "input#password-confirmation")
    WebElement passwordConfirmField;

    @FindBy(xpath = "//*[contains(text(),'Thank you for registering with Fake Online Clothing Store.')]")
    WebElement accountRegistered;

    @FindBy(xpath = "//div[@class='box box-information']//div")
    WebElement accountInformation;

    @FindBy(css = "#firstname-error")
    WebElement firstNameMessage;

    @FindBy(xpath = "//div[@id='lastname-error']")
    WebElement lastNameMessage;

    @FindBy(xpath = "//div[@id='email_address-error']")
    WebElement emailMessage;

    @FindBy(xpath = "//div[@id='password-error']")
    WebElement passwordMessage;

    @FindBy(xpath = "//div[@id='password-confirmation-error']")
    WebElement passwordConfirmMessage;

    @FindBy(xpath = "//div[@id='password-strength-meter']")
    WebElement strengthPassword;

    public void enterFirstName(String value){
        typeText(firstNameField, value, "first name is entered");
    }

    public void enterLastName(String value){
        typeText(lastNameField, value, "last name is entered");
    }

    public void enterEmail(String value){
        typeText(emailField, value, "email is entered");
    }

    public void enterPassword(String value){
        typeText(passwordField, value, "password is entered");
    }

    public void enterConfirmPassword(String value){
        typeText(passwordConfirmField, value, "confirm password is entered");
    }

    public void createAccountButton(){
        clickElement(createAccountButton, "create account button is pressed");
    }


    public String randomFirstName() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(1, 4999);
        String randomFirstName = "Sasa_" + number;
        System.out.println("Random first name exactly after generate is :" + randomFirstName);
        return randomFirstName;
    }

    public String randomLastName() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(5000, 9999);
        String randomLastName = "Stjepanovic_" + number;
        System.out.println("Random last name exactly after generate is :" + randomLastName);
        return randomLastName;
    }

    public String randomEmail() {
        Faker fakerData = new Faker();
        int number = fakerData.number().numberBetween(5000, 9999);
        String randomEmail = "stjepanovic_" + number + "@magneto.com";
        System.out.println("Random email exactly after generate is :" + randomEmail);
        return randomEmail;
    }

    public void createAccount(String firstName, String lastName, String email, String password, String confirmPassword, String randomTypeYesNo,
                              String randomFirstName, String randomLastName, String randomEmail) throws InterruptedException {
        if (randomTypeYesNo.equalsIgnoreCase("yes")) {
            typeText(firstNameField, randomFirstName, "random first name is entered");
            typeText(lastNameField, randomLastName, "random last name is entered");
            typeText(emailField, randomEmail, "random email is entered");
            enterPassword(password);
            enterConfirmPassword(confirmPassword);
            createAccountButton();
        } else {
            enterFirstName(firstName);
            enterLastName(lastName);
            enterEmail(email);
            enterPassword(password);
            enterConfirmPassword(confirmPassword);
            createAccountButton();
        }
    }
    public void verifyAccountCrated(String expectedText){
        compareText(accountRegistered,expectedText);
    }
    public void verifyAcountInformation(String randomFirstName, String randomLastName, String randomEmail) throws InterruptedException {
        comparePartOfText(accountInformation, randomFirstName);
        comparePartOfText(accountInformation, randomLastName);
        comparePartOfText(accountInformation, randomEmail);
    }

    public void verifyInvalidAccountMessages(String field, String expectedText) throws Exception {
        switch (field.toUpperCase()) {
            case "FIRSTNAME": {
                compareText(firstNameMessage, expectedText);
            }
            break;
            case "LASTNAME": {
                compareText(lastNameMessage, expectedText);
            }
            break;
            case "EMAIL": {
                compareText(emailMessage, expectedText);
            }
            break;
            case "PASSWORD": {
                compareText(passwordMessage, expectedText);
            }
            break;
            case "CONFIRMPASSWORD": {
                compareText(passwordConfirmMessage, expectedText);
            }
            break;
            case "STRENGTHPASSWORD": {
                compareText(strengthPassword, expectedText);
            }
            break;
            default:
                throw new Exception("No such field: " + field);

        }
    }
}
