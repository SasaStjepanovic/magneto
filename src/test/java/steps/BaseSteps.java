package steps;


import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Reporter;
import pages.CreateAccountPage;
import pages.LoginPage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        openMagnetoApp(env);
    }
    @After
    public void tearDown() throws IOException {
        quit();
    }
    @Given("I am logged in")
    public void iAmLoggedIn() {
        new LoginPage(driver).login();
    }

    @Given("I am logged in {string} AND {string}")
    public void iAmLoggedInAND(String email, String password) {
        new LoginPage(driver).login();
    }

    @Given("a user reads test data from {string} {string} by id {string}")
    public void aUserReadsTestDataFromById(String fileName, String sheetName, String id) throws Exception {
        data = new ExcelSupport().getDataByID(fileName, sheetName, id);
    }

    @And("user clicks create account button")
    public void userClicksCreateAccountButton() {
        new CreateAccountPage(driver).createAccountButton();
    }
}
