import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public abstract class BaseTest {

    //region Context
    protected static WebDriver driver = new SafariDriver();
    protected static ProjectConfig config;
    //endregion

    //region Actions
    @Before
    public void setUp() {
        initConfig();

        WebDriverManager.safaridriver().setup();
        driver.manage().window().maximize();
        driver.get(config.baseUrl());

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver quit у тебя завершает сессию с браузером, а клоуз просто закрывает вкладку, в данном случае - close - лишнее
//        driver.close();
        driver.quit();
    }
    //endregion

    private void initConfig() {
        config = ConfigFactory.create(ProjectConfig.class);
    }
}
