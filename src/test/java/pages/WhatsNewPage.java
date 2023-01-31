package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WhatsNewPage extends BasePage {
    public WhatsNewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#page-title-heading")
    WebElement menuPageTitle1;
    @FindBy(xpath = "//div[@class='categories-menu']//strong[1]/span")
    WebElement menuPageTitle2;

    @FindBy(xpath = "//div[@class='categories-menu']//strong[2]/span")
    WebElement menuPageTitle3;

    @FindBy(css = ".subtitle.empty")
    WebElement emptyCart;

    @FindBy(xpath = "//nav[@class='navigation']//ul//li[2]")
    WebElement emptyCart2;

    @FindBy(xpath = "//nav[@class='navigation']/ul/li[1]")
    WebElement menuItem1;


    public void clickWhatsNewItem(){
        clickElement(menuItem1, "menuitem1 is entered");
    }

    public void enterMenuItem(String item){
        String path = ("//nav[@class='navigation']/ul/li//span[text()='"+item+"']");
        clickElement(driver.findElement(By.xpath(path)),"Item menu element is entered");
    }

    public void verify1stMenuPageTitles(String expectedText1, String expectedText2, String expectedText3, String menuItemTitle2Sub, String firstPageYesNo) throws InterruptedException {
        if (firstPageYesNo.equalsIgnoreCase("yes")) {
            comparePartOfText(menuPageTitle1, expectedText1);
            compareText(menuPageTitle2, expectedText2);
            compareText(menuPageTitle3, expectedText3);
        } else {
            comparePartOfText(menuPageTitle1, menuItemTitle2Sub);
        }
    }

    public void selectWomensMensProduct(String item, String productType) {
        if (productType.equalsIgnoreCase("women")) {
            String path = ("//div[@class='categories-menu']//ul[1]//a[text()='" + item + "']");
            clickElement(driver.findElement(By.xpath(path)), "Product WOMEN item is selected");
        } else {
            String path = ("//div[@class='categories-menu']//ul[2]//a[text()='" + item + "']");
            clickElement(driver.findElement(By.xpath(path)), "Product MEN item is selected");
        }
    }
  }

