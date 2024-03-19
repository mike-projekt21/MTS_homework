package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AuthPage extends BasePage{

    @FindBy(xpath = "//input[@type = \"email\"]")
    WebElement inputLogin;
    @FindBy(xpath = "//input[@type = \"password\"]")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement authButton;
    public AuthPage() {
        PageFactory.initElements(driver, this);
    }
    public AuthPage auth(){
        inputLogin.sendKeys(config.login());
        inputPassword.sendKeys(config.password());
        authButton.click();
        return this;
    }
    public String getAuthPopUpClass() {
        WebElement popUpGood = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, \"popup_visible\")]"))));
        return popUpGood.getAttribute("class");
    }
    public MainPage finishAuth(){
        WebElement popUpGood = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, \"popup_visible\")]"))));
        driver.findElement(By.cssSelector(".popup__close.btn.btn_small")).click();
        return new MainPage();
    }


}
