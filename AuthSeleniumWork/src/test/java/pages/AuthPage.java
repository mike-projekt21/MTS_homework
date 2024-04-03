package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public AuthPage(WebDriver driver) {
        super(driver);
    }
    //endregion

    //region Actions
    public AuthPage auth(String login, String password){
        wait.until(d -> loginInput.isDisplayed());

        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        authBtn.click();

        return this;
    }

    public boolean waitHeaderProfile(){
        try {
            return wait.until(d -> header.isDisplayed());
        } catch (TimeoutException e) {
            throw new TimeoutException("Не дождался окна header: " + e);
        }
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
