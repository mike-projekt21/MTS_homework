package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.time.Duration;
import models.HotelCardModel;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    //region Elements
    private final By openMapBtn = By.xpath("//span[@data-map-trigger-button='1']");
    private final By hotelCardInfo = By.xpath("//div[@class='dccc7e1586']");
    //private final By jumpingMarker  = By.xpath("//div[@style='position: absolute; z-index: 10; left: 156.256px; top: -148.661px; touch-action: pan-x pan-y;']");

    //endregion

    //region Actions
    public SearchPage openMap() {
        $(openMapBtn).shouldBe(Condition.clickable, Duration.ofSeconds(10)).click();
        return this;
    }
    public HotelCardModel getFirstHotelInfo(){
        HotelCardModel hotelCardModel = new HotelCardModel();
        $(hotelCardInfo).shouldBe(Condition.clickable, Duration.ofSeconds(30)).scrollTo();
        hotelCardModel.parser(
                $(hotelCardInfo).find(By.cssSelector("h2")),            //Название
                $(hotelCardInfo).find(By.cssSelector("span")).findAll(By.cssSelector("span")).size(),      //Колличество звёзд
                $(hotelCardInfo).find(By.cssSelector(".a3b8729ab1.d86cee9b25")),     //Рейтинг
                $(hotelCardInfo).find(By.cssSelector(".abf093bdfe.f45d8e4c32.d935416c47")),      //Колличество отзывов
                $(hotelCardInfo).find(By.cssSelector(".f6431b446c.d9e6004b60"))     //Стоимость
        );
        return hotelCardModel;
    }

    public SearchPage clickJumpingMarker(){
        $(hotelCardInfo).hover().click();
        switchTo().window(1);
        //$(jumpingMarker).shouldBe(Condition.exist, Duration.ofSeconds(10)).click();
        return this;
    }
    //endregion
}
/*
    public SearchPage fillHotelCheckboxRate(String starsCount) {
//        $(objectRate).find(By.xpath(String.format(hotelCheckboxRate, starsCount))).click();
        $(By.xpath(String.format(rateInput2, starsCount)))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .scrollTo()
                .click();
        return this;
    }

    public SearchPage checkHotelRating(String rate) {
        $$(ratingHotel).forEach(x -> x.findAll(star).shouldHave(CollectionCondition.size(Integer.parseInt(rate))));
        return this;
    }
 */
