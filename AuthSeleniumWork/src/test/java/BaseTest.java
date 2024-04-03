import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public abstract class BaseTest {

    //region Context
    protected static WebDriver driver = new SafariDriver();
    protected static ProjectConfig config;
    //endregion

    //region Actions
    @BeforeClass
    public static void setUp() {
        initConfig();

        WebDriverManager.safaridriver().setup();
        driver.manage().window().maximize();
        driver.get(config.baseUrl());

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    //endregion

    private static void initConfig() {
        config = ConfigFactory.create(ProjectConfig.class);
    }
}
