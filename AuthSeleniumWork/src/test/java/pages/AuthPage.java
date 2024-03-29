package pages;

import config.ProjectConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage extends BasePage {

    //region Elements
    @FindBy(xpath = "//input[@type = 'email']")
    WebElement loginInput;

    @FindBy(xpath = "//input[@type = 'password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type= 'submit']")
    WebElement authBtn;

    @FindBy(css = ".header__profile")
    WebElement header;

    @FindBy(xpath = "//div[contains(@class, 'popup_visible')]")
    WebElement popup;

    @FindBy(css = ".popup__close.btn.btn_small")
    WebElement popupCloseBtn;
    //endregion

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    //region Actions
    public AuthPage auth(String login, String password){
        wait.until(d -> loginInput.isDisplayed());

        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        authBtn.click();

        return this;
    }

    public boolean waitHeaderProfile(){
        return wait.until(d -> header.isDisplayed());
    }

    public String getAuthPopUpClass() {
        wait.until(d -> popup.isDisplayed());
        return popup.getAttribute("class");
    }
    public AuthPage finishAuth(){
        wait.until(d -> popup.isDisplayed());
        popupCloseBtn.click();

        return this;
    }
    //endregion
}
