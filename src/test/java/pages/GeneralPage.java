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

    @FindBy(xpath = "//div[@class='filter-current']//span[@class='filter-label']")
    WebElement filterCategory;

    @FindBy(xpath = "//div[@class='filter-current']//span[@class='filter-value']")
    WebElement filterCategoryUnderItem;

    @FindBy(xpath = "//span[text()='Clear All']")
    WebElement clearAllButton;

    @FindBy(xpath = "//*[@class='action remove']")
    WebElement clearXbutton;

    @FindBy(xpath = "//div[@class='filter-current']//li")
    WebElement filterContainerItems;


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

    public void clickOnCategory(String category){
      WebElement webElCategory = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='"+category+"']"));
      clickElement(webElCategory,"category is choosed: " + category+ ".");
    }

    public void clickOnCategoryUnderItem(String category, String categoryItem1){
        try {
            WebElement webElCategory1 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='"+category+"']/..//div[@class='filter-options-content']//a[contains(text(),'"+categoryItem1+"')]"));
            clickElement(webElCategory1, "category sub item is choosed: " + categoryItem1 + ".");
        } catch (Exception e){
            try {
                WebElement webElCategory2 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category + "']/..//div[@class='filter-options-content']//a[contains(@aria-label,'" + categoryItem1 + "')]"));
                clickElement(webElCategory2, "category sub item is choosed: " + categoryItem1 + ".");
            }catch (Exception m){
                WebElement webElCategory3 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category + "']/..//div[@class='filter-options-content']//div[contains(@option-label,'" + categoryItem1 + "')]"));
                clickElement(webElCategory3, "category sub item is choosed: " + categoryItem1 + ".");
            }
        }
    }

//    public void clickOnMultipleCategoryUnderItem(String category, String categoryItem1, String categoryItem2){
//        try {
//            WebElement webElCategory1 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='"+category+"']/..//div[@class='filter-options-content']//a[contains(text(),'"+categoryItem1+"')]"));
//            clickElement(webElCategory1, "category sub item is choosed: " + categoryItem1 + ".");
//            clickElement(webElCategory1, "category sub item is choosed: " + categoryItem2 + ".");
//        } catch (Exception e){
//            try {
//                WebElement webElCategory2 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category + "']/..//div[@class='filter-options-content']//a[contains(@aria-label,'" + categoryItem1 + "')]"));
//                clickElement(webElCategory2, "category sub item is choosed: " + categoryItem1 + ".");
//                clickElement(webElCategory2, "category sub item is choosed: " + categoryItem2 + ".");
//            }catch (Exception m){
//                WebElement webElCategory3 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category + "']/..//div[@class='filter-options-content']//div[contains(@option-label,'" + categoryItem1 + "')]"));
//                clickElement(webElCategory3, "category sub item is choosed: " + categoryItem1 + ".");
//                clickElement(webElCategory3, "category sub item is choosed: " + categoryItem2 + ".");
//
//            }
//        }
//    }
    public void verifyFilteredValues(String categoryName, String categoryUnderItemName){
        compareText(filterCategory, categoryName);
        compareText(filterCategoryUnderItem, categoryUnderItemName);
    }

    public void clearAllButton(){
      clickElement(clearAllButton, "clear all button is pressed");
    }

    public void clearOneByOne() {
      boolean listItems = driver.findElements(By.xpath("//div[@class='filter-current']//li")).size()>0;
        if (listItems) {
            System.out.println("filter vidljiv i uradi brisanje elemenata dok je viljiv x buttoncic");
            List<WebElement> listOfItems = driver.findElements(By.xpath("//div[@class='filter-current']//li"));
            for (int i = 0; i < listOfItems.size(); i++){
                clickElement(clearXbutton, "x button for clear is pressed");
            }
        } else {
            System.out.println("filter nije vidljiv");
        }
    }

    public void verifyButtonInvisibility(){
        explicitWaitInvisibilityOfElement(clearAllButton);
        System.out.println("Element is not more visible");
    }

}
