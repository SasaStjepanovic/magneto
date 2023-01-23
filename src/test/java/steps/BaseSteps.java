package steps;


import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.*;
import pages.components.HeaderComponent;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    CreateAccountPage cap = new CreateAccountPage(driver);
    String randomFirstName;
    String randomLastName;
    String randomEmail;

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        openMagnetoApp(env);
        randomFirstName = cap.randomFirstName();
        randomLastName = cap.randomLastName();
        randomEmail = cap.randomEmail();
    }
    @After
    public void tearDown() throws IOException {
        quit();
    }

    @Given("I am logged in {string} AND {string}")
    public void iAmLoggedInAND(String email, String password) {
        new HeaderComponent(driver).loginButton();
    }

    @Given("a user reads test data from {string} {string} by id {string}")
    public void aUserReadsTestDataFromById(String fileName, String sheetName, String id) throws Exception {
        data = new ExcelSupport().getDataByID(fileName, sheetName, id);
    }

    @And("user clicks create account button")
    public void userClicksCreateAccountButton() {
        new HeaderComponent(driver).createAccountButton();
    }

    @And("user enters account credentials")
    public void userEntersAccountCredentials() throws InterruptedException {
        new CreateAccountPage(driver).createAccount(data.get("firstName"), data.get("lastName"),data.get("email"), data.get("password"),
                data.get("confirmPassword"),data.get("randomTypeYesNo"), randomFirstName, randomLastName, randomEmail);
    }

    @Then("user should verify that account is created")
    public void userShouldVerifyThatAccountIsCreated() throws InterruptedException {
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.verifyAccountCrated(data.get("accountRegistered"));
        cap.verifyAcountInformation(randomFirstName, randomLastName,randomEmail);
    }

    @Then("user should verify that field is an invalid")
    public void userShouldVerifyThatFieldIsAnInvalid() throws Exception {
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.verifyInvalidAccountMessages(data.get("field"),data.get("invalidMessageCreateAccount"));
    }

    @And("user clicks sign in button")
    public void userClicksSignInButton() {
        new HeaderComponent(driver).loginButton();
    }

    @And("user enters account credentials for login")
    public void userEntersAccountCredentialsForLogin() {
        new LoginPage(driver).login(data.get("password"),data.get("email"));
    }

    @Then("user should verify that login is successfully")
    public void userShouldVerifyThatLoginIsSuccessfully() throws InterruptedException {
        new BasePage(driver).checkUrlPage(data.get("urlBasePage"));
    }

    @Then("user should verify that login field is an invalid")
    public void userShouldVerifyThatLoginFieldIsAnInvalid() throws Exception {
        new LoginPage(driver).verifyInvalidLoginMessages(data.get("field"),data.get("invalidMessageCreateAccount"),data.get("invalidMessageCreateAccount2"));
    }

    @And("user clicks shoping cart button")
    public void userClicksShopingCartButton() {
        GeneralPage gp = new GeneralPage(driver);
        gp.miniCartButton();
        gp.shopingCartIsEmpty(data.get("emptyCartMessage"));
    }

    @Then("user should verify that shopping cart is empty")
    public void userShouldVerifyThatShoppingCartIsEmpty() {
        GeneralPage gp = new GeneralPage(driver);
        gp.shopingCartIsEmpty(data.get("emptyCartMessage"));
    }

    @Then("user click menu shoping items and verify them")
    public void userClickMenuShopingItemsAndVerifyThem() throws InterruptedException {
        String[] menuItems = {"What's New","Women","Men","Gear","Training","Sale"};
        GeneralPage gp = new GeneralPage(driver);
        gp.goThroughMenuItems(menuItems);
    }

    @And("user enters menu item")
    public void userEntersMenuItem() {
        WomanPage wp = new WomanPage(driver);
        wp.enterMenuItem(data.get("menuItemTitle1"));
    }

    @Then("user should be verify menu item page")
    public void userShouldBeVerifyMenuItemPage() throws InterruptedException {
        WhatsNewPage wp = new WhatsNewPage(driver);
        wp.verify1stMenuPageTitles(data.get("menuItemTitle1"),data.get("menuItemTitle2"),data.get("menuItemTitle3"),data.get("menuItemTitle2Sub"),data.get("firstPageYesNo"));
    }

    @And("user enters first menu item")
    public void userEntersFirstMenuItem() {
        WhatsNewPage wp = new WhatsNewPage(driver);
        wp.clickWhatsNewItem();
    }

    @And("user selects womens mens product")
    public void userSelectsWomensMensProduct() {
        WhatsNewPage wp = new WhatsNewPage(driver);
        wp.selectWomensMensProduct(data.get("product"),data.get("productType"));
    }

    @Then("user should verify next page title")
    public void userShouldVerifyNextPageTitle() throws InterruptedException {
        WhatsNewPage wp = new WhatsNewPage(driver);
        wp.verify1stMenuPageTitles(data.get("menuItemTitle1"),data.get("menuItemTitle2"),data.get("menuItemTitle3"),data.get("menuItemTitle2Sub"),data.get("firstPageYesNo"));
    }

    @And("user selects tops bottoms product")
    public void userSelectsTopsBottomsProduct() {
        WomanPage wp = new WomanPage(driver);
        wp.selectTopsBootomsProduct(data.get("product"),data.get("productType"));
    }

    @And("user expands menu item over hover option")
    public void userExpandsMenuItemOverHoverOption() throws InterruptedException {
        new GeneralPage(driver).hoverOverMenu(data.get("hoverItem"));
    }

    @And("user expands menu sub item over hover option")
    public void userExpandsMenuSubItemOverHoverOption() throws InterruptedException {
        new GeneralPage(driver).hoverOverSubMenu(data.get("hoverItem"), data.get("hoverSubItem"),data.get("hoverSubSubItem"));
    }

    @Then("user should verify final page title")
    public void userShouldVerifyFinalPageTitle() throws InterruptedException {
        WhatsNewPage wp = new WhatsNewPage(driver);
        wp.verify1stMenuPageTitles(data.get("menuItemTitle1"),data.get("menuItemTitle2"),data.get("menuItemTitle3"),data.get("hoverSubSubItem"),data.get("firstPageYesNo"));
    }
}
