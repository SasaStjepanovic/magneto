package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='page-header']//*[contains(text(), 'Create an Account')]")
    WebElement createAccountButton;

    public void createAccountButton(){
        clickElement(createAccountButton, "create account button is pressed");
    }
}
