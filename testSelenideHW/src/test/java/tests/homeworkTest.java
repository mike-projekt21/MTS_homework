package tests;

import models.HotelCardModel;
import org.junit.Assert;
import org.junit.Test;
import pages.HotelPage;
import pages.MainPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.sleep;

public class homeworkTest extends BaseTest{
    /*
    1.1 зайти на сайт https://www.booking.com/
    1.2 ввести в поиске любой город(заграничный)
    1.3 выбрать случайные даты
    1.4 нажать на кнопку «Найти»
    1.5 нажать на кнопку «Показать на карте»
    1.6 навести курсор на первый отель(карточка слева)
    1.7 сохранить(в переменные) название отеля, количество звезд, среднюю оценку, количество отзывов, стоимость
    1.8 нажать на прыгающий маркер на карте
    1.9 на открывшейся странице отеля проверить название отеля, количество звезд, среднюю оценку, количество отзывов и стоимость
    */

    //region Tests
    @Test
    public void popUpMessageTest() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        HotelPage hotelPage = new HotelPage();

        //region input Data
        String city = "Белград";
        String startDate = "'2024-05-11'";
        String endDate = "'2024-05-20'";
        //endregion

        mainPage.searchCity(city, startDate, endDate);
        sleep(10000);
        HotelCardModel mapHotelModel = searchPage
                .openMap()
                .getFirstHotelInfo();
        searchPage.clickJumpingMarker();

        HotelCardModel hotelPageModel = hotelPage.getHotelInfo();
        Assert.assertEquals(mapHotelModel, hotelPageModel);
    }

    //endregion
}
