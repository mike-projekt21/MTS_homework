package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    //region Context
    public WebDriver driver;
    public WebDriverWait wait;
    //endregion

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        synchronized (AbstractPage.class) {
            PageFactory.initElements(driver, this);
        }
    }

    public static <T extends AbstractPage> T createPage(Class<T> pageClass, WebDriver driver) {
        try {
            T page = pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create page instance");
        }
    }
}
