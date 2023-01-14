package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginProbaTestNG extends BaseTest {

    @Test
    @BeforeMethod
    @Parameters({"browser", "wait", "env"})
    public void setup(String browser, String wait, String env) throws Exception {
        init(browser, wait);
        openMagnetoApp(env);
    }

}
