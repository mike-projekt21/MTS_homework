package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    //region Elements
    @FindBy(xpath = "//a[@class='header__button header__button_login']")
    WebElement authBtn;
    //endregion

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //region Actions
    public void startAuth() {
        wait.until(d ->  authBtn.isEnabled() && authBtn.isDisplayed());
        authBtn.click();
    }
    //endregion
}
