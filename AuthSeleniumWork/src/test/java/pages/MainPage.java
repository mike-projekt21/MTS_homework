package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage{
    @FindBy(xpath = "//a[@class=\"header__button header__button_login\"]")
    WebElement authButton;
    public MainPage() {
        driver.get(config.baseUrl());
        PageFactory.initElements(driver, this);
    }
    public AuthPage startAuth(){
        authButton.click();
        return new AuthPage();
    }
    public boolean findProfileMenu(){
        return  new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".header__profile"))) != null;
    }
}
