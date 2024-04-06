package models;

import com.codeborne.selenide.SelenideElement;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class HotelCardModel {
    //region Context
    String name;
    int stars;
    double rating;
    int reviewsNumber;
    double price;
    //endregion

    public HotelCardModel() {
    }
    public void parser(SelenideElement name, int stars, SelenideElement rating, SelenideElement reviewsNumber, SelenideElement price) {
        this.name = name.getText();
        this.stars = stars;
        this.rating = Double.parseDouble(rating.getText().split(" ")[1].replace(",","."));
        this.reviewsNumber = Integer.parseInt(reviewsNumber.getText().split(" ")[0]);
        String[] priceFormat = price.getText().split(" ");
        this.price = Double.parseDouble(Arrays.stream(priceFormat).limit(priceFormat.length-1).collect(Collectors.joining("")));
        /*
        DecimalFormat format = new DecimalFormat("###,##0.00 руб");
        try {
            this.price = format.parse(price.getText()).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
         */
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelCardModel that = (HotelCardModel) o;
        return stars == that.stars && Double.compare(that.rating, rating) == 0 && reviewsNumber == that.reviewsNumber && Double.compare(that.price, price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stars, rating, reviewsNumber, price);
    }
}
