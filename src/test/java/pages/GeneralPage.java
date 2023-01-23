package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        pause(1);
        actions.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation']/ul/li//span[text()='"+hoverItem+"']"))).build().perform();
        pause(1);
    }
    public void hoverOverSubMenu(String hoverItem, String hoverSubItem, String hoverSubSubItem) throws InterruptedException {
        Actions actions = new Actions(driver);
        pause(1);
        if (hoverItem.equalsIgnoreCase("Women") || hoverItem.equalsIgnoreCase("Men")) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement el1 = driver.findElement(By.xpath("//nav[@class='navigation']/ul/li//span[text()='" + hoverItem + "']/../../ul//span[text()='" + hoverSubItem + "']/../../ul//span[text()='"+ hoverSubSubItem +"']"));
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('on mouseover');}";
            js.executeScript(mouseOverScript,el1);
            clickElementJS(el1, "sub sub menu element:" +hoverItem + "," + hoverSubItem + "," + hoverSubSubItem+ " is clicked");

        } else {
            WebElement el2 = driver.findElement(By.xpath("//nav[@class='navigation']/ul/li//span[text()='" + hoverItem + "']/../../ul//span[text()='" + hoverSubItem + "']"));
            actions.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation']/ul/li//span[text()='" + hoverItem + "']/../../ul//span[text()='" + hoverSubItem + "']"))).build().perform();
            clickElementJS(el2, "sub menu element:" + hoverItem + "," + hoverSubItem + " is clicked");
        }
    }


}
