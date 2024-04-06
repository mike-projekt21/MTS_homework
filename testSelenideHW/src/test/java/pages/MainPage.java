package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    //region Elements
    private final By searchCityField = By.xpath("//input[@type='search']");
    private final By searchDatesField = By.cssSelector(".xp__dates.xp__group");
    private final String date = "//td[@data-date=%s]";
    private final By findButton = By.xpath("//button[@type='submit']");
    //endregion

    //region Actions
    public MainPage searchCity(String city, String startDate, String endDate) {
        $(searchDatesField)
                .shouldBe(Condition.clickable, Duration.ofSeconds(10))
                .click();
        $(By.xpath(String.format(date, startDate)))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .scrollTo()
                .click();
        $(By.xpath(String.format(date, endDate)))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .scrollTo()
                .click();
        $(searchCityField).sendKeys(city);
        $(findButton).click();
        return this;
    }
    //endregion
}
