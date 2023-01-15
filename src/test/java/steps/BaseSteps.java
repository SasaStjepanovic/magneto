package steps;


import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.CreateAccountPage;
import pages.LoginPage;
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
//        quit();
    }
    @Given("I am logged in")
    public void iAmLoggedIn() {
        new LoginPage(driver).login();
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
        new CreateAccountPage(driver).createAccount(data.get("firstName"), data.get("lastName"),data.get("email"), data.get("password"),data.get("confirmPassword"),data.get("randomTypeYesNo"), randomFirstName, randomLastName, randomEmail);
    }

    @Then("user should verify that account is created")
    public void userShouldVerifyThatAccountIsCreated() throws InterruptedException {
        CreateAccountPage cap = new CreateAccountPage(driver);
        cap.verifyAccountCrated(data.get("accountRegistered"));
        cap.verifyAcountInformation(randomFirstName, randomLastName,randomEmail);
    }
}
