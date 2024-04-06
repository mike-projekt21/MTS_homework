package pages;

import com.codeborne.selenide.Condition;
import models.HotelCardModel;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class HotelPage {
    //private final By hotelTitle = By.xpath("//div[@id='hp_hotel_name']");
    private final By hotelTitle = By.xpath("//div[@data-capla-component-boundary='b-property-web-property-page/PropertyHeaderName']");
    private final By stars = By.xpath("//span[contains(@data-testid, 'rating')]");
    private final By price = By.cssSelector(".prco-valign-middle-helper");
    private final By rating = By.cssSelector(".ac4a7896c7");
    private final By reviewNumber = By.cssSelector(".abf093bdfe.f45d8e4c32.d935416c47");
    public HotelCardModel getHotelInfo(){
        HotelCardModel hotelCardModel = new HotelCardModel();
        hotelCardModel.parser(
                $(hotelTitle).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo().find(By.cssSelector("h2")),            //Название
                $(stars).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo().findAll(By.cssSelector("span")).size(),      //Колличество звёзд
                $(rating).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo(),     //Рейтинг
                $(reviewNumber).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo(),      //Колличество отзывов
                $(price).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo()     //Стоимость
        );
        return hotelCardModel;
    }
}
