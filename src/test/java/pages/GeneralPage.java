package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class GeneralPage extends BasePage {
    public GeneralPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".minicart-wrapper")
    WebElement miniCart;

    @FindBy(css = ".subtitle.empty")
    WebElement emptyCart;


  public void miniCartButton(){
      clickElement(miniCart, "minicart button is pressed");
  }
  public void shopingCartIsEmpty(String expectedText){
      compareText(emptyCart,expectedText);
  }
  public void goThroughMenuItems(String[] expectedItem) throws InterruptedException {
      List<WebElement> menuItems = driver.findElements(By.xpath("//nav[@class='navigation']/ul/li"));
      for(int i = 0; i < menuItems.size(); i++) {
          String actualItem = driver.findElements(By.xpath("//nav[@class='navigation']/ul/li")).get(i).getText();
          System.out.println("Menu item_"+i+": " + actualItem + " ,is displayed before comparing");
          driver.findElements(By.xpath("//nav[@class='navigation']/ul/li")).get(i).click();
          Thread.sleep(100);
          Assert.assertEquals(actualItem, expectedItem[i]);
          System.out.println("Menu item_"+i+": " + expectedItem + " ,is displayed after comparing");
      }
  }

    public void hoverOverMenu(String hoverItem) throws InterruptedException {
        Actions actions = new Actions(driver);
        pause(5);
        actions.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation']/ul/li//span[text()='"+hoverItem+"']"))).build().perform();
    }

    public void hoverOverSubMenu(String hoverSubItem) throws InterruptedException {
        Actions actions = new Actions(driver);
        pause(5);
        actions.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation']/ul/li//span[text()='"+hoverItem+"']"))).build().perform();
    }

}
