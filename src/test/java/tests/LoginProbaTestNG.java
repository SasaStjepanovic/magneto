package tests;

import com.sun.net.httpserver.Authenticator;
import org.testng.annotations.*;
import pages.BasePage;

public class LoginProbaTestNG extends BaseTest {


    @BeforeTest
    @Parameters({"browser", "wait", "env"})
    public void setup(String browser, String wait, String env) throws Exception {
        init(browser, wait);
        openMagnetoApp(env);
    }

    @AfterTest
    public void tearDown(){
        quit();
    }


    @Test(retryAnalyzer = Authenticator.Retry.class )
    public void provera () {
        BasePage bp = new BasePage(driver);
        String url = "rrerrr";
        bp.checkUrlPage(url);
    }

}
