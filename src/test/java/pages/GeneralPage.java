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

    @FindBy(xpath = "//input[@id='search']")
    WebElement seacrh;
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

    @FindBy(xpath = "//div[@id='search_autocomplete']/ul/li[3]")
    WebElement dropDownMenuItem;

    @FindBy(xpath = "//main[@id='maincontent']//span")
    WebElement seacxrhedDropItem;

    public void searchMain (String text){
        typeText(seacrh, text,  " text is entered in the search field");
//        clickElement(seacrh, "");
    }

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

    public void clickOnCategoryUnderItem1(String category1, String categoryItem1){
        try {
            WebElement webElCategory1 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='"+category1+"']/..//div[@class='filter-options-content']//a[contains(text(),'"+categoryItem1+"')]"));
            clickElement(webElCategory1, "category sub itemFirst is choosed: " + categoryItem1 + ".");
        } catch (Exception e){
            try {
                WebElement webElCategory2 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category1 + "']/..//div[@class='filter-options-content']//a[contains(@aria-label,'" + categoryItem1 + "')]"));
                clickElement(webElCategory2, "category sub itemFirst is choosed: " + categoryItem1 + ".");
            }catch (Exception m){
                WebElement webElCategory3 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category1 + "']/..//div[@class='filter-options-content']//div[contains(@option-label,'" + categoryItem1 + "')]"));
                clickElement(webElCategory3, "category sub itemFirst is choosed: " + categoryItem1 + ".");
            }

        }
    }

    public void clickOnCategoryUnderItem2(String category2, String categoryItem2){
        try {
            WebElement webElCategory1 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='"+category2+"']/..//div[@class='filter-options-content']//a[contains(text(),'"+categoryItem2+"')]"));
            clickElement(webElCategory1, "category sub itemSecond is choosed: " + categoryItem2 + ".");
        } catch (Exception e){
            try {
                WebElement webElCategory2 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category2 + "']/..//div[@class='filter-options-content']//a[contains(@aria-label,'" + categoryItem2 + "')]"));
                clickElement(webElCategory2, "category sub itemSecond is choosed: " + categoryItem2 + ".");
            }catch (Exception m){
                WebElement webElCategory3 = driver.findElement(By.xpath("//div[@id='narrow-by-list']//div[text()='" + category2 + "']/..//div[@class='filter-options-content']//div[contains(@option-label,'" + categoryItem2 + "')]"));
                clickElement(webElCategory3, "category sub itemSecond is choosed: " + categoryItem2 + ".");
            }

        }
    }

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
            System.out.println("filter is visible and doing deleting elements always when x button is visible");
            List<WebElement> listOfItems = driver.findElements(By.xpath("//div[@class='filter-current']//li"));
            for (int i = 0; i < listOfItems.size(); i++){
                clickElement(clearXbutton, "x button for clear is pressed");
            }
        } else {
            System.out.println("filter is no more visible");
        }
    }

    public void verifyButtonInvisibility(){
        explicitWaitInvisibilityOfElement();
        System.out.println("Element is no more visible");
    }

    public void verifySearchItems(String[] expectedItem1, String[] expectedItem2) throws InterruptedException {
        List<WebElement> searchItems = driver.findElements(By.xpath("//div[@id='search_autocomplete']/ul/li"));
        for(int i = 1; i < searchItems.size(); i++) {
            String actualText = driver.findElements(By.xpath("//div[@id='search_autocomplete']/ul/li['"+i+"']//span[1]")).get(i).getText();
            System.out.println("Search name item_"+i+": " + actualText + " ,is displayed before comparing");
            String actualNumber = driver.findElements(By.xpath("//div[@id='search_autocomplete']/ul/li['"+i+"']//span[2]")).get(i).getText();
            System.out.println("Search number of item_"+i+": " + actualNumber + " ,is displayed before comparing");
            Assert.assertEquals(actualText, expectedItem1[i]);
            Assert.assertEquals(actualNumber, expectedItem2[i]);

        }
    }

    public void clikDropDownMenuItem(String dropDownItem){
        WebElement element = driver.findElement(By.xpath("//div[@id='search_autocomplete']/ul/li/span[text()='"+dropDownItem+"']"));
        clickElement(element, "dropdown menu item is clicked");
    }

    public void verifySearchedItem(String searchedItem){
        compareText(seacxrhedDropItem,searchedItem);
    }

}

