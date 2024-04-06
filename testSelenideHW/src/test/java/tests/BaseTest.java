package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class BaseTest {

    //region Context
    protected static ProjectConfig CONFIG;
    //endregion

    //region Actions
    @BeforeClass
    public static void setUp() {
        initConfig();

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Selenide.open(CONFIG.baseUrl());
    }

    @AfterClass
    public static void turnDown() {
        Selenide.closeWebDriver();
    }
    //endregion

    private static void initConfig() {
        CONFIG = ConfigFactory.create(ProjectConfig.class);
    }
}
