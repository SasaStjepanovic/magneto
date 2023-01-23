package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WomanPage extends BasePage {
    public WomanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".minicart-wrapper")
    WebElement miniCart;

    @FindBy(css = ".subtitle.empty")
    WebElement emptyCart;

    public void enterMenuItem(String item){
        String path = ("//nav[@class='navigation']/ul/li//span[text()='"+item+"']");
        clickElement(driver.findElement(By.xpath(path)),"Item menu element is entered");
    }

    public void selectTopsBootomsProduct(String item, String productType) {
        if (productType.equalsIgnoreCase("tops")) {
            String path = ("//div[@class='categories-menu']//ul[1]//a[text()='" + item + "']");
            clickElement(driver.findElement(By.xpath(path)), "Product WOMEN item is selected");
        } else {
            String path = ("//div[@class='categories-menu']//ul[2]//a[text()='" + item + "']");
            clickElement(driver.findElement(By.xpath(path)), "Product MEN item is selected");
        }
    }
}
